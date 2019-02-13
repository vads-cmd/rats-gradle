# RATS-Gradle
Rest Automation Testing Suit. Gradle version

## Introduction

REST Automation Testing Suit (RATS) is a set of tools for quick and easy start of REST API automation testing. It is also a boilerplate for your automation testing framework. You can perform low-level tests using only Rest-Assured library or create high-level tests by building models for your requests and responses. Also this suit contains tools for logging and data visualization of your tests' performance.

## Quick installation
You need to do easy 5 steps to start using RATS.

1.  Download and unpack RATS package from GitHub.
2.  Create a new project in your IDE and import RATS as a module.
3.  Change BaseURL setting in src/test/com.github.rats/workers/AppManager class to your REST node.
4.  Make a simple GET request according to your needs using simple request from rest-assured library.
5.  Launch test.

Minimum requirements are Java 1.8.0_181 and Gradle 5.1.1

Also RATS can be used as a boilerplate or base for your testing framework. It can become a part of existing framework.
In this case, you need to add dependencies from gradle.build file to your project and refactor RATS structure for your needs.
After performing dummy tests and checking structure of a boilerplate, you may delete all packages and classes marked "Dummy*".

## List of tools
Testing Framework - TestNG 6.14.3 - https://testng.org/

REST library - REST Assured 3.3.0 - http://rest-assured.io/

HTTP client - Apache HTTPComponents 4.5.7 - http://hc.apache.org/

JSON Instrument - GSON 2.8.5 - https://github.com/google/gson 

Fake Data Generator - Java Faker 0.17.2 - https://github.com/DiUS/java-faker

Logging tool - Logback 1.2.3 - https://logback.qos.ch/

Results visualization tool - Allure 2.7.0 - http://allure.qatools.ru/

List of naughty strings for data generation - https://github.com/minimaxir/big-list-of-naughty-strings

