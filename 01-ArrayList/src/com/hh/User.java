package com.hh;

public class User {
	private int age;
	private String name;
	
	public User(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		
		System.out.println("Person - finalize");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof User) {
			User person  = (User) obj;
			return this.age == person.age;
		}
		return false;
	}
}
