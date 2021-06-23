package persistencia.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Libro;
import dominio.repositorio.RepositorioLibro;
import persistencia.builder.LibroBuilder;
import persistencia.entitad.LibroEntity;
import persistencia.repositorio.jpa.RepositorioLibroJPA;

public class RepositorioLibroPersistente implements RepositorioLibro, RepositorioLibroJPA {

	private static final String IDLIB = "idlib";
	private static final String LIBRO_FIND_BY_ISBN = "Libro.findByIsbn";
	
	private EntityManager entityManager;

	public RepositorioLibroPersistente(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}	

	@Override
	public Libro obtenerPorIsbn(String idlib) {
		
		LibroEntity libroEntity = obtenerLibroEntityPorIsbn(idlib);

		return LibroBuilder.convertirADominio(libroEntity);
	}

	@Override
	public void agregar(Libro libro) {
		
		entityManager.persist(LibroBuilder.convertirAEntity(libro));
	}

	@Override
	public LibroEntity obtenerLibroEntityPorIsbn(String idlib) {
		
		Query query = entityManager.createNamedQuery(LIBRO_FIND_BY_ISBN);
		query.setParameter(IDLIB, idlib);

		return (LibroEntity) query.getSingleResult();
	}

}
