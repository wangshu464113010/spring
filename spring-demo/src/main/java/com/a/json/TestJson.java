package com.a.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class TestJson {

	@Test
	public void test01(){
		String str = "[{10:100},{'\"1':'85',\"5454\":100,'2':'856'}]";
		Object parse = JSONObject.parse(str);
		System.out.println(parse.getClass());
		JSONArray jsonArray = (JSONArray) parse;
		System.out.println(jsonArray.get(1));
	}
}
