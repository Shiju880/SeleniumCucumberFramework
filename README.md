# Selenium Cucumber BDD Automation Framework

## Overview
This project is a Selenium WebDriver automation framework developed using Java, cucumber BDD, TestNG and Maven
The framework follows Page Object Model design patterns to improve code reusability and maintainability

## Technology Stack
- Java 
- Selenium
- Cucumber BDD
- TestNG
- Maven
- Extent Reports
- Git & GitHub

## Framework Structure
- hooks
    - Handles browser closing setup, Soft Assertion and Screenshot capture

- pageObjects
    - Contains page classes following POM design

- stepsDefinition
    - Contain Cucumber step implementation logic

- runner
    - Contain main runner and failed case re-runner
- utils
    - Contains reusable utilities and common methods 

## Key Features
- BDD framework implementation using Cucumber
- Page Object Model design pattern
- Maven based project structure
- TestNG execution support
- PicoContainer dependency injection for sharing TestContext between step definition classes 
- Reusable Selenium utility methods
- Explicit wait handling
- Screenshot capture for failed scenarios using Cucumber Hooks
- Extent Report integration
- Failed scenario rerun support
- Support jenkin CI execution through Maven build configuration

## Execution
- Clone the repository
  - git clone  < gitUrl >
- Run tests using maven
  - mvn clean
  - mvn test

## Reports
After execution, reports are generated locally with execution details and screenshots.

## SigningOff :)
Shiju



