#=========================================================================================#
#=========================================BIEFT SUMMARY===================================#
# Since I was told not to submit any form and I am not an authorized person 
# to work on this website, so I have limited scope to select test cases. 
# That’s why I have selected to automate some important negative test scenarios 
# and verify some important links.  While I was working with application, 
# I have noticed some issues. For example, sometime I have seen header menu 
# links were not interacted. It may have security issue or server was down. 
# Also, some input fields validation was missed. 
# In authentication page (https://auth.podium.com/), email or 
# mobile field accept a single number.
#--------------------------------------------------------------------------- 
# I worked with following test scenarios:

#1.	Verify all the important links are present in the home page.
#2.	Login function works as expected.
#3.	Create an account function works as expected 
#4.	Verify 'Watch Demo Video" plays as expected. 
#   Verify Create a free account function works as expected.
#5.	Verify Live Chat function works as expected. 
#6.	Verify Request a quote function works as expected. (https://www.podium.com/pricing/) 
#=========================================================================================#
#=========================================================================================#


--Environment Requirements:
	Selenium WebDriver (Supports all major browsers, we use Mozilla, Chrome, and IE)
	Intellij IDEA/Any IDE/Terminal (Java integrated development environment)
	Java (Programming Language)
	TestNG (Controls test cases)
	Maven (Manages project)
	Github(Control version)
	Git

--Following instruction to be followed in order to execute the test.

Modify the following paths:

--Location
Podium->Generic->src->main->java->commonapi->Base 
“testDataFilePath”
screenshotPath field.
chromeDriverPath

Be mindful with these parameters that I have written into testRunner.xml file.
The following  testrunner.xml file can have a control to test cases.  

--Location
Podium->SubModule->src->main->java->test->resources->TestRunner.xml
<parameter name="useSauceLab" value="false"/>
<parameter name="userName" value="israt"/>
<parameter name="key" value="662b4ed7-1a59-4ab2-ae8c-2dfe1e32f4aa"/>
<parameter name="appUrl" value="https://www.podium.com/"/>
<parameter name="os" value="windows"/>
<parameter name="browserName" value="chrome"/>
<parameter name="browserVersion" value="84.0.4147.135"/>

--Run on local
To run from local environment, first maven needs to installed in the system.
Then it can be run from terminal. 
terminal needs to be initiated from source project directory.
Then write  maven clean install command.

--Run in Docker Container
terminal needs to be initiated from source project directory.
docker build -t dockerImageName (e.g myDockerImage1) where docker file stored
  Following images needed
  selenium/standalone-chrome-debug
  
docker run -d --network="host" myDockerImage1 mvn - /home/SeleniumTestFramework/pom.xml clean test -Dbrowser="chrome"
To View test run install VNC viewer






