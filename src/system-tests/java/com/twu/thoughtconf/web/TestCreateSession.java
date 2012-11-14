package com.twu.thoughtconf.web;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TestCreateSession {

        public static WebDriver driver;

        public void getURL(String url) {
            driver.get(url);
        }

        String OrganiserLoginURL="http://10.10.4.126:8080/thoughtconf/organiser";
        @BeforeClass
        public static void functionBeforeClass(){
            driver= new FirefoxDriver();

        }

        @Before
        public void functionBeforeTests(){
            getURL(OrganiserLoginURL);
        }

        @Test
        public void testCreateSessionRedirection() {
            driver.findElement(By.className("button")).click();
            //  String ExpectedURL="http://10.10.4.126:8080/thoughtconf/organiser/new" ;
            //String ActualURL=driver.getCurrentUrl();
            // assertThat(ActualURL, is(ExpectedURL));
        }

        String ConferenceName="ConferenceXYZ";
        String SessionName="SessionXYZ";
        String Location="LocationXYZ";
        String Date="2012-11-12";
        String Time="11:00-15:00";
        String Abstract="Abstract for session XYZ in conference XYZ";
        String PresenterName="PresenterXYZ";
        String AboutPresenter="PresenterXYZ has been working for XYZ years in ThoughtWorks as a BA QA Dev and Tech Ops";

        public void createASession(){
            driver.findElement(By.id("conferenceName")).sendKeys(ConferenceName);
            driver.findElement(By.id("sessionName")).sendKeys(SessionName);
            driver.findElement(By.id("sessionLocation")).sendKeys(Location);
            driver.findElement(By.id("sessionDate")).sendKeys(Date);
            driver.findElement(By.id("sessionTime")).sendKeys(Time);
            driver.findElement(By.id("abstract")).sendKeys(Abstract);
            driver.findElement(By.id("presenterName")).sendKeys(PresenterName);
            driver.findElement(By.id("aboutPresenter")).sendKeys(AboutPresenter);
        }


        public static String ConfirmationPageURL;

        @Test
        public void testSessionNameConfirmation(){
            testCreateSessionRedirection();
            createASession();
            driver.findElement(By.xpath("//button[@name='Publish']")).click();

            String ActualConferenceName=driver.findElement(By.xpath("//div[1]/h2/i")).getText();
            assertThat(ActualConferenceName,is(SessionName));
            ConfirmationPageURL=driver.getCurrentUrl();
            System.out.println(ConfirmationPageURL);
        }

        @Test
        public void testConferenceNameConfirmation(){

            System.out.println(ConfirmationPageURL);
            getURL(ConfirmationPageURL);
            String ActualConferenceName=driver.findElement(By.xpath("//div[2]/p[1]")).getText();
            assertThat(ActualConferenceName,is("Conference Name: "+ConferenceName));

        }
        @Test
        public void testLocationConfirmation(){

            getURL(ConfirmationPageURL);
            String ActualConferenceName=driver.findElement(By.xpath("//div[2]/p[2]")).getText();
            assertThat(ActualConferenceName,is("Location: "+Location));

        }


        @Test
        public void testDateConfirmation(){
            getURL(ConfirmationPageURL);
            String ActualConferenceName=driver.findElement(By.xpath("//div[2]/p[3]")).getText();
            assertThat(ActualConferenceName,is("Date: 12 November 2012"));

        }

        @Test
        public void testTimeConfirmation(){
            getURL(ConfirmationPageURL);

            String ActualConferenceName=driver.findElement(By.xpath("//div[2]/p[5]")).getText();
            assertThat(ActualConferenceName,is("Time: 11:00 AM - 03:00 PM"));

        }

        @Test
        public void testAbstractConfirmation(){

            getURL(ConfirmationPageURL);
            String ActualConferenceName=driver.findElement(By.xpath("//div[2]/p[6]")).getText();
            assertThat(ActualConferenceName,is("Abstract: "+Abstract));

        }

        @Test
        public void testPresenterNameConfirmation(){
            getURL(ConfirmationPageURL);
            String ActualConferenceName=driver.findElement(By.xpath("//div[2]/p[7]")).getText();
            assertThat(ActualConferenceName,is("Speaker: "+PresenterName));

        }
        @Test
        public void testAboutPresenterConfirmation(){
            getURL(ConfirmationPageURL);
            String ActualConferenceName=driver.findElement(By.xpath("//div[2]/p[8]")).getText();
            assertThat(ActualConferenceName,is("About Speaker: "+AboutPresenter));

        }

        @AfterClass
        static public void functionAfterTests(){
            driver.close();
        }

}
