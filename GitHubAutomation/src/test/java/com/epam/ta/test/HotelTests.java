package com.epam.ta.test;

import com.epam.ta.model.HotelSearchCriteria;
import com.epam.ta.page.HomePage;
import com.epam.ta.page.HotelDetailPage;
import com.epam.ta.page.HotelsPage;
import com.epam.ta.service.HotelSearchCriteriaCreator;
import org.testng.annotations.Test;

import static com.epam.ta.util.StringUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HotelTests extends CommonConditions {

    @Test
    public void detailedHotelInformationHasPriceAlertMainText() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelDetailPage hotelDetailPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms())
                .openDetailedHotelInformation(1);

        switchToWindow(1);

        String priceAlertMainText = hotelDetailPage.openPricingAlertSettings()
                .getPriceAlertMainText();

        assertThat(PRICE_ALERT_MAIN_TEXT, is(equalTo(priceAlertMainText)));
    }

    @Test
    public void priceOfTheHotelAfterSearchingIsTheSameAsOnTheHotelPage() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms());

        String hotelPriceAfterSearching = hotelsPage.getHotelPrice(FIRST_HOTEL_NUMBER);

        HotelDetailPage hotelDetailPage = hotelsPage.openDetailedHotelInformation(FIRST_HOTEL_NUMBER);

        switchToWindow(1);

        String hotelPriceOnDetailPage = hotelDetailPage.getHotelPrice();

        assertThat(hotelPriceAfterSearching, is(equalTo(hotelPriceOnDetailPage)));
    }

    @Test
    public void openHotelDetailPageAfterClickTheButtonMoreDetails() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms());

        String hotelNameAfterSearching = hotelsPage.getHotelName(FIRST_HOTEL_NUMBER);
        String searchUrl = hotelsPage.getCurrentUrl();

        HotelDetailPage hotelDetailPage = hotelsPage.openDetailedHotelInformation(FIRST_HOTEL_NUMBER);

        switchToWindow(1);

        String currentUrl = hotelDetailPage.getCurrentUrl();
        String hotelNameOnDetailPage = hotelDetailPage.getHotelName();

        assertThat(hotelNameAfterSearching, is(equalTo(hotelNameOnDetailPage)));
        assertThat(currentUrl, is(not(searchUrl)));
    }

    @Test
    public void openHotelFromSelectionOfHotels() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab();

        String hotelName = hotelsPage.getHotelNameFromSelectionOfHotels(FIRST_HOTEL_NUMBER);

        hotelsPage = hotelsPage.openHotelFromSelectionOfHotels(FIRST_HOTEL_NUMBER);

        String destinationTextFromSearchBar = hotelsPage.getDestinationFromSearchBar();

        assertThat(hotelName, is(equalTo(destinationTextFromSearchBar)));
    }

    @Test
    public void checkSearchDestinationAfterSearch() throws InterruptedException {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms());

        String destinationTextFromSearchBar = hotelsPage.getDestination();

        assertThat(destinationTextFromSearchBar, is(equalTo(MINSK_SITY_IN_RUSSIA)));
    }

    @Test
    public void checkHotelRatingInDetailPage() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms());

        String hotelRationAfterSearch = hotelsPage.getHotelRating();

        HotelDetailPage hotelDetailPage = hotelsPage.openDetailedHotelInformation(FIRST_HOTEL_NUMBER);

        switchToWindow(1);

        String hotelRatingOnDetailPage = hotelDetailPage.getHotelRating();

        assertThat(hotelRationAfterSearch, is(equalTo(hotelRatingOnDetailPage)));
    }

    @Test
    public void openNewTabAfterClickTheButtonMoreDetails() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms());

        int tabsCountBeforeClick = driver.getWindowHandles().size();

        hotelsPage.openDetailedHotelInformation(FIRST_HOTEL_NUMBER);

        int tabsCountAfterClick = driver.getWindowHandles().size();

        assertThat(tabsCountAfterClick, is(equalTo(tabsCountBeforeClick + 1)));
    }

    @Test
    public void checkAdultsAndRoomNumberOnHotelDetailPage() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelDetailPage hotelDetailPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms())
                .openDetailedHotelInformation(1);

        switchToWindow(1);

        hotelDetailPage = hotelDetailPage.openEditHostelStay()
                .openGuestsSelect();

        int currentNumberOfAdults = hotelDetailPage.getCurrentNumberOfAdults();
        int currentNumberOfRooms = hotelDetailPage.getCurrentNumberOfRooms();

        assertThat(currentNumberOfAdults, is(equalTo(hotelSearchCriteria.getNumberOfGuests())));
        assertThat(currentNumberOfRooms, is(equalTo(hotelSearchCriteria.getNumberOfRooms())));
    }

    @Test
    public void changeAdultsAndRoomNumberOnHotelDetailPage() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelDetailPage hotelDetailPage = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .searchForHotels(hotelSearchCriteria.getDestinations(), hotelSearchCriteria.getNumberOfGuests(), hotelSearchCriteria.getNumberOfRooms())
                .openDetailedHotelInformation(1);

        switchToWindow(1);

        hotelDetailPage.openEditHostelStay()
                .openGuestsSelect();

        hotelDetailPage.changeRoomsCount(FIVE_ROOMS);
        hotelDetailPage.changeAdultsCount(TEN_ADULTS);

        hotelDetailPage.saveChangesGuestsAndRoomsButton().applyEditHostelStay();

        hotelDetailPage.openEditHostelStay()
                .openGuestsSelect();

        int currentNumberOfAdults = hotelDetailPage.getCurrentNumberOfAdults();
        int currentNumberOfRooms = hotelDetailPage.getCurrentNumberOfRooms();

        assertThat(currentNumberOfAdults, is(equalTo(TEN_ADULTS)));
        assertThat(currentNumberOfRooms, is(equalTo(FIVE_ROOMS)));
    }
}
