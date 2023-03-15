# Database setup on PostgreSQL
This project provides  implementation of file upload and download functionality using PostgreSQL and Spring Boot.

To get started with this project, follow the steps below.

## Prerequisites
To run this project, you will need:

+ PostgreSQL 
+ Java 11 or later
+ Maven
+ Setup
## Create a new PostgreSQL database for this project.

Set the database username and password in the application.properties file. You can find this file in the 
> src/main/resources folder.

Example:

``` spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.url=jdbc:postgresql://localhost:5432/<database-name>
spring.datasource.driver-class-name=org.postgresql.Driver  
```
Run the project using the following command:

```
mvn spring-boot:run
```
Once the application is up and running, you can use the following endpoints to upload and download files:

### To upload a file, use the following endpoint:

```
POST /api/verification/v1/files/451285412/upload
```
In your API client (e.g. Postman), select form-data as the body type, and files as the key. Then select the file you want to upload.

To download a file, use the following endpoint:

```
GET /api/verification/v1/files/451285412/download
```
### This endpoint will return a ZIP file containing the uploaded document.

__Note: Replace 451285412 with a unique identifier for your file.__

## Conclusion
That's it! You should now have a basic understanding of how to implement file upload and download functionality using PostgreSQL and Spring Boot. If you have any questions or feedback, feel free to reach out to us.