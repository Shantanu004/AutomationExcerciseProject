package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {

	public static WebDriver driver = null;
	public Properties PropForBaseInfo;
	public Properties PropForDataInfo;

	public void loadPropertiesFileOfWebAPPS() {   //To Manage Test Data 

		PropForBaseInfo = new Properties();
		File BaseDatafile = new File(System.getProperty("user.dir") + "\\BaseInfoConfig");
		try {
			FileInputStream BaseDatafis = new FileInputStream(BaseDatafile);
			PropForBaseInfo.load(BaseDatafis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		PropForDataInfo = new Properties();
		File TestDatafile = new File(System.getProperty("user.dir") + "\\TestDataConfig");
		try {
			FileInputStream TestDatafis = new FileInputStream(TestDatafile);
			PropForDataInfo.load(TestDatafis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver intilizeBrowserAndOpenApplicationURL(String browserName) { // To Execute test on Multiple Browser
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public void ChromeBrowserSetUp() {
		loadPropertiesFileOfWebAPPS();
		driver = intilizeBrowserAndOpenApplicationURL(PropForBaseInfo.getProperty("ChromeBrowser"));
		driver.get(PropForBaseInfo.getProperty("url"));
		driver.manage().window().maximize();
	}

	public void EdgeBrowserSetUp() {
		loadPropertiesFileOfWebAPPS();
		driver = intilizeBrowserAndOpenApplicationURL(PropForBaseInfo.getProperty("EdgeBrowser"));
		driver.get(PropForBaseInfo.getProperty("url"));
		driver.manage().window().maximize();
	}

	public void FireFoxBrowserSetUp() {
		loadPropertiesFileOfWebAPPS();
		driver = intilizeBrowserAndOpenApplicationURL(PropForBaseInfo.getProperty("FireFoxBrowser"));
		driver.get(PropForBaseInfo.getProperty("url"));
		driver.manage().window().maximize();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
