package TestNG_Frameworks.utilities;


import TestNG_Frameworks.pages.*;

public class Pages {
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private ProductsPage productsPage;
    private TransitionPage transitionPage;


    public Pages() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.signupPage = new SignupPage();
        this.productsPage = new ProductsPage();
        this.transitionPage = new TransitionPage();
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

    public TransitionPage getTransitionPage() {
        return transitionPage;
    }
}
