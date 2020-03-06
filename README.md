# myRetail RESTful service
servicemyRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps.

The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 

Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention.

# Build an application that performs the following actions: 
- Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number.
- Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793)
- Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}
- Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail)
- Example: http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics
- Reads pricing information from a NoSQL data store and combinesit with the product id and name from the HTTP request into a single response
- BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store. 

# Technology Stack

  - Java (Coding Language)
  - Spring Boot (Framewark)
  - MongoDB (NoSQL-DB)
  - Redis (Caching)
  - JWT (Authentication Mechanism)
  - Swagger (API - Documentation)
  - Jaeger (Tracing/Logging)
  - Docker (deployment)

# Important Endpoints
  - Eclipse (IDE)
  - Postman (API Testing)
  
# Important Endpoints

  - http://localhost:8097/authenticate/ (POST)
  -     To generate jwt token
  ![myRetail-Api](https://github.com/atulmgupta/myRetail-Api/blob/master/snaphots/Generate-JwtToken.jpg)
  - http://localhost:8097/products/{id} (GET)
  -     To get product by id
  ![myRetail-Api](https://github.com/atulmgupta/myRetail-Api/blob/master/snaphots/product-found.jpg)
  ![myRetail-Api](https://github.com/atulmgupta/myRetail-Api/blob/master/snaphots/product-notfound.jpg)
  ![myRetail-Api](https://github.com/atulmgupta/myRetail-Api/blob/master/snaphots/product-apiDown.jpg)
  - http://localhost:8097/products/{id} (PUT)
  -     To update product details
  ![myRetail-Api](https://github.com/atulmgupta/myRetail-Api/blob/master/snaphots/put-price.jpg)
  - http://localhost:8097/actuator/heath (GET) 
  -     To monitor status of the rest api
  - http://localhost:8097/swagger-ui.html 
  -     Access Swagger UI for API documentation
  ![myRetail-Api](https://github.com/atulmgupta/myRetail-Api/blob/master/snaphots/Swagger_UI.jpg)
  - http://localhost:16686/search 
  -     Tracing Details
  ![myRetail-Api](https://github.com/atulmgupta/myRetail-Api/blob/master/snaphots/Jaeger.jpg)
  ![myRetail-Api](https://github.com/atulmgupta/myRetail-Api/blob/master/snaphots/Jaeger-error.jpg)
  - MongoDB (NoSQL-DB)
  - Redis (Caching)
  - JWT (Authentication Mechanism)
  - Docker (deployment)
  
### Deployment
download or clone repo https://github.com/atulmgupta/myRetail-Api.git

```sh
$ cd myRetail-Api/my-retail-api
$ mvn clean install
$ docker system prune -a
$ docker-compose down
$ docker-compose up -d
```

