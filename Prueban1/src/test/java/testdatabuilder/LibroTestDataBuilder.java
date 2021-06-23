package testdatabuilder;

import dominio.Libro;

public class LibroTestDataBuilder {

	private static final int ANIO = 2010;
	private static final String TITULO = "Cien años de soledad";
	private static final String IDLIB = "1234";
	
	private String idlib;
	private String titulo;
	private int anio;

	public LibroTestDataBuilder() {
		this.idlib = IDLIB;
		this.titulo = TITULO;
		this.anio = ANIO;
	}

	public LibroTestDataBuilder conTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public LibroTestDataBuilder conIsbn(String idlib) {
		this.idlib = idlib;
		return this;
	}

	public LibroTestDataBuilder conAnio(int anio) {
		this.anio = anio;
		return this;
	}

	public Libro build() {
		return new Libro(this.idlib, this.titulo, this.anio);
	}
}
