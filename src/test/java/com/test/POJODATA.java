package com.test;

import java.awt.JobAttributes;
import java.security.PrivateKey;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;


@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class POJODATA {
	
	private String id;
	private String  createdAt;
	
	private String name ;
	 
	private String job;
	
	public POJODATA() {}

	
	
	public POJODATA(String name,String job) {
		
		this.name=name;
		
		this.job=job;
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}
	
