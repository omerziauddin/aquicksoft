package com.aquicksoft.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Order implements Serializable {
public Long txnId;
public Long userId;
public String hbkey;

@JsonCreator
public Order(@JsonProperty("txnId") final Long txnId, @JsonProperty("userId") final Long userId,
		@JsonProperty("hbkey") final String hbkey) {
	this.txnId = txnId;
	this.userId = userId;
	this.hbkey = hbkey;
}
}
