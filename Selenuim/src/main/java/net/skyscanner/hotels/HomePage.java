package net.skyscanner.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://www.skyscanner.net";
    private WebDriver webDriver;

    @FindBy(xpath = "//a[@data-analytics-name='hotels']")
    private WebElement hotelsTag;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public HomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public HotelsPage goToTheHotelsTab() {
        hotelsTag.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new HotelsPage(webDriver);
    }
}
