package SeleniumSessions;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// Launch chrome

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://spicejet.com");// enter URL

		List<WebElement> linklist = driver.findElements(By.tagName("a"));

		System.out.println(linklist.size());

		// Advanced for loop
		// for(WebElement list: linklist) {
		//
		// System.out.println(list.getText());
		// }

		// By lambda exp
//		linklist.forEach(list -> {
//			System.out.println(list.getText());
//		});

		// Iterator method
		Iterator<WebElement> it = linklist.iterator();
		while (it.hasNext()) {
			WebElement wb = it.next();
			System.out.println(wb.getText());
		}

	}

}
