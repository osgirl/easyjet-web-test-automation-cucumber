package com.mycompany.pageobjects;

import com.mycompany.model.TravelBooking;
import com.mycompany.pageobjects.PageFragments.ShowBasket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketConfirmatioAndPaymentPage extends Page {

    @FindBy(css = ".booker-details")
    WebElement bookersDetails_ul;

    ShowBasket showBasket;

    public BasketConfirmatioAndPaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean validate_booker_details() {
        return true;
    }
    public boolean validate_passenger_details() {
        return true;
    }
    public boolean validate_basket_details(TravelBooking travelBooking) {
        //TODO
        return true;
    }
}
