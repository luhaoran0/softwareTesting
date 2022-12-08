package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {
    private static String PAGE_URL="https://phptravels.net/login";

    private static final By LOGIN_ERROR = By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/div[1]/div[1]");
    private static final By CONTACT_ERROR = By.cssSelector("#center_column > div > ol > li");
    public static final By EMAIL = By.name("email");
    public static final By PASSWORD = By.name("password");
    public static final By FROM=By.xpath("//*[@id=\"autocomplete\"]");
    public static final By DESTINATION=By.xpath("//*[@id=\"autocomplete2\"]");
    public static final By DATE=By.xpath("//*[@id=\"departure\"]");
    public static final By RECENT_SEARCH=By.xpath("//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/div/a/div/div[2]/h3");

    @FindBy(name="email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"fadein\"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[2]/a")
    private WebElement flight;

    @FindBy(xpath = "//*[@id=\"autocomplete\"]")
    private WebElement flightFrom;

    @FindBy(xpath = "//*[@id=\"autocomplete2\"]")
    private WebElement flightDestination;

    @FindBy(xpath = "//*[@id=\"departure\"]")
    private WebElement date;

    @FindBy(xpath = "//*[@id=\"flights-search\"]")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/header/div/div/div/div/div/div[2]/div/div[2]/div[3]/div/ul/li[1]/a")
    private WebElement dashboardButton;

    @FindBy(css = "#fadein > section.dashboard-area > div > div.dashboard-main-content > div > div.row > div > div > div.form-content.p-0 > div > a > div > div.msg-content.w-100 > h3")
    private WebElement recentSearch;

    @FindBy(xpath = "/html/body/header/div/div/div/div/div/div[2]/div/div[2]/div[3]/div/button")
    private WebElement accountButton;
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton(){
        login.click();
    }

    public void clickFlightButton(){flight.click();}

    public void clickSearchButton(){searchButton.click();}

    public void clickDashboardButton(){dashboardButton.click();}

    public void clickAccountButton(){accountButton.click();}

    public String getMessage(){
        return recentSearch.getText();
    }
    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }
    public void fillField(By locator, String value) {
        getField(locator).sendKeys(value);
    }
    public void cleanField(By locator){
        getField(locator).clear();
    }
    public Optional<String> getLoginError() {
        return getErrorMessage();
    }

    private Optional<String> getErrorMessage() {
        Optional<WebElement> error = getError();
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }
    private Optional<WebElement> getError() {
        List<WebElement> elements = driver.findElements(HomePage.RECENT_SEARCH);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
}
