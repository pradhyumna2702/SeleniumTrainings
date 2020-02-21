package testNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		driver = new ChromeDriver();// Launch chrome

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.google.com");// enter URL

	}

	@Test(priority = 2, groups = "logo")
	public void logoTest() {
		Boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
		System.out.println(b);
		Assert.assertTrue(b);
	}

	@Test(priority = 3, groups = "link")
	public void mailLinkTest() {
		WebElement element = driver.findElement(By.linkText("Gmail"));
		String t = element.getText();
		System.out.println(t);
		Assert.assertEquals(t, "mail");
	}

	@Test(priority = 1, groups = "title")
	public void googleTitleTest() {
		String s1 = driver.getTitle();
		System.out.println(s1);
	}

	@Test(priority = 4, groups = "link")
	public void imgLinkTest() {
		WebElement element = driver.findElement(By.linkText("Images"));
		System.out.println(element.getText());
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
