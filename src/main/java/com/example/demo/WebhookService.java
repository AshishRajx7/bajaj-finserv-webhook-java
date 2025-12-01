package com.example.demo;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WebhookService {

    private final RestTemplate restTemplate;


    public WebhookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void start() {
        generateWebhook();
    }

    private void generateWebhook() {
        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        Map<String, String> body = Map.of(
                "name", "Ashish Raj",
                "regNo", "22BLC1009",
                "email", "ashish.raj2022a@vitstudent.ac.in"
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        System.out.println("Webhook response: " + response.getBody());

        String webhookUrl = (String) response.getBody().get("webhook");
        String accessToken = (String) response.getBody().get("accessToken");

        submitFinalQuery(webhookUrl, accessToken);
    }

    private void submitFinalQuery(String webhookUrl, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);

        Map<String, String> body = Map.of(
                "finalQuery", "SELECT e.emp_name FROM employee e JOIN department d ON e.dep_id = d.dep_id WHERE e.salary > 70000 AND d.dep_name = 'Finance';"
        );


        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(webhookUrl, entity, String.class);

        System.out.println("Submit response: " + response.getBody());
    }
}
