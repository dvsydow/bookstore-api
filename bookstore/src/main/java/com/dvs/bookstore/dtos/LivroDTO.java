package com.dvs.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.dvs.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Campo título requerido!")
	@Length(min = 3, max = 50, message = "O campo título deve ter entre 3 e 50 caracteres")
	private String titulo;
	@NotEmpty(message = "Campo nome do autor requerido!")
	@Length(min = 3, max = 50, message = "O campo nome do autor deve ter entre 3 e 50 caracteres")
	private String nome_autor;
	@NotEmpty(message = "Campo texto requerido!")
	@Length(min = 10, max = 2000000, message = "O campo texto deve ter entre 3 e 2000000 caracteres")
	private String texto;

	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.nome_autor = obj.getNome_autor();
		this.texto = obj.getTexto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
