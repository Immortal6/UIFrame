package com.first.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MouseUtils {
	
	private Actions action;
	public  MouseUtils(WebDriver dr){
		action = new Actions(dr); 
	}
	//右击操作
	public void rightClick(WebElement el){
	 
		action.contextClick(el).perform();
	}
	//双击
	public  void doubleClick(WebElement el){
		action.doubleClick(el).perform();
	
	}
}
