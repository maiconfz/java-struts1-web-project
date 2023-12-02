# Java 7, Struts 1, jQuery, Bootstrap 3... web project for evaluations

[![en](https://img.shields.io/badge/lang-en-red.svg)](./README.md)
[![pt](https://img.shields.io/badge/lang-pt-green.svg)](./README-PT.md)

Project to evaluate the knowledge needed to work with legacy projects using the following technologies:

- Java 7
- JDBC connections
- Servlets
- Struts 1
- JSP/Scriptlets/JSTL
- Eclipse IDE project configuration
- Jquery
- Bootstrap 3.x

## Notes and tips

1. You can use the website <https://www.lipsum.com/> to generate texts
1. The project "java compile level" is 7, but you must use java 8u202 and can't use java 8 features. (You can download the jdk from <https://www.oracle.com/pt/java/technologies/javase/javase8-archive-downloads.html>)

## Tasks

1. Fork this repository to make the changes on your own repository

1. Configure the project to run on a Tomcat 7 server, with java 8u202

1. Create a public and a private (must be logged in) static page displaying any information
    - Add them to the header menu and choose an existing page layout
    - Add some bootstrap components just show the usage of them

1. Create the logout functionality
    - Action, session clean and redirection to Login page
    - The logout link is already defined in the page header

1. Create a new attribute for the "User"
    - email (Required and should be a valid email. Use regex or any lib to validate it)

1. Using the "User" area as the example, create "Companies" area with the following features:
    - Features
        - List
        - Create
        - Edit
        - Delete
    - Data to collect (All required)
        - Name
        - Address
        - VAT Number (Doesn't need to be a valid VAT number)
        - Country (list from database)
        - City (list from database, filtered by the selected country)

1. Open a pull request (The pull request will not be accepted... it's just for the evaluation)

### Optional

1. Convert the project to a Maven/Gradle project
