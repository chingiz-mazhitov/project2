package com.andersen;

public abstract class Identify {

	protected int id;

	protected abstract int getId();

	protected abstract void setId(int id);

	public void print() {
		System.out.println("print content in console");
	}
}
