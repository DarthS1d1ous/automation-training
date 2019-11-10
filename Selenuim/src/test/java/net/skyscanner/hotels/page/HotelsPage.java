package net.skyscanner.hotels.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotelsPage extends AbstractPage {
    @FindBy(xpath = "//input[@name='destination-autosuggest']")
    private WebElement destinationsInput;

    @FindBy(xpath = "//select[@class='BpkSelect_bpk-select__3Bhp6 PeopleRoomSelector_PeopleRoomSelector__adults__1vqnl']")
    private WebElement guestsSelect;

    @FindBy(xpath = "//select[@class='BpkSelect_bpk-select__3Bhp6 PeopleRoomSelector_PeopleRoomSelector__adults__1vqnl']")
    private WebElement guestsNumber;

    @FindBy(xpath = "//button[@class='BpkButton_bpk-button__3CLCx BpkButton_bpk-button--large__3nGhA SearchControls_SearchControls__cta__3nH4P']")
    private WebElement searchHotelsButton;

    @FindBy(xpath = "//div[@class='HotelCardsListChunk_HotelCardsListChunk__card__2eXne']/descendant-or-self::button[@class='BpkButton_bpk-button__3CLCx']")
    private List<WebElement> detailHotelInformationButton;


    protected AbstractPage openPage() {
        return null;
    }

    public HotelsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public HotelsPage incorrectSearchForHotels(String destinations) {
        destinationsInput.sendKeys(destinations);
        destinationsInput.click();
        searchHotelsButton.click();
        return this;
    }

    public HotelsPage correctSearchForHotels(String destinations, int guestsNumber) {
        destinationsInput.sendKeys(destinations);
        destinationsInput.click();
        guestsSelect.click();
        this.guestsNumber = webDriver
                .findElement(By.xpath("//select[@class='BpkSelect_bpk-select__3Bhp6 PeopleRoomSelector_PeopleRoomSelector__adults__1vqnl']/descendant-or-self::option[@value='" + guestsNumber + "']"));
        this.guestsNumber.click();
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        searchHotelsButton.click();
        return this;
    }

    public HotelDetailPage openDetailedHotelInformation(int hotelNumber) {
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (hotelNumber - 1 < detailHotelInformationButton.size()) {
            detailHotelInformationButton.get(hotelNumber - 1).click();
            ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(newTab.get(1));
            return new HotelDetailPage(webDriver);
        }
        return null;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
