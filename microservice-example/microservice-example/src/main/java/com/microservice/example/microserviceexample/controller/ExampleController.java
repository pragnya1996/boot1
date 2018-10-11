package com.microservice.example.microserviceexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	@RequestMapping("/")
	String home(){
		 return "hello world";
	 }
}
