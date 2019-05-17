package Pages;

import framework.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopicPage extends BasePage {


    private static final String CATEGORY_LIST_XPATH = "//ul[@class='category-list category-navigation hide-on-mobile']";
    private static final String ACTIVE_TITLE_XPATH = "//a[@class='active']";
    private static final String QUESTIONS_CONTAINER_XPATH = "//ul[@class='article-list']";
    private static final String QUESTIONS_LIST_XPATH = "//ul[@class='article-list']/li";

    @FindBy(xpath = ACTIVE_TITLE_XPATH)
    private WebElement activeTitle;

    @FindBy(xpath = CATEGORY_LIST_XPATH)
    private WebElement categoryList;

    @FindBy(xpath = QUESTIONS_CONTAINER_XPATH)
    private WebElement questionsContainer;

    @FindBy(xpath = QUESTIONS_LIST_XPATH)
    private List<WebElement> questionsList;

    public void assertActiveTopic(String topicName) {
        Assert.assertEquals("Wrong topic selected", activeTitle.getText(), topicName);
    }

    public void assertCategoryListIsDisplayed() {
        Assert.assertTrue(categoryList.isDisplayed());
    }

    public void assertQuestionsListIsDisplayed() {
        Assert.assertTrue(questionsContainer.isDisplayed());
    }

    private WebElement getQuestionWebElement(int num) {
        return questionsList.get(num);
    }

    public String getQuestionText(int number) {
        return getQuestionWebElement(number).getText();
    }

    public AnswerPage clickQuestionByNumber(int num) {
        getQuestionWebElement(num).click();
        return initPage(AnswerPage.class);
    }
}
