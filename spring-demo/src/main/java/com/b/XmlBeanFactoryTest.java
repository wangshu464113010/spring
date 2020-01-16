package com.b;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;

public class XmlBeanFactoryTest {


	public static void main(String[] args) throws Exception{
		/**
		 * ClassPathResource的构造函数来构造Resource资源文件的实例对象
		 * 后续的资源处理就可以用Resource提供的各种服务来操作
		 */

		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
		ResourceAPI();
	}
	public static void ResourceAPI() throws Exception{
		Resource resource = new ClassPathResource("liveTemplate.html");
		System.out.println("path = "+resource.getFile().getPath());
		System.out.println("ParentFile = "+resource.getFile().getParentFile());
		System.out.println("fileName = "+resource.getFilename());
		System.out.println("url = "+ resource.getURL());
		System.out.println("uri = "+resource.getURI());
		System.out.println("description = "+resource.getDescription());
		System.out.println("exists = "+resource.exists());
		System.out.println("contentLength = "+resource.contentLength());
		System.out.println("lastModified = "+resource.lastModified());
		System.out.println("readableChannel = "+resource.readableChannel());
		InputStream inputStream = resource.getInputStream();

	}
}
