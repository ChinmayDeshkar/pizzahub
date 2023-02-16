package com.pizza.home.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.home.model.Pizza;
import com.pizza.home.services.PizzaServices;

@RestController
@RequestMapping("/")
public class PizzaController {
	@Autowired
	private PizzaServices services;
	@GetMapping("pizza/all")
	ResponseEntity<List<Pizza>>getallPizza(){
		try {
			List<Pizza>pizzas=services.getAll();
			if(pizzas!=null) {
				return new ResponseEntity<List<Pizza>>(pizzas,HttpStatus.FOUND);
			}
			
		 }catch (Exception e) {
			e.printStackTrace();
		 }
		return new ResponseEntity<List<Pizza>>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("pizza/all/orderByPrice")
	ResponseEntity<List<Pizza>>getallPizzaOrderByPrice(){
		try {
			List<Pizza>pizzas=services.getAllSortedByPrice();
			if(pizzas!=null) {
				return new ResponseEntity<List<Pizza>>(pizzas,HttpStatus.FOUND);
			}
			
		 }catch (Exception e) {
			e.printStackTrace();
		 }
		return new ResponseEntity<List<Pizza>>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("pizza/all/orderByPopularity")
	ResponseEntity<List<Pizza>>getallPizzaOrderByPopularity(){
		try {
			List<Pizza>pizzas=services.getAllSortedByOrderCount();
			if(pizzas!=null) {
				return new ResponseEntity<List<Pizza>>(pizzas,HttpStatus.FOUND);
			}
			
		 }catch (Exception e) {
			e.printStackTrace();
		 }
		return new ResponseEntity<List<Pizza>>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("pizza/{name}")
	public ResponseEntity<Optional<Pizza>>getPizzaByName(@RequestParam String  name){
		try {
			Optional<Pizza>gotPizza=services.findByPizzaName(name);
			if (gotPizza.isPresent()) {
				return new ResponseEntity<>(gotPizza,HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Optional<Pizza>>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/pizza/{id}")
	public ResponseEntity<?>deletePizza(@RequestParam Integer id){
		try {
			services.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@PutMapping("/pizza/update")
	public ResponseEntity<Pizza>updatePizza(@RequestBody Pizza pizza){
		try {
			services.updatePizza(pizza);
			return new ResponseEntity<Pizza>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Pizza>(HttpStatus.BAD_REQUEST);
	}
   @PostMapping("pizza/add")
   public ResponseEntity<Pizza>addPizza(@RequestBody Pizza pizza){
	   try {
		if (pizza!=null) {
			services.createPizza(pizza);
			return new ResponseEntity<Pizza>(pizza,HttpStatus.CREATED);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return new ResponseEntity<Pizza>(HttpStatus.BAD_REQUEST); 
   }
}
