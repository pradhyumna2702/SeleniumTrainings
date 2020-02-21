package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUPHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);

		// To click ok and to proceed further
		alert.accept();

		// To cancel the alert
		// alert.dismiss();

		if (text.equals("Please enter a valid user name")) {
			System.out.println("valid text");
		} else {
			System.out.println("Invalid text");
		}
	}

}
