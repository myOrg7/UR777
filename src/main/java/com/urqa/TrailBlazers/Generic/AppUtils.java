package com.urqa.TrailBlazers.Generic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AppUtils {
	AndroidDriver<MobileElement>driver;
	public AppUtils(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
	public void swipeDown(int n ){
		Dimension d=driver.manage().window().getSize();
		int startHeight=(int)(d.getHeight()*0.7);
		int endHeight=(int)(d.getHeight()*0.3);
		driver.swipe(0, startHeight, 0, endHeight, 2000);
		
		
	}
	public void tapAction(int x,int y )
	{
		TouchAction ta=new TouchAction(driver);
		ta.tap(x, y).waitAction(2000).perform();
		
		}
	public void scrolldown(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollable(true)).scrollIntoView(new UiSelector().text(\""+text+"\"))");
		
	}
	public void chngeOrientation(String orientation)
	{
		if(orientation.equalsIgnoreCase("L"))
		{
			driver.rotate(ScreenOrientation.LANDSCAPE);
		}
		else if(orientation.equalsIgnoreCase("P"))
		{
			driver.rotate(ScreenOrientation.PORTRAIT);
			
		}
	}

}
