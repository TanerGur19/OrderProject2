package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/tanergur/Documents/selenium dependencies/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		Random random2 = new Random();
		int result2 = random2.nextInt(100);

		Random random = new Random();
		int result = random.nextInt(90);

		while (result < 65) {
			result = random.nextInt(90);
		}
		char c = (char) result;
		String s = c + ".";

		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx"
				+ " (Links to an external site.)Links to an external site.aspx");

		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");

		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(String.valueOf(result));

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + s + " Smith");

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Anytown");

		Random random3 = new Random();
		int zip = random.nextInt(99999);

		while (zip < 10000) {
			zip = random3.nextInt(99999);
		}

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(String.valueOf(zip));

		Random card = new Random();
		int cardType = card.nextInt(3);

		Random cardNumber = new Random();
		int cardX = cardNumber.nextInt(10);
		if (cardType == 0) {
			driver.findElement(By.cssSelector("label[for='ctl00_MainContent_fmwOrder_cardList_0']")).click();
			StringBuilder sb = new StringBuilder();
			sb.append(4);

			for (int i = 0; i <= 15; i++) {
				sb.append(cardNumber.nextInt(10));

			}

			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(sb.toString());

		} else if (cardType == 1) {
			driver.findElement(By.cssSelector("label[for='ctl00_MainContent_fmwOrder_cardList_1']")).click();
			StringBuilder sb = new StringBuilder();
			sb.append(5);

			for (int i = 0; i <= 15; i++) {
				sb.append(cardNumber.nextInt(10));

			}
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(sb.toString());

		} else if (cardType == 2) {
			driver.findElement(By.cssSelector("label[for='ctl00_MainContent_fmwOrder_cardList_2']")).click();
			StringBuilder sb = new StringBuilder();
			sb.append(3);

			for (int i = 0; i <= 14; i++) {
				sb.append(cardNumber.nextInt(10));

			}
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(sb.toString());
		}

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("06/11");

		driver.findElement(By.linkText("Process")).click();

		String expected = "New order has been successfully added";
		String actual = driver.findElement(By.tagName("body")).getText();

		if (actual.contains(expected)) {

			System.out.println("pass");
		} else {
			System.out.println("fail");
			System.out.println("Expected:\n" + expected);
			System.out.println("Actual:\t" + actual);
		}

		Thread.sleep(4000);
		// driver.close();

	}
}