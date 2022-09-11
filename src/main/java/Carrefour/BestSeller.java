package Carrefour;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BestSeller {
    private WebDriver driver;
    private final int TIMEOUT_COOKIE = 6;
    private By fleche = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div/div/div/div/button[2]");//By.cssSelector("[class='pl-button pl-button--primary ds-carousel__arrow ds-carousel__arrow--right']");
    private By VoirResultattSelector = By.xpath("//*[@id=\"3701134907896\"]/div[2]/div[1]/div[2]/div[2]/a");//By.cssSelector("img.s-image");
    public BestSeller(WebDriver driver){

        this.driver=driver;

    }

    public ProductPage OuvrirResultat() {

        WebElement SurvolButton = driver.findElement(fleche);

        Actions actions = new Actions(driver);
        actions.moveToElement(SurvolButton);
        actions.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonfleche = wait.until(ExpectedConditions.visibilityOfElementLocated(fleche));
        buttonfleche.click();

        WebElement buttonVoir = wait.until(ExpectedConditions.visibilityOfElementLocated(VoirResultattSelector));
        buttonVoir.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ProductPage(driver);
    }


}
