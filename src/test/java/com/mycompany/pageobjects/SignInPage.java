package com.mycompany.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends Page {

    @FindBy(id = "new-customer-radio")
    public WebElement new_customer_radio;

    @FindBy(id = "signup-email")
    public WebElement signup_email;

    @FindBy(id = "signup-login")
    public WebElement signup_login;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void select_new_customer_option() {
        //System.out.println("new_customer_radio.toString() = " + new_customer_radio.toString());
        new_customer_radio = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(new_customer_radio));
        new_customer_radio.click();
    }
    public void fill_email() {
        //System.out.println("signup_email = " + signup_email.toString());
        signup_email.sendKeys("poglietti@reply.com");
        signup_email = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(new_customer_radio));
        signup_email.sendKeys("poglietti@reply.com");
    }
    public void click_login_bt() {
        //System.out.println("signup_login = " + signup_login.toString());
        //signup_login.click();
        jsClick(signup_login);
    }

}
