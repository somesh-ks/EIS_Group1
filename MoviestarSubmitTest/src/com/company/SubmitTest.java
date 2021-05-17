package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class SubmitTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private final StringBuffer verificationErrors = new StringBuffer();

    private final List<Double> textButtonDelayList = new ArrayList<Double>();
    private final List<Double> iconButtonDelayList = new ArrayList<Double>();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSubmit1() throws Exception {

        try {
            File myObj = new File("files/text_button.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                this.textButtonDelayList.add(Double.parseDouble(myReader.nextLine()));
            }
            myObj = new File("files/icon_button.txt");
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                this.iconButtonDelayList.add(Double.parseDouble(myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numOfTests = Math.round((textButtonDelayList.size() + iconButtonDelayList.size()) / 2);
        if (textButtonDelayList.size() != iconButtonDelayList.size()) {
            numOfTests = 100; // arbitrary
        }
        double delayValue = 11500;

        for (int i = 0; i < numOfTests; i++) {

            driver.get("https://somesh-ks.github.io/EIS_moviestar/");

            int variation = Integer.valueOf(driver.findElement(By.id("variation_text")).getText());

            if (variation == 1) {
                delayValue = textButtonDelayList.get(i) * 1000;
            } else {
                delayValue = iconButtonDelayList.get(i) * 1000;
            }

            Thread.sleep((int) delayValue);
            driver.findElement(By.id("user_email")).clear();
            driver.findElement(By.id("user_email")).sendKeys("group1@upm.com");
            // driver.findElement(By.xpath("//span")).click();
            driver.findElement(By.id("submit" + variation)).click();
//            assertEquals("signed up", closeAlertAndGetItsText());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
