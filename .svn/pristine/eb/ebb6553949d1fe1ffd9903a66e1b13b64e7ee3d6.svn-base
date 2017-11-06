package com.first.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;

public class MainPage extends BasePage{
//	private WebDriver dr;
//	private WebElement userMenu;
	
	public MainPage(WebDriver dr) {
		super(dr);
	}
	Locator userLink = getLocator("userLink");
//		this.userMenu=getElement("css", "div#userMenu");
//		this.userMenu=dr.findElement(By.cssSelector("div#userMenu"));
	
	public String getLoginUserName(){
		return getText(userLink);
	}
}
