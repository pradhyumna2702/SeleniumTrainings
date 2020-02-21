package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:\\Users\\p.a.madhusudan\\Desktop\\DOCS\\ACR.docx");

	}

}
