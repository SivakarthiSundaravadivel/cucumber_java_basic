package pages_sample;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;
import static stepDefinitions.Hooks.driver;

public class addperson {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameInupt;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dobInput;
    @FindBy(how = How.ID, using = "language")
    private WebElement languageInput;
    @FindBy(how = How.ID, using = "name")
    private WebElement editname;
    @FindBy(how = How.ID, using = "modal_button")
    private WebElement enteredit;
    @FindBy(how = How.CLASS_NAME, using = "w3-closebtn")
    private WebElement deleteuser;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addPersonBtn\"]")
    private WebElement resetuser;
    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement clearinputs;






    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people.html";
    }

    public void enterName(String name) throws InterruptedException {
        nameInput.clear();
        nameInput.sendKeys(name);
    }
    public void enterSurname(String surname) {
        surnameInupt.clear();
        surnameInupt.sendKeys(surname);
    }
    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }
    public void enterdob(String dob) {
        dobInput.clear();
        dobInput.sendKeys(dob);
    }


    public void editname(String name){
        editname.clear();
        editname.sendKeys(name);

    }

    public void enteredit(){
        enteredit.click();

    }

    public void deleteuser(){
        deleteuser.click();

    }

    public void setResetuser(){
        resetuser.click();
    }

    public void clearinputs(){
        clearinputs.click();
    }
    public void checkclearinputs() throws InterruptedException {
        assertEquals("",nameInput.getText());
        assertEquals("",surnameInupt.getText());
        assertEquals("",jobInput.getText());
        assertEquals("",dobInput.getText());
    }



}
