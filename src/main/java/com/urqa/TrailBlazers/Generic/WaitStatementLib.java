package com.urqa.TrailBlazers.Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WaitStatementLib {
	
	public static void hardWait(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();	}
	}
	public static void iWait(AndroidDriver<MobileElement>driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		
	}
	public static void eWait(AndroidDriver<MobileElement>driver,MobileElement ele,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOf(ele));	
	} 
}
