import Amazon.CartPage;
import Amazon.HomePage;
import Amazon.ProductPage;
import Amazon.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObject {

    WebDriver driver;
    final String expectedProductName  = "Sous-total (2 articles):";
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
    public void testPO() {

        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        homePage.SearchWithButton("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");



        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openSearchResult(0);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.refuseAppleCare();
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.selectQuantity(2);
        cartPage.getFirstProductCapacity();
        cartPage.getFirstProductColor();
        cartPage.getFirstProductConfiguration();
        cartPage.getSubtotalCart();


        //Assert.assertEquals(Collections.singleton(cartPage.getSubtotalCart()),expectedProductName);
        Assert.assertEquals(cartPage.getSubtotalCart(), expectedProductName);

    }
    @Test
    public void testPOO() {
        final String keyword = "iPhone 13";

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = homePage.acceptCookie()
                .SearchWithButton(keyword)
                .openSearchResult(0)
                .addToCart()
                .refuseAppleCare()
                .openCart();

        Assert.assertEquals(cartPage.getSubtotalCart(), "1000");
    }

    @Test
    public void test2(){ // passer le curseur de souris sur le bouton sans appuie
        HomePage homePage = new HomePage(driver);

        WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-accountList"));

        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton);
        actions.perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}