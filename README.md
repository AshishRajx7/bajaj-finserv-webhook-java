# Bajaj Finserv Health Java Webhook Assignment

When the application starts, it sends a POST request to the generateWebhook API. The API returns a webhook URL and an access token. Based on my reg number, I had to solve Question 1 from the assignment and then send the final SQL query to the webhook URL using the token.

There are no controllers in this project. The flow is triggered using CommandLineRunner in the main class.

## Assigned SQL Question

My reg number is 22BLC1009. The last two digits are 09 which is odd, so I had to solve Question 1.

Final SQL query used:

SELECT e.emp_name FROM employee e JOIN department d ON e.dep_id = d.dep_id WHERE e.salary > 70000 AND d.dep_name = 'Finance';

## How to Run

### Run the jar file

java -jar demo-0.0.1-SNAPSHOT.jar

This will send the first API call, receive the webhook and token, and submit the SQL query automatically. The responses will be printed in the console.

### Run from IntelliJ

Open the project and run DemoApplication.java

## Project Structure

src/main/java/com/example/demo  
DemoApplication.java  
WebhookService.java  
AppConfig.java

## JAR Download Link

https://raw.githubusercontent.com/AshishRajx7/bajaj-finserv-webhook-java/main/demo-0.0.1-SNAPSHOT.jar

## GitHub Repository

https://github.com/AshishRajx7/bajaj-finserv-webhook-java

## Author
Ashsih Raj
