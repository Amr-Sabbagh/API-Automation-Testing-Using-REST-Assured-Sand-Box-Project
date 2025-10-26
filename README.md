# API-Automation-Testing-Using-REST-Assured-Sand-Box-Project

This repository is a sandbox project for API Automation Testing built with Java, REST Assured, and JUnit 5, designed to explore and apply modern automation design patterns and practices for creating scalable, maintainable, and reusable API testing frameworks.
It integrates Allure Reports for rich, interactive reporting and uses the Maven Surefire Plugin for test execution and lifecycle management.
The project targets the demo application [Restful Booker](https://restful-booker.herokuapp.com/apidoc/index.html#api-Auth) as its practice API.

## Project Structure
The project follows the Object Model Design Pattern, separating API interactions, data handling, and validations into independent, modular layers.
Each package represents a specific responsibility, ensuring clarity and ease of maintenance.
<pre>
  .
├── src
│   ├── main/java
│   │   ├── client               (Global setup for REST Assured request specifications and base configuration)
│   │   ├── services             (Service classes that utilize client setup and data objects to define API endpoints and methods)
│   │   ├── data                 (Data model and factory classes for constructing dynamic request payloads)
│   │   ├── utils                (Utility classes for logging, reporting integration with Allure, and helper methods)
│   │   └── resources            (Configuration files, schemas, and reusable JSON templates)
│   └── test/java
│       ├── apitests             (Test classes covering functional and end-to-end API scenarios)
│       ├── contracttests        (Tests focused on validating API response schemas and structure)
│       └── basetest             (Base test setup ensuring consistent initialization across test suites)
└── ...
</pre>

## Object Model Design Pattern
Implements a modular structure that separates:
* Client layer: Configures global request specifications, including headers, authentication, and base URIs (read from system properties or defaulted).
* Services layer: Defines reusable service methods for API endpoints, built on top of the client setup.
* Data layer: Centralizes request payload generation and test data management.
* Utils layer: Provides support for reporting, configuration handling, and helper utilities.

This design enhances reusability, readability, and maintainability across test suites.

## Allure Reporting Integration
Integrated with Allure to produce detailed and interactive HTML reports that include:
* Request and response logs.
* Test steps and execution timeline.
* Attachments for API request/response data.
* Summary of passed, failed, and skipped tests.

## Maven & Surefire Plugin
Maven handles dependency management and test build lifecycle.
The Surefire Plugin executes test classes and integrates directly with Allure for automated report generation.
Supports command-line parameterization for flexible test runs, such as:
<pre>
  mvn clean test -Dbase.url=(*targeturl*)
</pre>
or:
<pre>
  mvn clean test
</pre>
to run all test with default Base URL, or:
<pre>
  mvn clean verify
</pre>
to run all test and open the generated allure report automatically after test excition

## Contract & Functional Testing
* Contract Tests: Validate response structure and schemas to ensure contract compliance between client and server.
* API Tests: Validate response codes, payloads, and workflows through functional and end-to-end scenarios.

## Enhancements
### GitHub Actions CI:
Configure continuous integration to automatically run tests on each push or pull request, ensuring consistent build quality and fast feedback.
### Dependabot Integration:
Automate dependency updates to maintain security and stability by regularly checking for new versions of project libraries.
