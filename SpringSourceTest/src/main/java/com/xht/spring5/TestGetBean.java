package com.xht.spring5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestGetBean {

	public static void main(String[] args) {

//		Person p = new Person();
//		p.setAge(1);
//		
		
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ctx.getBean("myFactoryBean");

		//下面这种方法，是没有传包路径的，需要用到配置类解析。（在配置类上面写扫描的包路径）
		AnnotationConfigApplicationContext acT = new AnnotationConfigApplicationContext();
		//在进行调用bfpp之前，Spring 已经在beanFactory里面注册了几个内部使用的beandefinition了，在构造AnnotatedBeanDefinitionReader方法中。（Annotation、Common、ConfigurationAnnotation）
		//这里是把这个类注册到beanDefinition中。
		acT.register(MyBeanClass.class);
		acT.refresh();

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.xht.spring5.factorybean");
		Object bean2 = ac.getBean("serviceAnnotation");

		Object bean = ac.getBean("&myFactoryBean");
		Object bean1 =  ac.getBean("myFactoryBean");;


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
