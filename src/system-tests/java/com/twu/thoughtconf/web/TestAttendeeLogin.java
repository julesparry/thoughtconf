package com.twu.thoughtconf.web;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestAttendeeLogin {

    public static WebDriver driver;

    String msg="";
    String ViewSesssionPage= "http://10.10.4.126:8080/thoughtconf/attendee/sessions" ;
    String ExpectedTitle="";
    LoginManager loginManager = new LoginManager(driver);


    @BeforeClass
    public static void Suitesetup(){

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("general.useragent.override","NokiaE72/GoBrowser/2.0.290");
        driver = new FirefoxDriver(profile);

    }


    @Before
    public void beforeTests(){

        getURL(ViewSesssionPage);
    }

    public void getURL(String url) {
        driver.get(url);
    }

    @Test
    public void testCheckRedirection() {
        ExpectedTitle= "CAS – Central Authentication Service";
        assertThat(driver.getTitle(),is(ExpectedTitle));

    }

    String correctUsername="test.twu";
    String correctPassword="Th0ughtW0rks@12";



    @Test
    public void testValidCredentials() {
        loginManager.login(correctUsername,correctPassword);

        ExpectedTitle="Attendee Home Page";

        assertThat(driver.getTitle() ,is(ExpectedTitle));
        loginManager.logout();
        driver.close();
    }


}