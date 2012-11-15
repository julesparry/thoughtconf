package com.twu.thoughtconf.web.page.tests;

import com.twu.thoughtconf.web.page.Application;
import com.twu.thoughtconf.web.page.Browser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestAttendeeLogin {

    static String ViewSesssionPage= "/thoughtconf/attendee/sessions" ;
    String correctUsername="test.twu";
    String correctPassword="Th0ughtW0rks@12";
    Browser browser;

    @Rule
    public static LoginLogoutRule rule = new LoginLogoutRule("test");

    @Before
    public void startBrowser(){
        browser = rule.browser();
        browser.open(ViewSesssionPage);
    }

    @Test
    public void testCheckRedirection() {
        String ExpectedTitle= "CAS – Central Authentication Service";
        assertThat(browser.getPageTitle(),is(ExpectedTitle));
    }

//    @Test
//    public void testValidCredentials() {
//        browser.findElement(By.id("username")).sendKeys(correctUsername);
//        browser.findElement(By.id("password")).sendKeys(correctPassword);
//        browser.findElement(By.className("btn-submit")).click();
//        browser.timeout();
//        String ExpectedTitle="Attendee Home Page";
//        assertThat(browser.getPageTitle() ,is(ExpectedTitle));
//
//    }






}
