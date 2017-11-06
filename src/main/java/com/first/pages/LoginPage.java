package com.first.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;

import com.first.config.LocalConfig;
import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;
import com.first.utils.xmlUtils;
import com.gargoylesoftware.htmlunit.util.WebClientUtils;

public class LoginPage extends BasePage {
//	private WebDriver dr;
//	private WebElement usernameInputBox;
//	private WebElement passwordInputBox;
//	private WebElement loginButton;
	
	
	public WebDriver getDr() {
		return dr;
	}
	public  LoginPage(WebDriver dr) {
		super(dr);
		openUrl(LocalConfig.URL);	
		
//		dr.get(LocalConfig.URL);
//		usernameInputBox = getElement("css", xmlUtils.readElementInfo("LoginPage.xml").get("usernameInputBox").getLocaltorInfo());
//		passwordInputBox = getElement("name", "password");
//		loginButton = getElement("css", "#submit");
//		usernameInputBox = dr.findElement(By.cssSelector("input#account"));
//		passwordInputBox = dr.findElement(By.name("password"));
//		loginButton = dr.findElement(By.cssSelector("#submit"));
	}
	Locator usernameInputBox = getLocator("usernameInputBox");
	Locator passwordInputBox = getLocator("passwordInputBox");
	Locator loginButton = getLocator("loginButton");
	
	
	public void inputUserName(String username){
		input(usernameInputBox,username);
	}
	public void inputPassword(String password){
		input(passwordInputBox,password);
	}
	public void clickLoginButton(){
		click(loginButton);
	}
//	public  MainPage loginOperate(String name,String password) throws DocumentException{
//		input(usernameInputBox, name);
//		input(passwordInputBox, password);
////		usernameInputBox.sendKeys(name);
////		passwordInputBox.sendKeys(password);
//		click(loginButton);
////		loginButton.click();
//		wait(3);
//			return new MainPage(getDr());
		
//	}
//	//登录失败的业务
//	public String loginFailOperate(String name,String password){
//		input(usernameInputBox, name);
//		input(passwordInputBox, password);
//		click(loginButton);
////		usernameInputBox.sendKeys(name);
////		passwordInputBox.sendKeys(password);
////		loginButton.click();
//		wait(3);
//		String value=getAlertText();
//		alertAccept();
////		Alert alert = dr.switchTo().alert();
////		String value = alert.getText();
////		alert.accept();
//		return value;
		
//	}
	
	public void wait(int second){
		try {
			Thread.sleep(second*1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
  