package com.xht.spring5;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {

	private String name;
	private int age;
	private Food food;
	public Person() {
		super();
	}
	
	public Person(String name, int age, Food food) {
		super();
		this.name = name;
		this.age = age;
		this.food = food;
	}

	@Autowired
    public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
    }


    public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
