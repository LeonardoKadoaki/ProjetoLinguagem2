package com.projeto.linguagem.controllers;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projeto.linguagem.models.Banco;
import com.projeto.linguagem.models.Livro;

/**
 * Controller responsável pela edição de informações de livros que estão no banco
 **/
@WebServlet("/livro/editar")
public class EditaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		Banco banco = new Banco();
		
		Livro livro = banco.getLivrobyId(Integer.valueOf(id));
		request.setAttribute("id", livro.getId());
		request.setAttribute("titulo", livro.getTitulo());
		request.setAttribute("autor", livro.getAutor());
		request.setAttribute("isbn", livro.getIsbn());
		request.setAttribute("preco", livro.getPreco());
		
		RequestDispatcher rd = request.getRequestDispatcher("/livro-novo.jsp");
		rd.forward(request, response);
	} 

}
