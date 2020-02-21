package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotConcept {

	public static void main(String[] args) throws IOException {

		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// Launch chrome

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");// enter URL
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		File DestFile=new File("C:\\\\Users\\\\p.a.madhusudan\\\\eclipse-workspace\\\\SeleniumTrainingSession\\\\src\\\\SeleniumSessions\\\\google.png");
		
		FileHandler.copy(SrcFile, DestFile);


		
		//FileUtils.copyFile(SrcFile, new File("C:\\Users\\p.a.madhusudan\\eclipse-workspace\\SeleniumTrainingSession\\src\\SeleniumSessions"));

	}

}
