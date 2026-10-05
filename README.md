# SeleniumMavenProject

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.47.0-43B02A?logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-7.12.0-E76F00)
![Apache POI](https://img.shields.io/badge/Apache%20POI-5.5.1-C60C30)
![Maven](https://img.shields.io/badge/Maven-3.9-C71A36?logo=apachemaven&logoColor=white)
![Tests](https://img.shields.io/badge/tests-15%20passed-brightgreen)

UI test automation with **Java + Selenium 4 + TestNG + Maven**, including
**Excel-driven data** (Apache POI), TestNG groups, cross-browser parameters and
explicit waits — exercised against [SauceDemo](https://www.saucedemo.com),
[selenium.dev](https://www.selenium.dev/selenium/web/web-form.html) and Google.

## Table of contents
- [What it tests](#what-it-tests)
- [Tech stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Setup and run](#setup-and-run)
- [Running from Eclipse/IntelliJ](#running-from-eclipseintellij)
- [Project structure](#project-structure)

## What it tests

| Test class | What it covers |
|------------|----------------|
| `FirstSeleniumTest` | Intro/smoke test |
| `LoginTest` | SauceDemo login → asserts title `Swag Labs` + `inventory.html` URL |
| `AddToCartTest` | Adds Sauce Labs Backpack, opens the cart, asserts the item name |
| `CheckoutTest` | Full checkout flow with `ChromeOptions` (password prompts disabled) + explicit `WebDriverWait` |
| `SauceDemoExcelTest` | **Data-driven login** — positive & negative rows via Excel `@DataProvider`, explicit waits |
| `ParameterTest` | Cross-browser (`Chrome`/`Edge`/`Firefox` via `@Parameters`) form test on selenium.dev: type → submit → assert `Received!`, ordered with `priority` |
| `GoogleTest` | Cross-browser Google search smoke test |
| `GroupTest` | TestNG **groups** demo (`login`, `products`, `checkout`) |
| `ExcelDataProvider`, `Reader`, `ReadExcel`, `ReadSpecificvalue` | Apache POI helpers that read test data from Excel |
| `testngPractice.DataForTesting` | The `@DataProvider` consumed by `SauceDemoExcelTest` |

`mvn test` runs the whole suite: **15 tests**.

## Tech stack

| Tool          | Version | Purpose                        |
|---------------|---------|--------------------------------|
| Java          | 21      | Language                       |
| Selenium      | 4.47.0  | Browser automation (Selenium Manager auto-resolves ChromeDriver) |
| TestNG        | 7.12.0  | Test framework (groups, parameters, data providers) |
| Apache POI    | 5.5.1   | Excel test-data reading        |
| Maven         | 3.9+    | Build + Surefire runner        |

## Prerequisites

- **JDK 21** — `java -version`
- **Maven 3.9+** — `mvn -v`
- **Google Chrome** (the SauceDemo tests use `ChromeDriver`; Edge/Firefox optional)
- Internet access (tests hit live websites)

## Setup and run

```bash
git clone https://github.com/anithaswam95-beep/SeleniumMavenProject.git
cd SeleniumMavenProject

# Full suite
mvn clean test
```

Real output from the full suite:

```
[INFO] Building SeleniumMavenProject 0.0.1-SNAPSHOT
[INFO] Running TestSuite
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 71.38 s -- in TestSuite
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

Other useful commands:

```bash
mvn test -Dtest=LoginTest          # a single test class
mvn test -Dgroups=login            # run a TestNG group
```

No driver management needed — **Selenium Manager** (bundled with Selenium 4)
downloads the matching ChromeDriver automatically.

## Running from Eclipse/IntelliJ

1. Import the folder as an **Existing Maven Project**
2. Open [`testng.xml`](testng.xml) (or [`Group.xml`](Group.xml) for group runs)
3. **Run As → TestNG Suite** — this also lets you set the `browserName`
   parameter (`Chrome` by default) for the cross-browser tests
4. Reports are generated in `test-output/`

## Project structure

```
SeleniumMavenProject/
├── pom.xml                     # deps: Selenium, TestNG, Apache POI
├── testng.xml                  # TestNG suite (IDE runs)
├── Group.xml / google.xml      # group & browser-specific suites
├── src/test/java/
│   ├── tests/                  # all test classes (see table above)
│   └── testngPractice/         # DataForTesting (@DataProvider)
├── target/                     # build output + surefire reports
└── test-output/                # TestNG HTML reports
```
