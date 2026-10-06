# Selenium Maven Automation Project

A Java-based Selenium automation framework for browser testing with TestNG, Maven, and Excel-driven data. This project demonstrates end-to-end UI testing across real public websites and follows a structured test automation architecture suitable for real-world QA work.

## Why this project matters

This repository showcases a solid automation foundation in Java and Selenium:

- browser automation with Selenium WebDriver
- test execution with TestNG
- data-driven testing using Apache POI
- cross-browser execution patterns
- page-level test organization
- reusable setup and utility logic

## Tech stack

- Java 21
- Selenium 4.47.0
- TestNG 7.12.0
- Apache POI 5.5.1
- Maven 3.9+
- Chrome, Edge, Firefox support

## Architecture overview

This project follows a practical automation design that separates concerns between tests, page actions, and data providers.

```text
SeleniumMavenProject/
├── src/test/java/
│   ├── tests/
│   │   ├── FirstSeleniumTest.java
│   │   ├── LoginTest.java
│   │   ├── AddToCartTest.java
│   │   ├── CheckoutTest.java
│   │   ├── GoogleTest.java
│   │   ├── GroupTest.java
│   │   ├── ParameterTest.java
│   │   ├── SauceDemoExcelTest.java
│   │   ├── ExcelDataProvider.java
│   │   ├── ReadExcel.java
│   │   ├── ReadSpecificvalue.java
│   │   └── Reader.java
│   └── testngPractice/
│       └── DataForTesting.java
├── testng.xml
├── Group.xml
├── google.xml
├── pom.xml
├── README.md
├── test-output/
├── target/
└── resources / datasets
```

## What this project covers

| Test class | Scope |
|------------|-------|
| FirstSeleniumTest | basic smoke / intro test |
| LoginTest | SauceDemo login flow |
| AddToCartTest | product add-to-cart behavior |
| CheckoutTest | end-to-end checkout flow |
| SauceDemoExcelTest | Excel-driven login validation |
| ParameterTest | cross-browser execution checks |
| GoogleTest | search flow smoke test |
| GroupTest | TestNG groups demo |

## Key testing concepts demonstrated

### 1. Page-object style separation
Tests focus on behavior and validation instead of embedding every UI step in one large method.

### 2. TestNG features
This project uses:
- annotations
- groups
- parameterization
- data providers
- suite configuration

### 3. Data-driven testing
The project reads test input from Excel files and passes those values into test cases using Apache POI helpers.

### 4. Browser flexibility
The project includes browser parameterization and supports multiple browsers for targeted validation.

## Prerequisites

- JDK 21+
- Maven 3.9+
- Chrome installed
- Optional: Edge or Firefox for cross-browser scenarios

## How to run

```bash
git clone https://github.com/anithaswam95-beep/SeleniumMavenProject.git
cd SeleniumMavenProject
mvn clean test
```

### Run a single class

```bash
mvn test -Dtest=LoginTest
```

### Run a group

```bash
mvn test -Dgroups=login
```

## Example result

The project has been designed to execute a full suite of UI validations, with results generated in the `test-output/` directory and Surefire reports under `target/`.

## Why it is a strong portfolio project

This repository is one of the strongest examples of your QA automation skill set because it demonstrates:

- real browser automation
- reusable test structure
- cross-browser and parameterized testing
- data-driven design
- practical enterprise-style coverage

## Suggested next improvements

- add a page object model layer for more complex flows
- implement screenshot capture on failure
- add CI execution through GitHub Actions
- add a reporting dashboard summary
- expand scenarios for more real-world user journeys

## Summary

This project represents a practical Selenium automation foundation and is a strong portfolio project for demonstrating Java-based browser automation, TestNG usage, and test data management.

