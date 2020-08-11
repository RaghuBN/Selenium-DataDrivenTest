package DataDrivenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EasyCalculationDDT {

	WebDriver driver;

	@Test(dataProvider = "EasyCalculation")
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

	@DataProvider(name = "EasyCalculation")
	public Object[][] passData() {
		Object[][] data = new Object[3][2];

		data[0][0] = "9740673180";
		data[0][1] = "raghubn";

		data[1][0] = "9740673180";
		data[1][1] = "raghubn@123";

		data[2][0] = "raghubn2";
		data[2][1] = "raghubn";

		return data;
	}
}
