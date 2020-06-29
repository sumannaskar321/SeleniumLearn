package com.sele.learn;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ThirdAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		boolean valActual;
		
		System.setProperty("webdriver.chrome.driver", "F:\\gmit_softwares\\Resource\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// check and uncheck
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String checkBoxXpath = "//input[@id='checkBoxOption1']";
		
		driver.findElement(By.xpath(checkBoxXpath)).click();	//check the check box
		valActual = driver.findElement(By.xpath(checkBoxXpath)).isSelected();
		System.out.println(valActual);
		Assert.assertEquals(valActual, true );
		
		driver.findElement( By.xpath(checkBoxXpath)).click();		// uncheck the check box
		valActual = driver.findElement( By.xpath(checkBoxXpath)).isSelected();
		System.out.println(valActual);
		Assert.assertEquals(valActual, false);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
