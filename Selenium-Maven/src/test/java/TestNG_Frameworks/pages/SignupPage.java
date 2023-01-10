package TestNG_Frameworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {

    @FindBy(xpath = "//div[1]/h2/b")
    private WebElement enterAccountInformationTitle;

    @FindBy(id = "id_gender1")
    private WebElement genderMR;

    @FindBy(id = "id_gender2")
    private WebElement genderMRS;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "days")
    private WebElement dateOfBirt_Days;

    @FindBy(id = "months")
    private WebElement dateOfBirt_Months;

    @FindBy(id = "years")
    private WebElement dateOfBirt_Years;

    @FindBy(xpath = "//div[1]/form/div[6]")
    private WebElement signupForOurNewsletter_Checkbox;

    @FindBy(xpath = "//div[1]/form/div[7]")
    private WebElement receiveSpecialOffers_Checkbox;

    @FindBy(id = "first_name")
    private WebElement firstNameBox;

    @FindBy(id = "last_name")
    private WebElement lastNameBox;

    @FindBy(id = "company")
    private WebElement companyBox;

    @FindBy(id = "address1")
    private WebElement addressBox;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateBox;

    @FindBy(id = "city")
    private WebElement cityBox;

    @FindBy(id = "zipcode")
    private WebElement zipcodeBox;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberBox;

    @FindBy(css = "[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[3]/div/form/p")
    private WebElement emailAlreadyExistMessage;


    public String getEnterAccountInformationTitle() {
        return enterAccountInformationTitle.getText();
    }

    public void selectTitleMen() {
        genderMR.click();
    }

    public void selectTitleWomen() {
        genderMRS.click();
    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void setDateOfBirt(String day, String month, String year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    private void setDay(String day) {
        Select select = new Select(dateOfBirt_Days);
        select.selectByVisibleText(day);
    }

    private void setMonth(String month) {
        Select select = new Select(dateOfBirt_Months);
        select.selectByVisibleText(month);
    }

    private void setYear(String year) {
        Select select = new Select(dateOfBirt_Years);
        select.selectByVisibleText(year);
    }

    public void selectSignupForOurNewsletter_Checkbox() {
        signupForOurNewsletter_Checkbox.click();
    }

    public void selectReceiveSpecialOffers_Checkbox() {
        receiveSpecialOffers_Checkbox.click();
    }

    public void setFirstName(String firstName) {
        firstNameBox.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameBox.sendKeys(lastName);
    }

    public void setCompany(String company) {
        companyBox.sendKeys(company);
    }

    public void setAddress(String address) {
        addressBox.sendKeys(address);
    }

    public void setCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void setState(String state) {
        stateBox.sendKeys(state);
    }

    public void setCity(String city) {
        cityBox.sendKeys(city);
    }

    public void setZipcode(String zipcode) {
        zipcodeBox.sendKeys(zipcode);
    }

    public void setMobileNumber(String mobileNumber) {
        mobileNumberBox.sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public String getEmailAlreadyExistMessage() {
        return emailAlreadyExistMessage.getText();
    }

}
