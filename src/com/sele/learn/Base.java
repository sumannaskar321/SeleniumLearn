package com.sele.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static void main(String[] args) {
		
		WebDriver driver = null;
		String browser = "ie";
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","F:\\gmit_softwares\\Resource\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "F:\\gmit_softwares\\Resource\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.setProperty("webdriver.ie.driver", "F:\\gmit_softwares\\Resource\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement( By.id("autocomplete")).sendKeys("Hello..");
		//driver.quit();
		driver.close();

		
	}

}
