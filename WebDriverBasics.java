package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);

		// Validation

		if (title.equals("Google")) {
			System.out.println("valid Title");
		} else {
			System.out.println("invalid title");

		}
		
		String page=driver.getPageSource();
		System.out.println(page);
		driver.quit();
		
		
	}

}
