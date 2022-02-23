package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.CategoriaDao;
import ec.edu.ups.model.Categoria;

@Stateless
public class GestionCategoriaOn {

	@Inject
	CategoriaDao categoriaDao;
	
	public void guardarProducto(Categoria categoria) {
		
		Categoria c = categoriaDao.read(categoria.getNombre());
		
		if(c==null)
			categoriaDao.insert(c);
		else
			categoriaDao.update(c);

	}
	
	public List<Categoria> getCategorias(){
		return categoriaDao.getList();
	}
	
	
	public Categoria getCategoria(String nombre) {
		Categoria categoria = categoriaDao.read(nombre);
		return categoria;
	}
	
	public void eliminar(String nombre) {
		categoriaDao.delete(nombre);;
	}
	
	public List<Categoria> getCategoriaTodo(){
			return categoriaDao.getList();
		}
}
