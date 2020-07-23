package com.leandro.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.workshopmongo.domain.User;
import com.leandro.workshopmongo.dto.UserDTO;
import com.leandro.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService service;
	//Reponse Encapsula, Retorna http já com possiveis cabeçarios,erros etc.
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		//converte para o DTO
		List<UserDTO> 	listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		//no corpo da resposta vai ter o list	
		return ResponseEntity.ok().body(listDto);
	}
}
