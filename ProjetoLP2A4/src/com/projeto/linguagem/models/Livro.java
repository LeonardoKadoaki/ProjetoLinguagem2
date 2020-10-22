package com.projeto.linguagem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//anota��o para mapear entidade
@Entity
//anota��o para indicar o nome da tabela que ser� criada
@Table(name = "livro")
public class Livro {
	
	//anota��o para indicar que esse dado � o ID 
	@Id
	//deixar o ID como auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//anota��o para indicar que � uma coluna na tabela
	@Column
	private String titulo;

	@Column
	private String autor;

	@Column
	private String isbn;

	@Column
	private Double preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}