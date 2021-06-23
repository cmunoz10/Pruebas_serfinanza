package persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Libro;
import dominio.Prestamo;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;
import persistencia.builder.LibroBuilder;
import persistencia.entitad.LibroEntity;
import persistencia.entitad.PrestamoEntity;
import persistencia.repositorio.jpa.RepositorioLibroJPA;

public class RepositorioPrestamoPersistente implements RepositorioPrestamo {

	private static final String IDLIB = "idlib";
	private static final String PRESTAMO_FIND_BY_ISBN = "Prestamo.findByIsbn";

	private EntityManager entityManager;

	private RepositorioLibroJPA repositorioLibroJPA;

	public RepositorioPrestamoPersistente(EntityManager entityManager, RepositorioLibro repositorioLibro) {

		this.entityManager = entityManager;
		this.repositorioLibroJPA = (RepositorioLibroJPA) repositorioLibro;
	}

	@Override
	public void agregar(Prestamo prestamo) {

		PrestamoEntity prestamoEntity = buildPrestamoEntity(prestamo);

		entityManager.persist(prestamoEntity);
	}

	@Override
	public Libro obtenerLibroPrestadoPorIsbn(String idlib) {

		PrestamoEntity prestamoEntity = obtenerPrestamoEntityPorIsbn(idlib);

		return LibroBuilder.convertirADominio(prestamoEntity != null ? prestamoEntity.getLibro() : null);
	}

	@SuppressWarnings("rawtypes")
	private PrestamoEntity obtenerPrestamoEntityPorIsbn(String idlib) {

		Query query = entityManager.createNamedQuery(PRESTAMO_FIND_BY_ISBN);
		query.setParameter(IDLIB, idlib);

		List resultList = query.getResultList();

		return !resultList.isEmpty() ? (PrestamoEntity) resultList.get(0) : null;
	}

	private PrestamoEntity buildPrestamoEntity(Prestamo prestamo) {

		LibroEntity libroEntity = repositorioLibroJPA.obtenerLibroEntityPorIsbn(prestamo.getLibro().getIsbn());

		PrestamoEntity prestamoEntity = new PrestamoEntity();
		prestamoEntity.setLibro(libroEntity);
		prestamoEntity.setFechaSolicitud(prestamo.getFechaSolicitud());
		prestamoEntity.setFechaEntregaMaxima(prestamo.getFechaEntregaMaxima());
		prestamoEntity.setNombreUsuario(prestamo.getNombreUsuario());

		return prestamoEntity;
	}

	@Override
	public Prestamo obtener(String idlib) {

		PrestamoEntity prestamoEntity = obtenerPrestamoEntityPorIsbn(idlib);

		return new Prestamo(prestamoEntity.getFechaSolicitud(),
				LibroBuilder.convertirADominio(prestamoEntity.getLibro()), prestamoEntity.getFechaEntregaMaxima(),
				prestamoEntity.getNombreUsuario());
	}
}
