package com.map;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put(null,1230);
		Integer i = 0;
		m.put(0,12);
		m.put(i,"a");
		System.out.println(i.hashCode());
		System.out.println(m.get(0));
		System.out.println(m.get(null));
	}
}
