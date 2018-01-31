package com.mycompany.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookerPassengerDetails extends Page {

    @FindBy(id = "title-dropdown")
    public WebElement title_select;

    @FindBy(id = "firstname-textbox")
    public WebElement firstname;

    @FindBy(id = "lastname-textbox")
    public WebElement lastname;

    @FindBy(id = "password-textbox")
    public WebElement password;

    @FindBy(id = "house-number-textbox")
    public WebElement address1;

    @FindBy(id = "town-city-textbox")
    public WebElement city;

    @FindBy(id = "postcode-textbox")
    public WebElement postcode;

    @FindBy(id = "phone-number-textbox")
    public WebElement telephone;

    //@FindBy(css = "button[ng-click=Continue()]")
    @FindBy(css = "button.ej-button.rounded-corners")
    //@FindBy(css = "body > div.page-wrapper > main > div > div:nth-child(2) > div > div:nth-child(2) > div.above-below-container > div.above-section > div > div.section-content > div.edit-mode > div.button-container.centered-container > button")
    public WebElement continue_bt;

    @FindBy(name = "reasonForTravel-2")
    public WebElement reasonForTravel_radio;
    //<input type="radio" id="reason-2-507dc671-0382-42ee-a486-dfb65850e047" value="4|LEIS|" name="reasonForTravel-2" ng-model="Reason" required="" class="ng-dirty ng-valid-parse ng-valid ng-valid-required ng-touched" aria-checked="true" aria-invalid="false" style="">

    @FindBy(css = "button.ej-link-button.ej-arrow-button")
    public WebElement copyFromContactDetails_bt;

    @FindBy(id = "age-dropdown-adult-1")
    public WebElement ageDropDown;

    @FindBy(css = "body > div.page-wrapper > main > div > div:nth-child(2) > div > div:nth-child(2) > div.above-below-container > div.below-section > div > div.section-content > div.edit-mode > div.button-container.centered-container > button")
    //@FindBy(css = "button[ng-click='Continue()']")
    public WebElement continueToConfirm_bt;

    public BookerPassengerDetails(WebDriver driver) {
        super(driver);
    }

    public void fillBookerDetails() {

        firstname = (new WebDriverWait(driver, 10))
               .until(ExpectedConditions.visibilityOf(firstname));
        Select select = new Select(title_select);
        //select.selectByIndex(0);
        select.selectByVisibleText("Mr");
        //title_select.findElement(By.cssSelector("#title-dropdown > option:nth-child(1)")).click();
        firstname.sendKeys("firstname");
        lastname.sendKeys("lastname");
        password.sendKeys("Password123");
        address1.sendKeys("123 highstreet");
        city.sendKeys("Edinburgh");
        postcode.sendKeys("EH11 2BY");
        telephone.sendKeys("07711200300");
    }
    public void click_continue() {

        continue_bt = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(continue_bt));
        continue_bt.click();
    }
    public void fillPassengerDetails() {
        reasonForTravel_radio = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(reasonForTravel_radio));
        reasonForTravel_radio.click();
        copyFromContactDetails_bt.click();
        Select select = new Select(ageDropDown);
        select.selectByVisibleText("18+");
    }
    public void click_continue_to_confirm() {
        continueToConfirm_bt = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(continueToConfirm_bt));
        continueToConfirm_bt.click();
    }
}
