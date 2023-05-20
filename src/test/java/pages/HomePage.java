package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class HomePage {
    private final WebDriver driver;
    private final Random random;
    String PAGE_URL = "https://ecom-pet-store.myshopify.com/";
    @FindBy(className = "collection-grid__item-link")
    private List<WebElement> petTypes;

    @FindBy(className = "product--image")
    private List<WebElement> petItems;

    public HomePage(WebDriver d, Random r) {
        driver = d;
        random = r;
        PageFactory.initElements(d, this);
    }

    public void selectRandomPetType() {
        driver.get(PAGE_URL);
        int randomPetType = random.nextInt(4);
        petTypes.get(randomPetType).click();

    }

    public int getPetItemsNumber() {
        return petItems.size();
    }

}