package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.model.Autor;
import ec.edu.ups.on.GestionAutorOn;

@Named
@RequestScoped
public class AutorBean {

	@Inject
	private GestionAutorOn gestionAutorOn;
	
	private Autor autor;
	
	private List<Autor> autores;
	
	private String filtro;
	
	@PostConstruct
	public void init() {
		autor = new Autor();
		//autores=gestionAutorOn.getAutores();
	}

	public GestionAutorOn getGestionAutorOn() {
		return gestionAutorOn;
	}

	public void setGestionAutorOn(GestionAutorOn gestionAutorOn) {
		this.gestionAutorOn = gestionAutorOn;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	
	
}
