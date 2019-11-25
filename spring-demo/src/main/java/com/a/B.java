package com.a;

import org.springframework.stereotype.Component;

@Component("B")
public class B {
	public void println(){
		System.out.println("B class");
	}
}
