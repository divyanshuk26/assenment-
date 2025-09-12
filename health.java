package Driver;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class health {
	WebDriver driver;
	
	
	@BeforeClass
	public void startup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://healthapp.yaksha.com/");
	}
	
	public boolean title() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "DanpheHealth";
		String url = driver.getCurrentUrl();
		String expectedUrl = "https://healthapp.yaksha.com/";
		
		return (expectedTitle.equals(actualTitle) && url.equals(expectedUrl));	
	}
	
	@Test
	public void verifyTitleUrl() {
		Assert.assertTrue(title(), "title and url not matched");
		
	}
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"username_id\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("pass123");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

		//Testcase 2
		// Verify pop up and proceed to the next page in the new 1 counter page.
		//		Thread.sleep(2000);
//		WebElement clickOnBill = driver.findElement(By.cssSelector("body > my-app > div > div > div.page-container > div.page-sidebar-wrapper > div > ul > li:nth-child(9) > a > span.title"));
//		clickOnBill.click();
//		Thread.sleep(2000);
//		WebElement verifyPopUp = driver.findElement(By.xpath("//span[text()='Select Counter']"));
//		String popTitle = verifyPopUp.getText();
//		System.out.println(popTitle);
		}
	
	@Test 
	public void keybordAction() {
		driver.get("https://healthapp.yaksha.com/Home/Index#/Billing/SearchPatient");
		driver.findElement(By.xpath("/html[1]/body[1]/my-app[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/scheme-refund[1]/change-billing-counter[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h5[1]")).click();
		Actions action = new Actions(driver);
		 action.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).build().perform();
		
		
		
	}
//	@AfterClass
//	public void teardown() {
//		driver.quit();
//	}
}
