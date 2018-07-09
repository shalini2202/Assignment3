package com.assignment3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class FlightFunction {
	
	static WebDriver driver;
	
	   
    public  void login(String username, String password) 
    {

			   driver.findElement(By.name("userName")).sendKeys(username);
			    
			   driver.findElement(By.name("password")).sendKeys(password);
			    
			   driver.findElement(By.name("login")).click();
			    	   
	}  
    
    
    public void signOFFVerification()
    {
        String s = driver.findElement(By.linkText("SIGN-OFF")).getText();
 	    System.out.println(s);
 	    Assert.assertTrue(s.contains("SIGN-OFF"));
 	    System.out.println("Verification Successfull!!!");
 	    
    }
    
    
    public void flightDetails(String source, String destination, String preference)
    {
    	 driver.findElement(By.xpath("//input[@value='oneway']")).click();
    	 
    	 Select s=new Select(driver.findElement(By.name("passCount")));
	     s.selectByIndex(1);
	     
	     Select s11=new Select(driver.findElement(By.name("fromPort")));
	     s11.selectByVisibleText(source);
	     
	     Select s12=new Select(driver.findElement(By.name("fromMonth")));
	     s12.selectByIndex(1);
	     
	     Select s13=new Select(driver.findElement(By.name("fromDay")));
	     s13.selectByIndex(1);
	     
	     Select s14=new Select(driver.findElement(By.name("toPort")));
	     s14.selectByVisibleText(destination);
	     
	     Select s15=new Select(driver.findElement(By.name("toMonth")));
	     s15.selectByVisibleText("March");
	     
	     Select s16=new Select(driver.findElement(By.name("toDay")));
	     s16.selectByIndex(1);
	     
	     driver.findElement(By.xpath("//input[@value='Business']")).click();
	     
	     Select s17=new Select(driver.findElement(By.name("airline")));
	     s17.selectByVisibleText(preference);
	     
	     driver.findElement(By.name("findFlights")).click();
	     
    }
    
    
    public void cityVerification()
    {
    	
    	 String City = driver.findElement(By.xpath("(//td[@class = 'title']/b/font)[1]")).getText();
         System.out.println(City);
	     Assert.assertTrue(City.contains("Paris to London"));
	     System.out.println("Verification Successfull!!!");
	     
	     driver.findElement(By.name("reserveFlights")).click();
		    
    }
    
    
    public void personalDetails(String userFN1, String userLN1,String userFN2, String userLN2)
    {
    	driver.findElement(By.name("passFirst0")).sendKeys(userFN1);
    	
    	driver.findElement(By.name("passLast0")).sendKeys(userLN1);
    	
        Select s18=new Select(driver.findElement(By.name("pass.0.meal")));
	    s18.selectByIndex(1);
	    
    	driver.findElement(By.name("passFirst1")).sendKeys(userFN2);
    	
    	driver.findElement(By.name("passLast1")).sendKeys(userLN2);
    	
    	Select s19=new Select(driver.findElement(By.name("pass.1.meal")));
	    s19.selectByIndex(3);
    	
    }
    
    
    public void creditCard()
    {
    	 Select s19=new Select(driver.findElement(By.name("creditCard")));
	     s19.selectByIndex(1);
	     
	     driver.findElement(By.name("creditnumber")).sendKeys("2202199222021992");
	     
	     Select s20=new Select(driver.findElement(By.name("cc_exp_dt_mn")));
	     s20.selectByIndex(4);
	     
	     Select s21=new Select(driver.findElement(By.name("cc_exp_dt_yr")));
	     s21.selectByValue("2002");
	     
	     driver.findElement(By.name("cc_frst_name")).sendKeys("Shalini");
	     
	     driver.findElement(By.name("cc_last_name")).sendKeys("Gupta");
	     
	     driver.findElement(By.name("ticketLess")).click();
	     
	     driver.findElement(By.xpath("//input[@name = 'buyFlights']")).click();
	           
    }
    
    
    public void bookingVerification()
    {
    	
    	String book = driver.findElement(By.xpath("//font[@size = '+1']")).getText();
    	System.out.println(book);
    	Assert.assertTrue(book.contains("Your itinerary has been booked!"));
    	System.out.println("Verification Successfull!!!");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a631020\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://newtours.demoaut.com/");
	    
	    FlightFunction ff = new FlightFunction();
	    
	    ff.login("demo","demo");
	    ff.signOFFVerification();
	    ff.flightDetails("Paris", "London", "Blue Skies Airlines");
	    ff.cityVerification();
	    ff.personalDetails("Shalini", "Gupta", "Shikha", "Gupta");
	    ff.creditCard();
	    ff.bookingVerification();
	    

	}

}
