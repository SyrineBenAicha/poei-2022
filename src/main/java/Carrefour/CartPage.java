package Carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private By NomProduit = By.xpath("//*[@id=\"3701134907896\"]/div[2]/div[2]/div[1]/div/div/h2");//By.cssSelector("#sc-subtotal-label-activecart");
    public CartPage(WebDriver driver){

        this.driver=driver;
    }

    /*public static CartPage getNomProduit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement TitreNomProduit = wait.until(ExpectedConditions.visibilityOfElementLocated(NomProduit));
        TitreNomProduit.getText();
        return new CartPage(driver);
    }*/
    public String gettitreproduit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(NomProduit));
        return soustotale.getText();
       // return this;
    }
}
