package com.first.uiframework;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.first.config.LocalConfig;
import com.first.utils.Log;

public class DriverFactory {
	private static  WebDriver dr;
	//在启动之前，关闭之前的异常页面
	static Runtime runtime = Runtime.getRuntime();
	private static Log log = new Log(DriverFactory.class);
	public static WebDriver getChromeDriver(){
		try {
			runtime.exec("taskkill /F /IM chrome.exe");
			log.info("杀死chrome浏览器进程");
		} catch (IOException e) {
			log.error("杀进程出现异常");	
		}
		//封装Chrome驱动
		String driverpath = System.getProperty("user.dir")+LocalConfig.CHROME_PATH;
		System.out.println(LocalConfig.CHROME_PATH);
		System.setProperty("webdriver.chrome.driver", driverpath);
		//去掉浏览器的黄条
		ChromeOptions options = new  ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		options.addArguments("--test-type","--start-maximized");
		dr=new ChromeDriver(options);
		return dr;
	}

}
