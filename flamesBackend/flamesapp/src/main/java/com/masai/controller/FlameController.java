package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.FlameException;
import com.masai.model.Flame;
import com.masai.service.FlameService;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class FlameController {
	
	private FlameService fService;
	
	@Autowired
	public FlameController(FlameService fService) {
	this.fService = fService;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/flames/{boyName}/{girlName}")
	public ResponseEntity<Flame> saveFlameHandler(@PathVariable("boyName") String boyName,@PathVariable("girlName") String girlName)throws FlameException{
		
		return new ResponseEntity<Flame>(fService.saveFlame(boyName, girlName),HttpStatus.ACCEPTED);
	}
	
	
}
