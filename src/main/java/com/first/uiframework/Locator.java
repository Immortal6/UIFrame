package com.first.uiframework;

public class Locator {
	//枚举类型
	public  enum ByType{
		xpath,id,name,cssSelector,linkText,className,partialLinkText,tagName
	}
	private String  elementName;
	private String 	localtorInfo;
	private int timeOut;
	private ByType ByType;
	public String getElementName() {
		return elementName;
	}

	public String getLocaltorInfo() {
		return localtorInfo;
	}

	public int getTimeOut() {
		return timeOut;
	}
	public ByType getByType() {
		return ByType;
	}
	public Locator(String element,int waitSec,ByType byType,String name ){
		this.localtorInfo = element;
		this.timeOut = waitSec;
		this.ByType = byType;
		this.elementName = name;
	}

}
