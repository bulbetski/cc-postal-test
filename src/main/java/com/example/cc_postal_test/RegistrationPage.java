package com.example.cc_postal_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
//
//    private static final int SURNAME_INDEX = 1;
//    private static final int NAME_INDEX = 2;
//    private static final int PATRONIM_INDEX = 3;
//    private static final int LOGIN_INDEX = 4;
//    private static final int PASSPORT_INDEX = 5;
//    private static final int PASSWORD_INDEX = 6;


    public WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/main/div/div/div/div/div[1]/div/form/div[1]/div/div[1]/div/input")
    private WebElement surnameField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/main/div/div/div/div/div[1]/div/form/div[2]/div/div[1]/div/input")
    private WebElement nameField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/main/div/div/div/div/div[1]/div/form/div[3]/div/div[1]/div/input")
    private WebElement patronimField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/main/div/div/div/div/div[1]/div/form/div[4]/div/div[1]/div/input")
    private WebElement loginField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/main/div/div/div/div/div[1]/div/form/div[5]/div/div[1]/div/input")
    private WebElement passportFieild;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/main/div/div/div/div/div[1]/div/form/div[6]/div/div[1]/div/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(text(), 'Зарегистрироваться')]/..")
    private WebElement registrationBtn;
//
    public void inputSurname(String surname){
        surnameField.sendKeys(surname);
    }
    public void inputName(String name){
        nameField.sendKeys(name);
    }
    public void inputPatronim(String patronim){
        patronimField.sendKeys(patronim);
    }
    public void inputLogin(String login){
        loginField.sendKeys(login);
    }
    public void inputPassport(String passport){
        passportFieild.sendKeys(passport);
    }
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickRegistationBtn(){
        registrationBtn.click();
    }
}
