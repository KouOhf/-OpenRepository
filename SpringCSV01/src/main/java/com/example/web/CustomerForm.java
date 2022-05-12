package com.example.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerForm {
    private Integer id;
    @NotBlank
    @Size(min = 1,max = 20)
    private String name;
    @NotBlank
    @Size(min = 1,max = 100)
    @Email
    private String email;
    
    private String gender;
}
