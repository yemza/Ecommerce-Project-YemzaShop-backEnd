package com.yemzashop.Controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yemzashop.Entities.BasketEntityDAO;
import com.yemzashop.Services.BasketService;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin("*")
@Api(value = "BasketController", tags = { "Basket Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Basket Controller", description = "Write description here") })
@RestController
public class BasketController {

	
	@Autowired
	BasketService basketService;
	
	
	@GetMapping("/getBasket")
	public List<BasketEntityDAO> getAllBasket() {
		//Call Product Service Interface
		return basketService.getAllClientBasket();
	}
	

	@PostMapping("/addBasket")
	public BasketEntityDAO addBasket(@RequestBody BasketEntityDAO myBasket) {
		return basketService.addBasket(myBasket);
	}
}
