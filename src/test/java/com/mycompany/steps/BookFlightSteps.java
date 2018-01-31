package com.mycompany.steps;

import com.mycompany.model.FlightBooking;
import com.mycompany.model.FlightDetails;
import com.mycompany.model.FlightSearch;
import com.mycompany.model.TravelBooking;
import com.mycompany.pageobjects.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static junit.framework.Assert.assertTrue;

public class BookFlightSteps {

    @Autowired
    WebDriver driver;

    FlightBooking flightBooking;
    FlightDetails flightDetails;
    FlightSearch flightSearch;

    HomePage homePage;
    FlightSearchResultsPage flightSearchResultsPage;
    SeatSelectionPage seatSelectionPage;
    LuggageSelectionPage luggageSelectionPage;
    HotelReservationPage hotelReservationPage;
    CarHirePage carHirePage;
    SignInPage signInPage;
    BookerPassengerDetails bookerPassengerDetails;
    BasketConfirmatioAndPaymentPage basketConfirmationAndPaymentPage;
    TravelBooking travelBooking;

    @Given("^I am on home page$")
    public void i_am_on_home_page() {
        homePage = new HomePage(driver);
        homePage.visitUrl();
        assertTrue(homePage.isOnPage());
        homePage.acceptCookiePolicy();
        flightSearch = new FlightSearch();
    }

    @When("^I searh for one-way flight from (.*) to (.*) on (.*)")
    public void i_searh_for_one_way_flight_from_to_on(
                    String from, String to, String departureDate) {
       flightSearch.setOneWay(true);
       flightSearch.setFrom(from);
       flightSearch.setTo(to);
       homePage.fill_oneway_checkbox(true);
        homePage.fill_from_location(from);
        homePage.fill_to_location(to);
       LocalDate date = homePage.fill_any_available_future_departure_date(
                LocalDate.now().plusDays(7));
       flightSearch.setDepartureDate(date);

       flightSearchResultsPage = homePage.click_submit();
    }

    @When("^choose an available flight$")
    public void choose_an_available_flight() {
        flightSearchResultsPage.select_any_available_Flight();
    }

    @When("^proceed to checkout$")
    public void proceed_to_checkout() {
       flightSearchResultsPage.click_continue();
    }

    @When("^skip seat selection$")
    public void skip_seat_selection() {
        seatSelectionPage = new SeatSelectionPage(driver);
        seatSelectionPage.skip_seat_selection();
    }

    @When("^skip luggage selection$")
    public void skip_luggage_selection() {
        luggageSelectionPage = new LuggageSelectionPage(driver);
        luggageSelectionPage.skip_luggage_selection();
        luggageSelectionPage.accept_cabin_bag_policy();
    }

    @When("^skip hotel selection$")
    public void skip_hotel_selection() {
        hotelReservationPage = new HotelReservationPage(driver);
        hotelReservationPage.skip_hotel_reservation();
    }

    @When("^skip car-hire selection$")
    public void skip_car_hire_selection() {
        carHirePage = new CarHirePage(driver);
        carHirePage.skip_car_hire_selection();
    }

    @When("^continue with new-user create-account$")
    public void continue_with_new_user_create_account() {
        signInPage = new SignInPage(driver);
        signInPage.select_new_customer_option();
        signInPage.fill_email();
        signInPage.click_login_bt();
    }

    @When("^add booker's details$")
    public void add_booker_s_details() {
        bookerPassengerDetails = new BookerPassengerDetails(driver);
        bookerPassengerDetails.fillBookerDetails();
        bookerPassengerDetails.click_continue();

    }

    @When("^add passenger's details$")
    public void add_passenger_s_details() {
        bookerPassengerDetails.fillPassengerDetails();
        bookerPassengerDetails.click_continue_to_confirm();
    }

    @Then("^basket details should match$")
    public void basket_details_should_match() {
        basketConfirmationAndPaymentPage = new BasketConfirmatioAndPaymentPage(driver);
        assertTrue(basketConfirmationAndPaymentPage.validate_basket_details(travelBooking));
    }

}
