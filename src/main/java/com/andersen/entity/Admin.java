package com.andersen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class Admin extends User {


	@Override
	public void printRole() {
		System.out.println("Role: " + this.getClass().getSimpleName());
	}

}
