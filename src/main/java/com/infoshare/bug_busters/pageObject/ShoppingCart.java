package com.infoshare.bug_busters.pageObject;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    WebElement shoppingCartText;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement catalogueDropDownList;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Colourful')]")
    private WebElement socksColourfulAddedToCart;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Holy')]")
    private WebElement socksHolyAddedToCart;

    @FindBy(xpath = "//a[contains(text(),'Figueroa')]")
    private WebElement socksFigueroafulAddedToCart;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'SuperSport XL')]")
    private WebElement socksSuperSportXLAddedToCart;

    @FindBy(xpath = "//a[contains(text(),'Crossed')]")
    private WebElement socksCrossedfulAddedToCart;

    @FindBy(xpath = "//a[contains(text(),'Cat socks')]")
    private WebElement socksCatSocksAddedToCart;

    @FindBy(xpath = "//a[contains(text(),'YouTube.sock')]")
    private WebElement socksYouTubeSockAddedToCart;

    @FindBy(xpath = "//a[contains(text(),'Nerd leg')]")
    private WebElement socksNerdLegAddedToCart;

    @FindBy(xpath = "//a[contains(text(),'Classic')]")
    private WebElement socksClassicAddedToCart;

    @FindBy(xpath = "//tbody[@id='cart-list']//tr//td[2]")
    private List<WebElement> listOfSocksinTheCartOnlyName;

    @FindBy(id = "cartTotal")
    private WebElement totalAmountToPay;

    @FindBy(xpath = "//tbody[@id='cart-list']//tr//td[3]//input")
    private List<WebElement> quantityElement;

    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default']")
    private WebElement updateBasketButton;

    @FindBy(xpath = "//tbody[@id='cart-list']//tr//td[7]//a")
    private List<WebElement> listOfTrashButton;


    private WebDriver driver;
    private Waits waits;
    private By firstElementLocator = By.xpath("//tbody[@id='cart-list']//tr//td[7]//a[1]");

    public ShoppingCart(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickCatalogueDropDownList(){
        catalogueDropDownList.click();
        Catalogue catalogue = new Catalogue(driver);
        waits.waitForElementToBeVisible(catalogue.catalogueTextElementInCatalogue);
    }

    public List<String> forAssertionForAll_9_ProductsAdded() {
        List<String> allProducts = new ArrayList<>();

        for (int i = 0 ; i < listOfSocksinTheCartOnlyName.size() ; i++){
            allProducts.add(listOfSocksinTheCartOnlyName.get(i).getText());
        }

        return allProducts;
    }

    public void changingQuantity() {
        for(int i = 0 ; i < quantityElement.size() ; i++) {
            quantityElement.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            quantityElement.get(i).sendKeys("2");
        }
        updateBasketButton.click();
        waits.waitForElementToBeVisible2(totalAmountToPay, "$420.58");
    }
    public String costOfOrder() {
        return totalAmountToPay.getText();
    }

    public void deleteAllProductsFromBasket() {
//        waits.waitForElementToBeVisible3(listOfTrashButton.get(0));
//        int listOfTrashButtonSize = listOfTrashButton.size();
//        for(WebElement element : listOfTrashButton) {
//            waits.waitForElementToBeVisibleBy(By.xpath("//tbody[@id='cart-list']//tr//td[7]//a[1]"));
//            listOfTrashButton.get(0).click();
//        }
        listOfTrashButton.forEach((it) -> {
            waits.waitForElementToBeVisibleBy(firstElementLocator);
                listOfTrashButton.get(0).click();}
        );
    }
}
