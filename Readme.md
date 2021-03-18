**Description**
* This repository consists a maven project (version 3.6.3) using Java 11 (11.0.9)
* Selenide and Cucumber frameworks have been used for UI test automation
* Rest Assured framework has been used for API testing
* The development environment was as follows:
    - Operating System: Windows 10 
    - Browsers used for UI testing: 
        + Google Chrome Browser - Version 89.0.4389.82 (Official Build) (64-bit)
        + Mozilla Firefox - Version 86.0 (64-bit)
    - Development IDE: Intellij IDEA community edition

**How to run?**

Pre-requisites for a Windows 10 machine for the UI/browser tests:
1. Download Java JDK 11.0.9 and set JAVA_HOME system variable, for help please [refer](https://mkyong.com/java/how-to-set-java_home-on-windows-10/)
2. Download maven 3.6.3 and set MAVEN_HOME system variable, for help please [refer](https://mkyong.com/maven/how-to-install-maven-in-windows/)
3. Install Google Chrome Browser (Version 86.0.4240.198 (Official Build) (64-bit)) if not available

**To run browser tests:**
1. Clone the git repository and go to the root folder
2. Run "mvn test -Dtest=DemoAppTest" command from command line
4. The updated test report is available as "UiTestCucumberReport.html" under "reports" folder
5. The test can be run using IDEs like Intellij too, in that case please run "DemoApp.feature" or "DemoAppTest.java" file

**To run API tests:**
1. Clone the git repository and go to the root folder
2. Run "mvn test -Dtest=ApiTest" command from command line
4. The updated test report is available as "emailable-report.html" under "reports/surefire-reports" folder
5. The test can be run using IDEs like Intellij too, in that case please run "ApiTest.java" file

_**Note:**_

"mvn test" command will run both browser and api tests, resulting -
* "UiTestCucumberReport.html" with run results of only browser tests
* "emailable-report.html" with run results of both api and browser tests

**Load tests**
* Load test has been created using Jmeter.
* The load test plan, report, and related answers are available in "load-testing" folder
* The load test can be run using the following command
  
`jmeter -f -n -t <path to the .jmx file> -l report.csv -e -o <path to reports folder>`

**Bug report**
UI and API testing bugs are mentioned in "Bug_Report.txt" file
