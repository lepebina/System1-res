package com.ice.automation.drivers.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;
    private String server = "http://" + host + ":" + port;
    private RestTemplate rest;
    private HttpHeaders headers;


    public RestClient() {
        this.rest = new RestTemplate();
    }

    public HttpHeaders getHeaders() {
        if (this.headers == null) {
            this.headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "*/*");
        }
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public ResponseEntity<String> get(String uri) {
        //HttpEntity<String> requestEntity = new HttpEntity<String>("", this.getHeaders());
        System.out.println("URI: " + uri);
        System.out.println("");
        return new ResponseEntity<String>(HttpStatus.ACCEPTED); //rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
    }

    public ResponseEntity<String> post(String uri, String json) {
        //HttpEntity<String> requestEntity = new HttpEntity<String>(json, this.getHeaders());
        System.out.println(""); //"Body request: " + json);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED); //rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
    }

    public ResponseEntity<String> put(String uri, String json) {
        //HttpEntity<String> requestEntity = new HttpEntity<String>(json, this.getHeaders());
        System.out.println(""); //Body request: " + json);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED); //rest.exchange(uri, HttpMethod.PUT, requestEntity, String.class);
    }

    public ResponseEntity<String> delete(String uri) {
        //HttpEntity<String> requestEntity = new HttpEntity<String>("", this.getHeaders());
        return new ResponseEntity<String>(HttpStatus.ACCEPTED); //rest.exchange(uri, HttpMethod.DELETE, requestEntity, String.class);
    }

}