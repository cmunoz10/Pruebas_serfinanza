package dominio.repositorio;

import dominio.Libro;

public interface RepositorioLibro {

	/**
	 * Permite obtener un libro dado un idlib
	 * @param idlib
	 * @return
	 */
	Libro obtenerPorIsbn(String idlib);

	/**
	 * Permite agregar un libro al repositorio
	 * @param libro
	 */
	void agregar(Libro libro);

}