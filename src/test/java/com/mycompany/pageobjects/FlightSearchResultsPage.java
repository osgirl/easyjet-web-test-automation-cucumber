package com.mycompany.pageobjects;

import com.mycompany.pageobjects.PageFragments.HelpingHandSubHeader;
import com.mycompany.pageobjects.PageFragments.MainHeader;
import com.mycompany.pageobjects.PageFragments.ShowBasket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightSearchResultsPage extends Page {

    @FindBy(css = ".flight-grid-day")  //price-container
    public List<WebElement> flightList;

    //@FindBy(css = ".div.flight-grid-flight-body > div > button")
    @FindBy(css = "button.flight-grid-flight-fare")
    public List<WebElement> availableFlightList;

    MainHeader mainHeader;
    HelpingHandSubHeader helpingHandSubHeader;
    ShowBasket showBasket;

    public FlightSearchResultsPage(WebDriver driver) {
        super(driver);
        mainHeader = new MainHeader(driver);
        helpingHandSubHeader = new HelpingHandSubHeader(driver);
        showBasket = new ShowBasket(driver);
    }

    public void select_any_available_Flight() {
        //System.out.println("availableFlightList = " + availableFlightList.size());
        //System.out.println("flightList = " + flightList.size());
        if (availableFlightList.size() > 0)
            jsClick(availableFlightList.get(0));
        //ToDo else seek next

    }
    public void  click_continue() {
        if (!mainHeader.is_basketLink_shown())
            showBasket.click_skipORcontinue_button();
        else
            helpingHandSubHeader.click_skipORcontinue_button();
    }
}
