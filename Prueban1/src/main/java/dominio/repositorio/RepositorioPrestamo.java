package dominio.repositorio;

import dominio.Libro;
import dominio.Prestamo;

public interface RepositorioPrestamo {

	/**
	 * Permite obtener un libro prestado dado un idlib
	 * @param idlib
	 * @return
	 */
	Libro obtenerLibroPrestadoPorIsbn(String idlib);
	
	/**
	 * Permite agregar un prestamo al repositorio de prestamos
	 * @param prestamo
	 */
	void agregar(Prestamo prestamo);
	
	/**
	 * Permite obtener un prestamo por el IDLIB del libro
	 * @param idlib
	 */
	Prestamo obtener(String idlib);

}
