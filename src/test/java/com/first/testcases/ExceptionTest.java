package com.first.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ExceptionTest {
  @BeforeMethod
  //数组越界异常
  public void beforeMethod() {
//	  int i[] = {1,2,3,4,5};
//	  int b = i[8];
	  }
  @Test
  public void f() {
	  int i[] = {1,2,3,4,5};
	  int b = i[8];
	  Assert.assertEquals(1, 1);
	  }
	  
  @Test
  public void f1() {
	  Assert.assertEquals(1, 1);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
