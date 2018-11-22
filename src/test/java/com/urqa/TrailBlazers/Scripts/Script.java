package com.urqa.TrailBlazers.Scripts;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.urqa.TrailBlazers.Generic.BaseLibs;


public class Script extends BaseLibs {
	//public AndroidDriver<MobileElement> d;
	@Test
	public void LoginTB(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='xyz123']").sendKeys("108509");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//d.findElementByXPath("//android.widget.EditText[@index='1']").sendKeys("108509");
		driver.findElementById("trailBlaze.com.trailBlaze:id/et_password").sendKeys("108509");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//d.findElementById("trailBlaze.com.trailBlaze:id/btn_submit").click();
		//driver.findElementByXPath("//android.widget.ImageButton[@index='3']").click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.closeApp();
	}	
}
