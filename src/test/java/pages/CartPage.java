package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(name = "lastName")
    private WebElement lastNameField;
    @FindBy(name = "address1")
    private WebElement addressField;
    @FindBy(name = "city")
    private WebElement cityField;
    @FindBy(name = "postalCode")
    private WebElement postalField;
    @FindBy(xpath = "//button[@class='QT4by rqC98 hodFu VDIfJ j6D1f janiy']")
    private WebElement continueToShippingButton;
    @FindBy(xpath = "//button[@class='QT4by rqC98 hodFu VDIfJ j6D1f janiy']")
    private WebElement continueToPaymentButton;
    public CartPage(WebDriver d, WebDriverWait w) {
        driver = d;
        webDriverWait = w;
        PageFactory.initElements(d, this);
    }

    public void fillForm() {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys("asdfsfa@gmail.com");
        lastNameField.sendKeys("johnson");
        addressField.sendKeys("Groove Street");
        cityField.sendKeys("San Andreas");
        postalField.sendKeys("95249");
    }

    public void clickContinueToShipping() {
        continueToShippingButton.click();

    }

    public void clickContinueToPayment() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(continueToPaymentButton));
        continueToPaymentButton.click();
    }

    public boolean takeScreenshot() throws IOException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='All transactions are secure and encrypted.']")));
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        String dateTimeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File screenshotFile = new File("D:\\projects\\Pet-Store\\screenshot_" + dateTimeString + ".png");
        FileUtils.copyFile(screenshotDriver.getScreenshotAs(OutputType.FILE), screenshotFile);
        return driver.findElement(By.id("step-section-primary-header")).isDisplayed();
    }

}
