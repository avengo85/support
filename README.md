# Test automation for "Support & FAQ" webpage

This project includes tests for  [https://support.wire.com/hc/en-us](https://support.wire.com/hc/en-us) web page.

The technology stack that is used:
* Selenium Webdriver
 * JAVA
 * JUnit
 * Maven
 * Cucumber 
 * Extent Reports

### Prerequisites

In order to use these tests you need to install following software:


* [Maven](https://maven.apache.org/)
* [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (JDK)


### Installing

After cloning the project from Githab, you can either build it in your IDE (IntelliJ IDEA or Eclipse) or just go to the project folder and type in command line "mvn clean install".

## Parameters
At the catalogue **\src\test\resources** you can find **selenium.properties** file where you can specify base URL of the project and browser where the test is executed. 

## Running the tests

You can execute tests either in IDE or just go to the project folder and type in command line "mvn test"  


## Results and reports

You can find Cucumber json and HTML reports in **/target/** folder, and extent HTML reports, screenshots for fails, logs and some statistics in **/test-output/** folder.


## Tests


### Scenarios Descriptions

###### User clicks topic at the main Support page and navigates to the topic page

This test opens main Support page and clicks specified topic. 

Checkings:
* The list of answers is displayed.
* Navigation bar with all topics is displayed.
* The topic specified is marked as active.

One issue has been found: 
*When 'Pro' topic is selected for the first time, it is not marked as active.*

'Pro' and 'Basics' are selected for examples. All other topics can be added in the same way.



###### User can search with keyword

This test opens main Support page, types key word into the Search fileld and clicks Search button.

Checkings:
* The header of the Result block contains the key word.
* The header of the Result block contains the word 'result'.



###### User opens answer to the question from the list of topic 

This test opens main Support page, selects specified topic and clicks the first question in the list. 

Checkings:
* The article header contains the same question as the user clicks in the list of questions in the topic article. 


###### User fills all required fields of ASK SUPPORT form and clicks Submit button 

This test opens main Support page, clicks ASK SUPPORT button, selects all required dropdowns values, fills all required text boxes and clicks Submit button. 

* **ASK SUPPORT** form is tested till captcha appears. Only ability of user to fill the form and click Submit button is tested. 

## Author

 **Alexander Ognev** 

