package Pages;


import framework.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AskSupportFormPage extends BasePage {


    private static final String SELECT_ISSUE_TYPE_ID = "request_issue_type_select";
    private static final String SELECT_PLATFORM_ID = "request_custom_fields_26008879";
    private static final String SELECT_BROWSER_ID = "request_custom_fields_26008969";
    private static final String SUBMIT_BUTTON_XPATH = "//form[@id='new_request']//input[@name='commit']";
    private static final String SELECT_ACCOUNT_TYPE_XPATH = "//label[contains(text(),'Account type')]/following::a[1]";

    private static final String EMAIL_BOX_XPATH = "//input[@id='request_anonymous_requester_email']";
    private static final String SUBJECT_BOX_XPATH = "//input[@id='request_subject']";
    private static final String DESCRIPTION_BOX_XPATH = "//textarea[@id='request_description']";

    private static final String VALIDATION_NOTIFICATIONS_XPATH = "//div[@class='notification notification-error notification-inline'][not(contains(@style,'display: none;'))]";
    public static final String QUESTION_TEXT = "I have a Question/Feedback";

    private JavascriptExecutor js = (JavascriptExecutor) driver;


    @FindBy(id = SELECT_ISSUE_TYPE_ID)
    private WebElement issueTypeSelectWebelement;

    @FindBy(xpath = SUBMIT_BUTTON_XPATH)
    private WebElement submitButton;

    @FindBy(xpath = EMAIL_BOX_XPATH)
    private WebElement emailTextBox;

    @FindBy(xpath = SUBJECT_BOX_XPATH)
    private WebElement subjectTextBox;

    @FindBy(xpath = DESCRIPTION_BOX_XPATH)
    private WebElement descriptionTextBox;

    @FindBy(xpath = SELECT_ACCOUNT_TYPE_XPATH)
    private WebElement accountType;

    @FindBy(xpath = VALIDATION_NOTIFICATIONS_XPATH)
    private List<WebElement> validationNotifications;

    public void selectIssueType(String text) {
        Select issueTypeSelect = new Select(issueTypeSelectWebelement);
        js.executeScript("document.getElementById('" + SELECT_ISSUE_TYPE_ID + "').style = 'display'");
        issueTypeSelect.selectByVisibleText(text);
    }

    public void fillEmail(String email) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
    }

    public void fillSubject(String subj) {
        subjectTextBox.clear();
        subjectTextBox.sendKeys(subj);
    }

    public void fillDescription(String desc) {
        descriptionTextBox.clear();
        descriptionTextBox.sendKeys(desc);
    }

    public void clickAccountTypeSelector() {
        accountType.click();
    }

    public void selectPlatform(String platform) {
        js.executeScript("document.getElementById('" + SELECT_PLATFORM_ID + "').value = '" + platform + "'");
    }

    public void selectBrowser(String browser) {
        js.executeScript("document.getElementById('" + SELECT_BROWSER_ID + "').value = '" + browser + "'");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public Integer getValidationNotificationsNumber() {
        Integer res = validationNotifications.size();
        return res;
    }

}
