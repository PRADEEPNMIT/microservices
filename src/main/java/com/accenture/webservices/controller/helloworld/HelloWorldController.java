package com.accenture.webservices.controller.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.webservices.controller.helloworld.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/helloWorld")
	public String returnString() {
		return "HelloWorld";
	}
	
	
	//return a bean
	@GetMapping(path="/helloWorldBean")
	public HelloWorldBean returnHelloWorldBean() {
		return new HelloWorldBean("HelloWorld");
	}
	
	@GetMapping(path="/helloWorldBean/{name}")
	public HelloWorldBean returnHelloWorldBeanWithPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello ,"+name);	
	}
	
	

}
