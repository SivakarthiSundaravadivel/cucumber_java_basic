package stepDefinitions;

import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SamplePOSteps {
    private WebDriver driver;
    static AgePage agePage;
    static addperson addPerson;
    static AgeSubmittedPage ageSubmittedPage;

    public SamplePOSteps() {
        this.driver = Hooks.driver;
        agePage = PageFactory.initElements(Hooks.driver, AgePage.class);
        addPerson = PageFactory.initElements(Hooks.driver, addperson.class);
        ageSubmittedPage = PageFactory.initElements(Hooks.driver, AgeSubmittedPage.class);
    }

    @When("^I enter name: \"([^\"]*)\" using PO$")
    public void iEnterName(String name) throws Throwable {
        agePage.enterName(name);
    }

    @And("^I enter age: (\\d+) using PO$")
    public void iEnterAge(int age) throws Throwable {
        agePage.enterAge(age);
    }

    @Given("^I (?:am on|open) age page using PO$")
    public void iAmOnAgePage() throws Throwable {
        driver.get(agePage.getPageUrl());
    }

    @And("^I click submit age using PO$")
    public void iClickSubmitAge() throws Throwable {
        agePage.clickSubmit();
    }

    @Then("^I see message: \"(.*)\" using PO$")
    public void iSeeMessage(String message) throws Throwable {
        ageSubmittedPage.checkMessageText(message);
    }

    @When("^I enter values using PO:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        agePage.enterName(valuesToEnter.get("name"));
        agePage.enterAge(valuesToEnter.get("age"));
    }

    @When("^I the enter name: \"([^\"]*)\" using PO$")
    public void iEnterTheName(String name) throws Throwable {
        agePage.entername(name);
    }
    @And("^I the click submit age using PO$")
    public void iTheClickSubmitAgeusingPO(String age)throws Throwable{
        agePage.enterage(age);
    }
    @Then ("^I see error: \"([^\"]*)\" using PO$")
    public void iSeeError()throws Throwable{
        agePage.errortextdisplay();
    }
    @And("^I remain in age page using PO$")
    public void iRemaininAgepage(){
        assertEquals(agePage.getPageUrl(),driver.getCurrentUrl());
    }




    @When("^I am on peoples page$")
    public void iAmOnPeoplesPage(){
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @Then("^I press add person button$")
    public void ipressAddPersonButton(){
        driver.findElement(By.id("addPersonBtn")).click();
    }
    @Then("^I enter person name: \"([^\"]*)\" using PO$")
    public void iEnterPersonName(String name)throws Throwable{
        addPerson.enterName(name);
        Thread.sleep(5000);
    }
    @Then("^I enter surname: \"([^\"]*)\" using PO$")
    public void iEnterSurname(String surname)throws Throwable{
        addPerson.enterSurname(surname);
    }
    @Then("^I enter job: \"([^\"]*)\" using PO$")
    public void iEnterJob(String job)throws Throwable{
        addPerson.enterJob(job);
    }
    @Then("^I enter dob: \"([^\"]*)\" using PO$")
    public void iEnterDOB(String dob)throws Throwable{
        addPerson.enterdob(dob);
    }

    @Then("^I select languages: \"([^\"]*)\" using PO$")
    public void iSelectLanguage(String language)throws Throwable{

        driver.findElement(By.id(language)).click();

    }

    @Then("^I select gender: \"([^\"]*)\"$")
    public void iSelectgender(String gender)throws Throwable{
        driver.findElement(By.id(gender)).click();
    }


    @And("^I press add button$")
    public void iPressAndButton(){
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^I click edit button$")
    public void iClickEditButton() throws InterruptedException {
        driver.findElement(By.className("editbtn")).click();
    }

    @Then("^I edit name: \"([^\"]*)\"$")
    public  void ThenIEditName(String name) throws Throwable{
        addPerson.editname(name);
    }

    @And("^press edit button$")
    public void PressEditButton(){

        addPerson.enteredit();
    }

    @Then("^I click delete button$")
    public void iClickDeleteButton(){

        addPerson.deleteuser();
    }
    @Then("^I reset the page$")
    public void IResetThePage(){

        addPerson.setResetuser();
    }
    @And("^press clear button$")
    public void PressClearButton(){
        addPerson.clearinputs();
    }
    @And("^check all inputs are clears$")
    public void CheckAllInputsAreClear() throws InterruptedException {
        addPerson.checkclearinputs();

    }











}
