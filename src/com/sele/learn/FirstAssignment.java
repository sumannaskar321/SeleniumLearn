package com.sele.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\gmit_softwares\\Resource\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/login");
		
		driver.manage().window().maximize();
		
		driver.findElement( By.id("username") ).sendKeys("tomsmith");
		driver.findElement( By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement( By.className("radius")).click();
		
		System.out.println(driver.getTitle());
		driver.findElement( By.linkText("Logout")).click();
		
		driver.close();

	}

}
