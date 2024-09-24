package com.andersen.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	protected Integer id;

	public void print() {
		System.out.println("print content in console");
	}
}
