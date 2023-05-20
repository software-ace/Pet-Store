package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private final WebDriver driver;
    String PAGE_URL = "https://ecom-pet-store.myshopify.com/search?q=";

    @FindBy(name = "q")
    private WebElement searchTextField;
    @FindBy(className = "grid-product__title")
    private List<WebElement> itemsTitle;

    public List<WebElement> getItemsTitle() {
        return itemsTitle;
    }

    public SearchPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }

    public void performSearch(String searchText) {
        driver.get(PAGE_URL);
        searchTextField.sendKeys(searchText, Keys.ENTER);
    }

    public int countItemsWithTitleContaining(String word) {
        int matchingItemsCounter = 0;
        for (WebElement itemTitle : itemsTitle) {
            if ((itemTitle.getText().toLowerCase()).contains(word)) {
                matchingItemsCounter++;
            }
        }
        return matchingItemsCounter;
    }

}
