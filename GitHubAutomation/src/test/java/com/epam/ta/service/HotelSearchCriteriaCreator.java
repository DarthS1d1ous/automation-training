package com.epam.ta.service;

import com.epam.ta.model.HotelSearchCriteria;

public class HotelSearchCriteriaCreator {

    public static final String TESTDATA_HOTEL_SEARCH_CRITERIA_DESTINATION = "testdata.hotelSearchCriteria.destination";
    public static final String TESTDATA_HOTEL_SEARCH_CRITERIA_ARRIVAL_DATE = "testdata.hotelSearchCriteria.arrivalDate";
    public static final String TESTDATA_HOTEL_SEARCH_CRITERIA_DEPARTURE_DATE = "testdata.hotelSearchCriteria.departureDate";
    public static final String TESTDATA_HOTEL_SEARCH_CRITERIA_GUESTS_NUMBER = "testdata.hotelSearchCriteria.guestsNumber";
    public static final String TESTDATA_HOTEL_SEARCH_CRITERIA_ROOMS_NUMBER = "testdata.hotelSearchCriteria.roomsNumber";

    public static HotelSearchCriteria withCredentialsFromProperty() {
        return new HotelSearchCriteria(TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CRITERIA_DESTINATION),
                TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CRITERIA_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CRITERIA_DEPARTURE_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CRITERIA_GUESTS_NUMBER)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CRITERIA_ROOMS_NUMBER)));
    }

    public static HotelSearchCriteria withEmptyDate() {
        return new HotelSearchCriteria(TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CRITERIA_DESTINATION),
                "", "",
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CRITERIA_GUESTS_NUMBER)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CRITERIA_ROOMS_NUMBER)));
    }
}
