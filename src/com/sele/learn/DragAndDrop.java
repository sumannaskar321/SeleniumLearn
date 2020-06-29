package com.sele.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		
		WebDriver driver = null;

		
		System.setProperty("webdriver.chrome.driver", "F:\\gmit_softwares\\Resource\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		// ********* drag and drop ********
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		WebElement elemA = driver.findElement( By.xpath("//div[@id='column-a']"));
		WebElement elemB = driver.findElement( By.xpath("//div[@id='column-b']"));
		
		Actions action = new Actions(driver);
		
	/*	action.clickAndHold(elemA)
			.moveToElement(elemB)
			.release()
			.build().perform();
		*/
		action.dragAndDrop(elemA, elemB).build().perform();
		
	/*	action.moveToElement(elemA).clickAndHold()
			.moveToElement(elemB).release().build().perform();
			
		*/
		
		driver.quit();

	}

}
