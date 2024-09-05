package com.andersen;

public interface Identifiable {

	int getId();

	void setId(int id);

	default void print() {
		System.out.println("print content in console");
	}
}
