package com.Supertails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuperTails_POM {
	By ExeAct;
	WebDriver driver;
	
	public SuperTails_POM(WebDriver driver){
		this.driver=driver;
	}
	
	public void ClickMethod(String val,String locator) {
		if(locator.equalsIgnoreCase("className")) {
			ExeAct=By.className(val);
		}
		else if(locator.equalsIgnoreCase("xpath")) {
			ExeAct=By.xpath(val);
		}
		else if(locator.equalsIgnoreCase("id")) {
			ExeAct=By.id(val);
		}
		driver.findElement(ExeAct).click();
	}

}
