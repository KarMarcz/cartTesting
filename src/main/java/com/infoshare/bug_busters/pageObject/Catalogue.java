package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Catalogue {

    @FindBy(xpath = "//li[contains(text(),'Catalogue')]")
    WebElement catalogueTextElementInCatalogue;

    @FindBy(xpath = "//a[contains(text(),'9')]")
    private WebElement show_9_Button;

    @FindBy(id = "totalProducts")
    private WebElement textFromHowManyProductsAreVisible;

    @FindBy (xpath = "//a[@class='btn btn-primary navbar-btn']")
    private WebElement itemsInCartButton;

    @FindBy(xpath = "//div[@id='products']//div[1]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksHolyAddToCartButton;
    @FindBy(xpath = "//div[@id='products']//div[2]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksColourfulAddToCartButton;
    @FindBy(xpath = "//div[@id='products']//div[3]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksSuperSportXLAddToCartButton;
    @FindBy(xpath = "//div[@id='products']//div[4]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksCrossedAddToCartButton;
    @FindBy(xpath = "//div[@id='products']//div[5]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksFigueroaAddToCartButton;
    @FindBy(xpath = "//div[@id='products']//div[6]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksCatSocksAddToCartButton;
    @FindBy(xpath = "//div[@id='products']//div[7]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksNerdLegAddToCartButton;
    @FindBy(xpath = "//div[@id='products']//div[8]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksYouTubeSockAddToCartButton;
    @FindBy(xpath = "//div[@id='products']//div[9]//div[1]//div[2]//p[2]//a[2]")
    private WebElement socksClassicAddToCartButton;

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
        socksHolyAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "1 item(s) in cart");
        socksColourfulAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "2 item(s) in cart");
        socksSuperSportXLAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "3 item(s) in cart");
        socksCrossedAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "4 item(s) in cart");
        socksFigueroaAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "5 item(s) in cart");
        socksCatSocksAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "6 item(s) in cart");
        socksNerdLegAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "7 item(s) in cart");
        socksYouTubeSockAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "8 item(s) in cart");
        socksClassicAddToCartButton.click();
        waits.waitForElementToBeVisible2(itemsInCartButton, "9 item(s) in cart");


    }

}
