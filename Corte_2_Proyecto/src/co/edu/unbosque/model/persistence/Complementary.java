package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;

import co.edu.unbosque.model.Piloto;

/**
 * Clase que gestiona una lista de pilotos, permitiendo realizar operaciones de
 * adición, eliminación, búsqueda, lectura y escritura de datos en archivos y
 * almacenamiento serializado.
 * 
 * @author Mario
 * @version 1.0
 * @since 2024-09-24
 */
public class Complementary {

	private ArrayList<Piloto> listaPilotos; // Lista de pilotos
	private final String SERIAL_NAME = "pilotos.bat"; // Nombre del archivo serializado
	private final String FILE_NAME = "pilotos.csv"; // Nombre del archivo CSV

	/**
	 * Constructor de la clase. Inicializa la lista de pilotos y verifica la
	 * existencia de la carpeta de almacenamiento.
	 */
	public Complementary() {
		FileHandler.checkFolder();
		readSerialized();
	}

	/**
	 * Agrega un nuevo piloto a la lista si no existe previamente.
	 * 
	 * @param newData El piloto que se desea agregar.
	 * @return true si el piloto se agregó exitosamente, false si ya existe.
	 */
	public boolean add(Piloto newData) {
		if (find(newData) == null) {
			listaPilotos.add(newData);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina un piloto de la lista.
	 * 
	 * @param toDelete El piloto que se desea eliminar.
	 * @return true si se eliminó exitosamente, false si no se encontró.
	 */
	public boolean delete(Piloto toDelete) {
		Piloto found = find(toDelete);
		if (found != null) {
			listaPilotos.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Busca un piloto en la lista.
	 * 
	 * @param toFind El piloto que se desea encontrar.
	 * @return El piloto encontrado, o null si no se encuentra.
	 */
	public Piloto find(Piloto toFind) {
		Piloto found = null;
		if (!listaPilotos.isEmpty()) {
			for (Piloto piloto : listaPilotos) {
				if (piloto.getName().toLowerCase().equals(toFind.getName().toLowerCase())) {
					found = piloto;
					return found;
				}
			}
		}
		return null;
	}

	/**
	 * Escribe la lista de pilotos en un archivo CSV.
	 */
	public void writeFile() {
		String content = "";
		for (Piloto piloto : listaPilotos) {
			content += piloto.getName() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	/**
	 * Lee la lista de pilotos desde un archivo CSV.
	 */
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaPilotos = new ArrayList<>();
		} else {
			listaPilotos = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Piloto p = new Piloto();
				p.setName(cols[0]);
				listaPilotos.add(p);
			}
		}
	}

	/**
	 * Muestra la lista de pilotos en formato de cadena.
	 * 
	 * @return Una cadena que representa los pilotos o un mensaje si la lista está
	 *         vacía.
	 */
	public String showPilots() {
		String content = "";
		int pos = 1;
		if (listaPilotos.isEmpty()) {
			return "NO HAY PILOTOS";
		} else {
			for (Piloto pilots : listaPilotos) {
				content += "Piloto " + pos;
				pos++;
				content += pilots + "\n";
			}
			return content.toString();
		}
	}

	/**
	 * Escribe la lista de pilotos en un archivo serializado.
	 */
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaPilotos);
	}

	/**
	 * Lee la lista de pilotos desde un archivo serializado.
	 */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaPilotos = new ArrayList<>();
		} else {
			listaPilotos = (ArrayList<Piloto>) content;
		}
	}

	/**
	 * Selecciona un piloto aleatorio de la lista.
	 * 
	 * @return Una cadena que representa el piloto aleatorio o un mensaje si la
	 *         lista está vacía.
	 */
	public String randomizer() {
		if (listaPilotos.isEmpty()) {
			return "NO PILOTOS";
		}
		Random random = new Random();
		int index = random.nextInt(listaPilotos.size());
		return listaPilotos.get(index).toString();
	}
}
