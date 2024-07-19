# Project Title:

Order Fulfilment System

## 1. Problem Statement ?

> "Implement a high-volume order fulfilment system that can handle more than 100,000 concurrent orders per second, and orders should be completed from multiple warehouses, beginning with the nearest warehouse. Implement real-time stock updates and guaranteed order delivery."

#### This is an Order Fulfilment RESTful API for Spring Boot, which performs CRUD operations on an in-memory database , utilizes asynchronous flow, messaging flow.

## 2. Tech Stack:

- Java 11
- Spring MVC
- Spring Boot
- Java JPA
- H2 Database.
- JSON

## 4. Details:

In this project I have added logic and details at a very broad level, focusing more on the approach rather the metric assumptions. 
I have assumed it to a microservice , which is to be functional with other different services aswell via direct sync call or mesaage queue protocol.

i. Open project in preferred IDE (I'm using SpringToolSuit4) 

ii. Selected SQL database as choice to utilize ACID properties for concurrent database operation. Implemented logic over H2 database for ease of representation, however in real world , databases like Postgres to be preffered since they are more performance oriented.nI have preferred JPA queries , however native queries are better in performance.


iii. Implemented caching logic for caching frequently accessed data.

iv. Implemented Asynchronus programming to perform concurrent operation for better performance.:
v. Added token based security for stateless authentication & authorization

v. Added scheduler annotation aswell, this can be used to scheduled tasks based on clon expression.

vii. In one of controller I have some commented piece of code, i.e. for reactive flow. Reactive code to be preffered since its a non-blocking model. Its a pub-sub model , which performs better as user base increases

viii. Please note that all the endpoints may not be functional end to end , they represent a blueprint for a task expected to be done.  

ix. For a service to cater large number of user, some techniches like load balancing, database indexing and normalisation,distributed caching vertical & horizontal scaling such practices to be performed for optimal utilization

## 3. Assumptions:

i. This is only a sample for backend flow.

ii. Driving layer to be present to utilize api endpoints.

iii. Added logic for authorization token generation in a very generic manner, assuming it to embedded at much higher level

iv. Other services also to be present for seamless interaction.


## 4. How To Use

i. Open project in preferred IDE (I'm using SpringToolSuit4) 

ii. Run as a Spring Boot App

iii. Test RESTful API end points using Postman for CRUD operations:
