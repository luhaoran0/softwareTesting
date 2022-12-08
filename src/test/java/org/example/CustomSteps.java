package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class CustomSteps {
    private static final int WAIT_TIME = 10;

    static WebDriver driver;

    protected static HomePage homePage;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @Given("the homepage is open")
    public void theHomepageIsOpen() {homePage.openPage();
    }
    @Given("the Username is filled with {string}")
    public void theUsernameIsFilledWithStandard_user(String email) {
        homePage.fillField(HomePage.EMAIL,email);
    }

    @And("the Password is filled with {string}")
    public void thePasswordIsFilledWithPassword(String password) {
        homePage.fillField(HomePage.PASSWORD,password);
    }

    @And("the Login button is clicked")
    public void theLoginButtonIsClicked() {
        homePage.clickLoginButton();
    }

    @Given("Flights page is open")
    public void flightsPageIsOpen() {homePage.clickFlightButton();
    }


    @And("From enter {string}")
    public void fromEnterLONAllAirportsLondon(String from) {homePage.fillField(HomePage.FROM,from);
    }

    @And("Destination enter {string}")
    public void destinationEnterBUDFerihegyBudapest(String destination) {homePage.fillField(HomePage.DESTINATION,destination);
    }

    @And("Date is enter {string}")
    public void dateIsChoosen(String date) {
        homePage.cleanField(HomePage.DATE);
        homePage.fillField(HomePage.DATE,date);
    }


    @And("Search is clicked")
    public void searchIsClicked() {homePage.clickSearchButton();
    }

    @And("Dashboard is open")
    public void dashboardIsOpen() throws InterruptedException {
        homePage.clickAccountButton();
        Thread.sleep(1000);
        homePage.clickDashboardButton();
    }

    @Then("Recent Searches is shown")
    public void recentSearchesIsShownFlightsLON() {
        if (homePage.getMessage()!=null){
            System.out.println(homePage.getMessage());
        }else {
            fail();
        }
    }

    @And("Account is clicked")
    public void accountIsClicked() {
homePage.clickAccountButton();
    }
}