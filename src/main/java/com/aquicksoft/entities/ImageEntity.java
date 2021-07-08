package com.aquicksoft.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
//@Entity
//@Table(name = "Image")
@Document(collection = "order_DB")
public class ImageEntity {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	public Long image_Id;
	/* @Column(name = "limitColumn") */
	public Long limit;
	public Long offset;

	public Long total_count;
	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "image",orphanRemoval =
	 * true,cascade=CascadeType.ALL)
	 */private List<PictureEntity> pictures;

}
