package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

public class ExplicitWaitConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// Launch chrome

		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");// enter URL

		WebElement wb = wait.ignoring(StaleElementReferenceException.class).until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"))));
		wb.click();

		// clickOnElement(driver,
		// driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")), 20);

	}

	// public static void clickOnElement(WebDriver driver, WebElement locator, int
	// timeout) {
	//
	// new WebDriverWait(driver,
	// timeout).ignoring(StaleElementReferenceException.class)
	// .until(ExpectedConditions.elementToBeClickable(locator));
	// locator.click();
	// }

}
