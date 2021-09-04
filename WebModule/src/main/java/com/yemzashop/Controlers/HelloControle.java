package com.yemzashop.Controlers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin("*")
@Api(value = "TestController", tags = { "Test Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Test Controller", description = "Write description here") })

@RestController
public class HelloControle {
	

    @GetMapping("/hello")
	public String sayHello() {
		return "Swagger Hello World";
	}

}
