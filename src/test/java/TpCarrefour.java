import Carrefour.CartPage;
import Carrefour.BestSeller;
import Carrefour.HomePage;
import Carrefour.ShoopingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpCarrefour {
    WebDriver driver;
    final String expectedProductName  = "Trottinette électrique Connect - 7711945834 - Noir RENAULT";

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.carrefour.fr/");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown() {
        driver.quit();

    }

    @Test
    public void testCarrefour(){
        HomePage homePage = new HomePage(driver);
        CartPage cartPage =homePage.acceptCookie()
                .OuvrirMaisonLoisir()
                .OuvrirRayon().OuvrirSportLoisirMobiliteChoix(4).OuvrirMeilleurVente()
                .OuvrirResultat().livrerDomicile().AjouterAuPanier().OuvrirPanier()
                .VoirPanier();

       // Assert.assertEquals(CartPage.getNomProduit(),expectedProductName,"sous total pa bon");
        Assert.assertEquals(cartPage.gettitreproduit(), expectedProductName);

    }


}
