package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushpaWIKIpom {
@FindBy(xpath = "//input[@name=\"search\"]") private WebElement searchMovieName;
@FindBy(xpath = "//input[@id=\"searchButton\"]") private WebElement searchButton;
@FindBy(xpath = "//body//table//tbody//tr[12]//td//ul//li") private WebElement date;
@FindBy(xpath = "//body//table//tbody//tr[14]//td") private WebElement country;

public PushpaWIKIpom(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void enterPushpaName()
{
	searchMovieName.sendKeys("pushpa");
}
public void clickOnSearchButton()
{
	searchButton.click();
}
public String getDate()
{
	String actualDate=date.getText();
	System.out.println(actualDate);
	return actualDate;
}
public String getCountry()
{
	String actualCountry=country.getText();
	System.out.println(actualCountry);
	return actualCountry;
}
}
