package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(id = "search_product")
    private WebElement searchProductBox;

    @FindBy(css = "[class='fa fa-search']")
    private WebElement searchButton;

    @FindBy(css = "[class='title text-center']")
    private WebElement searchedProductTitle;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/p")
    private List<WebElement> searchedProducts;


    public void searchProduct(String productName) {
        searchProductBox.sendKeys(productName);
    }


    public void clickSearchButton() {
        searchButton.click();
    }

    public String getSearchedProductTitle() {
        return searchedProductTitle.getText();
    }

    public List<WebElement> getSearchedProducts() {
        return searchedProducts;
    }
}
