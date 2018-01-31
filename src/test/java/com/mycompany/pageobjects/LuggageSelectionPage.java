package com.mycompany.pageobjects;

import com.mycompany.pageobjects.PageFragments.HelpingHandSubHeader;
import com.mycompany.pageobjects.PageFragments.MainHeader;
import com.mycompany.pageobjects.PageFragments.ShowBasket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LuggageSelectionPage extends Page {

    //@FindBy(css = "input[value='Accept & Continue'][type=submit]")
    //@FindBy(css = "div.option-item:nth-child(1) > input:nth-child(1)")
    //@FindBy(css = "input[value='Accept &amp; Continue'][type=submit]")
    @FindBy(css = "div.option-item > input")
    public WebElement cabinBagPolicy_Accept;
    //<input class="ej-button rounded-corners" type="submit" value="Accept &amp; Continue >" aria-label="Click to accept and move on" ng-click="OnSelect('0')">


    MainHeader mainHeader;
    HelpingHandSubHeader helpingHandSubHeader;
    ShowBasket showBasket;

    public LuggageSelectionPage(WebDriver driver) {
        super(driver);
        mainHeader = new MainHeader(driver);
        helpingHandSubHeader = new HelpingHandSubHeader(driver);
        showBasket = new ShowBasket(driver);
    }

    public void skip_luggage_selection() {
        if (!mainHeader.is_basketLink_shown())
            showBasket.click_skipORcontinue_button();
        else
            helpingHandSubHeader.click_skipORcontinue_button();
    }

    public  void accept_cabin_bag_policy() {
        //System.out.println("cabinBagPolicy_Accept = " + cabinBagPolicy_Accept.toString());
        cabinBagPolicy_Accept = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(cabinBagPolicy_Accept));
        //cabinBagPolicy_Accept.click();
        //Actions actions = new Actions(driver);
        //actions.moveToElement(cabinBagPolicy_Accept).click().perform();
        jsClick(cabinBagPolicy_Accept);
    }
}
