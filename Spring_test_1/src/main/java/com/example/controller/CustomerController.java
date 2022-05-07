package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Customer;
import com.example.form.CustomerForm;
import com.example.service.CustomerService;


@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
 
    @GetMapping
    String list(Model model) {
      
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }
    
    @GetMapping("create")
    String create(@ModelAttribute CustomerForm customerForm) {
        return "create";
    }
    
    @PostMapping("create")
    String regist(@ModelAttribute @Validated CustomerForm customerForm, BindingResult result, Model model) {
        
    	if (result.hasErrors()) {
            return create(customerForm);
        }
    	
    	Customer customer = new Customer();
    	BeanUtils.copyProperties(customerForm, customer);
    	customerService.insert(customer);
    	return "redirect:/";
    }
    
    @PostMapping(path = "edit", params = "edit")
    String edit(@RequestParam Integer id, @ModelAttribute CustomerForm customerForm) {
    	Optional<Customer> customerOpt = customerService.selectById(id);
    	Customer customer = customerOpt.get();
    	BeanUtils.copyProperties(customer, customerForm);
    	return "edit";
    }
    
    @PostMapping(path = "edit", params = "regist")
    String regist(@RequestParam Integer id, @Validated @ModelAttribute CustomerForm customerForm, BindingResult result) {
    	
    	if(result.hasErrors()) {
    		return edit(id, customerForm);
    	}
    	Customer customer = new Customer();
    	BeanUtils.copyProperties(customerForm, customer);
    	customerService.update(customer);
    	return "redirect:/";
    }
}