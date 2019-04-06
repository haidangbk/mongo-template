package com.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "user")
@Getter
@Setter
public class User {
	@Id
	private String _id;
	private String name;
	private int age;
	private String address;
}
