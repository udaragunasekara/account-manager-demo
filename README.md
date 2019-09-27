# account-manager-demo
A project to demonstrate REST api implementation using spring-boot

Following design decisions are made in order to complete the highest priority features in the limited time.

Security
--------
This service is implemented as a stateless service with token based authentication.

1. JWT token based authentication using username / password to issue the token.
2. Authentication using LDAP if the organisation has internal LDAP
3. OAuth2 if the SSO capability needs to be provided. This could be using an existing authorization provider such as Goole, GitHub or a custom one such as Keycloak. We can also define our own authorization server using spring. If we need these apis to be exposed to 3rd parties we can implement JWT token based authentication using OAuth2.

Due to the time limitations for the project option 1 is implemented.

Persistence
---------

Persistence is done via Hibernate. We can have following options as the persistence store
1. An In memory database that doesn't need any external configuration.
2. MySql or Postgres as the database. This requires setting up a separate database server and configuring the application to
connect to the server.

Since spring jpa abstracts the implementation details, we can easily switch to a different db.

Due to the limited scope of the project option 1 is selected. Also auto schema generation is used to avoid the need to use a database schema migration utility such as liquibase or flyway. For production applications it is highly recommended.

API Documentation
-------------

To demonstrate the api documentation capability of Swagger, it is used in the project. Users can access the Swagger documentation by this url http:localhost:8000/swagger-ui

Schema Design
------------

Schema design is included in the design folder as a draw.io file that can be viewed online by visiting the draw.io website and opening the design file.

Other Considerations
-----------------------------

- It is highly recommended to use https over http for any web application. This can be achieved by putting a ssl terminating proxy such as nginx. Not done in the scope of this exercise.
- All passwords in the database will be encrypted.
- Logback is used as the loggin provider. See the logback.xml file for changing defaults.

Running the project
-------------------

- mvn spring-boot:run
- Default user is created when starting up with the user name 'admin' and password 'adminPassword0987!'
- To authenticate 


curl -i -X POST \
   -H "Content-Type:application/json" \
   -d \
'{
  "username": "admin",
  "password": "adminPassword0987!"
}' \
 'http://localhost:8000/api/auth/login'
 
 - To exercise an api with the token received in the login step do the following.
 
 curl -i -X POST \
   -H "Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU2OTU2Mjc3MCwiaWF0IjoxNTY5NTYyMTcwfQ.Ez9yF460yRguvRxbq5XacxZaOcaLQf21DqYcuIjBDYtzYiFAlbBG1eplQeYLSa_2bgWCKKvCQy2aThbUATxgUw" \
   -H "Content-Type:application/json" \
   -d \
'{
  "name" : "my account5",
  "description": "some desc"
}' \
 'http://localhost:8000/api/accounts'
 
 
 
 
