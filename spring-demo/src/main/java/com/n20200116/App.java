package com.n20200116;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * ApplicationContext 继承了 ListableBeanFactory，这个 Listable 的意思就是，通过这个接口，可以获取多个 Bean，
 * 最顶层 BeanFactory 接口的方法都是获取单个 Bean 的。
 *
 * ApplicationContext 继承了 HierarchicalBeanFactory，
 * 可以在应用中起多个 BeanFactory，然后可以将各个 BeanFactory 设置为父子关系。
 *
 * AutowireCapableBeanFactory ，它就是用来自动装配 Bean 用的，ApplicationContext 并没有继承它，
 * 不使用继承，可以使用组合， ApplicationContext 接口定义中的最后一个方法 getAutowireCapableBeanFactory() 。
 *
 * ConfigurableListableBeanFactory 也是一个特殊的接口，看图（20200116BeanFactory.jpg），特殊之处在于它继承了第二层所有的三个接口
 * （ListableBeanFactory ,AutowireCapableBeanFactory ,ConfigurableBeanFactory->HierarchicalBeanFactory），
 * 而 ApplicationContext 没有。
 *  https://javadoop.com/post/spring-ioc#%E5%BC%95%E8%A8%80
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-20200116.xml");

		MessageService bean = context.getBean(MessageService.class);

		System.out.println(bean.getMessage());
	}
}
/**
 * 1. ClassPathXmlApplication的构造方法
 *
 **/