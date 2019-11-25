package com.a;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.NamedBeanHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by a on 2019/11/8.
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("start->--------------------------------------->");
		System.out.println("Application->start->-------------------------->");
		//xml配置文件的方式
//		ClassApplicationContext.configXml();
		//配置类的方式
		//ClassApplicationContext.configClass();
		AnnotationConfigApplicationContext bf = new AnnotationConfigApplicationContext(ConfigClass.class);
		B b = bf.getBean("B", B.class);
		System.out.println(bf.getParent());
		System.out.println(bf.getBeanFactory());//DefaultListableBeanFactory
		b.println();
		/**
		 * NamedBeanHolder nbh  = new NamedBeanHolder("A",new A());
		Object beanInstance = nbh.getBeanInstance();
		System.out.println(beanInstance);
		 ***/
		System.out.println("end--->--------------------------------------->");
	}

}
class ClassApplicationContext{


	public static void configXml(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		A aBean = (A)applicationContext.getBean("aBean");
		aBean.println();
	}
	public static void configClass(){
		/***
		 * 	AbstractApplicationContext-->static{ContextClosedEvent.class.getName();}
		 * 	AnnotationConfigApplicationContext(String... basePackages) {
		 * 		this();
		 * 		scan(basePackages);
		 * 		refresh();
		 *        }
		 */

		ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext("com.a");
		Object myConfig = applicationContext1.getBean("B");
		System.out.println(myConfig);
	}
}
