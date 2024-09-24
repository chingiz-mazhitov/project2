package com.andersen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	protected Integer id;

	public void print() {
		System.out.println("print content in console");
	}
}
