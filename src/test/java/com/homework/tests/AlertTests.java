package com.homework.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests extends BaseTest {

    @Test
    public void handleTextBoxAlertAndVerify() {
        driver.get("https://demo.automationtesting.in/Alerts.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
        // Click the button that shows the prompt
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String myName = "Saba Dzodzuashvili";
        alert.sendKeys(myName);
        alert.accept();

        String resultText = driver.findElement(By.id("demo1")).getText();

        Assert.assertEquals(resultText, "Hello " + myName + " How are you today");

        System.out.println("Alert test passed! Result: " + resultText);
        System.out.println("Form submitted! Popup is visible. Press ENTER in console to close browser...");
        new java.util.Scanner(System.in).nextLine();
    }
}