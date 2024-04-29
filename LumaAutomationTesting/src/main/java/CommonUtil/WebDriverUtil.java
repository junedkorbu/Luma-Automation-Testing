package CommonUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {

	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handleDropdown(WebElement ele,String visibleText)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(visibleText);
	}
	
	public void switchWindow(WebDriver driver,String expectedUrl)
	{
		Set<String> ids = driver.getWindowHandles();
		 
		 for(String a:ids)
		 {
			 if((driver.switchTo().window(a).getCurrentUrl()).contains(expectedUrl))
			 {
				 break;
			 }
		 }
	}
	
	public File screenshot(WebDriver driver,String ScreenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+ScreenshotName+".png");
		FileUtils.copyFile(temp, dest);
		return dest;
	}
	
	public File screenshot(WebDriver driver,WebElement targeted,String ScreenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = targeted.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+ScreenshotName+".png");
		FileUtils.copyFile(temp, dest);
		return dest;
	}
	
	public void mouseHover(WebDriver driver,WebElement ele)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele);
		a.perform();
	}
}
