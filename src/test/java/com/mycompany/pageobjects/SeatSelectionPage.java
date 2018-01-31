package com.mycompany.pageobjects;

import com.mycompany.pageobjects.PageFragments.HelpingHandSubHeader;
import com.mycompany.pageobjects.PageFragments.MainHeader;
import com.mycompany.pageobjects.PageFragments.ShowBasket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeatSelectionPage extends Page {
    @FindBy(css = "div.helping-hand")
    public WebElement helpingHand_div;

    MainHeader mainHeader;
    HelpingHandSubHeader helpingHandSubHeader;
    ShowBasket showBasket;

    public SeatSelectionPage(WebDriver driver) {
        super(driver);
        mainHeader = new MainHeader(driver);
        helpingHandSubHeader = new HelpingHandSubHeader(driver);
        showBasket = new ShowBasket(driver);
        //waitforPageToLoad();
    }
    public void  skip_seat_selection() {
        if (!mainHeader.is_basketLink_shown())
            showBasket.click_skipORcontinue_button();
        else
            helpingHandSubHeader.click_skipORcontinue_button();
    }

}
