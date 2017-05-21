# Synopsis
Library management system is a demonstration projectof for internship students of Mandalay region computer universities. The project structure is built by following multiple platform.
1. Microsfot SQL Server for Libaray database.
2. Java Spring Boot for backend RESTFul API.
3. Angular JS with [CoreUI](http://coreui.io/) framework for front end web app
## Library System Features
The system currently include the following features and will add new features by students or project maintainers.
1. Creating, Retrieving, Updating and Deleting books in library with (Author, Publisher, Language, Location)
2. Creating, Retrieving, Updating and Deleting library members
3. Borrowing books to members

# Motivation
This project is only for learning purpose and everyone can study all coding and project structure. Every students or begineers who wants to learn full stack development of web or mobile applications.

# Installation
To study and run all the things in this project, you will need the following tools and compilers.
1. Microsfot SQL Server 2008 or later
2. Java 1.8 and [STS Spring tool suite](https://spring.io/tools/sts/all)
3. [Maven build tool](https://maven.apache.org/download.cgi) *is optional*
4. Some text editor for front end web app *(Visual Code, Sublime Text, Atom)*

# Code Example
You may change the server configurations to run the project in you locl environment. First, create a database for library system and then change *application.properties* file in backend project and app.js in frontend project as following example.

## Change database connection in backend API

    spring.datasource.url=jdbc:sqlserver:[server];databaseName=[database]
    spring.datasource.username=[db username]
    spring.datasource.password=[db user password]
    spring.datasource.sql-script-encoding=utf-8
    spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
    spring.jpa.show-sql=true
    spring.jpa.database-platform = org.hibernate.dialect.SQLServer2012Dialect
## Change API url in frontend web app (app.js)
    .constant('urls', {
        BASE: 'http://localhost:8080',
        USER_SERVICE_API : 'http://localhost:8080/api/'
    })
# API Reference
Description|URL|Method
-----------|---|------
Get author list|http://localhost:8080/api/authors|GET
Save an author|http://localhost:8080/api/authors|POST
Update an author|http://localhost:8080/api/authors/{id}|PUT
Delete an author|http://localhost:8080/api/authors/{id}|DELETE
Get publisher list|http://localhost:8080/api/publishers|GET
Save a publisher|http://localhost:8080/api/publishers|POST
Update a publisher|http://localhost:8080/api/publishers/{id}|PUT
Delete publisher|http://localhost:8080/api/publisher/{id}|DELETE
Etc...|...|...

# Contribution
Any kind of contribution are welcome. If you are a student and not too familieer with coding, you can contribute by posting an issue or writing some documentation or discussing new featurs in the system. If you are an expert and love to share yours, please make some changes and create pull request. Any of your contributions will appreciate by others who are learning and maintaining our porject. 


