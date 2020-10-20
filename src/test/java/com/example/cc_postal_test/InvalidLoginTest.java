package com.example.cc_postal_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InvalidLoginTest {
    public static AuthorizationPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new AuthorizationPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void invalidLoginTest(){
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("invalid_data"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("invalid_data"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//*[contains(text(), 'Неверное имя пользователя или пароль')]")));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        //закрываем окно браузера
        driver.quit();
    }
}
