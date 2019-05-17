package Pages;

import framework.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    private static final String SEARCH_TEXT_FIELD_XPATH = "//input[@name='query']";
    private static final String SEARCH_BUTTON_XPATH = "//input[@name='commit']";
    private static final String ASK_SUPPORT_BUTTON_XPATH = "//a[@id='askSupport']";


    private WebElement topicLink(String topic) {
        return driver.findElement(By.xpath(getXPATHtopicTitle(topic)));
    }

    public TopicPage selectTopic(String topic) {
        topicLink(topic).click();
        return initPage(TopicPage.class);
    }

    @FindBy(xpath = SEARCH_TEXT_FIELD_XPATH)
    private WebElement searchTextField;

    @FindBy(xpath = SEARCH_BUTTON_XPATH)
    private WebElement searchButton;

    @FindBy(xpath = ASK_SUPPORT_BUTTON_XPATH)
    private WebElement askSupportButton;

    private String getXPATHtopicTitle(String title) {
        return "//ul[@class='main-menu hide-on-mobile']//a[contains(text(),'" + title + "')]";
    }

    public void enterKeyword(String text) {
        searchTextField.sendKeys(text);
    }

    public ResultsPage clickSearchButton() {
        searchButton.click();
        return initPage(ResultsPage.class);
    }

    public AskSupportFormPage clickAskSupportButton() {
        askSupportButton.click();
        return initPage(AskSupportFormPage.class);
    }


}

