package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * Interfaz que define operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para
 * manejar entidades y sus respectivos Data Transfer Objects (DTO).
 *
 * @param <D> El tipo del objeto DTO.
 * @param <E> El tipo de la entidad.
 * 
 * @author Mario
 * @version 1.0
 * @since 2024-09-24
 */
public interface CRUDOperation<D, E> {

	/**
	 * Muestra todos los elementos disponibles.
	 *
	 * @return Una cadena que representa todos los elementos.
	 */
	public String showAll();

	/**
	 * Obtiene una lista de todos los objetos DTO.
	 *
	 * @return Una lista de objetos DTO.
	 */
	public ArrayList<D> getAll();

	/**
	 * Agrega un nuevo objeto DTO.
	 *
	 * @param newData El nuevo objeto DTO que se desea agregar.
	 * @return true si se agregó exitosamente, false de lo contrario.
	 */
	public boolean add(D newData);

	/**
	 * Elimina un objeto DTO existente.
	 *
	 * @param toDelete El objeto DTO que se desea eliminar.
	 * @return true si se eliminó exitosamente, false de lo contrario.
	 */
	public boolean delete(D toDelete);

	/**
	 * Busca una entidad dada.
	 *
	 * @param toFind La entidad que se desea encontrar.
	 * @return La entidad encontrada, o null si no se encuentra.
	 */
	public E find(E toFind);

	/**
	 * Actualiza un objeto DTO existente.
	 *
	 * @param previous El objeto DTO existente que se desea actualizar.
	 * @param newData  El nuevo objeto DTO que se usará para la actualización.
	 * @return true si se actualizó exitosamente, false de lo contrario.
	 */
	public boolean update(D previous, D newData);

	/**
	 * Lee datos desde un archivo.
	 */
	public void readFile();

	/**
	 * Escribe datos a un archivo.
	 */
	public void writeFile();

	/**
	 * Lee datos desde un archivo serializado.
	 */
	public void readSerialized();

	/**
	 * Escribe datos a un archivo serializado.
	 */
	public void writeSerialized();
}
