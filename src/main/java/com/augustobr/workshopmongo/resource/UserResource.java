package com.augustobr.workshopmongo.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augustobr.workshopmongo.domain.User;
import com.augustobr.workshopmongo.dto.UserDTO;
import com.augustobr.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	
	}
	/*
	@GetMapping("{id}")
	public ResponseEntity<Optional<User>> findById(String id){
		Optional<User> user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	*/
}
