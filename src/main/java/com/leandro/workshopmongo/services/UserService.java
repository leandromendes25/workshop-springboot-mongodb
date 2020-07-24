package com.leandro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.workshopmongo.domain.User;
import com.leandro.workshopmongo.dto.UserDTO;
import com.leandro.workshopmongo.repository.UserRepository;
import com.leandro.workshopmongo.services.exception.ObjectNotFoundException;
@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	public User FindById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public User insert(User obj) {
		return repo.insert(obj);	
	}
	//Em caso de instanciar o user, posso querer acesar o banco, e quem já tem dependencia é essa classe com o repo.
	//no lugar do user DTO. Retornando User from DTO
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
		
	}
	public void delete(String id) {
		FindById(id);
		repo.deleteById(id);
	}
	public User update(User obj) {
	User newObj = repo.findById(obj.getId()).get();
		updateData(newObj, obj);
		
		return repo.save(newObj);
	}
	//copia obj para new obj.
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
}
