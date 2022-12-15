package com.maven.base;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;


public class Base {
	private WebDriver dr;
	public static Properties prop;
	
	@BeforeSuite
public void initialization() throws Exception {
		
		prop=new Properties();
		FileInputStream inputStream=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop.load(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
		if(prop.getProperty("browser").equals("chrome")) {
			setDriver(new ChromeDriver());
		} 
		else if(prop.getProperty("browser").equals("firefox")) {
			setDriver(new FirefoxDriver());
		}
		else if(prop.getProperty("browser").equals("edge")) {
			setDriver(new EdgeDriver());
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	public WebDriver getDriver() {
		return dr;
	}
	private void setDriver(WebDriver driver) {
		this.dr = driver;
	}
	
	
}
