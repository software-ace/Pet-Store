package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class PetStoreTests {

    private WebDriver driver;
    WebDriverWait webDriverWait;
    Random random = new Random();
    HomePage homePage;
    SearchPage searchPage;
    DogsPage dogsPage;
    CartPage cartPage;
    ContactPage contactPage;


    @BeforeTest
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofMinutes(1));
        searchPage = new SearchPage(driver);
        homePage = new HomePage(driver, random);
        dogsPage = new DogsPage(driver, random);
        cartPage = new CartPage(driver, webDriverWait);
        contactPage = new ContactPage(driver, webDriverWait);

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verify_search_for_cat() {
        searchPage.performSearch("cat");
        int catsItemsCounter = searchPage.countItemsWithTitleContaining("cat");
        Assert.assertEquals(catsItemsCounter, searchPage.getItemsTitle().size(), "Not all shown items have the word 'cat' in it, found only: " + catsItemsCounter);
    }

    @Test(priority = 2)
    public void verify_selecting_random_animal_category() {
        homePage.selectRandomPetType();
        int petItemsNumber = homePage.getPetItemsNumber();
        Assert.assertTrue(petItemsNumber == 10 || petItemsNumber == 12,
                "Unexpected number of items: " + petItemsNumber);
    }

    @Test(priority = 3)
    public void verify_selecting_random_dog_item() {
        dogsPage.selectRandomDogItem();
        dogsPage.selectRandomColor();
        dogsPage.selectRandomSize();
        dogsPage.clickBuyNow();
    }

    @Test(priority = 4, dependsOnMethods = "verify_selecting_random_dog_item")
    public void verify_checkout_process_and_screenshot_payment_page() throws IOException {
        cartPage.fillForm();
        cartPage.clickContinueToShipping();
        cartPage.clickContinueToPayment();
        boolean done = cartPage.takeScreenshot();
        Assert.assertTrue(done);
    }

    @Test(priority = 5, dataProvider = "contactFormData", dataProviderClass = TestDataProviders.class)
    public void verify_filling_contact_form_and_submit(String name, String email, String phone, String message) {
        contactPage.fillForm(name, email, phone, message);
        contactPage.submitForm();
        Assert.assertEquals(contactPage.EXPECTED_MSG, contactPage.getFormMessage());
    }
}