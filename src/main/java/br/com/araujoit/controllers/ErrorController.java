package br.com.araujoit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {

	@GetMapping
	public String errorMessage() {
		return "Um erro foi encontrado";
	}
}
