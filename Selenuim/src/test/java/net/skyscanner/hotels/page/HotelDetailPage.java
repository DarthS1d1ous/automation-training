package net.skyscanner.hotels.page;

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

    protected AbstractPage openPage() {
        return null;
    }

    public HotelDetailPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public HotelDetailPage openPricingAlertSettings() {
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        priceAlertButton.click();
        return this;
    }

    public String getPriceAlertMainText() {
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return priceAlertMainText.getText();
    }
}
