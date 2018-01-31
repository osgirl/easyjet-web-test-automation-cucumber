package com.mycompany.model;

import java.time.LocalDate;

public class FlightDetails {
    String id;
    String from;
    String to;
    LocalDate departureDate;
    LocalDate returnDate;
    FlightSeat flightSeat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public FlightSeat getFlightSeat() {
        return flightSeat;
    }

    public void setFlightSeat(FlightSeat flightSeat) {
        this.flightSeat = flightSeat;
    }


}
