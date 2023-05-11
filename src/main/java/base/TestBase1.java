package base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase1 {
	
	//1st property
	public static WebDriver driver;
	
	public static Properties prop;
	
   //2nd property
	public  static void init() {
		
		try {
			prop=new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\AutomationTestingJan23\\config.properties");
		    prop.load(file);
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Config File is missing");
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase(" mozilla firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("please enter valid browser name");
		}
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
