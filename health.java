package Driver;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	@Test(priority=1)
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"username_id\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("pass123");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		}
	
	 
	public boolean openVerificationMenu() {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement verificationTab = driver.findElement(By.xpath("/html/body/my-app/div/div/div[3]/div[1]/div/ul/li[33]/a/span[1]"));
	        
	        // Scroll till element visible
	        js.executeScript("arguments[0].scrollIntoView(true);", verificationTab);
	        
	        // Click
	        verificationTab.click();
	        return true;

	    } catch (Exception e) {
	        System.err.println("openVerificationMenu failed: " + e.getMessage());
	        return false;
	    }
	}
	
	@Test(priority=2)
	public void verficationScroll() {
		Assert.assertTrue(openVerificationMenu(), "Verification not found ");
	}
	
	

//	@AfterClass
//	public void teardown() {
//		driver.quit();
//	}
}
