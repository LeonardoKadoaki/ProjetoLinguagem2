package com.projeto.linguagem.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Banco {

	/**
	 * método que escreve as informações do livro no banco
	 **/
	public void salvaLivro(Livro livro) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			if (livro.getId() == 0) {
				em.persist(livro);
			} else {
				em.merge(livro);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

	/**
	 * método que retorna a lista de livros que estão no banco
	 **/
	public List<Livro> getListaLivro() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		EntityManager em = emf.createEntityManager();
		List<Livro> listaLivro = null;
		try {
			listaLivro = em.createQuery("from Livro l").getResultList();
			return listaLivro;
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
			emf.close();
		}
		return null;
	}

	/**
	 * método que retorna o livro que ID
	 **/
	public Livro getLivrobyId(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		EntityManager em = emf.createEntityManager();
		Livro localiza = null;
		try {
			localiza = em.find(Livro.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
			emf.close();
		}
		return localiza;
	}

	/**
	 * método que deleta o livro
	 **/
	public void deletaLivro(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		EntityManager em = emf.createEntityManager();
		Livro livro = null;

		try {
			livro = em.find(Livro.class, id);
			em.getTransaction().begin();
			em.remove(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}