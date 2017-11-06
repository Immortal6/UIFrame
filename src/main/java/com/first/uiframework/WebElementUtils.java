package com.first.uiframework;


import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.first.uiframework.Locator.ByType;
import com.first.utils.xmlUtils;

public class WebElementUtils extends DriverUtils{
	protected HashMap<String, Locator> locatorMap;
	protected String path;
	//点击、输入、提交、获取元素属性、获取元素文本
	public WebElementUtils(WebDriver dr) {
		super(dr);
		path=System.getProperty("user.dir")+"/webelementdata/"
				+this.getClass().getSimpleName()+".xml";
		
			locatorMap = xmlUtils.readElementInfo(path);
	}
	//获取元素
	public WebElement getElement(Locator locator){
	ByType type = locator.getByType();
	WebElement el = null;
	try{switch(type){
	case id:
		el = dr.findElement(By.id(locator.getLocaltorInfo()));
		break;
	case name:
		el = dr.findElement(By.name(locator.getLocaltorInfo()));
		break;
	case xpath:
		el = dr.findElement(By.xpath(locator.getLocaltorInfo()));
		break;
	case cssSelector:
		el = dr.findElement(By.cssSelector(locator.getLocaltorInfo()));
		break;
	case linkText:
		el = dr.findElement(By.linkText(locator.getLocaltorInfo()));
		break;
	case className:
		el = dr.findElement(By.className(locator.getLocaltorInfo()));
		break;
	}}catch(Exception e){
		log.info("元素:"+locator.getElementName()+"识别异常");
		takeScreenShot("findElementErrorImg");
		Assert.fail("元素未找到，不继续执行测试用例！");
	}
	return el;
	}
	
	//使用显示等待区查找元素
	public WebElement findElement(final Locator locator){
		WebDriverWait wait = new WebDriverWait(dr, locator.getTimeOut());
		WebElement el = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver dr){
				return getElement(locator);
			}
		});
		return el;	
	}
	//click对象
	public void click(Locator locator ){
		WebElement el = findElement(locator);
		el.click();
		log.info("点击元素 "+locator.getElementName());
	}
	//sendKeys
	public void input(Locator locator,String content){
		WebElement el = findElement(locator);
		el.sendKeys(content);
		log.info("在元素："+locator.getElementName()+"输入"+content);
	}
	//获取对象的文本
	public String getText(Locator locator){
		WebElement el = findElement(locator);
		log.info("获取元素："+locator.getElementName()+"文本值："+el.getText());
		return el.getText();
		
}
	//获取对象的属性
	public String  getAttribute(Locator locator,String attribute){
		WebElement el = findElement(locator);
		return el.getAttribute(attribute);
	}
	public Locator getLocator(String locatorName){
		Locator locator = locatorMap.get(locatorName);
		return locator;
		
	}
}
