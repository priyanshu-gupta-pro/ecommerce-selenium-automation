# E-Commerce Selenium Automation Framework

A web automation testing framework developed using Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM).

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- ExtentReports

## Application Under Test

SauceDemo E-Commerce Application

## Automated Test Scenarios

The following scenarios are automated:

1. Valid Login
2. Invalid Login using TestNG DataProvider
3. Add Product to Cart
4. Logout
5. Complete Checkout

## Framework Features

- Page Object Model (POM)
- Reusable BaseTest class
- Configuration using properties file
- Explicit Wait
- TestNG DataProvider
- Screenshot capture on test failure
- ExtentReports HTML report
- TestNG XML test suite

## Project Structure

```text
src/test/java
├── base
│   └── BaseTest.java
├── listeners
│   └── TestListener.java
├── pages
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   ├── CartPage.java
│   ├── CheckoutPage.java
│   └── OrderConfirmationPage.java
├── tests
│   ├── LoginTest.java
│   ├── InvalidLoginTest.java
│   ├── AddToCartTest.java
│   ├── LogoutTest.java
│   └── CheckoutTest.java
└── utilities
    ├── ExtentReportManager.java
    └── WaitUtility.java
