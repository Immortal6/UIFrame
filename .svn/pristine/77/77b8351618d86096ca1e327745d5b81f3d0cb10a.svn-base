package com.first.utils;

import org.testng.Assert;

public class AssertUtils {
	//可接收多个String
	Log log =  new Log(AssertUtils.class);
	public void checkIntNum(int actual,int excepted,String... com){
		try{	
		Assert.assertEquals(actual, excepted);	
	}catch(AssertionError e){
		log.error("断言失败");
		Assert.fail("断言失败！");
	}	
	}
	public void checkString(String actual,String excepted,String... com){
		try{
		Assert.assertEquals(actual, excepted);
		}catch(AssertionError e){
			log.error("断言失败");
			Assert.fail("断言失败！");
		}
	}
	public void checkStringContains(String actual,String excepted,String... com){
		try{
		Assert.assertEquals(true, actual.contains(excepted));
		}catch(AssertionError e){
			log.error("断言失败");
			Assert.fail("断言失败！");
		}
	}
	public void notNull(Object actual,String... com){
		try{
		Assert.assertNotNull(actual);
		}catch(AssertionError e){
			log.error("断言失败");
			Assert.fail("断言失败！");
		}
	}
}

