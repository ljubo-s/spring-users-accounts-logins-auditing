#   Use JPA + Hibernate + Enverse + PostgreSQL + Spring Security in Spring Boot for 
# spring-users-accounts-logins-auditing

## Auditing
### Enverse
The Envers module aims to provide an easy auditing / versioning solution for entity classes.
https://hibernate.org/orm/envers/

## Spring Security
Basic implementation Spring Security for autentication.  

##  Usage
-	Run the application and go on http://localhost:8080/
-	Use the index page to choose: 
    -	HTML web forms  
        -   Users
        -   Roles
        -   Users & Roles
        -   Users Auditing
        -   Person
        -   Logins
    -	Bootstrap lists
        -   Users List
        -   Users & Roles List
        -   Person List
        -   Roles List

##  Build and run
### Configurations
Open the `application.properties` file and set your own configurations for the database connection and username/password for Spring Security
###    Create database
Open `db.sql file` and use code for creating database.
### Prerequisites
-	Java 
-	Gradle
-	PostgreSQL
###    From Eclipse (Spring Tool Suite)
Import as Existing Gradle Project and run it as Spring Boot App.
### Run 
Run as Spring Boot application or 
###    Web server
Export to war, deploy on Tomcat server
