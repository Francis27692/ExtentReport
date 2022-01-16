package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenTest {

	public static void main(String[] args) {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("report.html");
		ExtentReports extReports = new ExtentReports();
		extReports.attachReporter(reporter);
		ExtentTest test = extReports.createTest("India vs Srilanka");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.co.in");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("India vs Srilanka");
		driver.findElement(By.xpath("//input[@name='q']")).submit();
		test.pass("Test Passed");
		driver.quit();
		extReports.flush();
		System.out.println("Mathew Updating");
	}
}
