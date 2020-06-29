package com.sele.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "F:\\gmit_softwares\\Resource\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		String from = "New Delhi, IN - Indira Gandhi Airport (DEL)";
		String to = "Kolkata, IN - Netaji Subhas Chandra Bose Airport (CCU)";
		
		driver.findElement( By.xpath("//input[@id='FromTag']")).sendKeys(from);
		driver.findElement( By.xpath("//input[@id='ToTag']")).sendKeys(to);
		
		driver.findElement( By.xpath("//i[@class='icon ir datePicker']")).click();
		driver.findElement( By.xpath("//a[@class='nextMonth ']")).click();
		driver.findElement( By.xpath("//div[@class='monthBlock last']//a[text()='15']")).click();
		
		Select s;
		
		s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("2");
		s = new Select(driver.findElement(By.id("Childrens")));
		s.selectByValue("1");
		s = new Select(driver.findElement(By.id("Infants")));
		s.selectByValue("1");
		
		driver.findElement( By.id("SearchBtn")).click();
		
		Thread.sleep(15000);
		driver.quit();
	}

}
