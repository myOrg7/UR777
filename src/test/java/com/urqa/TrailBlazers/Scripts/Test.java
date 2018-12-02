package com.urqa.TrailBlazers.Scripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test {
	public static void main(String [] args){
		AndroidDriver d = null;
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
			d = new AndroidDriver<MobileElement>(new URL(url), dc);
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
		
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		d.findElementByXPath("//android.widget.EditText[@text='xyz123']").sendKeys("108509");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//d.findElementByXPath("//android.widget.EditText[@index='1']").sendKeys("108509");
		d.findElementById("trailBlaze.com.trailBlaze:id/et_password").sendKeys("108509");
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//d.findElementById("trailBlaze.com.trailBlaze:id/btn_submit").click();
		d.findElementByXPath("//android.widget.ImageButton[@index='3']").click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.closeApp(); // closing the app
	}
}
