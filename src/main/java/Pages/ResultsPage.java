package Pages;

import framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends BasePage {

    private static final String HEADING_XPATH = " //h1[@class='search-results-heading']";

    @FindBy(xpath = HEADING_XPATH)
    private WebElement heading;

    public String getHeaderText() {
        return heading.getText();
    }

}
