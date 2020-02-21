package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		
		WebDriver driver = new ChromeDriver();//Launch chrome
		driver.get("https://spicejet.com");//enter URL 
		
		driver.manage().window().maximize();//maximize the windows
		driver.manage().deleteAllCookies();//to delete all cookies/

		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		driver.get("https://spicejet.com");
		

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"))).build().perform();
		action.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();

		//Static Wait
		Thread.sleep(2000);

		driver.findElement(By.linkText("Sign up")).click();

	}

}
