package com.andersen.entity;

public abstract class AbstractEntity {

	protected Integer id;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void print() {
		System.out.println("print content in console");
	}
}
