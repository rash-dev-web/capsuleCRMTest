package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_002 {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Assignment3\\Files\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rasheed.capsulecrm.com");
	}
	
	@Test
	public void test() throws InterruptedException {
		login();
	
	}
	
	public void login() throws InterruptedException {
		WebElement usrname = driver.findElement(By.id("login:usernameDecorate:username"));
		WebElement passwd = driver.findElement(By.id("login:passwordDecorate:password"));
		WebElement logIn = driver.findElement(By.id("login:login"));
		
		usrname.sendKeys("rasheed");
		passwd.sendKeys("Harman1-5");
		logIn.click();
		Thread.sleep(3000);
	}
	
	public void accSetting() throws InterruptedException {
		WebElement name = driver.findElement(By.xpath("//span[@class='nav-bar-username']"));
		name.click();
		
		Thread.sleep(3000);
		WebElement accLink = driver.findElement(By.xpath("//a[text()='Account Settings']"));
		accLink.click();
		
		WebElement acc = driver.findElement(By.xpath("//a[text()='Account']"));
		WebElement invoice = driver.findElement(By.xpath("//a[text()='Invoices']"));
		WebElement export = driver.findElement(By.xpath("//a[text()='Export']"));
		WebElement apperance = driver.findElement(By.xpath("//a[text()='Appearance']"));
		WebElement mailDropBox = driver.findElement(By.xpath("//a[text()='Mail Drop Box']"));
		WebElement users = driver.findElement(By.xpath("//a[text()='Users']"));
		WebElement opportunities = driver.findElement(By.xpath("//a[text()='Opportunities']"));//need to check again xpath
		WebElement tracks = driver.findElement(By.xpath("//a[text()='Tracks']"));
		WebElement taskCat = driver.findElement(By.xpath("//a[text()='Task Categories']"));
		WebElement customField = driver.findElement(By.xpath("//a[text()='Custom Fields']"));
		WebElement tags = driver.findElement(By.xpath("//a[text()='Tags']"));
		WebElement integrations = driver.findElement(By.xpath("//a[text()='Integrations']"));
		WebElement trash = driver.findElement(By.xpath("//a[text()='Trash']"));
		
	}
	
	@AfterTest
	public void testDown() {
		driver.close();
	}
}
