package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.PushpaWIKIpom;

public class PushpaWIKItest {
	WebDriver driver;
	@BeforeMethod
	public void openChromeBrowserWIKI()
	{
		driver=Browser.openBrowser("https://en.wikipedia.org/wiki/Main_Page");
	}
	@Test
	public void getTextDateCountryWIKI()
	{
		PushpaWIKIpom pushpaWIKIpom=new PushpaWIKIpom(driver);
		pushpaWIKIpom.enterPushpaName();
		pushpaWIKIpom.clickOnSearchButton();
		String actualDate=pushpaWIKIpom.getDate();
		String expDate="17 December 2021";
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualDate, expDate);
		String actualCountry=pushpaWIKIpom.getCountry();
		String expCountry="India";
		softAssert.assertEquals(actualCountry, expCountry);
		softAssert.assertAll();
	}
}
