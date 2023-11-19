# Legacy Java 7, Struts 1, jQuery, Bootstrap 3... web project for evaluations

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

## Tasks

1. Fork this repository to make the changes in your own repository

1. Create a public and a private (must be logged in) static page displaying any information
    - Add them to the header menu and choose an existing page layout
    - Add some bootstrap components just show the usage of them

1. Create the logout functionality
    - Action, session clean and redirection to Login page
    - The logout link is already defined in the page header

1. Create 2 new attributes for the "People"
    - Birthdate (Required and should be a valid date)
    - Document (Only required if the person is 18 years old or older)
        - Type
        - Number (Doesn't need to be a valid document number)

1. Using the "People" area as example, create a new one to create "Companies" as follow
    - Features
        - Create
        - Edit
        - List
        - Delete (must be done from the listing page and in async way)
    - Data to collect (All required)
        - Name
        - Address
        - VAT Number (Doesn't need to be a valid VAT number)
        - Country (list from database)
        - City (list from database, filtered by the selected country)

1. Open a pull request (The pull request will not be accepted... it's just for the evaluation)

### Optional

1. Convert the project to a Maven/Gradle project

## Notes and tips

1. You can use the website https://www.lipsum.com/ to generate texts
1. The project java compile level is 1.7, but you can use a jdk 1.8 up to 1.8.265 (Can't use java 8 features)