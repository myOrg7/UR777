package com.urqa.TrailBlazers.Generic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseLibs {
	public AndroidDriver<MobileElement> driver;
	public AppUtils appUtils;
	public AppiumDriverLocalService service;
	public String Node_Js="C:\\Program Files\\nodejs\\node.exe";
	String userprofile = System.getenv("USERPROFILE");
	String Path = "\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	public String Appium_js=userprofile+Path;	
	
	@BeforeSuite
	public void startAppiumServer(){
		
		System.out.println("Appium server starting");
		service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort().usingDriverExecutable(new File(Node_Js)).withAppiumJS(new File(Appium_js)));
	 service.start();
	 System.out.println("service started");
	}
			
	@BeforeMethod
	 public void preCond()
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("automationName",GetPropertyValue.getValue("AutomationName"));
		System.out.println("automation name");
		/*dc.setCapability("platformName", GetPropertyValue.getValue("PlatformName"));
		dc.setCapability("platformVersion", GetPropertyValue.getValue("PlatformVersion"));
		*/
		dc.setCapability("platformName", System.getProperty("PlatformName"));  // from POM.xml
		dc.setCapability("platformVersion", System.getProperty("PlatformVersion"));
		
		dc.setCapability("deviceName", GetPropertyValue.getValue("DeviceName"));
		System.out.println("devicename");
		dc.setCapability("appPackage", GetPropertyValue.getValue("AppPackage"));
		dc.setCapability("appActivity", GetPropertyValue.getValue("AppActivity"));
		dc.setCapability("noReset", GetPropertyValue.getValue("NoReset"));
		
		
		try {
			driver=new AndroidDriver<MobileElement>(new URL(service.getUrl().toString()),dc);
			appUtils = new AppUtils(driver);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	@AfterMethod

	public void postCond(ITestResult result){
		if(!result.isSuccess()){
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File(".\\screenshots\\"+result.getName()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if(driver!=null)
		{
			driver.closeApp();
		}
	}


	@AfterSuite

	public void stopAppiumServer()
	{ 
		service.stop();
	System.out.println("appium server stopped");

		}
}
