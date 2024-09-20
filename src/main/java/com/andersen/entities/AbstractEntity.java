package com.andersen.entities;

public abstract class AbstractEntity {

	protected Integer id;

	protected Integer getId() {
		return this.id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	public void print() {
		System.out.println("print content in console");
	}
}
