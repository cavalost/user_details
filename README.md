# User details API

## Description

The API can save, delete, update and display user details:

*  Full name
*  Email
*  Password
*  Phone number
*  Department
*  Job title

## Factsheet

| **Category**              | **Value**                                 |
| ------------------------- | ---------------------------------------- |
| **Contact**               | @cavalost 
| **Language / Framework**  | Java / Spring Boot / Maven
| **Deployment type**       | Heroku
| **Production URL**     | [https://users-details.herokuapp.com/](https://users-details.herokuapp.com/)|

## Configuration

Configuration is via the following environment variables:

| Env var      | Example      | Purpose                   |
| ------------ | ------------ | ------------------------- |
| `SPRING_DATA_MONGODB_URI` | `mongodb+srv://<username>:<password>@uri` | To insert, retrieve, update and delete data to the DB

## Requirements

* JDK (version 8 or above)
* Maven

## Running the application locally
```
mvn spring-boot:run
```

## Endpoints

* Add a User: /api/user/add

    * Body
        {            
            "fullName": "",
            "email": "",
            "password": "",
            "phoneNumber": "",
            "department": "",
            "jobTitle": ""
        }
        
* Display a User: /api/user/display/{id}

* Update a User: /api/user/update/{id}

* Delete a User: /api/user/delete/{id}

