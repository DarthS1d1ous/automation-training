package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotelsPage extends AbstractPage {
    private final String XPATH = "//select[@class='BpkSelect_bpk-select__3Bhp6 PeopleRoomSelector_PeopleRoomSelector__adults__1vqnl']/descendant-or-self::option[@value='%d']";

    @FindBy(xpath = "//input[@id='destination-autosuggest']")
    private WebElement destinationsInput;

    @FindBy(xpath = "//input[@id='guests-rooms']")
    private WebElement guestsSelect;

    @FindBy(xpath = "//div[@class='SearchBar_SearchBar__destination__3W9DK']")
    private WebElement searchBarDestination;

    @FindBy(xpath = "//*[@id='adults']")
    private WebElement currectRoomsNumber;

    @FindBy(xpath = "/html/body/div[2]/section/div/div/div/div[2]/div/input")
    private WebElement currectAdultsNumber;

    @FindBy(xpath = "//*[@id='popover']/div/div/div/div[2]/div/button[1]")
    private WebElement minusAdultsButtuon;

    @FindBy(xpath = "//*[@id='popover']/div/div/div/div[2]/div/button[2]")
    private WebElement plusAdultsButtuon;

    @FindBy(xpath = "//*[@id='popover']/div/div/div/div[1]/div/button[1]")
    private WebElement minusRoomsButtuon;

    @FindBy(xpath = "//*[@id='popover']/div/div/div/div[1]/div/button[2]")
    private WebElement plusRoomsButtuon;

    @FindBy(xpath = "//*[@id='popover']/footer/button")
    private WebElement applyGuestsNumber;

    @FindBy(xpath = "//*[@id='search-controls']/div[2]/button")
    private WebElement searchHotelsButton;

    @FindBy(xpath = "//div[@class='HotelCard_HotelCard__price__1Q_iY']")
    private List<WebElement> hotelPrice;

    @FindBy(xpath = "//span[@class='HotelCard_HotelCard__name__3EA3e']")
    private List<WebElement> hotelName;

    @FindBy(xpath = "//span[@class='BpkText_bpk-text__nraB1 BpkText_bpk-text--sm__7CSMP CardScore_CardScore__OzMF2 CardScore_CardScore--rating_excellent__ROatW']")
    private WebElement hotelRating;

    @FindBy(xpath = "//div[@class='HotelCard_HotelCard__cta__26snW']/descendant-or-self::button[@class='BpkButton_bpk-button__3CLCx']")
    private List<WebElement> detailHotelInformationButton;

    @FindBy(xpath = "//a[@class='BpkCard_bpk-card__3E_5J InspirationCard_InspirationCard__194hh']")
    private List<WebElement> selectionOfHotels;

    @FindBy(xpath = "//p[@class='BpkText_bpk-text__nraB1 BpkText_bpk-text--lg__1QQ0B BpkText_bpk-text--bold__2uCy0 InspirationCard_InspirationCard__name__oZQFO']")
    private List<WebElement> hotelNamesInsselectionOfHotels;

    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HotelsPage openPage() {
        return this;
    }

    public HotelsPage searchForHotels(String destinations, int adultsNumber, int roomsNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        try {
            destinationsInput.sendKeys(destinations);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            destinationsInput.sendKeys(destinations);
        }
        destinationsInput.click();
        logger.info("Input destination");
        guestsSelect.click();
        logger.info("Opened guests selector");
        changeRoomsCount(roomsNumber);
        changeAdultsCount(adultsNumber);
        applyGuestsNumber.click();
        logger.info("Save changes");
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        searchHotelsButton.click();
        logger.info("Pressed search button");
        return this;
    }

    public HotelDetailPage openDetailedHotelInformation(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (hotelNumber - 1 < detailHotelInformationButton.size()) {
            detailHotelInformationButton.get(hotelNumber - 1).click();
            logger.info("Opened detail Hotel Page");
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(newTab.get(1));
            return new HotelDetailPage(driver);
        }
        return null;
    }

    public String getHotelPrice(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get hotel price");
        return hotelNumber - 1 < hotelPrice.size() ? hotelPrice.get(hotelNumber - 1).getText() : null;
    }

    public String getHotelName(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get hotel name");
        return hotelNumber - 1 < hotelName.size() ? hotelName.get(hotelNumber - 1).getText() : null;
    }

    public String getDestination() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        Thread.sleep(2000);
        logger.info("Get destination");
        return destinationsInput.getAttribute("value");
    }

    public String getDestinationFromSearchBar() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        System.out.println(searchBarDestination.getTagName());
        logger.info("Get destination from search bar");
        return searchBarDestination.getText();
    }

    public String getHotelRating() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get hotel rating");
        return hotelRating.getText();
    }

    public String getCurrentUrl() {
        logger.info("Get current url");
        return driver.getCurrentUrl();
    }

    public HotelsPage openHotelFromSelectionOfHotels(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (hotelNumber - 1 < selectionOfHotels.size()) {
            selectionOfHotels.get(hotelNumber - 1).click();
            logger.info("Opened hotel from selection of hotels");
            return this;
        }
        return null;
    }

    public String getHotelNameFromSelectionOfHotels(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get hotel name from selection of hotels");
        return hotelNumber - 1 < hotelNamesInsselectionOfHotels.size() ? hotelNamesInsselectionOfHotels.get(hotelNumber - 1).getText() : null;
    }

    private void changeRoomsCount(int roomsNumber) {
        int roomsClickCount = roomsNumber - Integer.parseInt(currectRoomsNumber.getAttribute("value"));
        if (roomsClickCount > 0) {
            for (int i = 0; i <= roomsClickCount; i++) {
                plusRoomsButtuon.click();
                logger.info("Add 1 room");
            }
        } else {
            for (int i = 0; i <= Math.abs(roomsClickCount); i++) {
                minusRoomsButtuon.click();
                logger.info("Remove 1 room");
            }
        }
    }

    private void changeAdultsCount(int adultsNumber) {
        int adultsClickCount = adultsNumber - Integer.parseInt(currectAdultsNumber.getAttribute("value"));
        if (adultsClickCount > 0) {
            for (int i = 0; i < adultsClickCount; i++) {
                plusAdultsButtuon.click();
                logger.info("Add 1 adult");
            }
        } else {
            for (int i = 0; i < Math.abs(adultsClickCount); i++) {
                minusAdultsButtuon.click();
                logger.info("Remove 1 adult");
            }
        }
    }
}
