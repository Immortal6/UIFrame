package com.first.uiframework;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebElementUtils{

	public BasePage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	public String getPageSource(){
		wait(3);
		return dr.getPageSource();
		
	}
	public void alertAccept(){
		Alert alert =dr.switchTo().alert();
		alert.accept();
	}
	public  void  alertDismiss(){
		Alert alert = dr.switchTo().alert();
		alert.dismiss();
	}
	public String getAlertText(){
		Alert alert = dr.switchTo().alert();
		return alert.getText();	
	}
	public void  inputAlert(String value){
		Alert alert = dr.switchTo().alert();
		alert.sendKeys(value);
	}
}

