package Driver;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Driver {
	WebDriver driver;
	Properties prop;
	
	@BeforeClass
	public void SetUp() throws FileNotFoundException, IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		prop = new Properties();
		prop.load(new FileInputStream("C:\\Users\\ASUS\\Desktop\\Assenment-2\\MilestonTwo\\src\\config.properties"));
	}
	@Test
	public void opengoogle() {
		driver.get(prop.getProperty("url"));
		
	}
    @Test(priority=2)
    public void selectCountry() throws InterruptedException {
        WebElement countryDropdown = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span"));
        countryDropdown.click();
        Thread.sleep(1000); // wait for options to appear
        WebElement indiaOption = driver.findElement(By.xpath("//li[text()='India']"));
        indiaOption.click();
    }
    @Test(priority=1)
    public void dropDown() {
        WebElement year = driver.findElement(By.id("yearbox"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1996");

        WebElement month = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("November");

        WebElement day = driver.findElement(By.id("daybox"));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("25");
    }
    
    @Test(priority=3)
    public void upload () {
    	WebElement uploadimage = driver.findElement(By.xpath("//*[@id=\"imagesrc\"]"));
    	uploadimage.sendKeys("C:\\Users\\ASUS\\Downloads\\image (3).png");
    }
    
    @Test(priority=4)
    public void alertHandle () throws InterruptedException {
    	driver.get(prop.getProperty("url2"));
    	Thread.sleep(2000);
    	WebElement openAlert = driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button"));
    	openAlert.click();
    	Thread.sleep(2000);
    	Alert alert = driver.switchTo().alert();
    	Thread.sleep(2000);
    	alert.accept();
    }
    
    @Test(priority=5)
    public void firstNameEmpty() {
    	driver.get("url");
    	WebElement firstName = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input"));
    	WebElement submit = driver.findElement(By.xpath("//*[@id=\"submitbtn\"]"));
    	submit.click();
    	String message = firstName.getAttribute("Please fill out this field");
    	Assert.assertEquals(message, "Please fill out this field");
    }
   
    
    @AfterClass
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.quit();
    }
    
}