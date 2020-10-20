package com.example.cc_postal_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {
    public WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@name, 'login')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'password')]")
    private WebElement passwdField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(text(), 'Зарегистрироваться')]/..")
    private WebElement registrationBtn;


    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void clickRegistationBtn(){
        registrationBtn.click();
    }
}
