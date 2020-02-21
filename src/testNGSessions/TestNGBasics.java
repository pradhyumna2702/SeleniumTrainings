package testNGSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	@BeforeSuite
	public void setUp() {
		System.out.println("@BeforeSuite--Set the system properties");
	}

	@BeforeTest
	public void launchBrowser() {
		System.out.println("@BeforeTest--launchBrowser");
	}

	@BeforeClass
	public void launchURL() {
		System.out.println("@BeforeClass--launch the URL");
	}

	@BeforeMethod
	public void login() {
		System.out.println("@BeforeMethod--Login to app");
	}

	@Test(priority = 1)
	public void titleTest() {
		System.out.println("@Test 1--title test");
	}

	@Test(priority = 2)
	public void linkTest() {
		System.out.println("@Test 2---link test");
	}

	@AfterMethod
	public void closeApp() {
		System.out.println("@AfterMethod--closeApp");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("@AfterClass--closeBrowser");
	}

	@AfterTest
	public void deleteAllCookies() {
		System.out.println("@AfterTest--deleteAllCookies");
	}

	@AfterSuite
	public void reports() {
		System.out.println("@AfterSuite--generate reports");
	}

}
