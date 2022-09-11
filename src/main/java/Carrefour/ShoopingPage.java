package Carrefour;

import Amazon.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoopingPage {

    private WebDriver driver;

    private By RayonSelector = By.cssSelector("[aria-label='Ouvrir la liste des rayons']");//By.xpath("//*[@id=\"data-rayons\"]/span[1]");
    private By SportLoisirMobiliteSelector = By.cssSelector("ul.nav-item__menu-level-0 > li.nav-item");//By.xpath("//*[@id=\"data-menu-level-0\"]/li[5]/a")
    private By MeilleurVenteSelector = By.cssSelector("[href='/edito/high-tech-maison-loisirs-meilleures-ventes#sportsetloisirs']");//By.xpath("//*[@id=\"data-menu-level-1_R26\"]/li[3]/a");
    private final int TIMEOUT_COOKIE = 6;

    public ShoopingPage(WebDriver driver){

        this.driver=driver;
    }
    public ShoopingPage OuvrirRayon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonRayon = wait.until(ExpectedConditions.visibilityOfElementLocated(RayonSelector));
        buttonRayon.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public ShoopingPage OuvrirSportLoisirMobiliteChoix(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        List<WebElement> Listechoix = driver.findElements(SportLoisirMobiliteSelector);
        WebElement SportLoisirMobilité = Listechoix.get(index);
        SportLoisirMobilité.click();
       // MeilleurVente.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public BestSeller OuvrirMeilleurVente() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement MeilleurVente = wait.until(ExpectedConditions.visibilityOfElementLocated(MeilleurVenteSelector));
        MeilleurVente.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new BestSeller(driver);
    }
}
