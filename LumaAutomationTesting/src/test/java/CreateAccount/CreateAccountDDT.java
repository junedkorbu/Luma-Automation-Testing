package CreateAccount;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CommonUtil.PropertyFileUtil;
import CommonUtil.WebDriverUtil;

public class CreateAccountDDT {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//DDT- Data Driven Testing
		PropertyFileUtil putil = new PropertyFileUtil();
		String fname = putil.getDataFromPropertyFile("Firstname");
		String lname = putil.getDataFromPropertyFile("Lastname");
		String email = putil.getDataFromPropertyFile("Email");
		String password = putil.getDataFromPropertyFile("Password");
		
		driver.get("https://magento.softwaretestingboard.com/");
		
		driver.findElement(By.linkText("Create an Account")).click();
		
		driver.findElement(By.id("firstname")).sendKeys(fname);
		
		driver.findElement(By.id("lastname")).sendKeys(lname);
		
		driver.findElement(By.id("email_address")).sendKeys(email);
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("password-confirmation")).sendKeys(password);
		
		driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
	}
}
