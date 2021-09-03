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
		
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll(Integer id_cat){
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}
	
	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());		
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
