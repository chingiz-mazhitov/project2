package com.andersen;

public abstract class Identify {

	protected int id;

	protected int getId() {
		return this.id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public void print() {
		System.out.println("print content in console");
	}
}
