package com.dvs.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvs.bookstore.domain.Livro;
import com.dvs.bookstore.domain.Livro;
import com.dvs.bookstore.dtos.LivroDTO;
import com.dvs.bookstore.repositories.LivroRepository;
import com.dvs.bookstore.service.exceptions.DataIntegrityViolationException;
import com.dvs.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + " Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll(){
		return repository.findAll();
	}
	
	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Livro update(Integer id, LivroDTO objDto) {
		Livro obj = findById(id);
		
		obj.setTitulo(objDto.getTitulo());
		obj.setNome_autor(objDto.getNome_autor());
		obj.setTexto(objDto.getTexto());
		
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
