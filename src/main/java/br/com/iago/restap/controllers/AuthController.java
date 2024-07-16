package br.com.iago.restap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.restap.dataVo.AcconutCredencialVO;
import br.com.iago.restap.servises.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentication Endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthService authService;
	
	
	@Operation(summary = "Authentcates a user and returns a token")
	@PostMapping(value = "/signin")
	public ResponseEntity singnin(@RequestBody AcconutCredencialVO data) {
		if (CheckIfParansIsNotNull(data)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid user");
		var token = authService.signin(data);
		if (token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid user");
		return token;

	}

	private boolean CheckIfParansIsNotNull(AcconutCredencialVO data) {
		return data == null 
				|| data.getUsername() == null 
				|| data.getUsername().isBlank() 
				|| data.getPassword() == null
				|| data.getPassword().isBlank();
	}

}
