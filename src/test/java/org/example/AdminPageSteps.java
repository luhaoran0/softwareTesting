package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Optional;

import static org.junit.Assert.fail;

public class AdminPageSteps extends AbstractStepDefs {
    @Given("the adminpage is open")
    public void theHomepageIsOpen() {
        adminPageDef.openPage();
    }

    @Given("the Email is filled with {string} and Password with {string}")
    public void theFieldIsFilledWithParameter(String arg1, String arg2) throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(arg1);
        driver.findElement(By.name("password")).sendKeys(arg2);
        Thread.sleep(1000);
    }
    @When("When the Login button is clicked")
    public void theLoginButtonIsClicked() throws InterruptedException {
        adminPageDef.clickLoginButton();
        Thread.sleep(1000);
    }
    @Then("{string} shown")
    public void msgShown(String msg) {
        Optional<String> errorMessage = adminPageDef.getLoginError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    @Given("press forget password")
    public void pressForgetPassword() {adminPageDef.clickForgetButton();
    }


    @And("enter {string}")
    public void enterEmail(String resetEmail) {
        driver.findElement(By.xpath("//*[@id=\"resetemail\"]")).sendKeys(resetEmail);
    }

    @When("reset password")
    public void resetPassword() throws InterruptedException {
        adminPageDef.clickResetPassword();
        Thread.sleep(5000);
    }

    @Then("password {string} shown")
    public void passwordMsgShown(String msg) {
        String webMsg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/form/div[1]")).getText();
        if (webMsg!=null){
            Assert.assertEquals(msg,webMsg);
        }
    }
}
