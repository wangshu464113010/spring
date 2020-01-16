package com.b;

import com.a.ConfigClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnnotationConfigTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(ConfigClass.class);

	}
}
