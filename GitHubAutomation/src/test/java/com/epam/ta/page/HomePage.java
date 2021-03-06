package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.skyscanner.net";

    @FindBy(xpath = "//a[@data-analytics-name='hotels']")
    private WebElement hotelsTag;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Home Page opened");
        return this;
    }

    public HotelsPage goToTheHotelsTab() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        hotelsTag.click();
        logger.info("Hotels Tab opened");
        return new HotelsPage(driver);
    }
}
