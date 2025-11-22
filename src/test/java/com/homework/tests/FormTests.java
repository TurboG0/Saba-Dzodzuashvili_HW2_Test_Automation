package com.homework.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Scanner;

public class FormTests extends BaseTest {

    @Test
    public void fillFormAndVerifyPopup() {
        driver.get("https://demoqa.com/automation-practice-form");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        driver.findElement(By.id("firstName")).sendKeys("Saba");
        driver.findElement(By.id("lastName")).sendKeys("Dzodzuashvili");
        driver.findElement(By.id("userEmail")).sendKeys("sabadzodzuashvili@gmail.com");


        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();

        driver.findElement(By.id("userNumber")).sendKeys("1234567899");

        driver.findElement(By.id("dateOfBirthInput")).click();
        new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")))
                .selectByVisibleText("November");
        new Select(driver.findElement(By.cssSelector(".react-datepicker__year-select")))
                .selectByValue("1986");
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='5']")).click();

        driver.findElement(By.id("subjectsInput")).sendKeys("Computer Science");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='hobbies-checkbox-1']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='hobbies-checkbox-2']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='hobbies-checkbox-3']"))).click();

        driver.findElement(By.id("currentAddress")).sendKeys("Tbilisi, Georgia");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("state"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='Uttar Pradesh']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("city"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='Lucknow']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        String name = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText();
        String email = driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td")).getText();

        Assert.assertEquals(name, "Saba Dzodzuashvili");
        Assert.assertEquals(email, "sabadzodzuashvili@gmail.com");

        System.out.println("Form filled and submitted successfully!");
        System.out.println("Popup is visible – check all data, then press ENTER to close...");
        new Scanner(System.in).nextLine();
    }
}