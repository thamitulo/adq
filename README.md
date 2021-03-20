# MAHA adq
MAHA ADQ Interview Project  

This project is built on Java SpringBoot framework using gradle.  

# Targetted Tech
Gradle Version : 6.5.1  
Java 8  
H2 In-Memory Database 
Junit for tests 
Swagger2 for Visualising API Documentation  
Lombok for reducing boilerplate code  

# Additional Documentation at runtime

http://localhost:8080/swagger-ui/index.html  
http://localhost:8080/v2/api-docs  
 
# Building the project
Executing `gradle build` builds the application

# Running the project
Executing `gradle bootRun` in the root of the project will spawn the application.

# What i could have done better

I could have used flyway or liquibase for database version control, 
it felt like a bit of over complication given the number of entities

I could have handled additional edge cases and therefore had a higher code coverage for my testing



