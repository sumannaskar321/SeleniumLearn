package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	public static JavascriptExecutor executor = null;
	public static WebDriver driver = null;
	public static String browser = null;
	public static String URL = null;
	public static int timeLimit = 0;
	public static String mainDir = System.getProperty("user.dir");

	static {
		try {
			FileInputStream stream = new FileInputStream(mainDir+"\\src\\config.properties");
			Properties properties = new Properties();
			properties.load(stream);
			browser = properties.getProperty("browser");
			URL = properties.getProperty("URL");
			timeLimit = Integer.parseInt(properties.getProperty("timeLimit"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() 
	{
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",mainDir+"\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", mainDir + "\\Resources\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeLimit, TimeUnit.SECONDS);
		driver.get(URL);
		executor = (JavascriptExecutor) driver;
		
		return driver;
	}
	
	public static void highLight(WebElement elem) {
		executor.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", elem);
	}

	public static void click(By by) {
		WebElement elem = driver.findElement(by);
		highLight(elem);
		elem.click();
	}
	
	// for text box
	public static void typeText(By by,String value) {
		WebElement elem = driver.findElement(by);
		highLight(elem);
		elem.sendKeys(value);
	}
	
	//for static drop down select by index
	public static void dropDownByIndex(By by, int index) {
		WebElement elem = driver.findElement(by);
		highLight(elem);
		Select select = new Select(elem);
		select.selectByIndex(index);
	}
	
	//for static drop down select by value & visible text
	public static void staticDropDown(By by,String value) {
		WebElement elem = driver.findElement(by);
		highLight(elem);
		Select select = new Select(elem);
		boolean flag = true;
		
		do {
			try {
				if(flag)
					select.selectByValue(value);
				else
					select.deselectByVisibleText(value);
				break;
			}catch(Exception e) {
				if(flag) {
					flag=false;
					continue;
				}else
					e.printStackTrace();
			}
		}while(true);
	}
	
	// for quit
	public static void workDone() {
		driver.quit();
	}
}
