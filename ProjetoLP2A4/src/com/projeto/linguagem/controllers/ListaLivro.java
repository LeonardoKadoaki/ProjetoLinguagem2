package com.projeto.linguagem.controllers;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projeto.linguagem.models.Banco;
import com.projeto.linguagem.models.Livro;

/**
 * Controller responsável pela listagem de livros que estão no banco
 **/

@WebServlet("/livro/lista")
public class ListaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ListaLivro() {
        
    }

    /**
     * método GET que retorna a lista de livros
     **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Livro> lista = banco.getListaLivro();
		

		request.setAttribute("livros", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/livro-lista.jsp");
		rd.forward(request, response);
		
	}

}
