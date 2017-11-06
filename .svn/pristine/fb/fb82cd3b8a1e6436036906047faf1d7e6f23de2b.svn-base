package com.first.testcases;

import org.testng.annotations.Test;

import com.first.actions.LoginOperate;
import com.first.pages.LoginPage;
import com.first.pages.MainPage;
import com.first.uiframework.DriverFactory;
import com.first.uiframework.TestCase;
import com.first.utils.AssertUtils;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
  WebDriver dr;
  AssertUtils assertutils;
  List<TestCase> testCases = ExcelUtils.getUITestData("UITestData.xlsx");
  @BeforeMethod
  public void beforeMethod() {
	  try{
	  assertutils  = new AssertUtils();
	  dr=DriverFactory.getChromeDriver();
	  dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }catch(Exception e){
		  Assert.fail("初始化报错，不再执行后续代码！！");
	  }
	  }
  @Test
  public void loginTest1() {
	  HashMap<String, String> testData = (HashMap<String, String>) testCases.get(0).getTestData();
	  LoginOperate.setDr(dr);
	  String value = LoginOperate.getLoginUserName(testData.get("username"), testData.get("password"));
	  assertutils.checkStringContains(value, testCases.get(0).getExpectedResult(), "测试登录成功");
	   }
  @Test
  public void failLoginTest1() throws DocumentException{
	  HashMap<String, String>  testData = (HashMap<String, String>) testCases.get(2).getTestData();
	  LoginOperate.setDr(dr);
	  String value = LoginOperate.loginFail(testData.get("username"),testData.get("password"));
	  assertutils.checkStringContains(value,testCases.get(2).getExpectedResult(), "测试登录失败");	   
  }
  @AfterMethod
  public void afterMethod()  {
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  dr.close();
	 
	}
	  
  }


