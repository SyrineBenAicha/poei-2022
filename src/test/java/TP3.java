import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TP3 {
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

        driver.findElement(By.id("nav-hamburger-menu")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item")));

        List<WebElement> menuList = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));
        menuList.get(0).click();

        List<WebElement> choixList = driver.findElements(By.cssSelector("ol.a-carousel > li.a-carousel-card"));
        choixList.get(1).click();

    }

    @Test
    public void testAsserts() {
        // Arrange
        final String expectedToutes = "Toutes";
        final String expectedMeilleuresVentes = "Meilleures ventes";
        final String expectedAmazonBasics = "Amazon Basics";
        final String expectedVentesLivres = "Meilleures ventes dans Livres";

        // Act
        WebElement logo = driver.findElement(By.cssSelector("#nav-logo"));
        WebElement barreRecherche = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement toutesMenu = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        WebElement meilleuresVentes = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_bestsellers]"));
        WebElement amazonBasics = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_amazonbasics]"));
        WebElement meilleuresVentesLivres = driver.findElement(By.cssSelector("[data-csa-c-slot-id=desktop-5] h2.as-title-block-left"));

        // Asserts
        Assert.assertTrue(logo.isDisplayed(), "The Amazon Logo is not displayed");
        Assert.assertTrue(barreRecherche.isDisplayed());
        Assert.assertEquals(toutesMenu.getText(), expectedToutes);

        Assert.assertTrue(meilleuresVentes.isDisplayed());
        Assert.assertEquals(meilleuresVentes.getText(), expectedMeilleuresVentes, "The button Meilleures Ventes is not correct");

        Assert.assertTrue(amazonBasics.isDisplayed());
        Assert.assertEquals(amazonBasics.getText(), expectedAmazonBasics);

        Assert.assertTrue(meilleuresVentesLivres.isDisplayed());
        Assert.assertEquals(meilleuresVentesLivres.getText(), expectedVentesLivres);
    }

    @Test
    public void testSelect() {
        WebElement dropdown = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByValue("2");
    }

}
