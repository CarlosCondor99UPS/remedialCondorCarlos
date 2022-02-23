package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.model.Autor;
import ec.edu.ups.model.Libro;
import ec.edu.ups.on.GestionAutorOn;
import ec.edu.ups.on.GestionCategoriaOn;
import ec.edu.ups.on.GestionLibroOn;

@Named
@RequestScoped
public class LibroBean {

	@Inject
	private GestionLibroOn gestionLibroOn;
	@Inject
	private GestionAutorOn gestionAutorOn;
	@Inject
	private GestionCategoriaOn gestionCategoriaOn;
	
	private Libro libro;
	
	private List<Libro> libros;
	
	private String nombreCategoria;
	private int idAutor;
	
	public GestionAutorOn getGestionAutorOn() {
		return gestionAutorOn;
	}

	public void setGestionAutorOn(GestionAutorOn gestionAutorOn) {
		this.gestionAutorOn = gestionAutorOn;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public GestionCategoriaOn getGestionCategoriaOn() {
		return gestionCategoriaOn;
	}

	public void setGestionCategoriaOn(GestionCategoriaOn gestionCategoriaOn) {
		this.gestionCategoriaOn = gestionCategoriaOn;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	private int filtroCategoria;
	
	@PostConstruct
	public void init() {
		libro=new Libro();
//		libros=gestionLibroOn.getLibros();
	}

	public GestionLibroOn getGestionLibroOn() {
		return gestionLibroOn;
	}

	public void setGestionLibroOn(GestionLibroOn gestionLibroOn) {
		this.gestionLibroOn = gestionLibroOn;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public List<Libro> getLibrosxCategoria() {
		return gestionLibroOn.getLibroXCategoria(filtroCategoria);
	}
	
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public int getFiltroCategoria() {
		return filtroCategoria;
	}

	public void setFiltroCategoria(int filtro) {
		this.filtroCategoria = filtro;
	}
	
	
	public String saveLibro() {
		establecerCategoria(this.nombreCategoria);
		gestionLibroOn.guardarLibro(libro);
		this.init();
		return "ListProducto";
		
	}
	
	public void filtrarLibrosxCategoria() {
		this.libros=gestionLibroOn.getLibroXCategoria(filtroCategoria);
	}
	
	public void establecerCategoria(String nombre) {
		this.libro.setCategoria(gestionCategoriaOn.getCategoria(nombre));
	}
	
	public void addAutor() {
		
		Autor autor = new Autor() ;
		autor=gestionAutorOn.getAutor(this.idAutor);
		
		libro.addAutor(autor);

		//return null;
	}
	
}
