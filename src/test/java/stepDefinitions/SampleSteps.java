package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @And("^I see error: \"You haven't entered anything in age field\"$")
    public void iSeeErrorYouHaventEnteredAge() throws Throwable{
        assertEquals("You haven't entered anything in age field",driver.findElement(By.id("error")).getText());
    }

    @And("^I am not navigated to age message page$")
    public void iAmNotNavigatedToAgeMessagePage() throws Throwable{
        assertTrue(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age"));
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @Given("^I am on feedback page$")
    public void iAmOnFeedbackPage() throws Throwable{
        driver.get("https://kristinek.github.io/site/examples/age");

    }

    @When("^I enter feedback name: \"([^\"]*)\"$")
    public void iEnterFeedbackName(String name) throws Throwable{
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @When("^I enter feedback age: ([^\"]*)$")
    public void iEnterFeeedbackAge(String age) throws Throwable{
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys(age);
    }

    @And("^I click submit button$")
    public void IClickSubmitButton() throws Throwable{
        driver.findElement(By.id("submit")).click();

    }

    @When("^I will see message: \"([^\"]*)\"$")
    public void iWillSeeMessage(String message) throws Throwable{
        assertEquals(message,driver.findElement(By.id("message")).getText());
    }



    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }


    @Given("^I am on the locators page$")
    public void iAmOnTheLocatersPage(){
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @Then("^I should see both locators page headers$")
    public void iShouldSeeBothLocatersPageHeaders() {
        assertTrue(driver.findElement(By.id("heading_1")).isDisplayed());
        assertTrue(driver.findElement(By.id("heading_2")).isDisplayed());
    }

    @Then("^Buttons in Locators page are clickable$")
    public void buttonsInLocatorsPageAreClickables() {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
    }

    @Given("^I am on the enter a number page$")
    public void iAmOnTheEnterANumberPage(){
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }
    @Then("^I should enter correct number$")
    public void iShoulEnterCorrectNumber(){
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys("100");
    }
    @And("^I should click submit button$")
    public void iShouldclickSubmitButton() throws Throwable{
        driver.findElement(By.tagName("button")).click();
    }

    @And("^I should see the alert box with square root$")
    public void iShouldSeeTheAlertBoxWithSquareRoot() throws Throwable{

       assertEquals("Square root of 100 is 10.00", driver.switchTo().alert().getText());
    }
    @Given("^I am on the enter_a_number page$")
    public void iAmOnTheEnter_A_NumberPage(){
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }
    @Then("^I should enter wrong number : ([^\"]*)$")
    public void iShoulEnterWrongNumber(String number)throws  Throwable{
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }
    @And("^I should click submit_button$")
    public void iShouldclickSubmit_Button() throws Throwable{
        driver.findElement(By.tagName("button")).click();
    }
    @Then("^I should see the error message : \"([^\"]*)\"$")
    public void iShoulSeeTheErrorMessage(String message)throws  Throwable{
       assertEquals(message,driver.findElement(By.id("ch1_error")).getText());
    }

    @Given("^I am on feedbackk page$")
    public void IAmOnFeedbackkPage(){

        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @When("^I select feedback languages$")
    public void iSelectFeedbackLanguages(List<String> languages) throws Throwable {
        for (String language : languages) {
            driver.findElement(By.xpath("//input[@class='w3-check' and @value='" + language + "']")).click();
        }
    }

    @And("^I click sendd feedback$")
    public void iClickSenddFeedback(){
        driver.findElement(By.tagName("button")).click();
    }

    @Then("^I can see languages \"([^\"]*)\" in feedback check$")
    public void iCanSeeLanguages(String languages) throws Throwable {
        assertEquals(languages,driver.findElement(By.id("language")).getText());
    }
}
