package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Random;

public class DogsPage {
    WebDriver driver;
    Random random;
    String PAGE_URL = "https://ecom-pet-store.myshopify.com/collections/frontpage";
    @FindBy(className = "grid-product__meta")
    private List<WebElement> dogProducts;
    @FindBy(css = "#ProductSelect-option-0 label")
    private List<WebElement> colors;
    @FindBy(css = "#ProductSelect-option-1 label")
    private List<WebElement> sizes;
    @FindBy(className = "shopify-payment-button__button")
    private WebElement buyNowButton;

    public DogsPage(WebDriver d, Random r) {
        driver = d;
        random = r;
        PageFactory.initElements(d, this);
    }

    public void selectRandomDogItem() {
        driver.get(PAGE_URL);
        int randomProductIndex = random.nextInt(dogProducts.size());
        dogProducts.get(randomProductIndex).click();
    }

    public void selectRandomColor() {
        int colorRandInd = random.nextInt(colors.size());
        colors.get(colorRandInd).click();
    }

    public void selectRandomSize() {
        int sizeRandInd = random.nextInt(sizes.size());
        sizes.get(sizeRandInd).click();
    }

    public void clickBuyNow() {
        buyNowButton.click();
    }
}
