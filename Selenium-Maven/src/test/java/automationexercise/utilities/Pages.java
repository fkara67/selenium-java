package automationexercise.utilities;

import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import automationexercise.pages.ProductsPage;
import automationexercise.pages.SignupPage;

public class Pages {
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private ProductsPage productsPage;

    public Pages() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.signupPage = new SignupPage();
        this.productsPage = new ProductsPage();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }
}
