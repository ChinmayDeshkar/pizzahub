package com.pizza.home.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pizza.home.model.Pizza;
import com.pizza.home.repo.PizzaRepository;
@Service
public class PizzaServices {
	@Autowired
	private PizzaRepository pizzaRepository;
	
	public List<Pizza> getAll() {
	  return pizzaRepository.findAll();
	}
    public Optional<Pizza>findByPizzaName(String name){
    	return pizzaRepository.findByPizzaName(name);
    }
   public void deleteById(Integer id) {
	   pizzaRepository.deleteById(id);
   }
   public Pizza updatePizza(Pizza pizza) {
	   return pizzaRepository.save(pizza);
   }
   public Pizza createPizza(Pizza pizza) {
	 return   pizzaRepository.save(pizza);
   }
   public List<Pizza> getAllSortedByPrice() {
		  return pizzaRepository.findAll(Sort.by(Sort.Direction.ASC,"pizzaPrice"));
		}
   public List<Pizza> getAllSortedByOrderCount() {
		  return pizzaRepository.findAll(Sort.by(Sort.Direction.ASC,"pizzaCount"));
		}
   
}
