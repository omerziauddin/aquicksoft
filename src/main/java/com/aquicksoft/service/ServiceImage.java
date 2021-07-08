package com.aquicksoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aquicksoft.dto.Image;
import com.aquicksoft.entities.ImageEntity;
import com.aquicksoft.entities.PictureEntity;
import com.aquicksoft.repository.ImageRepository;
import com.aquicksoft.repository.PictureRepository;

import lombok.Data;

@Service
@Data
public class ServiceImage {

	@Value("${application.fileAccept}")
	private List<String> acceptFileType;

	@Autowired
	private final RestTemplate restTemplate;

	public ServiceImage(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;
	}

	@Autowired
	public PictureRepository pictureRepository;

	@Autowired
	public ImageRepository imageRepository;

	

	public List<Image> hbImageUpdateGateway(int limit, int offset, String hbkey) {
		int totalCount = 376;
		int treveser = 0;
		List<Image> imageList=new ArrayList<>();
		for (int i = 0; i <= treveser; i++) {
			offset = i * 100;
			treveser = totalCount / limit;
			String url = "https://api.hubapi.com/filemanager/api/v2/" + "files?type=IMG&limit=" + limit + "&hapikey="
					+ hbkey + "&offset=" + offset;
			System.out.println(url);
			imageList.add(restTemplate.getForObject(url, Image.class));

		}
		return imageList;
	}

	public ImageEntity saveImage(ImageEntity imageEntity) {
		return imageRepository.save(imageEntity);
	}

	public PictureEntity savePicture(PictureEntity pictureEntity) {
		return pictureRepository.save(pictureEntity);
	}

	
	
}
