package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerForm {
	private Integer id;
	@NotBlank
	@Size(max = 20)
	private String name;
	@Email
	@Size(max = 100)
	private String email;
}
