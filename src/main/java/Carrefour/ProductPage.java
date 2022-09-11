package Carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final int TIMEOUT_COOKIE = 6;

    private By ChoixlivraisonDomicile = By.cssSelector("div.pl-radio");//By.xpath("//*[@id=\"product-detail-page\"]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div");
    private By AjouterAuPanier = By.cssSelector("[aria-label='Ajouter au panier']");//By.xpath("//*[@id=\"data-produit-acheter\"]/button");
    private By OuvrirPanier = By.cssSelector("[href='/cart/driveclcv']");//By.xpath("//*[@id=\"data-basket-panel\"]");
    private By VoirPanier = By.cssSelector("[data-testid='checkout-cta-priced_button']");//By.xpath("//*[@id=\"basket-panel__drawer\"]/div[3]/section/div[4]/div[2]/button");
    private WebDriver driver;

    public ProductPage (WebDriver driver){

        this.driver=driver;
    }
    public ProductPage livrerDomicile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonRadioChoixlivraisonDomicile = wait.until(ExpectedConditions.visibilityOfElementLocated(ChoixlivraisonDomicile));
        buttonRadioChoixlivraisonDomicile.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public ProductPage AjouterAuPanier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonAjouterAuPanier = wait.until(ExpectedConditions.visibilityOfElementLocated(AjouterAuPanier));
        buttonAjouterAuPanier.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public ProductPage OuvrirPanier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonOuvrirPanier = wait.until(ExpectedConditions.visibilityOfElementLocated(OuvrirPanier));
        buttonOuvrirPanier.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public CartPage VoirPanier() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonVoirPanier = wait.until(ExpectedConditions.visibilityOfElementLocated(VoirPanier));
        buttonVoirPanier.click();
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        return new CartPage(driver);
    }
}
