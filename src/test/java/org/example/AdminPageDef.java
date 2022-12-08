package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.fail;

public class AdminPageDef {
    private static final String PAGE_URL="https://phptravels.net/api/admin";
    public static final By EMAIL = By.name("email");
    public static final By PASSWORD = By.name("password");
    private static final By LOGIN_ERROR = By.xpath("//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[5]/div");

    @FindBy(name="email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[4]/button/span[1]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"link-forgot\"]")
    private WebElement forgetPassword;
    @FindBy(xpath = "//*[@id=\"resetemail\"]")
    private WebElement resetEmail;

    @FindBy(xpath = "//*[@id=\"btn-forgot\"]")
    private WebElement resetPassword;

    @FindBy(xpath = "//*[@id=\"passresetfrm\"]/div[1]")
    private WebElement resetMessage;

    private final WebDriver driver;

    public AdminPageDef(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton(){
        login.click();
    }

    public void clickForgetButton(){forgetPassword.click();}

    public void clickResetPassword(){resetPassword.click();}

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }
    public void fillField(By locator, String value) {
        getField(locator).sendKeys(value);
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
        List<WebElement> elements = driver.findElements(AdminPageDef.LOGIN_ERROR);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }

    public WebElement getEmail() {
        return email;
    }

    public void setEmail(WebElement email) {
        this.email = email;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getLogin() {
        return login;
    }

    public void setLogin(WebElement login) {
        this.login = login;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
