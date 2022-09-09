import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    private By ElementSelector = By.cssSelector("img.s-image");
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public ProductPage  openSearchResult(int index) {
        List<WebElement> resultatList = driver.findElements(ElementSelector);
        resultatList.get(index).click();
        return new ProductPage(driver);
    }
}
