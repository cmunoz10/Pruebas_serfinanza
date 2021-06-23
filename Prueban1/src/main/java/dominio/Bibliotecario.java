package dominio;

import dominio.excepcion.LibroNoEncontradoException;
import dominio.excepcion.PrestamoException;
import dominio.excepcion.ReglaPrestamoException;
import dominio.regla.ReglamentoPrestamo;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;

public class Bibliotecario {

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
	public static final String EL_LIBRO_SOLO_SE_PUEDE_USAR_EN_LA_BIBLIOTECA = "los libros palíndromos solo se pueden utilizar en la biblioteca";
	public static final String EL_LIBRO_NO_EXISTE_EN_LA_BIBLIOTECA = "El libro no existe en la biblioteca";
	
	private RepositorioLibro repositorioLibro;
	private RepositorioPrestamo repositorioPrestamo;
	private ReglamentoPrestamo reglamentoPrestamo;

	public Bibliotecario(RepositorioLibro repositorioLibro, 
			RepositorioPrestamo repositorioPrestamo, 
			ReglamentoPrestamo reglamentoPrestamo) {
		
		this.repositorioLibro = repositorioLibro;
		this.repositorioPrestamo = repositorioPrestamo;
		this.reglamentoPrestamo = reglamentoPrestamo;
	}

	public void prestar(String idlib, String nombreUsuario) {

		Libro libroParaPrestar = verificarLibro(idlib);
		this.repositorioPrestamo.agregar(reglamentoPrestamo.reglaDePrestamo(libroParaPrestar, nombreUsuario));
	}

	public boolean esPrestado(String idlib) {
		if (repositorioPrestamo.obtenerLibroPrestadoPorIsbn(idlib) != null) {
			return true;
		}
		return false;
	}
	
	private Libro obtenerLibro(String idlib) {
		Libro libroParaPrestar = repositorioLibro.obtenerPorIsbn(idlib);
		
		if (libroParaPrestar == null) {
			throw new LibroNoEncontradoException(EL_LIBRO_NO_EXISTE_EN_LA_BIBLIOTECA);
		}
		if (libroParaPrestar.esPalindromo()) {
			throw new ReglaPrestamoException(EL_LIBRO_SOLO_SE_PUEDE_USAR_EN_LA_BIBLIOTECA);
		}
		return libroParaPrestar;
	}

	public Libro verificarLibro(String idlib) {
		
		if (esPrestado(idlib)) {
			throw new PrestamoException(EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE);
		}	
		
		return obtenerLibro(idlib);
	}

}
