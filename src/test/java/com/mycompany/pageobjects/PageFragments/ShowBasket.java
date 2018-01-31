package com.mycompany.pageobjects.PageFragments;

import com.mycompany.pageobjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShowBasket extends Page {

    //@FindBy(css = "div.helping-hand > div > div > div > div.link-container > button")
    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div/div[2]/div/div/div/div[6]/div/button")
    public WebElement skipORcontinue_bt;
    /*
    <button class="ej-button rounded-corners" ng-if="ShowContinueButton() &amp;&amp; ContinueButtonEnabled()" ng-click="ContinueButtonClick($event)" style="">
    Continue
            </button>

    <button ng-class="IsALink ? 'button-link arrow-button': 'ej-button rounded-corners'" ng-if="IsButtonEnabled" ng-click="ButtonClick($event)" class="ej-button rounded-corners">
    Continue
            </button>
    */
    public ShowBasket(WebDriver driver) {
        super(driver);
    }

    public void click_skipORcontinue_button() {
        skipORcontinue_bt = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(skipORcontinue_bt));
        skipORcontinue_bt.click();
    }

    public boolean validateBaket() {
        return true;
    }
}
