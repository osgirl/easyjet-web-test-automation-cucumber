package com.mycompany.pageobjects;

import com.mycompany.pageobjects.PageFragments.HelpingHandSubHeader;
import com.mycompany.pageobjects.PageFragments.MainHeader;
import com.mycompany.pageobjects.PageFragments.ShowBasket;
import org.openqa.selenium.WebDriver;

public class CarHirePage extends Page {

    MainHeader mainHeader;
    HelpingHandSubHeader helpingHandSubHeader;
    ShowBasket showBasket;



    public CarHirePage(WebDriver driver) {
        super(driver);
        mainHeader = new MainHeader(driver);
        helpingHandSubHeader = new HelpingHandSubHeader(driver);
        showBasket = new ShowBasket(driver);
    }
    public void  skip_car_hire_selection() {
        try {
            if (!mainHeader.is_basketLink_shown())
                showBasket.click_skipORcontinue_button();
            else
                helpingHandSubHeader.click_skipORcontinue_button();
        } catch (Exception e) {
            System.out.println("Signin popup may have arrived too fast");
            //e.printStackTrace();
        }
    }
}
