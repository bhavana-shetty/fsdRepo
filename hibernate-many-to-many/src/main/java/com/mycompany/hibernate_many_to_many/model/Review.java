package com.mycompany.hibernate_many_to_many.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="review")
public class Review {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	public Review() {
		
	}

	public Review(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
}


