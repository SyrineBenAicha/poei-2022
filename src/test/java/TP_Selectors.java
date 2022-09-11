import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TP_Selectors {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testxpath() {


        WebElement cookieButton = driver.findElement(By.xpath("//input[@aria-labelledby='a-autoid-0-announce']"));
        cookieButton.click();
        WebElement searchBar = driver.findElement(By.xpath("//input[@aria-label='Rechercher']"));
        searchBar.sendKeys("coque iphone 13");
        WebElement ButtonLoup;
        ButtonLoup = driver.findElement(By.xpath("//input[@type='submit' and @value='Go']"));
        ButtonLoup.click();
        WebElement premierresultat = driver.findElement(By.xpath("//div[@class='a-section a-spacing-base']"));
        premierresultat.click();
        WebElement Ajouterpanier = driver.findElement(By.xpath("//input[@title='Ajouter au panier']"));
        Ajouterpanier.click();
        WebElement Ouvrirpanier = driver.findElement(By.xpath("//div[@class=' nav-progressive-attribute']"));
        Ouvrirpanier.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void testCss() {
        /*
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
        *//*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();*/
        /*
        final int IMPLICIT_TIMEOUT =10;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
        */
        /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        *//*
        WebElement buttoCookie = driver.findElement(By.cssSelector("[data-cel-widget=sp-cc-accept]"));
        buttoCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Coque iphone 13");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();
       /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        */
        WebElement premierResultat = driver.findElement(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]"));
        premierResultat.click();

        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajouterAuPanierButton.click();

        WebElement panierButton = driver.findElement(By.cssSelector("#nav-cart"));
        panierButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    @Test
    public void testExplicitWait() {
        /*
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
        */
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();
        */
        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Coque iphone 13");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();
/*
        WebElement premierResultat = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]")));
        premierResultat.click();
*/
        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajouterAuPanierButton.click();

        WebElement panierButton = driver.findElement(By.id("nav-cart"));
        panierButton.click();

        driver.quit();
    }
}
