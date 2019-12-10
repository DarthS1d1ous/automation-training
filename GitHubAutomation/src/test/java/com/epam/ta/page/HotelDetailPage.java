package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelDetailPage extends AbstractPage {
    @FindBy(xpath = "//button[@class='BpkButton_bpk-button__3CLCx BpkButton_bpk-button--secondary__Rr80M DetailsPageSubscribeButton_DetailsPageSubscribeButton__34hIL']")
    private WebElement priceAlertButton;

    @FindBy(xpath = "//div[@class='SubscribeLogin_SubscribeLogin__2XDN6']/descendant-or-self::p[@class='BpkText_bpk-text__nraB1 BpkText_bpk-text--base__2vSPQ']")
    private WebElement priceAlertMainText;

    @FindBy(xpath = "//*[@id='app-root']/div/div/div[4]/div[3]/div[1]/a")
    private WebElement chooseRoomButton;

    @FindBy(xpath = "//*[@id='app-root']/div[2]/div[2]/div[2]/section[1]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/button")
    private WebElement roomDetailInformationButton;

    @FindBy(xpath = "//*[@id='app-root']/div[2]/div/div/div[1]/div/form/div[3]/button")
    private WebElement bookButton;

    @FindBy(xpath = "//*[@id='app-root']/div/div/div[4]/div[1]/div/div[1]/h1")
    private WebElement hotelName;

    @FindBy(xpath = "//*[@id='app-root']/div/div/div[4]/div[3]/div[1]/div/span")
    private WebElement hotelPrice;

    @FindBy(xpath = "//*[@id='app-root']/div/div/div[4]/div[1]/div/div[2]/div[1]/span")
    private WebElement hotelRating;

    @FindBy(xpath = "//div[@class='HotelStay_HotelStay__editIcon__2Zo-F']")
    private WebElement editHostelStayButton;

    @FindBy(xpath = "//input[@id='guests-rooms']")
    private WebElement guestsSelect;

    @FindBy(xpath = "//*[@id='rooms']")
    private WebElement currectRoomsNumber;

    @FindBy(xpath = "//*[@id='adults']")
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
    private WebElement saveChangesGuestsAndRoomsButton;

    @FindBy(xpath = "//*[@id='edit-apply']")
    private WebElement applyEditHostelStay;


    public HotelDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HotelDetailPage openPricingAlertSettings() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        priceAlertButton.click();
        logger.info("Opened pricing alert settings");
        return this;
    }

    public String getPriceAlertMainText() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get price alert main text");
        return priceAlertMainText.getText();
    }

    public HotelDetailPage openHotelRooms() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        chooseRoomButton.click();
        logger.info("Opened hotel rooms");
        return this;
    }

    public HotelDetailPage openRoomDetailInformationButton() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        roomDetailInformationButton.click();
        logger.info("Opened room detail information");
        return this;
    }

    public String getHotelName() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get hotel name");
        return hotelName.getText();
    }

    public HotelDetailPage openEditHostelStay() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        editHostelStayButton.click();
        logger.info("Opened edit hotel stay");
        return this;
    }

    public HotelDetailPage saveChangesGuestsAndRoomsButton() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        saveChangesGuestsAndRoomsButton.click();
        logger.info("Saved guests and rooms changes ");
        return this;
    }

    public String getHotelPrice() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get hotel price");
        return hotelPrice.getText();
    }

    public HotelDetailPage applyEditHostelStay() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Apply hostel stay changes");
        applyEditHostelStay.click();
        return this;
    }

    public String getCurrentUrl() {
        logger.info("Get current utl");
        return driver.getCurrentUrl();
    }

    public String getHotelRating() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get hotel rating");
        return hotelRating.getText();
    }

    public HotelDetailPage openGuestsSelect() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        guestsSelect.click();
        logger.info("Opened guests select");
        return this;
    }

    public int getCurrentNumberOfAdults() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get current number of adults");
        return Integer.parseInt(currectAdultsNumber.getAttribute("value"));
    }

    public int getCurrentNumberOfRooms() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        logger.info("Get current number of rooms");
        return Integer.parseInt(currectRoomsNumber.getAttribute("value"));
    }

    public void changeRoomsCount(int roomsNumber) {
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

    public void changeAdultsCount(int adultsNumber) {
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

    @Override
    public HotelDetailPage openPage() {
        return this;
    }

}
