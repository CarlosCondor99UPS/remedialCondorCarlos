package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Libro;

@Stateless
public class LibroDao {
	
	

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Libro libro) {
		em.persist(libro);
	}
	
	public void update(Libro libro) {
		em.merge(libro);
	}
	
	public Libro read(int id) {
		Libro libro=em.find(Libro.class, id);
		return libro;
	}
	
	public void delete(int id) {
		Libro libro=em.find(Libro.class, id);
		em.remove(libro);
	}
	
//	public List<Libro> getList(){
//		String jpql="Select l From Libro l";
//		
//		Query q = em.createQuery(jpql, Libro.class);
//		return q.getResultList();
//	}
//	
	private long getCountID(){
		String jpql="Select Count(id) From Libro l ";
		
		
		long q = (long) em.createQuery(jpql).getSingleResult();
		System.out.println("asdasd  "+ q);
		
		return q;
	}
	
	public List<Libro> getListXCategoria(int id){
		
		String jpql="Select l From  Libro l Where categoria_id = ?1";
		
		Query q = em.createQuery(jpql, Libro.class)
				.setParameter(1, id);
		return q.getResultList();
		
	}
	
	
	
}
