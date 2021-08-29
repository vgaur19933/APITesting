
package com.test.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Resreq {

	public void Resreq() {

	}

	@JsonProperty("name")
	private String name;
	@JsonProperty("job")
	private String job;
	@JsonProperty("id")
	private String id;
	@JsonProperty("createdAt")
	private String createdAt;
	
}


