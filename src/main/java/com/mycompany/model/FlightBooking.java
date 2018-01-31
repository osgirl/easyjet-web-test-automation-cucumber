package com.mycompany.model;

public class FlightBooking {
    String id;
    boolean oneWay;
    FlightDetails onwardFlight;
    FlightDetails returnFlight;
    FlightLuggage flightLuggage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }

    public FlightDetails getOnwardFlight() {
        return onwardFlight;
    }

    public void setOnwardFlight(FlightDetails onwardFlight) {
        this.onwardFlight = onwardFlight;
    }

    public FlightDetails getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(FlightDetails returnFlight) {
        this.returnFlight = returnFlight;
    }

    public FlightLuggage getFlightLuggage() {
        return flightLuggage;
    }

    public void setFlightLuggage(FlightLuggage flightLuggage) {
        this.flightLuggage = flightLuggage;
    }

}
