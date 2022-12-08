package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ContactUsSteps extends AbstractStepDefs{
    @Given("Contact us page is open")
    public void ContactUsPageIsOpen(){
        driver.get("https://ultimateqa.com/contact/");
    }


    @Given("the First name is filled with {string} and Last name with {string} and Email with {string} and Message with {string}")
    public void theFirstNameIsFilledWithFirstnameAndLastNameWithLastnameAndEmailWithEmailAndMessageWithMsg(String first,String last,String email,String msg) {
        driver.findElement(By.xpath(ContactUsPageDef.getFIRSTNAME())).sendKeys(first);
        driver.findElement(By.xpath(ContactUsPageDef.getLASTNAME())).sendKeys(last);
        driver.findElement(By.xpath(ContactUsPageDef.getEMAIL())).sendKeys(email);
        driver.findElement(By.xpath(ContactUsPageDef.getSendMessage())).sendKeys(msg);
    }

    @When("send message")
    public void sendMessage() throws InterruptedException {
        driver.findElement(By.xpath(ContactUsPageDef.getMessagebutton())).click();
        Thread.sleep(1000);
    }

    @Then("error shown with {string}")
    public void errorShownWithEmsg(String emsg) throws InterruptedException {
        String err =driver.findElement(By.className(ContactUsPageDef.getErroeMessage())).getText();
        if (err!=null){
            Assert.assertEquals(emsg,err);
        }
    }


    @Then("Show Thanks for contacting us")
    public void showThanksForContactingUs() {
        driver.findElement(By.className(ContactUsPageDef.getErroeMessage())).getText();
    }

    @Then("Alert shown {string}")
    public void alertShown(String alert) {
        String err =driver.switchTo().alert().getText();
        if (err!=null){
            Assert.assertEquals(alert,err);
        }
    }
}
