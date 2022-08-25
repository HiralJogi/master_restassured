This is a demo project for automating API testing functional flows.

Base Class :- APIConfig is the base class which can extended in the sub classes.
Utilities :- Common utilities for eg, data read/write from excel, listener classes etc can be written in this package.
Tests :- All the test cases will go in this package.
Resources :- 
1) TestData_JsonFile :- Body details for API / data to be added in this package.
2) Configuration.properties :- General information like base URL, Headers, wait time, DB credentials would be added in this file.
3) Endpoints.properties :- All the endpoints for all the API request types to be added in this file.

Reporting :- Please refer index.html for report validation.
Excution :- Right Click on testng.xml -> Run as -> TestNG Suite for executing tests.