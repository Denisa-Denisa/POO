package Ejercicio1pdf;

public class LIbro1 {

	protected String ISBN;
	protected String titulo;
	protected String autor;
	protected int numPaginas;
	
	
	public LIbro1(String iSBN, String titulo, String autor, int numPaginas) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public int getNumPaginas() {
		return numPaginas;
	}


	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	} 
	
	public String toString() {
		 return "El libro con ISBN:  " + ISBN  + " creado por: " + autor + " tiene " + numPaginas + " páginas";
	}
	
}
