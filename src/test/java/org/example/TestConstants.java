package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class TestConstants {
    static WebDriver driver = new EdgeDriver();
    Random random = new Random();
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofMinutes(2));
    static String BASE_URL = "https://ecom-pet-store.myshopify.com/";
    static String CART_URL = "https://ecom-pet-store.myshopify.com/cart";
    static String EXPECTED_MSG = "Thanks for contacting us. We'll get back to you as soon as possible.";
    static String CONTACT_URL = "https://ecom-pet-store.myshopify.com/pages/contact";
    static String DOGS_PAGE = "https://ecom-pet-store.myshopify.com/collections/frontpage";
}
