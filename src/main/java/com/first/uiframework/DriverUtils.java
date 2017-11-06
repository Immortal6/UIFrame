package com.first.uiframework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.first.config.LocalConfig;
import com.first.utils.Log;

public class DriverUtils {
	protected WebDriver dr;
	protected static MouseUtils mouse;
	protected static KeyBoardUtils keyboard;
	protected static Log log = new Log(DriverUtils.class);
	//构造函数
	public DriverUtils(WebDriver dr){
		this.dr=dr;	
		mouse = new MouseUtils(dr);
		keyboard = new  KeyBoardUtils(dr);
	}
	//1.打开网站
	public void openUrl(String url){
		dr.get(url);
		log.info("打开网址:"+url);
	}
	//2.浏览器窗口最大化
		public void maxWindow(){
			dr.manage().window().maximize();
			log.info("窗口最大化");
		}
	//3.后退
	public void back(){
		dr.navigate().back();
		log.info("后退");
	}
	//4.前进
	public  void forward(){
		dr.navigate().forward();
		log.info("向前进一页");
	}
	//5.刷新
	public void refresh(){
		dr.navigate().refresh();
		log.info("刷新");
	}
	//6.获取当前页的Url
	public String getUrl(){
		log.info("获取url");
		return dr.getCurrentUrl();
	}
	//7.关闭当前tab页面
	public void closeWeb(){
		dr.close();
		log.info("关闭页面");
	}
	//8.退出当前driver
	public void quitWeb(){
		dr.quit();
		log.info("退出页面");
	}
	//9.获取当前页的title
	public String  getTitle(){
		log.info("获取标题");
		return dr.getTitle();
	}
	//10.设置等待时间
	public void wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
			log.info("等待时间");
		} catch (InterruptedException e) {
			log.error("超时");
		}
	}
		
	public  void takeScreenShot(String... pngName){
		String fileName;
		String filePath = LocalConfig.SHOTPATH;
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		if(pngName.length == 0){
			fileName = "shotImage";
		}else{
			fileName = pngName[0];
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		String path = "\\"+filePath+"\\"+fileName+"_"+dateStr+".png";
		takeScreenShot(dr,path);
	}
	
	public void takeScreenShot(WebDriver dr,String path){
		String currentPath = System.getProperty("user.dir");
		File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		File picFile = new File(currentPath + path);
		try{
			FileUtils.copyFile(scrFile, picFile);
			log.info("截图成功，图片保存路径为："+currentPath + path);
		}catch(Exception e){
			log.error("截图失败！");
		}
		
	}
	

}
