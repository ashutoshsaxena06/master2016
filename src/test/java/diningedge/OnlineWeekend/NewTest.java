package diningedge.OnlineWeekend;

import org.testng.annotations.Test;

import com.util.Framework.SendFile;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	@Test
	public void f() {

		/*
		 * try { System.setProperty("webdriver.chrome.driver",
		 * "C:\\Ashutosh\\SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		 * 
		 * } catch (Exception e) { // TODO: handle exception System.out.println(
		 * "Chrome driver error"); }
		 * 
		 */

		// Create driver Instance for FF browser
		WebDriver driver = new FirefoxDriver();
		// Implicit wait for all instructions to be executed - 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Launch driver.get("http://powernet.kohlwholesale.com/pnet/eOrder")
		// URL for Kohl Wholsale
		driver.get("http://powernet.kohlwholesale.com/pnet/eOrder");
		// Maximize Window
		driver.manage().window().maximize();
		// Explicitly wait until iFrame is not visible
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement iFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentFrame")));
		System.out.println("Located iframe");
		// Switch to iFrame
		driver.switchTo().frame(iFrame);
		// Explicitly wait until UserName field is not visible - TimeOut 10
		// seconds

		// WebElement SignIn_btn =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value
		// ='button']")));
		// Enter UserName
		driver.findElement(By.xpath(".//*[@id='alphanumericspecialchars' and @type='text']")).sendKeys("38660");
		// Enter Password
		driver.findElement(By.xpath(".//*[@id='alphanumericspecialchars' and @type='password']")).sendKeys("leevia");

		// Click Sign In
		driver.findElement(By.xpath("//input[@name ='SubmitBtn']")).click();

		// Back to Parent iFrame - driver.switchTo().parentFrame();
		// Dismiss Alert
		isAlertPresent(driver);

		// Validate that we have reached login page.
		Assert.assertEquals("Login Successful", "http://powernet.kohlwholesale.com/pnet/eOrder",
				"http://powernet.kohlwholesale.com/pnet/eOrder");
		System.out.println("reached homepage");

		// Declared WebElements- Guides, Reports and History
		WebElement Reports_ddl = driver.findElement(By.xpath("//span[string()='Reports']"));
		WebElement Guides_ddl = driver.findElement(By.xpath("//span[string()='Guides']"));
		WebElement History_ddl = driver.findElement(By.xpath("//span[text()='History']"));

		/*-- Unused code --
		// Mouse Action- Use of Actions class Actions act =
		* new Actions(driver); // Click Reports and move to Guides, Select OG
		* 'History' // Mouse Hover Action- Select and click History
		* act.clickAndHold(Reports_ddl).build().perform();
		* act.moveToElement(Guides_ddl).build().perform(); //Selection of
		* History OG //((JavascriptExecutor)
		* driver).executeScript("arguments[0].scrollIntoView(true);",
		* History_ddl); act.moveToElement(History_ddl).build().perform();
		*/
		Reports_ddl.click();
		Guides_ddl.click();
		History_ddl.click();

		// Click on history
		// act.click(History_ddl).build().perform();
		System.out.println("Moved to History report page");

		// Explicitly wait until iFrame is not visible
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement iFrame1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentFrame")));
		System.out.println("Located iframe");
		// Switch to iFrame
		driver.switchTo().frame(iFrame1);

		// -- declaration of WB--
		// Declaration of WebElements - Advanced, Display prices, User Export
		// and Export
		WebElement Advanced_ddl = driver.findElement(By.xpath("//span[string()='Advanced']"));
		WebElement DisplayPrices_ddl = driver.findElement(By.xpath("//span[text()='Display Prices']"));

		// Click Advanced
		Advanced_ddl.click();
		// Click Display Prices
		DisplayPrices_ddl.click();
		System.out.println("Prices displayed");

		// Click Advanced to start export then click export and try User Export
		// to get the file
		WebElement UserExport_ddl = driver.findElement(By.xpath("//span[text()='User Export']"));
		WebElement Export_ddl = driver.findElement(By.xpath("//span[string()='Export']"));
		driver.findElement(By.xpath("//span[string()='Advanced']")).click();
		Export_ddl.click();
		UserExport_ddl.click();
		System.out.println("Clicked User Export");

		// SignOut
		// driver.findElement(By.xpath("//span[title='Signoff']"));
		System.out.println("signout successfully");

		NewTest k = new SendFile();
		try {
			k.sendMail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to connect senMail Class");
			e.printStackTrace();

		}
	}

	// Method to check if ALert is present on the page.
	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert handled");
			return true;
		} catch (NoAlertPresentException Ex) {
			System.out.println("No alert found");
			return false;
		}

	}

	public void sendMail() throws Exception {

	}

	// span[string()='Reports']
	// span[string()='Guides']
	// span[text()='History']
	// span[string()='Advanced']
	// span[text()='Display Prices']
	// span[string()='Export']
	// span[text()='User Export']

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
