package com.leandro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.workshopmongo.domain.Post;
import com.leandro.workshopmongo.repository.PostRepository;
import com.leandro.workshopmongo.services.exception.ObjectNotFoundException;
@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post FindById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
