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




        @Test
        public void testSessionConfirmationPage(){
            testCreateSessionRedirection();
            createASession();
            driver.findElement(By.xpath("//button[@name='Publish']")).click();

            String ActualSessionName=driver.findElement(By.xpath("//div[1]/h2/i")).getText();
            assertThat(ActualSessionName,is(SessionName));


            String ActualConferenceName=driver.findElement(By.xpath("//div[2]/p[1]")).getText();
            assertThat(ActualConferenceName,is("Conference Name: "+ConferenceName));

            String ActualLocation=driver.findElement(By.xpath("//div[2]/p[2]")).getText();
            assertThat(ActualLocation,is("Location: "+Location));



            String ActualDate=driver.findElement(By.xpath("//div[2]/p[3]")).getText();
            assertThat(ActualDate,is("Date: 12 November 2012"));



            String ActualTime=driver.findElement(By.xpath("//div[2]/p[5]")).getText();
            assertThat(ActualTime,is("Time: 11:00 AM - 03:00 PM"));


            String ActualAbstract=driver.findElement(By.xpath("//div[2]/p[6]")).getText();
            assertThat(ActualAbstract,is("Abstract: "+Abstract));


            String ActualPresenterName=driver.findElement(By.xpath("//div[2]/p[7]")).getText();
            assertThat(ActualPresenterName,is("Speaker: "+PresenterName));



            String ActualAboutPresenter=driver.findElement(By.xpath("//div[2]/p[8]")).getText();
            assertThat(ActualAboutPresenter,is("About Speaker: "+AboutPresenter));

        }

        @AfterClass
        static public void functionAfterTests(){
            driver.close();
        }

}
