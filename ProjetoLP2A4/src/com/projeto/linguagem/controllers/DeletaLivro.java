package com.projeto.linguagem.controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projeto.linguagem.models.Banco;

/**
 * Controller respons�vel pela exclus�o de livros que est�o no banco
 **/
@WebServlet("/livro/deletar")
public class DeletaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Banco banco = new Banco();
		banco.deletaLivro(Integer.valueOf(id));
	}

}
