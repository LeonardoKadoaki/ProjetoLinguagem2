package com.projeto.linguagem.controllers;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projeto.linguagem.models.Banco;
import com.projeto.linguagem.models.Livro;

/**
 * Controller respons�vel pelas informa��es de cria��o de um novo livro no banco
 **/

@WebServlet("/livro/novo")
public class NovoLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/livro-novo.jsp");
		rd.forward(request, response);
	}

	/**
	 * Requisi��o POST
	 **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Par�metros de entrada
		 **/
		
		String id = request.getParameter("id");
		if (id.isEmpty())
			id = "0";
		String titulo =request.getParameter("titulo");
		String autor =request.getParameter("autor");
		String isbn =request.getParameter("isbn");
		String preco =request.getParameter("preco");
		
		List<String> mensagens = new ArrayList<String>();
		
		if (titulo.isEmpty()) {
			mensagens.add("Campo titulo � obrigat�rio");
		}
		
		if (autor == null || autor.isEmpty()) {
			mensagens.add("Campo autor � obrigat�rio");
		}
		
		if (isbn.isEmpty()) {
			mensagens.add("Campo descri��o � obrigat�rio");
		}
		
		if (preco.isEmpty()) {
			mensagens.add("Campo p�ginas � obrigat�rio");
		}
		
		if (mensagens.size() > 0) {
			request.setAttribute("mensagens", mensagens);
			request.setAttribute("id", id);
			request.setAttribute("titulo", titulo);
			request.setAttribute("autor", autor);
			request.setAttribute("isbn", isbn);
			request.setAttribute("preco", preco);
		} else {	
			
			Livro livro = new Livro();
			livro.setId(Integer.valueOf(id));
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setIsbn(isbn);
			livro.setPreco(Double.parseDouble(preco));
			
			Banco banco = new Banco();
			banco.salvaLivro(livro);
			
			
			System.out.println("Livro cadastrado com sucesso!");
			request.setAttribute("success", "Livro cadastrado com sucesso!");
		}
			
		doGet(request, response);
	}

}
