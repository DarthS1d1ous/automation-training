package com.epam.ta.model;

import java.util.Objects;

public class HotelSearchCriteria {

    private String destination;
    private String arrivalDate;
    private String departureDate;
    private int numberOfGuests;
    private int numberOfRooms;

    public HotelSearchCriteria(String destination, String arrivalDate, String departureDate, int numberOfGuests, int numberOfRooms) {
        this.destination = destination;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.numberOfGuests = numberOfGuests;
        this.numberOfRooms = numberOfRooms;
    }

    public String getDestinations() {
        return destination;
    }

    public void setDestinations(String destination) {
        this.destination = destination;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "HotelSearchCriteria{" +
                "destination='" + destination + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelSearchCriteria that = (HotelSearchCriteria) o;
        return numberOfGuests == that.numberOfGuests &&
                numberOfRooms == that.numberOfRooms &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(arrivalDate, that.arrivalDate) &&
                Objects.equals(departureDate, that.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, arrivalDate, departureDate, numberOfGuests, numberOfRooms);
    }
}
