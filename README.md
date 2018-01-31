[![Build Status](https://travis-ci.org/pradeepk6/easyjet-web-test-automation-cucumber.svg?branch=master)](https://travis-ci.org/pradeepk6/easyjet-web-test-automation-cucumber)

##### About:
e2e test automation of website: 
http://easyjet.com

The project built with:
* Java 8
* Selenium WebDriver 3.8.1
* Cucumber 2.3.1
* Spring 5.0.2
* Maven 3.5


##### Highlights
* easyjet website does throw lot of challenges to automate
* full end to end and a long booking workflow implemented
* BDD with cucumber
* [Cucumber feature files](/src/test/resources/features)

##### how to run:
* need Java8 and maven to run.
* download a latest driver binary into project home dir. 
  firefox driver url: https://github.com/mozilla/geckodriver/releases
  Run mvn command : mvn verify 
* browser option,headless option(1 for true and 0 for false) and driver location can be changed in pom or via command-line
  for eg: mvn verify -Dwebdriver="firefox" -Dwebdriver.firefox.driver="location of ur driver" -Dwebdriver.headless="1"

##### tested on:
* os : windows 10
* Java8
* Firefox 58




  
  


