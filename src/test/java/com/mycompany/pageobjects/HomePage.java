package com.mycompany.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by user
 */
public class HomePage extends Page {

    public static String url = "https://www.easyjet.com";

    //@FindBy(name = "origin")
    @FindBy(css = "input[name=origin][type=text]")
    public WebElement from;

    @FindBy(id = "ui-id-1")
    public WebElement from_autoSuggest;

    //@FindBy(name = "destination")
    @FindBy(css = "input[name=destination][type=text]")
    public WebElement to;

    @FindBy(id = "ui-id-2")
    public WebElement to_autoSuggest;

    @FindBy(id = "one-way")
    public WebElement oneway_checkbox;

    @FindBy(css = "button[ej-click-event='SubmitFlightSearch()']")
    public WebElement search_submit;

    @FindBy(css = ".day")
    public List<WebElement> travelDays;


    //@FindBy(css="button:contains('Okay, got it')") //does not work
    //@FindBy(xpath = "//button[text()='Okay, got it']") //works
    @FindBy(css = "button[ng-click='DoAcceptCookiePolicy()']")
    public WebElement cookiePolicy_bt;

    //*[@id="routedatepicker-63714"]/span[2]/span //span
    @FindBy(xpath = "//span[text()='Departing']")
    public WebElement departureDate_span;

    public HomePage(WebDriver driver) {
        super(driver);
       // driver.get(url);
    }
    public void visitUrl(){
        driver.get(url);
    }

    public boolean isOnPage() {
        return getTitle().startsWith("Home");
    }

    public void acceptCookiePolicy() {
        cookiePolicy_bt = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(cookiePolicy_bt));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Object aa=executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", cookiePolicy_bt);
        System.out.println("cookiePolicy_bt : " + aa.toString());


        cookiePolicy_bt.click();
    }
    public void fill_oneway_checkbox(boolean isOneWay) {

        oneway_checkbox = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(oneway_checkbox));
        //chrome thrwoing wrong area will receive click error although firefox works fine
        //oneway_checkbox.click();
        // oneway_checkbox.sendKeys(Keys.RETURN); //wont work either

        /*** chrome has a problem with drawing;use either js or Actions ***/
        // new Actions(driver).moveToElement(oneway_checkbox).click().perform();
        jsClick(oneway_checkbox);

    }

    public void fill_from_location(String travellingFrom){
        from.clear();
        from.sendKeys(travellingFrom);
        from_autoSuggest = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(from_autoSuggest));
        List<WebElement> from_cities = from_autoSuggest.findElements(By.tagName("li"));
        //System.out.println("from_cities.toString() = " + from_cities.toString());
        for(WebElement we : from_cities){
            if (we.findElement(By.cssSelector("span:nth-child(1)")).getText().contains(travellingFrom))
                    we.click();
            //System.out.println("we = " + we.findElement(By.cssSelector("span:nth-child(1)")).getText());
        }
    }

    public void fill_to_location(String travellingTo){
        to.clear();
        to.sendKeys(travellingTo);
        List<WebElement> to_cities = to_autoSuggest.findElements(By.tagName("li"));
        for(WebElement we : to_cities){
            if (we.findElement(By.cssSelector("span:nth-child(1)")).getText().contains(travellingTo))
                we.click();
        }
    }

    public LocalDate fill_any_available_future_departure_date(LocalDate date) {
        departureDate_span.click();
        int i=0;
        while (i<travelDays.size()) {
            //System.out.println("trying to book for date = " + date.toString());
            if (fill_departure_date(date.toString())) return date;
            else date = date.plusDays(1);
        }
        return null;
    }

    public boolean fill_departure_date(String departureDate) {
        for (WebElement we : travelDays) {
            if (we.getAttribute("data-date").equalsIgnoreCase(departureDate)) {
                //System.out.println("we inner : " +we.getAttribute("innerHTML"));
                //System.out.println("we get class attribute : " +we.getAttribute("class"));
               // if (we.findElement(By.tagName("a")).getAttribute("class").equals("selectable")) {
                if (!we.getAttribute("innerHTML").contains("unselectable")) {
                    we.click();
                    return true;
                }
            }
        }
        return false;
    }

    public FlightSearchResultsPage click_submit() {
        search_submit = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(search_submit));
        search_submit.click();
        return new FlightSearchResultsPage(driver);
    }

}
