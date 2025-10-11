# AutomationExcerciseProject
Description of Project Structure: 
1. Base package:  Contains BaseClass, where Test Data Management is implemented, and Multiple Browser is set up for cross-browsing support.
2. Utilities Package: Contains BugScreenshot Class to capture bugs to save in the given folder, ExtentReport, and Listeners Class to generate Test Report
3. allPages Package: Contains all necessary pages as a class name to maintain the WebElement locators for that page using PageFactory for Page Object Model
4. testCasesOfPages Package: Contains all necessary test cases in classes where the test script is written for the given test case scenario in the assessment
5. testng.xml for running the test case as a suite using TestNg
6. pom.xml contains all necessary dependencies
7. TestDataConfig and BaseInfoConfig file for test data management
8. test-output/ExtentReport/extentReport_v1.html contains the test report result
