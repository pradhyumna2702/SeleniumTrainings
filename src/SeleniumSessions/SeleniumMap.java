package SeleniumSessions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMap {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/SPS/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://book.spicejet.com/Login.aspx");

		driver.findElement(By.id("ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID"))
				.sendKeys(userName("Dev"));
		driver.findElement(By.id("ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword"))
				.sendKeys(password("Dev"));

	}

	public static HashMap<String, String> getCredentials() {

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("admin", "8610558303:test@1234");
		map.put("QA", "76876:qa123");
		map.put("Dev", "76756:dev123");
		map.put("Prod", "76879:prod123");

		return map;

	}

	public static String userName(String role) {

		String cred = getCredentials().get(role);
		return cred.split(":")[0];

	}

	public static String password(String role) {

		String cred = getCredentials().get(role);
		return cred.split(":")[1];

	}

}
