package com.web.automation.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


public class StepDefinition {

    WebDriver driver= null;
    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.setProperty("webdriver.chrome.driver","Driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();



    }
    @When("User enters username")
    public void user_enters_username() {
      driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }
    @When("User enters password")
    public void user_enters_password() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
    driver.findElement(By.name("login-button")).click();
    }

    @Then("User should be loggedin")
    public void user_should_be_loggedin() {
    driver.getCurrentUrl();

    }
    @When("User click on Logout button")
    public void user_click_on_logout_button() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();


    }


    @And("User adds two products to cart {string} {string}")
    public void userAddsTwoProductsToCart(String firstProduct, String secondProduct) {
        driver.findElement(By.id(firstProduct)).click();

        driver.findElement(By.id(secondProduct)).click();
    }

    @And("User clicks on shopping cart")
    public void userClicksOnShoppingCart() {
        driver.findElement(By.className("shopping_cart_link")).click();

    }

    @And("User clicks checkout")
    public void userClicksCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User fills the information with firstName {string}, lastName {string} and ZipCode {string}")
    public void userFillsTheInformationWithFirstNameLastNameAndZipCode(String firstName, String lastName, String zipCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
        driver.findElement(By.id("continue")).click();
    }

    @Then("Verify if the total price is correct")
    public void verifyIfTheTotalPriceIsCorrect() {
        String price1= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
        String price2= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText();
        String taxStr= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")).getText();
        String total_priceStr=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")).getText();
        double item_price1= Double.parseDouble(price1.substring(1));
        double item_price2= Double.parseDouble(price2.substring(1));
        double tax= Double.parseDouble(taxStr.substring(6));
        double total_price= Double.parseDouble(total_priceStr.substring(8));

        if(item_price1+item_price2+tax==total_price){
            System.out.println("The price is correct");}
        else{
            System.out.println("The price is wrong");
            Assert.fail("Test failed because price is wrong");
        }
    }

    @And("User adds a product {string} to the cart")
    public void userAddsAProductToTheCart(String product) {
        driver.findElement(By.id(product)).click();
    }

    @And("User removes product {string} from the cart")
    public void userRemovesProductFromTheCart(String product2) {
     driver.findElement(By.id(product2)).click();
    }


    @Then("verify if product {string} is removed")
    public void verifyIfProductIsRemoved(String product2) {

        boolean isAbsent= driver.findElements(By.id(product2)).isEmpty();
        if(!isAbsent){
            Assert.fail("Product was not removed");
        }

    }

    @Then("User clicks on finish button")
    public void userClicksOnFinishButton() {
        driver.findElement(By.id("finish")).click();
    }
}
