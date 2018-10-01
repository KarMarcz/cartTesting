package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class UpdateShopingCartTest {
    private final String PAGE_URL = "http://localhost:4180/";

    private WebDriver driver;

    private HomePage homePage;

    private final static UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

    private static boolean isUserCreated = false;

    private static UserData userData;

    static {
        try {
            userData = userDataGenerator.prepareUserData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UpdateShopingCartTest() throws IOException {

    }
    private boolean isUserCreated() {
        return this.isUserCreated = true;
    }

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);

        if(!isUserCreated){
            driver.get(PAGE_URL);
            homePage.registrationSteps(userData);
            isUserCreated();
            homePage.waitsWhenLogout();
            //driver.close();
        }


    }

    @Test
    public void addingAllpossibleproducts() {
        driver.get(PAGE_URL);
        homePage.loginSteps(userData);
    }
    @Test
    public void addingAllpossibleproducts2() {
        driver.get(PAGE_URL);
        homePage.loginSteps(userData);
    }

}
