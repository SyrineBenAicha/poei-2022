package Carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    private By acceptCookieSelector = By.cssSelector("div.banner-actions-container > #onetrust-accept-btn-handler");

    private By MaisonLoisirSelector = By.cssSelector("[for = header-tab-non-food]");//By.xpath("//*[@id=\"data-top-bar\"]/div/div/div[2]/label");
    private final int TIMEOUT_COOKIE = 6;

    public HomePage(WebDriver driver){

        this.driver=driver;
    }

    public HomePage acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
        return this;
    }
    public ShoopingPage OuvrirMaisonLoisir() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonMaisonLoisir = wait.until(ExpectedConditions.visibilityOfElementLocated(MaisonLoisirSelector));
        buttonMaisonLoisir.click();
        return new ShoopingPage(driver);
    }


        }
