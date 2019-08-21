 Used Jenkins pipeline functionality to achieve entire build process
 
 Build -- Test --- Deploy -- Run (Pivotal)


Spring Boot Application

This is a application using Spring Boot, Angular JS and H2 database embedded in-memory running in Jetty.

For access web browser H2 embedded go to http://localhost:8082 and connect to the database "jdbc:h2:mem:testdb", username "sa", password empty.

- Application started in port 8080.

You can access application in Paas Heroku.

The basic autenthication is:

user: user

password: xpto123




JenkinsFile 
-----------
For windows : Need to use bat instead of sh and also need to keep " instead '

For Linux : Need to use sh instea of bat and also need to keep ' instead of "

Errors:
-----------
Cf login refused error -- Due to single quotes
