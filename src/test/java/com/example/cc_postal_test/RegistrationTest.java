package com.example.cc_postal_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class RegistrationTest {
    public static AuthorizationPage loginPage;
    public static WebDriver driver;
    public static RegistrationPage registrationPage;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new AuthorizationPage(driver);
        registrationPage = new RegistrationPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void registrationTest(){
        loginPage.clickRegistationBtn();
        registrationPage.inputSurname(ConfProperties.getProperty("reg_test"));
        registrationPage.inputName(ConfProperties.getProperty("reg_test"));
        registrationPage.inputPatronim(ConfProperties.getProperty("reg_test"));
        registrationPage.inputLogin(ConfProperties.getProperty("reg_test"));
        registrationPage.inputPassport(ConfProperties.getProperty("reg_passport"));
        registrationPage.inputPassword(ConfProperties.getProperty("reg_test"));
        registrationPage.clickRegistationBtn();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//*[contains(@id, 'greeting')]")));
    }
}
