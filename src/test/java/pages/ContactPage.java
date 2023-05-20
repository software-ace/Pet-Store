package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    WebDriver driver;
    public String EXPECTED_MSG = "Thanks for contacting us. We'll get back to you as soon as possible.";
    String PAGE_URL = "https://ecom-pet-store.myshopify.com/pages/contact";

    @FindBy(id = "ContactFormName")
    private WebElement nameTextField;
    @FindBy(id = "ContactFormEmail")
    private WebElement emailTextField;
    @FindBy(id = "ContactFormPhone")
    private WebElement phoneTextField;
    @FindBy(id = "ContactFormMessage")
    private WebElement messageTextField;
    @FindBy(className = "btn")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"contact_form\"]/p")
    private WebElement formMessage;
    private final WebDriverWait webDriverWait;

    public ContactPage(WebDriver d, WebDriverWait w) {
        driver = d;
        webDriverWait = w;
        PageFactory.initElements(d, this);
    }

    public void fillForm(String name, String email, String phone, String message) {
        driver.get(PAGE_URL);
        nameTextField.sendKeys(name);
        emailTextField.sendKeys(email);
        phoneTextField.sendKeys(phone);
        messageTextField.sendKeys(message);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getFormMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(formMessage));
        return formMessage.getText();
    }
}
