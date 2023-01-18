package TestNG_Frameworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(id = "search_product")
    private WebElement searchProductBox;

    @FindBy(css = "[class='fa fa-search']")
    public WebElement searchButton;

    @FindBy(css = "[class='title text-center']")
    private WebElement searchedProductTitle;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/p")
    private List<WebElement> searchedProducts;

    @FindBy(css = "[class='col-sm-4']")
    private List<WebElement> productList;


    public By viewProductButtons =  By.cssSelector("[class='choose']");

    @FindBy(css = "[class='col-sm-7']")
    public WebElement productDetails;


    private final By nameInDetails = By.cssSelector("h2");

    private final By priceInDetails = By.cssSelector("span:first-child");

    private final By otherDetails = By.cssSelector("p");



    public void searchProduct(String productName) {
        searchProductBox.sendKeys(productName);
    }

    public String getSearchedProductTitle() {
        return searchedProductTitle.getText();
    }

    public List<WebElement> getSearchedProducts() {
        return searchedProducts;
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public List<WebElement> getDesiredProductDetails() {
        List<WebElement> desiredDetails = new ArrayList<>();
        desiredDetails.add(productDetails.findElement(nameInDetails));
        desiredDetails.add(productDetails.findElement(priceInDetails));
        desiredDetails.addAll(productDetails.findElements(otherDetails));

        return desiredDetails;
    }
}
