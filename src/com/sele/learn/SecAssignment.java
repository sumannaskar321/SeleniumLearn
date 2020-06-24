package com.sele.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\gmit_softwares\\Resource\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
		
		driver.findElement( By.linkText("2")).click();
		String cellE7Value = driver.findElement( By.xpath("//table//tr[7]/td[6]")).getText();
		System.out.println("7th row 5th column value : "+cellE7Value);
		Thread.sleep(2000);
		driver.quit();

	}

}
