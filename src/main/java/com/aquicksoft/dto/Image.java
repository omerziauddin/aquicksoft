
package com.aquicksoft.dto;

import java.util.List;

import lombok.Data;

@Data
public class Image {

	public Long limit;
	public Long offset;
	public List<Picture> objects;
	public Long total_count;

}
