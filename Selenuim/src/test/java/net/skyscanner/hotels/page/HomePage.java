package net.skyscanner.hotels.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.skyscanner.net";

    @FindBy(xpath = "//a[@data-analytics-name='hotels']")
    private WebElement hotelsTag;

    public HomePage(WebDriver webDriver) {
       super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public HomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }

    public HotelsPage goToTheHotelsTab() {
        hotelsTag.click();
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return new HotelsPage(webDriver);
    }
}
