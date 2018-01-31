package com.mycompany.pageobjects.PageFragments;

import com.mycompany.pageobjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpingHandSubHeader extends Page {

    //@FindBy(css = "button.button-link.arrow-button")
    @FindBy(css = "div.helping-hand > div > div > div > div.link-container > button")
    public WebElement skipORcontinue_bt;
    //body > div.page-wrapper > header > div.helping-hand > div > div > div > div.button-container > button


    public HelpingHandSubHeader(WebDriver driver) {
        super(driver);
    }

    public void click_skipORcontinue_button() {
        skipORcontinue_bt = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(skipORcontinue_bt));
        skipORcontinue_bt.click();
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", skipORcontinue_bt);
    }
}
