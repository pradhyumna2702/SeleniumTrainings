package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.lib.util.TestUtil;

import HandsOn.SpiceJetRegistration;

public class DataProviderConcept {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\p.a.madhusudan\\\\\\\\Selenium\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();// Launch chrome
		driver.manage().window().maximize();// maximize the windows
		driver.manage().deleteAllCookies();// to delete all cookies/

		// Dynamic Wait

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://book.spicejet.com/Register.aspx");// enter URL

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {

		ArrayList<Object[]> data = TestUtil.getDataFromExcel();
		return data.iterator();

	}

	@Test(dataProvider = "getTestData")
	public void launchRegPage(String title, String firstname, String lastname, String mobile, String password,
			String dob, String email) {

		Select select = new Select(
				driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle")));
		select.selectByVisibleText(title);

		driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxFirstName")).clear();
		driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxFirstName"))
				.sendKeys(firstname);

		driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxLastName")).clear();
		driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxLastName"))
				.sendKeys(lastname);

		driver.findElement(By.name("CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TEXTBOXINTLMOBILENUMBER")).clear();
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

		WebElement date = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINPUTDOB"));

		SpiceJetRegistration.SelectDateByJS(driver, date, dob);
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail")).clear();
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail")).sendKeys(email);

		driver.findElement(By.id("chkSpiceClubTnC")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
