package com.leandro.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@RequestMapping(method = RequestMethod.GET)
	//Reponse Encapsula, Retorna http já com possiveis cabeçarios,erros etc.
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "maria brown", "maria@gmail.com");
		User Alex = new User("2", "Alex silva", "Alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, Alex));
		//no corpo da resposta vai ter o list	
		return ResponseEntity.ok().body(list);
	}
}
