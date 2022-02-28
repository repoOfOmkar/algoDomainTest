# Algo Domain Test Microservice

This repository contains source code for algo-domain interview test for customer, seller and admin product microservice.

### Packages used
* spring-boot-starter-web
* spring-boot-starter-data-jpa
* spring-boot-starter-validation
* org.projectlombok
* com.h2database
* org.junit.jupiter

### Port mappings
* default-server-port: 8080
* database-name: testdb
* h2-console: enabled

### Other information
* Tables are created during initialization of project using "schema.sql" present in src/main/resources folder.
* Users, categories and product-type information is saved in the database during initialization of project using "data.sql" present in src/main/resources folder.
* Have added JUnit test cases

## How this project can be improved further?
* Using eh-cache for caching the data for faster reads
* Using redis cache for caching categories and product types
* Using no-sql database like mongoDb or cassandra as data fields are changing for every product type
* Using search engine like elastic-search for searching/listing products, categories
* Implementing Spring-data security and using logging service using log4j and datadog