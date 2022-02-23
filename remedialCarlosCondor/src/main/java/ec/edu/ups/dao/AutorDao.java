package ec.edu.ups.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import ec.edu.ups.model.Autor;

@Stateless
public class AutorDao {

	
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Autor autor) {
		em.persist(autor);
	}
	
	public void update(Autor autor) {
		em.merge(autor);
	}
	
	public Autor read(int id) {
		Autor autor = em.find(Autor.class, id);
		return autor;
	}
	
	public void delete(int id) {
		Autor autor = em.find(Autor.class, id);
		em.remove(autor);
	}
	
}
