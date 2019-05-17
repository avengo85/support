package stepdefinitions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.BasePage;
import framework.Settings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class Hooks {
    public static Settings settings = new Settings();

    @Before
    public void beforeScenario(Scenario scenario) {
        BasePage.settings = settings;
        BasePage.driver = settings.getDriver();
        BasePage.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        BasePage.driver.manage().window().maximize();
    }


    @After(order = 0)
    public void afterScenario() {
        BasePage.driver.quit();
    }


    @After(order = 1)
    public void onTestFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenShotPath = "./test-output/HtmlReport/" + scenario.getName() + ".png";
            File screenshot1 = new File(screenShotPath);
            File screenshotTempFile = ((TakesScreenshot) BasePage.driver)
                    .getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenshotTempFile, screenshot1);
                MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build();
            } catch (IOException e) {

            }

        }
    }
}

