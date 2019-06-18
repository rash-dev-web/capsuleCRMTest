package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_001 {

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
		addPerson();
		addCases();
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
	
	public void addPerson() throws InterruptedException {
		WebElement personIcon = driver.findElement(By.xpath("//a[@id='ember18']"));
		Thread.sleep(3000);
		personIcon.click();
		System.out.println("person icon clicked!!!");
		Thread.sleep(3000);
		WebElement addPersonButton = driver.findElement(By.xpath("//a[text()='Add Person']"));
		addPersonButton.click();
		Thread.sleep(3000);
		WebElement fName = driver.findElement(By.id("party:fnDecorate:fn"));
		WebElement lName = driver.findElement(By.id("party:lnDecorate:ln"));
		fName.sendKeys("Almeer");
		lName.sendKeys("Sajid");
		WebElement saveButton = driver.findElement(By.id("party:save"));
		saveButton.click();
		Thread.sleep(3000);
	}
	
	
	public void addCases() throws InterruptedException {
		Thread.sleep(5000);
		WebElement caseIcon = driver.findElement(By.id("ember24"));
		if(caseIcon.isDisplayed()) {
			caseIcon.click();
			System.out.println("case icon clicked!!!");			
			Thread.sleep(5000);
		}
		
		WebElement addCaseButton = driver.findElement(By.xpath("//a[text()='Add Case']"));
		Thread.sleep(3000);
		addCaseButton.click();
		
		WebElement caseRelated = driver.findElement(By.id("partySearch"));
		Thread.sleep(3000);
		caseRelated.sendKeys("Almeer Sajid");
		Thread.sleep(3000);
		//Actions act = new Actions(driver);
		//act.moveToElement(Keys.ARROW_DOWN);
		caseRelated.sendKeys(Keys.ARROW_DOWN);
		caseRelated.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.id("caseNameDecorate:name"));
		Thread.sleep(3000);
		name.sendKeys("CaseOne");
		
		WebElement saveButton = driver.findElement(By.id("save"));
		
		saveButton.click();
		Thread.sleep(7000);
	}
	
	@AfterTest
	public void testDown() {
		driver.close();
	}
}
