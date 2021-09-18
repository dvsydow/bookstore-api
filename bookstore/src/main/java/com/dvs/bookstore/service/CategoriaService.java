package com.dvs.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.dvs.bookstore.domain.Categoria;
import com.dvs.bookstore.dtos.CategoriaDTO;
import com.dvs.bookstore.repositories.CategoriaRepository;
import com.dvs.bookstore.service.exceptions.DataIntegrityViolationException;
import com.dvs.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não Encontrado! id: "+id+", Tipo: "+Categoria.class.getName()));
		
	}
	
	/*
	 * public List<Categoria> findAll(){ return repository.findAll(); }
	 */
	

	public Page<Categoria> findAll(Pageable pageable) {
	    return repository.findAll(pageable);
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados.");
		}
		
	}
}
