# Todo REST service

This project was made using Spring Boot. We used H2 in memory database, 
as this project is used only to demonstrate de use of sonar cloud 

We have two endpoints here:

* POST `http://localhost:8080/todos`
    ```json
      {
        "text": "Todo text",
        "dueDate": "2023-07-28" // todo due date
      }
    ```
  
* GET `http://localhost:8080/todos?page=1&size=10`
    with page and size params

## Run this project

You`ll need JDK 11 and maven installed on your machine. Just run mvn clean install
and mvn:spring-boot run

## Authors

* @rennanprysthon
* @GabrielAlves0501