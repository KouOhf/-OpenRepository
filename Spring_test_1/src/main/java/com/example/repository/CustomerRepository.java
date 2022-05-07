package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
   // @Query("SELECT * FROM customer ORDER BY id")
    //List<Customer> findAllOrderById();

}
