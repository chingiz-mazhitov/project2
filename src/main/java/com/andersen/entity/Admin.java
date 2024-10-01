package com.andersen.entity;


public class Admin extends User {


	@Override
	public void printRole() {
		System.out.println("Role: " + this.getClass().getSimpleName());
	}

}
