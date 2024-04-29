package Assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import CommonUtil.PropertyFileUtil;
import CommonUtil.WebDriverUtil;

public class PlaceOrderOfProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//DDT- Data Driven Testing
		PropertyFileUtil putil = new PropertyFileUtil();
		String fname = putil.getDataFromPropertyFile("Firstname");
		String lname = putil.getDataFromPropertyFile("Lastname");
		String email = putil.getDataFromPropertyFile("Email");
		String password = putil.getDataFromPropertyFile("Password");
		String compnay = putil.getDataFromPropertyFile("Compnay");
		String street = putil.getDataFromPropertyFile("Street");
		String city = putil.getDataFromPropertyFile("City"); 
		String pincode = putil.getDataFromPropertyFile("Pincode");
		String phonenumber = putil.getDataFromPropertyFile("Phonenumber");
		
		WebDriverUtil wutil = new WebDriverUtil();
		
		driver.get("https://magento.softwaretestingboard.com/");
		
		//Create an account
		//i have already created account by following details so it will say "There is already an account with this email address"
		driver.findElement(By.linkText("Create an Account")).click();
		driver.findElement(By.id("firstname")).sendKeys(fname);
		driver.findElement(By.id("lastname")).sendKeys(lname);
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("password-confirmation")).sendKeys(password);
		driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
		
		//Login into the account
		driver.findElement(By.partialLinkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("send2")).click();
		
		//Search product 
		WebElement search = driver.findElement(By.id("search"));
		search.sendKeys("men pants");
		search.sendKeys(Keys.ENTER);
		
		//Select product
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[2]")).click();
		
		//Select size
		driver.findElement(By.xpath("//div[text()='33']")).click();
		
		//Select color
		driver.findElement(By.id("option-label-color-93-item-50")).click();
		
		//Add to cart
		driver.findElement(By.id("product-addtocart-button")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[class='action showcart']")).click();
		
		//Click on proceed to checkout
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		
		Thread.sleep(5000);
		WebElement newAddress = driver.findElement(By.xpath("//span[text()='New Address']"));
		
		 if(newAddress.isDisplayed())
		 {
			 driver.findElement(By.xpath("//span[text()='Next']")).click();
		 }else {
		//Fill the details after proceed to checkout
		driver.findElement(By.id("customer-email")).sendKeys(email);
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("company")).sendKeys(compnay);
		driver.findElement(By.name("street[0]")).sendKeys(street);
		driver.findElement(By.name("city")).sendKeys(city);
		
		WebElement countryDropdown = driver.findElement(By.name("country_id"));
		wutil.handleDropdown(countryDropdown, "India");
		
		WebElement stateDropdown = driver.findElement(By.name("region_id"));
		wutil.handleDropdown(stateDropdown, "Maharashtra");
		
		driver.findElement(By.name("postcode")).sendKeys(pincode);
		driver.findElement(By.name("telephone")).sendKeys(phonenumber);
		
		//Next
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		 }
		
		//Place Order 
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		
		//Sign out
		driver.findElement(By.partialLinkText("Sign Out")).click();
		
	}
		
}
