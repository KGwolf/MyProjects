package com.xht.spring5;

import org.springframework.stereotype.Component;

@Component
public class Food {

	private String name = "asd";

	public String getName() {
		System.out.println("Food 的name为："+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
