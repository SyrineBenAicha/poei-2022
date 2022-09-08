import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TP4 {
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
    public void testList() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();

        WebElement premierResultat = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=search_result_2]")));
        premierResultat.click();

        WebElement panierButton = driver.findElement(By.cssSelector("#add-to-cart-button"));
        panierButton.click();

        driver.get(" https://www.amazon.fr/gp/cart/view.html");

        WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByValue("2");

        List<WebElement> menuList = driver.findElements(By.cssSelector("span.a-text-bold.a-size-small + span"));


            // Arrange
            final String expectedtitreproduit = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
            final String expectedsoustotal = "Sous-total (2 articles)";
            final String expectedtaille = "256Go";
            final String expectedCouleur = "Vert alpin";
            final String expectedConfiguration = "Sans AppleCare+";

            // Act
            WebElement titreProduit = driver.findElement(By.cssSelector("li.a-spacing-mini"));
            WebElement soustotal = driver.findElement(By.cssSelector("#sc-subtotal-label-activecart"));
            WebElement taille = menuList.get(1);
            WebElement Couleur = menuList.get(2);
            WebElement Configuration = menuList.get(2);

            // Asserts

            Assert.assertTrue(titreProduit.isDisplayed());
            Assert.assertEquals(titreProduit.getText(), expectedtitreproduit);

            Assert.assertTrue(soustotal.isDisplayed());
            Assert.assertEquals(soustotal.getText(), expectedsoustotal);

            Assert.assertTrue(taille.isDisplayed());
            Assert.assertEquals(taille.getText(), expectedtaille);

            Assert.assertTrue(Couleur.isDisplayed());
            Assert.assertEquals(Couleur.getText(), expectedCouleur);

            Assert.assertTrue(Configuration.isDisplayed());
            Assert.assertEquals(Configuration.getText(), expectedConfiguration);


    }
}
