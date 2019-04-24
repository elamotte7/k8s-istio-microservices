package com.sedona.test.microservicespring.a.rest;

import java.util.concurrent.atomic.AtomicLong;

import com.sedona.test.microservicespring.a.pojo.Greeting;
import com.sedona.test.microservicespring.a.rest.client.ServiceBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    private static final String template = "Hello, %s from Spring Service A v2!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ServiceBClient serviceBClient;

    @GetMapping("/json")
    public ResponseEntity<Greeting> greetingJson(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(new Greeting(counter.incrementAndGet(),
                        String.format(template, name)));
    }

    @GetMapping
    public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(String.format(template, name));
    }

    @GetMapping("/service-b")
    public ResponseEntity<String> serciceB() {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body("Service B respond : [" + serviceBClient.hello() + "]");
    }
}