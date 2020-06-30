package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Utility;

public class Script_01 {
	public static void main(String[] args) {
		WebDriver driver = Utility.getDriver();
		List<WebElement> innerFrames = null;
		List<WebElement> frames = null;
/*		frames = driver.findElements(By.xpath("//frame"));

		//System.out.println(frames.size());
		boolean flag = true;
		for(WebElement elem:frames) {
			driver.switchTo().frame(elem);
			if(flag) {
			innerFrames = driver.findElements(By.xpath("//frame"));
			flag = false;
			//System.out.println(innerFrames.size());
			}
			if(innerFrames.size()>1) {
				for(WebElement innerElem:innerFrames) {
					driver.switchTo().frame(innerElem);
					System.out.println(driver.findElement(By.xpath("//body")).getText());
					driver.switchTo().parentFrame();
				}
			} else {
				System.out.println(driver.findElement(By.xpath("//body")).getText());
			}
			driver.switchTo().parentFrame();
		}	*/
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[1]")));
		innerFrames = driver.findElements(By.xpath("//frame"));
		
		for(WebElement innerElem:innerFrames) {
			driver.switchTo().frame(innerElem);
			System.out.println(driver.findElement(By.xpath("//body")).getText());
			driver.switchTo().parentFrame();
		}
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[2]")));
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		
		//Utility.highLight(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
		Utility.workDone();
	}

}
