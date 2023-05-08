package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AppTest extends TestConstants {

    @BeforeTest
    public void setup() {
        driver.get(BASE_URL);
    }

    @Test(priority = 1)
    public void verify_search_for_cat() {
        WebElement search_icon = driver.findElement(By.className("icon-search"));
        search_icon.click();

        WebElement search_text_field = driver.findElement(By.name("q"));
        search_text_field.sendKeys("cat", Keys.ENTER);

        List<WebElement> items_title = driver.findElements(By.className("grid-product__title"));
        bool isAllItemsHaveCat = false;
        for (WebElement item_title : items_title) {
            if ((item_title.getText().toLowerCase()).contains("cat")) {
                isAllItemsHaveCat=true;
            }else{
            isAllItemsHaveCat=false;
                break;
            }
        }
        Assert.assertTrue(isAllItemsHaveCat, true);
    }

    @Test(priority = 2)
    public void verify_selecting_random_dog_item() {
        driver.get(DOGS_PAGE);
        List<WebElement> Products = driver.findElements(By.className("grid-product__meta"));

        int productRandInd = random.nextInt(Products.size());

        Products.get(productRandInd).click();

        List<WebElement> colors = driver.findElements(By.cssSelector("#ProductSelect-option-0 label"));

        List<WebElement> sizes = driver.findElements(By.cssSelector("#ProductSelect-option-1 label"));

        int colorRandInd = random.nextInt(colors.size());

        int sizeRandInd = random.nextInt(sizes.size());

        colors.get(colorRandInd).click();

        sizes.get(sizeRandInd).click();
        // adding item to cart
        WebElement buy_now_button = driver.findElement(By.className("shopify-payment-button__button"));
        buy_now_button.click();
    }

    @Test(priority = 5)
    public void verify_selecting_random_animal() {
        driver.get(BASE_URL);
        List<WebElement> pet_type = driver.findElement(By.cssSelector("div.grid:nth-child(2)")).findElements(By.className("collection-grid__item-link"));
        int random_pet_type = random.nextInt(0, pet_type.size() - 2);
        pet_type.get(random_pet_type).click();
        WebElement items_grid = driver.findElement(By.className("grid-collage"));
        List<WebElement> pet_items = items_grid.findElements(By.className("product--image"));
        Assert.assertTrue(pet_items.size() == 10 || pet_items.size() == 12, "The actual number of items is not as expected");
    }

    @Test(priority = 4)
    public void verify_filling_contact_form_and_submit() {
        driver.get(CONTACT_URL);

        driver.findElement(By.id("ContactFormName")).sendKeys("Carl");

        driver.findElement(By.id("ContactFormEmail")).sendKeys("a@vmb.com");

        driver.findElement(By.id("ContactFormPhone")).sendKeys("55292500611");

        driver.findElement(By.id("ContactFormMessage")).sendKeys("I want my order wrapped as a gift");

        driver.findElement(By.className("btn")).click();
        WebElement success_msg = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contact_form\"]/p")));
        Assert.assertEquals(EXPECTED_MSG, success_msg.getText());
    }

    @Test(priority = 3, dependsOnMethods = "verify_selecting_random_dog_item")
    public void verify_checkout_process_and_screenshot_payment_page() throws IOException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        // fill the form
        WebElement email_field = driver.findElement(By.id("email"));
        WebElement last_field = driver.findElement(By.name("lastName"));
        WebElement address_field = driver.findElement(By.name("address1"));
        WebElement city_field = driver.findElement(By.name("city"));
        WebElement postal_field = driver.findElement(By.name("postalCode"));
        WebElement submit_button = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/main/form/div[1]/div/div[2]/div[2]/div[1]/button"));

        email_field.sendKeys("asdfsfa@gmail.com");
        last_field.sendKeys("johnson");
        address_field.sendKeys("Groove Street");
        city_field.sendKeys("San Andreas");
        postal_field.sendKeys("95249");

        // submit
        submit_button.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/main/form/div[1]/div/div/div[2]/div[1]/button")));
        WebElement continue_to_payment = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/main/form/div[1]/div/div/div[2]/div[1]/button"));
        continue_to_payment.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/main/div/form/div[1]/div/div[1]/section/div/div[1]/p")));
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        String dateTimeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File screenshotFile = new File("D:\\projects\\Pet-Store\\screenshot_" + dateTimeString + ".png");
        FileUtils.copyFile(screenshotDriver.getScreenshotAs(OutputType.FILE), screenshotFile);
        Assert.assertTrue(driver.findElement(By.id("step-section-primary-header")).isDisplayed());
    }

    @AfterTest
    public void teardown() {
            driver.quit();
    }
}
