package com.example.cc_postal_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"inspire\"]/div/header/div/button")
    private WebElement menuBtn;

    @FindBy(xpath = "//*[contains(text(), 'Личный кабинет')]/..")
    private WebElement accountInfo;

    @FindBy(xpath = "//*[contains(text(), 'Посылки')]/..")
    private WebElement deliveries;

    public void clickMenuBtn(){
        menuBtn.click();
    }

    public void clickAccountInfoBtn(){
        accountInfo.click();
    }
    public void clickDeliveriesBtn() {
        deliveries.click();
    }
}