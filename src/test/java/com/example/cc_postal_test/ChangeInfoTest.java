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

public class ChangeInfoTest {
    public static AuthorizationPage loginPage;
    public static MainPage mainPage;
    public static AccountInfoPage accountInfoPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);
        accountInfoPage = new AccountInfoPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void changeInfoPageTest() throws InterruptedException {
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        mainPage.clickMenuBtn();
        mainPage.clickAccountInfoBtn();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        accountInfoPage.clickChangeInfoBtn();
        accountInfoPage.inputName(ConfProperties.getProperty("change_name"));
        accountInfoPage.inputSurname(ConfProperties.getProperty("change_surname"));
        accountInfoPage.clickSaveChangesBtn();
        accountInfoPage.clickChangePasswordBtn();

        //проверяем, появилось ли окно смены пароля
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//*[contains(text(), 'Изменение пароля')]")));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        //закрываем окно браузера
        driver.quit();
    }
}