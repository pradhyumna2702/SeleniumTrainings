package HandsOn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJetRegistration {

	public static void main(String[] args) throws InterruptedException {
		
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();// Launch chrome
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");// enter URL

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"))).build().perform();
		action.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign up")).click();

		Select select = new Select(
				driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle")));
		select.selectByVisibleText("MS");

		driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxFirstName"))
				.sendKeys("Prakriti R");
		driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxLastName"))
				.sendKeys("Kumar");
		driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TEXTBOXINTLMOBILENUMBER"))
				.sendKeys("8147782008");
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword"))
				.sendKeys("test@1234");
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm"))
				.sendKeys("test@1234");

		WebElement date = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINPUTDOB"));
		String Dateval = "01/06/1994";

		SelectDateByJS(driver, date, Dateval);

		// driver.findElement(By.xpath("//tbody[@class='datepickerYears']//descendant::tr[3]/child::td[4]/a")).click();

		// driver.findElement(By.xpath("//th[@class='datepickerGoPrev']/a")).click();
		// driver.findElement(By.xpath("//tbody[@class='datepickerMonths']//descendant::tr[3]/child::td[2]/a")).click();
		//
		//
		// driver.findElement(By.xpath("(//td[@class='datepickerSaturday
		// validDate']/a)[3]")).click();
		//

		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail"))
				.sendKeys("prakrithi.ravi.kumar@gmail.com");
		driver.findElement(By.id("chkSpiceClubTnC")).click();
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_ButtonSubmit")).click();

	}

	    public static void  SelectDateByJS(WebDriver driver, WebElement element, String DateVal) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + DateVal + "');", element);

	}

}
