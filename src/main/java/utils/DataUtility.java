package utils;

import org.openqa.selenium.WebDriver;

public class DataUtility {
	
	WebDriver driver;

	public DataUtility(WebDriver driver) {
		this.driver=driver;
	}
	public String randomEmailGenerator() {
		 String randomemail = "lsnsponsor+"+System.currentTimeMillis()+"@gmail.com";
		 System.out.println("email"+randomemail);
		return randomemail;
	  }
}
