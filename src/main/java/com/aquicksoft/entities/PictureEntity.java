package com.aquicksoft.entities;

import lombok.Data;

@Data
public class PictureEntity {
	public Long pictureId;

	public Long txnId;
	public Long userId;

	public Long id;
	public Integer portal_id;
	public String name;
	public Integer size;
	public Integer height;
	public Integer width;
	public String encoding;
	public String type;
	public String extension;
	public String cloud_key;
	public String s3_url;
	public String friendly_url;
	public String alt_key;
	public String alt_key_hash;
	public String title;
	public Meta meta;
	public Long created;
	public Long updated;
	public Integer deleted_at;
	public Long folder_id;
	public Boolean hidden;
	public String cloud_key_hash;
	public Boolean archived;
	public String createdBy;
	public String deletedBy;
	public Boolean replaceable;
	public String default_hosting_url;
	public Boolean is_indexable;
	public String url;
	public String cdn_purge_embargo_time;
	public String file_hash;

}
