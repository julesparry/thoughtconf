package com.twu.thoughtconf.web.page.tests;

import com.twu.thoughtconf.web.page.Application;
import com.twu.thoughtconf.web.page.Browser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleFunctionalTests {

   // Application application =
    //Browser browser = new Browser("http://localhost:8080/", true);

    @Rule
    public LoginLogoutRule rule = new LoginLogoutRule("test");


    @Test
    public void testCheckRedirection() {
        String ExpectedTitle= "CAS – Central Authentication Service";
        String ViewSesssionPage= "/thoughtconf/attendee/sessions" ;
        Browser testBrowser = rule.browser().open(ViewSesssionPage);
        assertThat(testBrowser.getPageTitle(),is(ExpectedTitle));

    }

}
