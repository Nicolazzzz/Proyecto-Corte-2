package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa un piloto. Implementa la interfaz {@link Serializable}
 * para permitir la serialización de los objetos de esta clase.
 * <p>
 * Un piloto tiene un nombre, que puede ser establecido y recuperado a través de
 * los métodos correspondientes.
 * </p>
 * 
 * @author Emmanuel
 * @version 1.0
 * @since 2024-09-24
 */
public class Piloto implements Serializable {

	private String name;

	/**
	 * Constructor por defecto para crear un objeto Piloto sin inicializar sus
	 * atributos.
	 */
	public Piloto() {
		// Constructor vacío generado automáticamente
	}

	/**
	 * Constructor que inicializa un objeto Piloto con el nombre especificado.
	 * 
	 * @param name El nombre del piloto.
	 */
	public Piloto(String name) {
		super();
		this.name = name;
	}

	/**
	 * Obtiene el nombre del piloto.
	 * 
	 * @return El nombre del piloto.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del piloto.
	 * 
	 * @param name El nombre a asignar al piloto.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve una representación en cadena del objeto Piloto, que en este caso es
	 * el nombre del piloto.
	 * 
	 * @return El nombre del piloto como una cadena de texto.
	 */
	@Override
	public String toString() {
		return name;
	}
}
