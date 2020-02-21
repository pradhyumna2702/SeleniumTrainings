package testNGSessions;

import org.testng.annotations.Test;

public class TestNGFeatures {

	@Test
	public void registrationPageTest() {
		System.out.println("registrationPageTest");
		//int i=9/0;
	}

	@Test(dependsOnMethods = "registrationPageTest")
	public void loginPageTest() {
		System.out.println("loginPageTest");
		//int i=9/0;
	}

	@Test(dependsOnMethods = "loginPageTest")
	public void homePageTest() {
		System.out.println("homePageTest");
	}

	@Test(dependsOnMethods = "registrationPageTest")
	public void searchPageTest() {
		System.out.println("searchPageTest");
	}
	
	@Test(priority=5,invocationCount=10)
	public void sum() {
		int a=5;
		int b=10;
		int c=a+b;
		System.out.println("sum of a and b is " +c);
	}
	
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test1() {
		String a="100A";
		System.out.println(Integer.parseInt(a));
	}

}
