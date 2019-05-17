package Pages;

import framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnswerPage extends BasePage {


    private static final String HEADER_XPATH = "//header[@class='article-header clearfix']/h1";


    @FindBy(xpath = HEADER_XPATH)
    private WebElement header;

    public String getHeaderText() {
        return header.getText();
    }


}