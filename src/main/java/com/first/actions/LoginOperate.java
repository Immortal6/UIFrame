package com.first.actions;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.first.pages.LoginPage;
import com.first.pages.MainPage;

public class LoginOperate {
	private static WebDriver dr;

	public static WebDriver getDr() {
		return dr;
	}

	public static void setDr(WebDriver dr) {
		LoginOperate.dr = dr;
	}
	static LoginPage loginPage;
	static MainPage mainPage;
	//登录成功
	public static  MainPage loginSuccess(String username,String password){
		loginPage = new LoginPage(getDr());
		loginPage.inputUserName(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		return new MainPage(getDr()); 
	}
	//登录跳转的方法
	public static String getLoginUserName(String username,String password){
		mainPage = loginSuccess(username, password);
		return mainPage.getLoginUserName();
	}
	//登录失败的方法
	public static String loginFail(String username,String password){
		loginPage = new LoginPage(getDr());
		loginPage.inputUserName(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		loginPage.wait(3);
		String text = loginPage.getAlertText();
		loginPage.alertAccept();
		return text;
	}
}
