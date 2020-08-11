package DataDrivenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeLogin {
	

	@Test
	public void Browser() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\Selenium Browsers Jars\\Chrome\\Chrome 84\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[contains(@id,'btnLogin')]")).click();

		Thread.sleep(5000);

		System.out.println(driver.getTitle());

		
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"),
				"User Not able to login Sucessfully - Invalid Credentails");

		System.out.println("User Able to login Sucessfully - Valid Credentails");

		driver.quit();
	}
}
