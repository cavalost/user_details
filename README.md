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

## Endpoints

Register a User:
    * https://users-details.herokuapp.com/api/user/add

    * Body
        {            
            "fullName": "",
            "email": "",
            "password": "",
            "phoneNumber": "",
            "department": "",
            "jobTitle": ""
        }
        
Display User details:        
* https://users-details.herokuapp.com/api/user/display/{id}

Update User details:        
* https://users-details.herokuapp.com/api/user/update/{id}

Delete User details:        
* https://users-details.herokuapp.com/api/user/delete/{id}

