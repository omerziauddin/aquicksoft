package com.aquicksoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.aquicksoft.dto.Image;
import com.aquicksoft.dto.MessagingConfig2;
import com.aquicksoft.dto.Order;
import com.aquicksoft.dto.Picture;
import com.aquicksoft.entities.ImageEntity;
import com.aquicksoft.entities.PictureEntity;
import com.aquicksoft.repository.PictureRepository;
import com.aquicksoft.service.ServiceImage;

@RestController
public class ControllerImage {
	@Autowired
	public ServiceImage service;

	@Autowired
	public PictureRepository imageRepository;

	@Autowired
	private RabbitTemplate template;

	public String hbKey;

	public Long txnId;
	public Long userId;

	@RabbitListener(queues = "${QC_TASK_START}")
	public void recievedMessage(final Order order) {
		System.out.println("Received following message from rabbitmq= " + order);
		getData(order);
	}

	public List<ImageEntity> getData(Order order) {

		txnId = order.getTxnId();
		userId = order.getUserId();
		hbKey = order.getHbkey();
		System.out.println(hbKey);
		int limit = 100;
		int offset = 0;
		List<Image> imageList = service.hbImageUpdateGateway(limit, offset, hbKey);
		List<ImageEntity> imageEntityList = new ArrayList<>();
		for (Image image : imageList) {
			System.out.println(image);
			List<Picture> pictureList = image.getObjects();
			ImageEntity imageEntity = new ImageEntity();
			List<PictureEntity> pictureEntityList = new ArrayList<>();
			BeanUtils.copyProperties(image, imageEntity);
			for (Picture picture : pictureList) {
				if (!imageRepository.existsById(picture.getId())
						&& service.getAcceptFileType().contains(picture.getExtension().toUpperCase())) {
					PictureEntity pictureEntity = new PictureEntity();
					BeanUtils.copyProperties(picture, pictureEntity);

					service.savePicture(pictureEntity);
					pictureEntityList.add(pictureEntity);

					template.convertAndSend(MessagingConfig2.EXCHANGE, MessagingConfig2.ROUTING_KEY, picture);

				}
			}

			imageEntity.setPictures(pictureEntityList);
			service.saveImage(imageEntity);
			imageEntityList.add(imageEntity);
		}
		return imageEntityList;

	}

}
