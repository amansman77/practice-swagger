package com.ho.practice.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "회원정보")
public class Member {
	@ApiModelProperty(notes = "회원 ID")
	private String id;
	@ApiModelProperty(notes = "회원 이름")
	private String name;
	@ApiModelProperty(notes = "회원 나이")
	private Integer age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
