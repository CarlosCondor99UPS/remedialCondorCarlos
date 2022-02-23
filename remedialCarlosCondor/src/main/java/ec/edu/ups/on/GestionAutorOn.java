package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.AutorDao;
import ec.edu.ups.model.Autor;

@Stateless
public class GestionAutorOn {

	@Inject
	AutorDao autorDao;
	

	public void guardarProducto(Autor autor) {
		
		Autor a = autorDao.read(autor.getId());
		
		if(a==null)
			autorDao.insert(a);
		else
			autorDao.update(a);

	}
		
	public Autor getAutor(int id) {
		Autor autor = autorDao.read(id);
		return autor;
	}
	
	public void eliminar(int id) {
		autorDao.delete(id);
	}
	
}
