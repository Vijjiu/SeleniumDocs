package org.iit.mmpiit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMRS {
	WebDriver driver;
	@Test
	public void findServiceType() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/appointmentschedulingui/manageAppointmentTypes.page");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click();
		List<WebElement> pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
		List<WebElement> serviceTypeList = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		boolean result = false;
		outer:
		for(int i = 0;i<pageList.size() ;i++)
		{
			for(int j=0;j<serviceTypeList.size();j++)
			{
				System.out.println(serviceTypeList.get(j).getText());
				if(serviceTypeList.get(j).getText().contains("ECG"))
				{
					System.out.println("Service Found");
					result = true;
					break outer;
				}
			}
			if(i!=pageList.size()-1)
			{	
			  System.out.println(i+"---"+ pageList.size());
			  pageList.get(i+1).click(); 
			}
			pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
			serviceTypeList = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		} 
		if(result == false)
		{
			 System.out.println("Service Not Found!!!");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
