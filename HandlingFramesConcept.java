package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingFramesConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/SPS/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();// Launch chrome
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://paytm.com");// enter URL

		WebElement element = driver
				.findElement(By.xpath("//span[@class='_3B8E']//following::div[text()='Log In/Sign Up']"));

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		// Thread.sleep(5000);

		int totalfrmaes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("total no of frames is ..." + totalfrmaes);

		
		for (int i = 0; i < totalfrmaes; i++) {
			driver.switchTo().frame(i);
			int s = driver.findElements(By.xpath("//div/span[text()='Login/Signup with mobile number and password']"))
					.size();
			System.out.println("size = " + s);

			if (s == 0)
				driver.switchTo().defaultContent();
			else
				break;
		}

		driver.findElement(By.xpath("//div/span[text()='Login/Signup with mobile number and password']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("8147146560");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("pass@1234");

	}

}
