package com.nat.jenkins.qa.step;

import com.nat.jenkins.qa.page.ConfigurationPage;
import com.nat.jenkins.qa.page.HomePage;
import com.nat.jenkins.qa.page.JobDetailsPage;
import com.nat.jenkins.qa.page.NewItemPage;
import com.nat.jenkins.qa.utils.DataStore;
import com.nat.jenkins.qa.utils.DataTableExt;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
public class NewItemStep extends AbstractStep {

    @Autowired
    private NewItemPage newItemPage;
    @Autowired
    private HomePage homePage;
    @Autowired
    private ConfigurationPage configurationPage;
    @Autowired
    private JobDetailsPage jobDetailsPage;
    @Autowired
    private DataStore dataStore;
    @Autowired
    private DataTableExt dataTable;

    @When("^I initiate a New Item addition with the following values:$")
    public void initiateItemAddition(DataTable table) throws Throwable {
        dataTable.setTable(table);
        homePage.getNavigation().openHomePage();
        homePage.getNavigation().clickMenuItem("New Item");
        String itemName = dataTable.getValue("Name");
        newItemPage.getItemNameTextField().enterText(itemName);
        dataStore.put("itemName", itemName);
        String itemType = dataTable.getValue("Type");
        newItemPage.getItemTypeRadioButton().setValue(itemType);
        dataStore.put("itemType", itemType);
        newItemPage.getNavigation().clickOkButton();
    }

    @When("^I specify new \"([^\"]*)\" details with the following values:$")
    public void SpecifyItemDetails(String type, DataTable table) {
        switch (type) {
            case "External Job":
                fillExternalJobDetails(table);
                break;
            case "Freestyle project":
                fillFreestyleProjectDetails(table);
                break;
            case "Maven project":
                fillMavenProjectDetails(table);
                break;
            case "Multi-configuration project":
                fillMultiConfigurationProjectDetails(table);
                break;
            default:
                throw new IllegalArgumentException("Type " + type + " is not supported");
        }
    }

    @When("^I save job details$")
    public void saveJobDetails() throws Throwable {
        configurationPage.getNavigation().clickSaveButton();
    }

    @Then("^I should see the following created New Item:$")
    public void verifyCreatedItem(DataTable table) throws Throwable {
        dataTable.setTable(table);
        String expectedType = dataTable.getValue("Type");
        Assert.assertTrue("Job type: expected to start with:" + expectedType + ", actual: " +
                jobDetailsPage.getJobNamePageElement().getText(), jobDetailsPage.getJobNamePageElement().getText().
                startsWith(expectedType));
        String expectedName = dataTable.getValue("Name");
        Assert.assertTrue("Job name: expected to end with:" + expectedName + ", actual: " +
                jobDetailsPage.getJobNamePageElement().getText(), jobDetailsPage.getJobNamePageElement().
                getText().endsWith(expectedName));
        String expectedDescription = dataTable.getValue("Description");
        Assert.assertEquals("Job description expected: " + expectedDescription + ", actual: "
                + jobDetailsPage.getJobDescriptionPageElement().getText(), jobDetailsPage.getJobDescriptionPageElement().
                getText(), expectedDescription);
    }

    private void fillExternalJobDetails(DataTable table) {
        dataTable.setTable(table);
        configurationPage.getNameTextField().enterText(dataTable.getValue("Name"));
        String itemDescription = dataTable.getValue("Description");
        configurationPage.getDescriptionTextArea().enterText(itemDescription);
        dataStore.put("itemDescription", itemDescription);
        if (StringUtils.equals(dataTable.getValue("Discard Old Builds"), "true")) {
            configurationPage.getDiscardOldBuildsCheckBoxElement().check();

            // TODO: set other parameters
        }
    }

    private void fillFreestyleProjectDetails(DataTable table) {
        // TODO
    }

    private void fillMavenProjectDetails(DataTable table) {
        // TODO
    }

    private void fillMultiConfigurationProjectDetails(DataTable table) {
        // TODO
    }

}
