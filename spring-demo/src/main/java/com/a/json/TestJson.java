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
	
	
	@Test
	public void test02(){
		System.out.println("\u533b\u9662\u002c\u536b\u751f\u670d\u52a1\u002c\u4fdd\u5065\u9662\u002c\u536b\u751f\u9662\u002c\u536b\u751f\u6240\u002c\u95e8\u8bca\u90e8\u002c\u6212\u6bd2\u6240\u002c\u7597\u517b\u9662\u002c\u533b\u52a1\u5ba4\u002c\u75be\u75c5\u9884\u9632\u63a7\u5236\u4e2d\u5fc3\u002c\u773c\u79d1\u4e2d\u5fc3\u002c\u9632\u6cbb\u9662\u002c\u7cbe\u795e\u75c5\u9662\u002c\u9632\u6cbb\u4e2d\u5fc3\u002c\u63a7\u5236\u4e2d\u5fc3\u002c\u7ba1\u6559\u6240\u002c\u533b\u7597\u4e2d\u5fc3\u002c\u536b\u751f\u4e2d\u5fc3\u002c\u4f9b\u5e94\u7ad9\u002c\u9632\u6cbb\u6240\u002c\u9632\u6cbb\u7ad9\u002c\u670d\u52a1\u7ad9\u002c\u517b\u8001\u9662\u002c\u8840\u6db2\u4e2d\u5fc3\u002c\u6d4b\u8bd5\n");
		System.out.println("医院".getBytes());
		String s = "医院";
		char[] chars = s.toCharArray();
		for(int i=0;i<chars.length;++i){
			int a = (int)chars[i];
			System.out.print("\\u"+Integer.toHexString(a));
		}
		System.out.println();
	}
	
}
