# Automated Test Framework of Teststore using Cucumber
This repository contains an automated test framework for Teststore (URL: http://teststore.automationtesting.co.uk/). The framework utilizes various libraries and tools such as Cucumber, Selenium, and Hamcrest to create and execute automated tests. The framework is built around the POM design pattern, which promotes code reusability and maintainability by encapsulating web page elements and their interactions into reusable page objects.

## Supported Browsers

The automated test framework supports the following browser versions:

- Chrome: Version 114.0.5735.110
- Edge: Version 114.0.1823.41
- Safari: Version 16.6 (18615.3.12.11.2)

## Dependencies
The following dependencies are required to use the automated test framework:

- Cucumber: A behavior-driven development (BDD) testing tool that allows you to write test scenarios in a natural language format.
```
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-java</artifactId>
      <version>7.14.0</version>
    </dependency>
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-junit</artifactId>
      <version>7.14.0</version>
    </dependency>    
```
- Selenium: A web testing framework that provides a set of tools and APIs to automate browser interactions.
```
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.12.0</version>
    </dependency>
```
- JUnit: A popular unit testing framework for Java that provides annotations and assertions for test development.
```
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.10.0</version>
    </dependency>
```
- Hamcrest: A library of matchers that can be used with JUnit to create expressive and readable test assertions.
```
    <dependency>
      <groupId>org.hamcrest</groupId>
      <artifactId>hamcrest</artifactId>
      <version>2.2</version>
    </dependency>
```
## Installation and Setup

To set up the automated test framework, follow these steps:

1. Clone the repository to your local machine:

```
git clone https://github.com/Ezzerof/cucumber-teststore-automated-test-framework.git
```
2. Run test folder

## Test Structure
The automated test framework follows a BDD approach using Cucumber. Test scenarios are written in a feature file using Gherkin syntax, which is a human-readable format for defining test cases. These feature files are located in the features directory.

The step definitions for the test scenarios are implemented in Java using Cucumber's step definition annotations. These step definition files can be found in the step_definitions directory.

Additional utility classes, test helpers, and configuration files are provided to support the test framework's functionality.
