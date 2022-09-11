package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private By AjouterPanierSelector = By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']");
    private By NomerciSelector = By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']");
    private By PanierSelector = By.cssSelector("#attach-sidesheet-view-cart-button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    /*
    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AjouterPanierSelector));
        ajouterAuPanierButton.click();
    }*/
    public ProductPage addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AjouterPanierSelector));
        ajouterAuPanierButton.click();
        return new ProductPage(driver);
    }

    public ProductPage refuseAppleCare() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(NomerciSelector));
        nonmerci.click();
        return new ProductPage(driver);
    }
    public CartPage openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(PanierSelector));
        panierButton.click();
        return new CartPage(driver);
    }

}
