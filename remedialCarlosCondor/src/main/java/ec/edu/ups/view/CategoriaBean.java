package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.model.Categoria;
import ec.edu.ups.on.GestionCategoriaOn;

@Named
@RequestScoped
public class CategoriaBean {

	@Inject
	private GestionCategoriaOn gestionCategoriaOn;
	
	private Categoria categoria;
	
	private List<Categoria> categorias;
	
	private String filtro;
	
	@PostConstruct
	public void init() {
		categoria=new Categoria();
		categorias=gestionCategoriaOn.getCategorias();
	}

	public GestionCategoriaOn getGestionCategoriaOn() {
		return gestionCategoriaOn;
	}

	public void setGestionCategoriaOn(GestionCategoriaOn gestionCategoriaOn) {
		this.gestionCategoriaOn = gestionCategoriaOn;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	
	
}
