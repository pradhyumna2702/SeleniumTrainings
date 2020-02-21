package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://phptravels.org/clientarea.php");

		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("inputFirstName")).sendKeys("Pradhyumna");
		driver.findElement(By.xpath("//input[@id='inputLastName']")).sendKeys("Madhusudan");
		driver.findElement(By.id("inputEmail")).sendKeys("ananthanilaya@gmail.com");
		driver.findElement(By.id("inputPhone")).sendKeys("9789789998");
		driver.findElement(By.name("address2")).sendKeys("frazer town");

		
		//To handle dropdowns we need to use select class
		Select select = new Select(driver.findElement(By.id("inputCountry")));
		select.selectByVisibleText("India");
		

		Select select1 = new Select(driver.findElement(By.id("customfield1")));
		select1.selectByVisibleText("Friend");
		
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();

		driver.findElement(By.cssSelector("#inputCity")).sendKeys("BENGALURU");
		// driver.findElement(By.id("stateinput")).sendKeys("KARNATAKA");
		// driver.findElement(By.cssSelector("#inputPostcode")).sendKeys("560022");

		driver.findElement(By.xpath("//input[contains(@value,'Register')]")).click();

	}

}
