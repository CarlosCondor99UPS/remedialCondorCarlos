package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Categoria;

@Stateless
public class CategoriaDao {

	
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Categoria categoria) {
		em.persist(categoria);
	}
	public void update(Categoria categoria) {
		em.merge(categoria);
	}
	public Categoria read(String nombre) {
		Categoria categoria = em.find(Categoria.class, nombre);
		return categoria;
	}
	
	public void delete(String nombre) {
		Categoria categoria = em.find(Categoria.class, nombre);
		em.remove(categoria);
	}
	
	public List<Categoria> getList(){
		String jpql="Select c From Categoria c";
		
		Query q = em.createQuery(jpql, Categoria.class);
		return q.getResultList();
	}
	
	
}
