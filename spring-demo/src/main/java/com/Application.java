package com;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {

	//将T对象复制给E对象...
	private <T,E> void copyDomain(T t ,E e) throws InvocationTargetException, IllegalAccessException,NullPointerException {
		if(t == null || e == null){
			throw new NullPointerException("T or E is null");
		}
		Class<? extends T> dpClass = (Class<? extends T>) t.getClass();
		Class<? extends E> fsDpClass = (Class<? extends E>) e.getClass();
		Method[] dpMethods = dpClass.getMethods();
		Method[] fsDpMethods = fsDpClass.getMethods();
		// List<Method> methods = Arrays.asList(fsDpMethods);
		for (int i =0;i<dpMethods.length;++i){
			String getMethod = dpMethods[i].getName();
			if("get".equals(getMethod.substring(0,3))){
				Object invoke1 = dpMethods[i].invoke(t);
				if(invoke1 == null){
					continue;
				}
				for(int k =0;k<fsDpMethods.length;++k){
					if("set".equals(fsDpMethods[k].getName().substring(0,3)) &&
							getMethod.substring(3).equals(fsDpMethods[k].getName().substring(3))){
						fsDpMethods[k].invoke(e,invoke1);
						break;
					}
				}
			}
		}
	}
}
