package com.maven.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.maven.utilities.PageUtility;

public class Login {
	WebDriver dr;



	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement userName;

	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement passWord;

	@FindBy(xpath="//input[@id='btnSubmit']")
	private WebElement loGin;


	public Login(WebDriver dr) {
	    this.dr=dr;
	    PageFactory.initElements(dr, this);
	}




	public void setUserName(String struserName) {

	     PageUtility.sendInput(userName, struserName);

	}

	public void setPassword(String strPassword) {




	    PageUtility.sendInput(passWord, strPassword);

	}


	public void clickLogin() {

	    PageUtility.clickBtn(dr, loGin);


	}

}
