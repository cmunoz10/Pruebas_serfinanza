package persistencia.repositorio.jpa;

import persistencia.entitad.LibroEntity;

public interface RepositorioLibroJPA {

	/**
	 * Permite obtener un libro entity por un idlib
	 * @param idlib
	 * @return
	 */
	LibroEntity obtenerLibroEntityPorIsbn(String idlib);

}
