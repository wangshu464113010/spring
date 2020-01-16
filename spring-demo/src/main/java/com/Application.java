package com;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Application {

	//将T对象复制给E对象...
	public <T,E> void copyDomain(T t ,E e) throws InvocationTargetException, IllegalAccessException,NullPointerException {
		if(t == null || e == null){
			throw new NullPointerException("T or E is null");
		}
		Class<? extends T> dpClass = (Class<? extends T>) t.getClass();
		Class<? extends E> fsDpClass = (Class<? extends E>) e.getClass();
		Method[] dpMethods = dpClass.getMethods();
		Method[] fsDpMethods = fsDpClass.getMethods();
		List<Method> methods = Arrays.asList(fsDpMethods);
		for (int i =0;i<dpMethods.length;++i){
			String getMethod = dpMethods[i].getName();
			if("get".equals(getMethod.substring(0,3))){
				methods.remove(getMethod);
				Object invoke1 = dpMethods[i].invoke(t);
				if(invoke1 == null){
					methods.remove("set"+getMethod.substring(0,3));
					continue;
				}
				for(int k =0;k<methods.size();++k){
					Method m =  methods.get(i);
					String name = m.getName();
					if("set".equals(name.substring(0,3)) && getMethod.substring(3).equals(name.substring(3))){
						m.invoke(e,invoke1);
						methods.remove(i);
						break;
					}
				}
			}
		}
	}
}
