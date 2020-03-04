package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Enter;

public class WindowHandlePopUp {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// Launch chrome

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://popuptest.com/goodpopups.html");// enter URL
		
		
		driver.findElement(By.linkText("Good PopUp #2")).click();
		
		
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it=handles.iterator();
		
		String parentwindowid=it.next();
		System.out.println("parent window id is " +parentwindowid);
		
		String childwindowid=it.next();
		System.out.println("child window id is " +childwindowid);

		
		driver.switchTo().window(childwindowid);
		
		Thread.sleep(2000);
		
		System.out.println("child window title is " +driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentwindowid);
		
		Thread.sleep(2000);
		
		System.out.println("Parent window title is " +driver.getTitle());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
