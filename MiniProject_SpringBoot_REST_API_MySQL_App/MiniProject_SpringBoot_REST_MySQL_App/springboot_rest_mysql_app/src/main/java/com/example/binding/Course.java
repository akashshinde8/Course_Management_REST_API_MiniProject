package com.example.binding;
//this class is mapped to database table

import jakarta.persistence.Entity;
//it make primary key 

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
//it create automatic getters and setters
@Data

//it tells this class represents a table in database
@Entity

//it maps this class to course_dtls table in database
@Table(name="COURSE_DTLS")
public class Course {
	//it creates primary key
	@Id
	private Integer cid;
	private String name;
	private Double price;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
