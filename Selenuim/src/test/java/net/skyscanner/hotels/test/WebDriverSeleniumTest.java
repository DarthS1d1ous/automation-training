package net.skyscanner.hotels.test;

import net.skyscanner.hotels.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumTest {
    private static final String SKYSCANNER_HOTELS_URL = "https://www.skyscanner.net/hotels";
    private static final String PRICE_ALERT_MAIN_TEXT = "Понравился отель? Мы будем отслеживать динамику цен на самые выгодные номера и сообщать вам об изменениях цен по электронной почте.";
    private static final String INCORRECT_DESTINATIONS = "aaaaaaaaaaaaa";
    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
//        webDriver.manage().window().fullscreen();
    }

    @Test
    public void incorrectSearchForHotels() {
        String url = new HomePage(webDriver)
                .openPage()
                .goToTheHotelsTab()
                .incorrectSearchForHotels(INCORRECT_DESTINATIONS)
                .getCurrentUrl();
        Assert.assertEquals(url, SKYSCANNER_HOTELS_URL);
    }

    @Test
    public void getPriceAlertMainText() {
        String priceAlertMainText = new HomePage(webDriver)
                .openPage()
                .goToTheHotelsTab()
                .correctSearchForHotels("Milan", 1)
                .openDetailedHotelInformation(1)
                .openPricingAlertSettings()
                .getPriceAlertMainText();
        Assert.assertEquals(PRICE_ALERT_MAIN_TEXT, priceAlertMainText);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTurnDown() {
        webDriver.quit();
        webDriver = null;
    }
}
