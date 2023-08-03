package Ejercicio1pdf;

public class Libro {

	public static void main(String[] args) {
		/*Crear una clase Libro que contenga los siguientes atributos:
		 *  ISBN
		 *  Titulo
		 *  Autor
		 *  Número de páginas
		 * Crear sus respectivos métodos get y set correspondientes para cada
atributo. Crear el método toString() para mostrar la información relativa
al libro con el siguiente formato:
“El libro con ISBN creado por el autor tiene páginas”
En el fichero main, crear 2 objetos Libro (los valores que se quieran) y
mostrarlos por pantalla.
Por último, indicar cuál de los 2 tiene más páginas.
		 */
		
		LIbro1 libro1 = new LIbro1("978-84-939750-7-4","El corazón de la piedra","José María García López", 560);
// se puede hacer de las dos formas pero la de arriba es mas corta por tener mens lineas de codigo
		
	    LIbro1 libro2 = new LIbro1(null, null, null, 0);
	    libro2.setISBN("84 932914 8 X");
	    libro2.setTitulo("Salmos de vísperas");
	    libro2.setAutor("Esteban Hernández Castelló");
	    libro2.setNumPaginas(600);

		
	    System.out.println(libro1);
	    System.out.println(libro2);

	    if (libro1.getNumPaginas() > libro2.getNumPaginas()) {
	        System.out.println("El libro 1 tiene más páginas");
	    } else if (libro2.getNumPaginas() > libro1.getNumPaginas()) {
	        System.out.println("El libro 2 tiene más páginas");
	    } else {
	        System.out.println("Ambos libros tienen la misma cantidad de páginas");
	    }
	}
	    
	    

	}


