package SamokatTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


import java.time.Duration;

public class MakeOrder {
    @RunWith(Parameterized.class)


        private WebDriver driver;

        private final int numberOfButton;
        private final String name;
        private final String lastName;
        private final String metro;
        private final String address;
        private final String phone;
        private final String date;
        private final String period;


        public checkOrderButton(int numberOfButton, String name, String lastName, String metro, String address, String phone, String date, String period){
            this.numberOfButton = numberOfButton;
            this.name = name;
            this.lastName = lastName;
            this.metro = metro;
            this.address = address;
            this.phone = phone;
            this.date = date;
            this.period = period;

        }

        @Parameterized.Parameters
        public static Object[][] getOrderData(){
            return new Object[][]{
                    {0, "Иван", "Петров", "Крылатское", "Осенний б-р, 10", "+79777777777", "21.11.2022", "сутки"},
                    {1, "Мария", "Соколова", "Комсомольская", "Садовая, 33", "+79254326789", "01.10.2022", "двое суток"},
            };
        }

        @Before
        public void setUpChrome() {
            driver = new ChromeDriver();// для проверки в хроме
            //driver = new FirefoxDriver(); если приспичит проверить файерфоксе
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        @Test
        public void orderScooter(){
            OrderPage orderPage = new OrderPage(driver);

            orderPage.open();
            orderPage.pressCookieButton();
            orderPage.clickOrderButton(numberOfButton);
            orderPage.inputName(name);
            orderPage.inputLastName(lastName);
            orderPage.inputAddress(address);
            orderPage.selectMetroStation(metro);
            orderPage.inputPhoneNumber(phone);
            orderPage.clickNextButton();
            orderPage.selectDeliveryDate(date);
            orderPage.selectDropdownPeriod(period);
            orderPage.clickMiddleOrderButton();
            orderPage.clickConfirmButton();
            orderPage.checkOrderIsCreated();
        }

        @After
        public void tearDown(){
            driver.quit();
        }
    }
    

