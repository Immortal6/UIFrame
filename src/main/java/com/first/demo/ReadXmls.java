package com.first.demo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.first.uiframework.Locator;
import com.first.uiframework.Locator.ByType;


public class ReadXmls {
	public static void main(String []args) throws DocumentException{
		String xfh=System.getProperty("user.dir")+"/webelementdata/LoginPage.xml";
		Map<String, Locator> elementinfo = new HashMap<String,Locator>();
		SAXReader saxreader = new SAXReader();
		Document document = saxreader.read(new File(xfh));
		Element root =document.getRootElement();
		List<Element>childList =root.elements("locator");
		for(Element e:childList){
			String value = e.attributeValue("value").toString();
			int timeOut=Integer.parseInt(e.attributeValue("timeout"));
			String name = e.attributeValue("name").toString();
			String  type = e.attributeValue("type").toString();
			Locator locator = new Locator(value,timeOut,getType(type),name);
			String keyName = e.getText();
			elementinfo.put(keyName,locator);
		}
		System.out.println(elementinfo.get("forgetPassword").getElementName());
	}
	public static ByType getType(String value){
		ByType type = null;
		switch(value){
		case "css":
			type = ByType.cssSelector;
			break;
		case "xpath":
			type = ByType.xpath;
			break;
		}
		return type;
		
	}
}
