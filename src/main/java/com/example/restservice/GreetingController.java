package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!, you are awsome";
	private static final String TEMPLATE_POZDRAV = "Pozdrav %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
	}
	
	@GetMapping("/pozdrav")
	public Greeting pozdrav(@RequestParam(value = "name", defaultValue = "Rahane") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE_POZDRAV, name));
	}
}
