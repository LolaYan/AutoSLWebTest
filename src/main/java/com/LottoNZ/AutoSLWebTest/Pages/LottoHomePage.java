/**
 * 
 */
package com.LottoNZ.AutoSLWebTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Lola
 * @email lyan@planittesting.co.nz
 * Note: define the findelement methods here in LottoHomePage
 */
public class LottoHomePage extends PageBase{

	public LottoHomePage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
		
		this.driver.switchTo().defaultContent();
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("#outerBodyWrapper"))));
	    
	}

	//******************* 
		// BYELEMENTS
		//**** Search
	public By BySearchSignUp()
    {
        return By.id("signupLink");
    }
    public By BySearchLogin()
    {
        return By.id("loginLink");
    }
    public By BySearchForgetPwd()
    {
        return By.id("requestForgotPasswordLink");
    }
    
    public static By BySearchPowerball()
    {
    	return By.cssSelector("*[title='Go to Lotto']");
	}
    public By BySearchBW()
    {
    	return By.cssSelector("*[title='Go to Big Wednesday']");
	}
    public By BySearchBullseye()
    {
    	return By.cssSelector("*[title='Go to Bullseye']");
	}
    public By BySearchKeno()
    {
    	return By.cssSelector("*[title='Go to Keno']");
	}
    public By BySearchPlay3()
    {
    	return By.cssSelector("*[title='Go to Play 3']");
	}
    public By BySearchIK()
    {
    	return By.cssSelector("*[title='Go to Instant Kiwi']");
	}
    public By BySearch2ndChance()
    {
    	return By.cssSelector("*[title='Go to Second Chance']");
	}
    
    
    
   
    
  	//******************* 
    // METHODS

    public void GoToSignUp()
    {
        //this.driver.findElement(BySearchSignUp()).click();
        Click(BySearchSignUp());
    }
    public void GoToLogin()
    {
        //this.driver.findElement(BySearchLogin()).click();
        Click(BySearchLogin());
    }
    public void GoToPowerball()
    {
        //this.driver.findElement(BySearchPowerball()).click();
        Click(BySearchPowerball());
    }
    public void GoToBW()
    {
        //this.driver.findElement(BySearchBW()).click();
        Click(BySearchBW());
    }
    public void GoToBullseye()
    {
        //this.driver.findElement(BySearchBullseye()).click();
    	Click(BySearchBullseye());
    }
    public void GoToKeno()
    {
        //this.driver.findElement(BySearchKeno()).click();
    	Click(BySearchKeno());
    }
    public void GoToPlay3()
    {
        //this.driver.findElement(BySearchPlay3()).click();
        Click(BySearchPlay3());
    }
    public void GoToIK()
    {
        //this.driver.findElement(BySearchIK()).click();
    	Click(BySearchIK());
    }

    public void GoTo2ndChance()
    {
        //this.driver.findElement(BySearch2ndChance()).click();
        Click(BySearch2ndChance());
    }
}
