package net.skyscanner.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelDetailPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//button[@class='BpkButton_bpk-button__3CLCx BpkButton_bpk-button--secondary__Rr80M DetailsPageSubscribeButton_DetailsPageSubscribeButton__34hIL']")
    private WebElement priceAlertButton;

    @FindBy(xpath = "//div[@class='SubscribeLogin_SubscribeLogin__2XDN6']/descendant-or-self::p[@class='BpkText_bpk-text__nraB1 BpkText_bpk-text--base__2vSPQ']")
    private WebElement priceAlertMainText;

    public HotelDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public HotelDetailPage openPricingAlertSettings() {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        priceAlertButton.click();
        return this;
    }

    public String getPriceAlertMainText() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return priceAlertMainText.getText();
    }
}
