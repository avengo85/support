package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BasePage;


import Pages.*;
import framework.Settings;
import org.junit.Assert;


public class Steps {
    private MainPage mainPage;
    private TopicPage topicPage;
    private ResultsPage resultsPage;
    private AnswerPage answerPage;

    private AskSupportFormPage askSupportFormPage;
    private static Settings settings = Hooks.settings;
    private String questionText;

    @Given("user at the main Support page")
    public void user_at_the_main_Support_page() {
        BasePage.driver.get(settings.getBaseUrl());
        mainPage = BasePage.initPage(MainPage.class);
    }

    @When("user clicks topic \"([^\"]*)\"$")
    public void user_clicks_topic_Basics(String topicName) {
        topicPage = mainPage.selectTopic(topicName);
    }

    @Then("list of questions is displayed")
    public void list_of_questions_is_displayed() {
        topicPage.assertQuestionsListIsDisplayed();
    }

    @Then("heading with topics is displayed")
    public void heading_with_topics_is_displayed() {
        topicPage.assertCategoryListIsDisplayed();
    }

    @Then("^\"([^\"]*)\" is active")
    public void is_active(String topicName) {
        topicPage.assertActiveTopic(topicName);
    }

    @When("user enters keyword \"([^\"]*)\" to the Search field")
    public void user_enters_keyword_to_the_Search_field(String keyword) {
        mainPage.enterKeyword(keyword);
    }

    @When("user Clicks Search button")
    public void user_Clicks_Search_button() {
        resultsPage = mainPage.clickSearchButton();

    }

    @Then("user can see a list of answers relevant to keyword \"([^\"]*)\"$")
    public void user_can_see_a_list_of_answers_relevant_to_keyword(String keyword) {
        String headingText = resultsPage.getHeaderText();
        Assert.assertTrue("Header does not contain keyword" + keyword, headingText.contains(keyword));
        Assert.assertTrue("Header does not contain word 'result'", headingText.contains("result"));
    }

    @When("user clicks ASK SUPPORT button")
    public void user_clicks_ASK_SUPPORT_button() {
        askSupportFormPage = mainPage.clickAskSupportButton();
    }

    @When("user fills required fields")
    public void user_fills_required_fields() {
        askSupportFormPage.selectIssueType(askSupportFormPage.QUESTION_TEXT);
    }


    @When("user selects {string} as an issue type")
    public void user_selects_as_issue_type(String string) {
        askSupportFormPage.selectIssueType(string);
    }

    @When("user types {string} as an email address")
    public void user_types_as_an_email_address(String string) {
        askSupportFormPage.fillEmail(string);
    }

    @When("user fills Subject by {string}")
    public void user_fills_Subject_by(String string) {
        askSupportFormPage.fillSubject(string);
    }

    @When("user fills Descrition by {string}")
    public void user_fills_Descrition_by(String string) {
        askSupportFormPage.fillDescription(string);
    }

    @When("select {string} as a platform")
    public void select_as_a_platform(String string) {
        askSupportFormPage.selectPlatform(string);
    }

    @When("select {string} as a browser")
    public void select_as_a_browser(String string) {
        askSupportFormPage.selectBrowser(string);
    }

    @Then("user can click Submit button")
    public void click_Submit_button() {
        askSupportFormPage.clickSubmitButton();
    }

    @When("user clicks the question number {int} in the list")
    public void user_clicks_the_question_number_in_the_list(Integer int1) {
        questionText = topicPage.getQuestionText(int1);
        answerPage = topicPage.clickQuestionByNumber(int1);
    }

    @Then("user can see the answer to the question clicked")
    public void user_can_see_the_answer_to_the_question_clicked() {
        Assert.assertEquals("Answer is not to the question clicked", questionText,answerPage.getHeaderText());
    }


}
