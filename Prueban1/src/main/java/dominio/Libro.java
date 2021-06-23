package dominio;

public class Libro {

	private String idlib;
	private String titulo;
	private int anio;

	public Libro(String idlib, String titulo, int anio) {

		this.idlib = idlib;
		this.titulo = titulo;
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAnio() {
		return anio;
	}

	public String getIsbn() {
		return idlib.toString();
	}
	
	public boolean esPalindromo() {
		
		return this.idlib.equals(new StringBuilder(this.idlib).reverse().toString());
	}
	
	public long obtenerSumaDigitosIsbn() {
		
		return this.idlib.toString().replaceAll("\\D+", "").chars().mapToLong(Character::getNumericValue).sum();
	}

}
