package com.xht.spring5;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestGetBean {

	public static void main(String[] args) {

//		Person p = new Person();
//		p.setAge(1);
//		
		
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ctx.getBean("myFactoryBean");

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("constructorContext.xml");
		ctx.getBean("person");
		//自定义BeanFactory
		//ClassPathXmlApplicationContext ctx = new MyCoustomBeanFactory("applicationContext.xml");


//		Person person = (Person)ctx.getBean("person");
//		Food food = ctx.getBean("food",Food.class);
//		
//		food.setName("�㽶");
//		
//		person.setName("zhangsan");
//		person.setAge(18);
//		person.setFood(food);
		
		
		Person person = (Person)ctx.getBean("person");
		
		
//		System.out.println(ToStringBuilder.reflectionToString(person,ToStringStyle.MULTI_LINE_STYLE));;
//		System.out.println(ToStringBuilder.reflectionToString(ctx,ToStringStyle.MULTI_LINE_STYLE));;
		
	}
}
