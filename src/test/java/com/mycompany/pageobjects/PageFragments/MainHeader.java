package com.mycompany.pageobjects.PageFragments;

import com.mycompany.pageobjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainHeader extends Page {

    //@FindBy(css = "body > div:nth-child(8) > a")
    @FindBy(css = ".basket-header-text.show-basket-button.basket-header-funnel")
    public WebElement showBasket_link;

    public MainHeader(WebDriver driver) {
        super(driver);
    }
    public boolean is_basketLink_shown() {
        try {
            showBasket_link = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(showBasket_link));
        }catch (Exception e){
            //e.printStackTrace();
            return false;
        }
        return true;
    }
    public void click_showBasket() {
        showBasket_link.click();
    }
}
