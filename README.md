# RATS-Gradle
Rest Automation Testing Suit. Gradle version.

v.1.1.0

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

## Usage
For low-level tests you may use simple requests provided by rest-assured.io library.
For high-level tests you need to create a special structure for your tests.

All Dummy tests are performed using https://reqres.in/

First of all, you will need to create a **pojo** (plain old java object) with properties and methods to manipulate responses. Use server response or JSON schema. Use http://jsonschema2pojo.org with settings for generating this object for Gson library. Do not forget to include equals() and hashCode() methods. Put created pojo into models folder.

Next Step is to create a new test in tests folder. This test must extend TestBase class for using HTTP Requests library and Logger.

Creating test consists of several steps

 1. Creating a new object and adding parameters that we will need to send to server via request.

	``DummyPostCreate requestData = new DummyPostCreate(); ``

	``requestData.setName(fullName());``

	``requestData.setJob(occupation()); ``

	This step is optional and used if you need to validate response data.

2. Create a JSON for request body.
For this purpose we may use fake data objects.
Here is example of creating a request body:

	``JsonObject body = new JsonObject();``

	``params.addProperty("name", requestData.getName());``

	``params.addProperty("job", requestData.getJob()); ``

	This step is optional and used if you need to form request body. Also, you may add body parameters one by one during creating a request.

 3. Create a request.
 Create new RestRequest object and parse an endpoint as a parameter. All additional data (like headers, content-type, cookies, query parameters and body are optional. Also you may add parameters to body right here. All options can be repeated.

	``RestRequest request = new RestRequest("/api/users")
	.withContent().withHeader().withCookie().withQuery().withParam().withBody``

	List of options:

 - withContent() - set Content-Type. Use String as data type.
 - withHeader() - set Header of request. You may use either specialized Header data type from RestAssured library or  two Strings as key and value.
 - withQuery() - set query parameter that is sent in URI. Use String data type for both key and value
 - withBody() - set JSON object as body
 - withParam() - add data to body of request. Use String data type for both parameter name and value. It will be translated into JSON.
 - withCookie() - add a Cookie. You may use Cookie data type from RestAssured library or build one, using String data type for key and value.

 4. Send a request and receive response.
 Request will be automatically converted into response object

	 ``RestResponse response = app.post(request);``

	 Response is split into statusCode, headers and body properties. They can be parsed to different objects if necessary:

	``DummyPostCreate responseData = gson.fromJson(response.body(), DummyPostCreate.class);  ``

	Fail of test on this step means that response uses wrong JSON Schema and body cannot be parsed to our object.

 5. Perform Assertions.
 Assertions are performed using TestNG library.

	``assertEquals(response.statusCode(), 201);``

	``assertEquals(responseData.getName(), requestData.getName());``

	``assertEquals(responseData.getJob(), requestData.getJob());``


## Request methods
All requests can be performed both with any type and number of parameters (e.g. headers, content-type, cookies, query parameters and body) .

``app.%methodName%(request)``

Currently RATS supports next HTTP Methods:

 - GET
 - POST
 - PUT
 - PATCH
 - DELETE

## Fake data
You can use fake data for generation of data for objects and requests. Fake data methods are **static** so you can create this data without creating an instance of JavaFaker object.

Currently supported methods:

 - firstName()
 - lastName()
 - fullName()
 - age() - from 1 to 100
 - email()
 - url()
 - password() from 6 to 8 symbols
 - country()
 - counrtyCode() - 3 symbols
 - city()
 - street()
 - house()
 - occupation()
 - date()
 - company()
 - randomNumber() - from 0 to 2147483647
 - negativeRandomNumber() - from -2147483647 to -1
 - naughtyString() - list of strings that may cause problems
 - naughtyString64() - list of strings that may cause problems in 64 bit format

## Log files and reports
For logging RATS uses Logback. All logs are put into log directory in the root of RATS project folder. Logging levels for terminal and log file is [INFO]. Log levels and additional settings can be changed in src/test/recourses/logback.xml file

For reporting tool RATS uses Allure2. To run allure server type
*allure serve ./build/allure-results/*
See Allure2 documentation for more options and information

## Version info
14.02.2019 - 1.0.0 - Initial commit.

15.03.2019 - 1.1.0 - Reworked creation of request and usage of http methods
