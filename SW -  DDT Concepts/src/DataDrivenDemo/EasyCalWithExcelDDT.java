package DataDrivenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.ExcelDataConfig;

public class EasyCalWithExcelDDT {
	WebDriver driver;

	@Test(dataProvider = "LoginHRM")
	public void Browser(String UserName, String Password) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\Selenium Browsers Jars\\Chrome\\Chrome 84\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.login.hiox.com/login?referrer=easycalculation.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("log_email")).sendKeys(UserName);
		driver.findElement(By.id("log_password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name='log_submit']")).click();

		Thread.sleep(5000);

		Assert.assertTrue(driver.getTitle().contains("Free Online Math Calculator and Converter"),
				"User Not able to login Sucessfully - Invalid Credentails");
		
		System.out.println("User Able to login Sucessfully - Valid Credentails");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "LoginHRM")

	public Object[][] passData() {
		ExcelDataConfig config = new ExcelDataConfig(
				"D:\\SeleniumCompleteClass\\SW -  DDT Concepts\\OrangeTestData\\OrangeHRM TestData.xlsx");
		int rows = config.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0; i<rows; i++) {
			
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
					}

		return data;
	}
}
