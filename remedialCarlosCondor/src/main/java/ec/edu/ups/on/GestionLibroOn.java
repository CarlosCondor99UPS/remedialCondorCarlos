package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.LibroDao;
import ec.edu.ups.model.Libro;

@Stateless
public class GestionLibroOn {

	@Inject
	LibroDao libroDao;
	
public void guardarLibro(Libro libro) {
		
		Libro l = libroDao.read(libro.getId());
		
		if(l==null)
			libroDao.insert(l);
		else
			libroDao.update(l);
	}
	
//	public List<Libro> getLibros(){
//		return libroDao.getList();
//	}
//	
	
	public Libro getLibro(int id) {
		Libro l = libroDao.read(id);
		return l;
	}
	
	public void eliminar(int id) {
		libroDao.delete(id);
	}
	
	
	public List<Libro> getLibroXCategoria(int id){
		return libroDao.getListXCategoria(id);
	}

	
}
