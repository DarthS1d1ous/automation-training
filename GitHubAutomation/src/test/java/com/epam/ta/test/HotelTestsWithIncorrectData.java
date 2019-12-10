package com.epam.ta.test;

import com.epam.ta.model.HotelSearchCriteria;
import com.epam.ta.page.HomePage;
import com.epam.ta.service.HotelSearchCriteriaCreator;
import org.testng.annotations.Test;

import static com.epam.ta.util.StringUtils.SKYSCANNER_HOTELS_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HotelTestsWithIncorrectData extends CommonConditions {

    @Test
    public void searchForHotelsWithIncorrectData() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withEmptyDate();

        String url = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms())
                .getCurrentUrl();

        assertThat(url, is(equalTo(SKYSCANNER_HOTELS_URL)));
    }
}
