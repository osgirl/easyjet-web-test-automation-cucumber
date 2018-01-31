package com.mycompany.pageobjects;

import com.mycompany.pageobjects.PageFragments.HelpingHandSubHeader;
import com.mycompany.pageobjects.PageFragments.MainHeader;
import com.mycompany.pageobjects.PageFragments.ShowBasket;
import com.mycompany.utils.PopupHandler;
import org.openqa.selenium.WebDriver;

public class HotelReservationPage extends Page {

    MainHeader mainHeader;
    HelpingHandSubHeader helpingHandSubHeader;
    ShowBasket showBasket;

    public HotelReservationPage(WebDriver driver) {
        super(driver);
        mainHeader = new MainHeader(driver);
        helpingHandSubHeader = new HelpingHandSubHeader(driver);
        showBasket = new ShowBasket(driver);
    }
    public void skip_hotel_reservation() {
        if (!mainHeader.is_basketLink_shown())
            showBasket.click_skipORcontinue_button();
        else
            helpingHandSubHeader.click_skipORcontinue_button();

        //handle hotel popup
        PopupHandler.switchToOriginalWindow(this.driver);
    }
}
