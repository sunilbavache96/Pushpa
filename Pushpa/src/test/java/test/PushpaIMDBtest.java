package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.PushpaIMDBpom;

public class PushpaIMDBtest {
	WebDriver driver;

@Test
public void getTextDateCountryIMDB() 
{
	driver=Browser.openBrowser("https://www.imdb.com/");

	PushpaIMDBpom pushpaIMDBpom=new PushpaIMDBpom(driver);
	pushpaIMDBpom.enterMovieName("pushpa");
	pushpaIMDBpom.clickOnPushpa(driver);
	String dateText=pushpaIMDBpom.getTextOfDateCountry("January 7, 2022 (United States)", driver);
	String expReleaseDate="January 7, 2022 (United States)";
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals(dateText, expReleaseDate );
	String countryText= pushpaIMDBpom.getTextOfDateCountry("India", driver);
	String expCountry="India";
	softAssert.assertEquals(countryText, expCountry);
	softAssert.assertAll();

	
}
}
