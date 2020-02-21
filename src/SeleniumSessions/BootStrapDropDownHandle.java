package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDownHandle {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// Launch chrome

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://accounts.google.com/signin/v2/identifier?hl=en&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");// enter URL
		
		WebElement element=driver.findElement(By.xpath("//div[@class='CeEBt Ce1Y1c eU809d']/div[@class='TquXA']"));
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='OA0qNb ncFHed']//descendant::span[@class='vRMGwf oJeWuf']"));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("Afrikaans")){
				list.get(i).click();
				break;
			}
			
		}
		
	}

}
