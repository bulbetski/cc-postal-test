package com.example.cc_postal_test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInfoPage {
    WebDriver driver;
    public AccountInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/form/div[1]/div/div[1]/div/input")
    private WebElement idField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/form/div[2]/div/div[1]/div/input")
    private WebElement loginField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/form/div[3]/div/div[1]/div/input")
    private WebElement nameField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/form/div[4]/div/div[1]/div/input")
    private WebElement patronimField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/form/div[5]/div/div[1]/div/input")
    private WebElement surnameField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/form/div[6]/div/div[1]/div/input")
    private WebElement passportField;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/form/div[7]/div/div[1]/div/input")
    private WebElement addressField;

    @FindBy(xpath = "//*[contains(text(), 'Изменить информацию')]/..")
    private WebElement changeInfoBtn;

    @FindBy(xpath = "//*[contains(text(), 'Сохранить')]/..")
    private WebElement saveChangesBtn;

    @FindBy(xpath = "//*[contains(text(), 'Изменить пароль')]/..")
    private WebElement changePasswordBtn;

    public void inputName(String name){
        nameField.sendKeys(Keys.chord(Keys.CONTROL, "a"), name);
    }
    public void inputSurname(String surname){
        surnameField.sendKeys(Keys.chord(Keys.CONTROL, "a"), surname);
    }
    public void clickChangeInfoBtn(){
        changeInfoBtn.click();
    }
    public void clickSaveChangesBtn(){
        saveChangesBtn.click();
    }

    public void clickChangePasswordBtn(){
        changePasswordBtn.click();
    }
}
