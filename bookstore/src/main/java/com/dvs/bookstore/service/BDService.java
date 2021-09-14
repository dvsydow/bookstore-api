package com.dvs.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvs.bookstore.domain.Categoria;
import com.dvs.bookstore.domain.Livro;
import com.dvs.bookstore.repositories.CategoriaRepository;
import com.dvs.bookstore.repositories.LivroRepository;

@Service
public class BDService {
	
	@Autowired(required = true)
	private CategoriaRepository categoriaRepository;
	@Autowired(required = true)
	private LivroRepository livroRepository;
	
	public void instanciaBaseDados() {
	/*	
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção", "Livros de Ficção");
		Categoria cat3 = new Categoria(null, "Terror", "Livros de Terror");

		Livro l1 = new Livro(null, "Livro 1", "Robert Martin1", "Loren Ipsum1", cat1);
		Livro l2 = new Livro(null, "Livro 2", "Robert Martin2", "Loren Ipsum2", cat1);
		Livro l3 = new Livro(null, "Livro 3", "Robert Martin3", "Loren Ipsum3", cat2);
		Livro l4 = new Livro(null, "Livro 4", "Robert Martin4", "Loren Ipsum4", cat2);
		Livro l5 = new Livro(null, "Livro 5", "Robert Martin5", "Loren Ipsum5", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		*/
	}

}
