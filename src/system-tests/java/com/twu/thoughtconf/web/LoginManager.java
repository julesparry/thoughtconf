package com.twu.thoughtconf.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginManager {

    private WebDriver driver;

    public LoginManager(WebDriver driver){
        this.driver = driver;
    }

    public void login(String Username, String Password)
    {
        driver.findElement(By.id("username")).sendKeys(Username);
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.className("btn-submit")).click();
    }

    public void logout()
    {
        driver.get("https://castest.thoughtworks.com/cas/logout");
    }
}