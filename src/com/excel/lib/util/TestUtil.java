package com.excel.lib.util;

import java.util.ArrayList;

public class TestUtil {
	
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		
		Xls_Reader reader=new Xls_Reader("C:\\Users\\p.a.madhusudan\\eclipse-workspace\\SeleniumTrainingSession\\src\\com\\testdata\\testdata.xlsx");
		
		int rowcount=reader.getRowCount("regpage");
		
		for(int rownum=2;rownum<=rowcount;rownum++) {
			
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
			
			Object ob[]= {title,firstname,lastname,mobile,password,dob,email};
			
			
			mydata.add(ob);
			
		}
		
		return mydata;
		
		
	}

}