package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PushpaIMDBpom {
@FindBy(xpath = "//input[@type=\"text\"]") private WebElement search;
@FindBy(xpath = "//div[text()=\"Pushpa: The Rise - Part 1\"]") private WebElement pushpaMovie;
@FindBy(xpath = "//a[contains(@class,\"ipc-metadata-list-item__list-\")]") private List<WebElement> dateAndCountry;
public PushpaIMDBpom(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void enterMovieName(String nameOfMovie)
{
	search.sendKeys(nameOfMovie);
}
public void clickOnPushpa(WebDriver driver)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(4000));
	wait.until(ExpectedConditions.visibilityOf(pushpaMovie));
	pushpaMovie.click();
}
public String getTextOfDateCountry(String name, WebDriver driver)
{
	int count=dateAndCountry.size();
	String text="";
	for(int i=0;i<count;i++)
	{
	WebElement datecountry=dateAndCountry.get(i);
	text=datecountry.getText();
	if(text.equalsIgnoreCase(name))
	{
		Actions act=new Actions(driver);
		act.moveToElement(datecountry);
		act.perform();
		System.out.println(text);
		return text;
	}
	}
	return text;
}

}
