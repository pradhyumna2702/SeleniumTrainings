package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.excel.lib.util.Xls_Reader;
import HandsOn.SpiceJetRegistration;

public class DataDrivenTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\p.a.madhusudan\\\\Selenium\\\\Drivers\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// Launch chrome

		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://book.spicejet.com/Register.aspx");// enter URL

		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\p.a.madhusudan\\eclipse-workspace\\SeleniumTrainingSession\\src\\com\\testdata\\testdata.xlsx");
		int rowcount = reader.getRowCount("regpage");
		System.out.println("rowcount is " + rowcount);

		for (int rownum = 2; rownum <= rowcount; rownum++) {

			System.out.println("==============================");
			String title = reader.getCellData("regpage", "title", rownum);
			System.out.println(title);

			String firstname = reader.getCellData("regpage", "firstname", rownum);
			System.out.println(firstname);

			String lastname = reader.getCellData("regpage", "lastname", rownum);
			System.out.println(lastname);

			String mobile = reader.getCellData("regpage", "mobile", rownum);
			System.out.println(mobile);

			String password = reader.getCellData("regpage", "password", rownum);
			System.out.println(password);

			String dob = reader.getCellData("regpage", "dob", rownum);
			System.out.println(dob);

			String email = reader.getCellData("regpage", "email", rownum);
			System.out.println(email);

			Select select = new Select(
					driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle")));
			select.selectByVisibleText(title);

			driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxFirstName")).clear();
			driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxFirstName"))
					.sendKeys(firstname);

			driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxLastName")).clear();
			driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxLastName"))
					.sendKeys(lastname);

			driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TEXTBOXINTLMOBILENUMBER"))
					.clear();
			driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TEXTBOXINTLMOBILENUMBER"))
					.sendKeys(mobile);

			driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword"))
					.clear();
			driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword"))
					.sendKeys(password);

			driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm"))
					.clear();
			driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm"))
					.sendKeys(password);

			WebElement date = driver
					.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINPUTDOB"));

			SpiceJetRegistration.SelectDateByJS(driver, date, dob);
			driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail")).clear();
			driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail")).sendKeys(email);

			driver.findElement(By.id("chkSpiceClubTnC")).click();

		}
	}

}
