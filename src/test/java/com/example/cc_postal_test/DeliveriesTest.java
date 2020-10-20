package com.example.cc_postal_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DeliveriesTest {
    public static AuthorizationPage loginPage;
    public static MainPage mainPage;
    public static DeliveriesPage deliveriesPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);
        deliveriesPage = new DeliveriesPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void sendDeliveryTest() throws InterruptedException {
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        mainPage.clickMenuBtn();
        mainPage.clickDeliveriesBtn();

        deliveriesPage.clickCreateDeliveryBtn();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        deliveriesPage.inputType(ConfProperties.getProperty("delivery_type"));
        deliveriesPage.inputWeight(ConfProperties.getProperty("delivery_weight"));
        deliveriesPage.inputDescription(ConfProperties.getProperty("delivery_desc"));
        deliveriesPage.clickSendDeliveryBtn();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//*[contains(text(), 'Ваши посылки')]")));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        driver.quit();
    }
}
