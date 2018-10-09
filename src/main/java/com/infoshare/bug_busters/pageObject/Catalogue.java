package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Catalogue {

    @FindBy(xpath = "//li[contains(text(),'Catalogue')]")
    WebElement catalogueTextElementInCatalogue;

    @FindBy(xpath = "//a[contains(text(),'9')]")
    private WebElement show_9_Button;

    @FindBy(id = "totalProducts")
    private WebElement textFromHowManyProductsAreVisible;

    @FindBy (xpath = "//a[@class='btn btn-primary navbar-btn']")
    private WebElement itemsInCartButton;

    @FindBy(xpath = "//div[@id='products']//div//div[1]//div[2]//p[2]//a[2]")
    private List<WebElement> listforAddSocksButton;

    private WebDriver driver;
    private Waits waits;

    public Catalogue(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public void changeTo_9_Products() {
        show_9_Button.click();
        waits.waitForElementToBeVisible(textFromHowManyProductsAreVisible);
    }

    public String getTextFromHowManyProductsAreVisible() {
        return textFromHowManyProductsAreVisible.getText();
    }

    public void addingAll_9_Products() {

        AtomicInteger numberOfItemsInCart = new AtomicInteger();
        listforAddSocksButton.forEach((it) -> {

            listforAddSocksButton.get(numberOfItemsInCart.get()).click();
            waits.waitForElementToContainProperString(itemsInCartButton, String.format("%s item(s) in cart", numberOfItemsInCart.get() +1));
            numberOfItemsInCart.getAndIncrement();
        });
    }

}
