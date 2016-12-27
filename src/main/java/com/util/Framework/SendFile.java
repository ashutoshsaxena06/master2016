package com.util.Framework;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendFile {

	public void sendMail() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com/");
		// open gmail
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("teamesave@gmail.com");
		// enter emailid
		driver.findElement(By.xpath("//input[@id='next']")).click();
		// click Next
		driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("@Shu13579");
		// enter password
		driver.findElement(By.xpath("//*[@id='signIn']")).click();
		// wait to load Gmail account
		WebDriverWait wait = new WebDriverWait(driver, 200);
		WebElement compose_btn = wait
				.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(text(),'COMPOSE')]"))));
		// click on sign in
		compose_btn.click();
		// click on compose button

		driver.findElement(By.xpath("//form[1]//textarea[1]")).sendKeys("frank@cut-edge.net");
		// enter email id where you need to send email
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		driver.findElement(By.xpath("//div[@class='aoD az6']//input[@class='aoT']"))
				.sendKeys("Kohl Wholsale OG attachment - " + df.format(calobj.getTime()));
		// Enter subject
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
		// click on attachment icon
		StringSelection ss = new StringSelection("C:\\Users\\ashsaxen\\Downloads\\export.csv");
		// upload your file using RobotClass
		// attach your path where file is located.
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		// Click on send
		System.out.println("Mail send to Macros");
	}
}
