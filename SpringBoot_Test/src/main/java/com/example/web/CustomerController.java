package com.example.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Customer;
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

    //ポイント1
    @GetMapping("create")
    String create(@ModelAttribute CustomerForm customerForm) {
        return "create";
    }

    //ポイント1
    @PostMapping("create")
    String regist(@ModelAttribute CustomerForm customerForm) {
        Customer customer = new Customer();
        //ポイント2
        BeanUtils.copyProperties(customerForm, customer);

        //ポイント3
        customerService.insert(customer);

        //ポイント4
        return "redirect:/";
    }
}