package com.twu.thoughtconf.web.page.tests;

import com.twu.thoughtconf.web.page.Browser;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.nullValue;

public class ExampleFunctionalTests {

    @Rule
    public LoginLogoutRule rule = new LoginLogoutRule("test");

    @Test
    public void shouldSearchForSomething() {
        Browser browser = rule.browser().open("/app");
        WebElement element = browser.findElement(By.id("create_session"));
        assertThat(element, not(nullValue()));
    }


//    @Test
//    public void shouldGoToSessionConfirmationPage() {
//        Browser browser = rule.browser().open("/app/conference-session/confirmation/1");
//        browser.findElement()
//    }

}
