package com.example.cc_postal_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveriesPage {
    WebDriver driver;
    public DeliveriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div[1]/button")
    WebElement createDeliveryBtn;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/div[2]/div[2]/div/input[1]")
    WebElement deliveryType;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/div[2]/div[2]/div/input[2]")
    WebElement deliveryWeight;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/div[2]/div[2]/div/textarea")
    WebElement deliveryDescription;

    @FindBy(xpath = "/html/body/div/div/div/main/div/div/div/div/div/div[3]/button[1]")
    private WebElement sendDelivery;

    public void clickCreateDeliveryBtn(){
        createDeliveryBtn.click();
    }

    public void inputType(String type){
        deliveryType.sendKeys(type);
    }
    public void inputWeight(String weight){
        deliveryWeight.sendKeys(weight);
    }
    public void inputDescription(String description){
        deliveryDescription.sendKeys(description);
    }

    public void clickSendDeliveryBtn(){
        sendDelivery.click();
    }
}
