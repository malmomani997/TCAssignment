# QA-Automation

## Project Information

This Project is a Automation Project Built on Selenium and Java to Test Websites Using Web Elements and Assert The Results in the WebPage

## Tools
 
1. Selenium
2. TestNG
3. Maven Build Tool
4. Git 
5. Tests Report

## Project Installation

1. Clone the Repository
2. Install Web Driver (Chrome, Firefox, Edge)
3. Install Java Version 11
4. Install Maven Version 13.3.1

## Project Run

This Project Built based on Profiles (Regression, Smoke) and you Need to Specifiy the Profile in the Command
to Run the Tests

#### Commands To Run


Smoke Test : mvn test -p Smoke
Regression Test : mvn test -p Regression


#### Additional Info

This Project Built and Tested on Mac OSX or Windows
To enable The project to run on Linux you need to remove the comment from (BaseTest) - setBinary Method

## Test Scenarios

1. Landing Screen
2. Place Order Screen
3. Sign Up Screen


## Test Scenarios Description

> Landing Screen

1. Verify Price of Plans
2. Verify Currency and Updates Locales
3. Verify Gift card Section is Only on SA

#### Description

1. Verify Price of Plans

checking for all plans prices (lite , classic , premium) Across all three locals (SA,KW,BH)‏


2. Verify Currency and Updates Locales

verify first that the page components Are being displayed then we are verifying the currency compared to the country then we are
Checking the updating the locals and doing the same check for each local‏


3. Verify Gift card Section is Only on SA

verify that the redeem gift card section is only displayed on the Saudi Arabia local and It's not displayed on Kuwait and Bahrain Locals‏


> Sign Up Screen

1. Sign Up with Non Existed User
2. Sign Up with Invalid User

#### Description

In the following two tests we are trying to validate not being able to login with a non existed user and
Also trying to log in with an email with a wrong format‏



> Place Order Screen

1. Place Order with Light Plan on SA Locale
2. Place Order with Classic Plan on Kwait Locale
3. Place Order with Premium Plan on Bahrain Locale

#### Description

In the following three scenarios I'm trying to place an order with different plan types on each local
Note that I cant place the order all the way to the end as Its on prod Env‏## Project Information

This Project is a Automation Project Built on Selenium and Java to Test Websites Using Web Elements and Assert The Results in the WebPage

## Tools
 
1. Selenium
2. TestNG
3. Maven Build Tool
4. Git 
5. Tests Report

## Project Installation

1. Clone the Repository
2. Install Web Driver (Chrome, Firefox, Edge)
3. Install Java Version 11
4. Install Maven Version 13.3.1

## Project Run

This Project Built based on Profiles (Regression, Smoke) and you Need to Specifiy the Profile in the Command
to Run the Tests

#### Commands To Run


Smoke Test : mvn test -p Smoke
Regression Test : mvn test -p Regression


#### Additional Info

This Project Built and Tested on Mac OSX or Windows
To enable The project to run on Linux you need to remove the comment from (BaseTest) - setBinary Method

## Test Scenarios

1. Landing Screen
2. Place Order Screen
3. Sign Up Screen


## Test Scenarios Description

> Landing Screen

1. Verify Price of Plans
2. Verify Currency and Updates Locales
3. Verify Gift card Section is Only on SA

#### Description

1. Verify Price of Plans

checking for all plans prices (lite , classic , premium) Across all three locals (SA,KW,BH)‏


2. Verify Currency and Updates Locales

verify first that the page components Are being displayed then we are verifying the currency compared to the country then we are
Checking the updating the locals and doing the same check for each local‏


3. Verify Gift card Section is Only on SA

verify that the redeem gift card section is only displayed on the Saudi Arabia local and It's not displayed on Kuwait and Bahrain Locals‏


> Sign Up Screen

1. Sign Up with Non Existed User
2. Sign Up with Invalid User

#### Description

In the following two tests we are trying to validate not being able to login with a non existed user and
Also trying to log in with an email with a wrong format‏



> Place Order Screen

1. Place Order with Light Plan on SA Locale
2. Place Order with Classic Plan on Kwait Locale
3. Place Order with Premium Plan on Bahrain Locale

#### Description

In the following three scenarios I'm trying to place an order with different plan types on each local
Note that I cant place the order all the way to the end as Its on prod Env‏
