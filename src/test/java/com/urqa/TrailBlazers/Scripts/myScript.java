package com.urqa.TrailBlazers.Scripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class myScript {
	public static void main(String [] args){
		AndroidDriver driver = null;
		String url ="http://0.0.0.0:4723/wd/hub";
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("deviceName", "ZY223Q92ZC");
		dc.setCapability("appPackage", "trailBlaze.com.trailBlaze");
		dc.setCapability("appActivity", "trailBlaze.com.trailBlaze.Ui.Authentication.Activities.SplashActivity");
		dc.setCapability("noReset", true);
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL(url), dc);
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}
