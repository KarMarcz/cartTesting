package com.infoshare.bug_busters.ui;

import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.payment.PaymentDataGenerator;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;
import com.infoshare.bug_busters.utils.WebDriverCreators;
import com.infoshare.bug_busters.utils.WebDriverProvider;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(DataProviderRunner.class)
public class UpdateShopingCastTestWithDDT_Test {

    private static final String PAGE_URL = "http://localhost:4180/";

    private WebDriver driver;

    private HomePage homePage;

    private static UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());
    private static ShippingDataGenerator shippingDataGenerator = new ShippingDataGenerator(new RandomDataGenerator());
    private static PaymentDataGenerator paymentDataGenerator = new PaymentDataGenerator(new RandomDataGenerator());
    public UpdateShopingCastTestWithDDT_Test() throws IOException {
    }


    public static Object[][] DDTObject (){
        return new DDTGeneratoData[][] {
                new DDTGeneratoData[][] { userDataGenerator.prepareUserData(), paymentDataGenerator.preparePayments(), shippingDataGenerator. },




    }



    @DataProvider
    public static Object[][] testDataForRegistration() throws IOException {
        return new UserData[][] {
                new UserData[] { userDataGenerator.prepareUserData() },
                new UserData[] { userDataGenerator.prepareUserData() },
                new UserData[] { userDataGenerator.prepareUserData() },
                new UserData[] { userDataGenerator.prepareUserData() },


        };
    }

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    @UseDataProvider("testDataForRegistration")
    public void registrationWithUserDataGeneratorMethodTest(UserData userData) throws IOException {
        driver.get(PAGE_URL);
        homePage.registerUserWithDataGeneratorMethodWithDDT(userData);
        assertThat(homePage.getTextFromLogoutToConfirmLoginOrRegistration().contains("Logout")).as("User is not Registered");
    }

    @Test
    @UseDataProvider("testDataForRegistration")
    public void registrationTwiceWithTheSameData(UserData userData) throws IOException {
        driver.get(PAGE_URL);
        homePage.regiterUserTwiceWithTheSameDataWIthDDT(userData);
        assertThat(homePage.alertRegistration().contains("There was a problem with your registration: Internal Server Error")).as("Alert is not show after creating two indentical accounts");
    }

    @Test
    @UseDataProvider("testDataForRegistration")
    public void loginAfterRegistration(UserData userData) throws IOException {
        driver.get(PAGE_URL);
        homePage.loginUserAfterRegistrationWithDDT(userData);
        assertThat(homePage.getTextFromLogoutToConfirmLoginOrRegistration().contains("Logout")).as("User is not Logged");
    }
}
