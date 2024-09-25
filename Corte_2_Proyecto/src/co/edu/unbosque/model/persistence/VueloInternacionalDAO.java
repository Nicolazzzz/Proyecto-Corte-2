package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.VueloInternacional;
import co.edu.unbosque.model.VueloInternacionalDTO;

/**
 * Clase que implementa operaciones CRUD para vuelos internacionales.
 * Proporciona métodos para agregar, eliminar, actualizar y listar vuelos. Los
 * datos se almacenan en un archivo CSV y se serializan para persistencia.
 * 
 * @author Emmanuel
 * @version 1.0
 * @since 2024-09-24
 */
public class VueloInternacionalDAO implements CRUDOperation<VueloInternacionalDTO, VueloInternacional> {

	private ArrayList<VueloInternacional> listaVuelosInternacionales;
	private final String FILE_NAME = "vuelosInternacionales.csv";
	private final String SERIAL_NAME = "vuelosInternacionales.bat";

	/**
	 * Constructor de la clase VueloInternacionalDAO. Inicializa la lista de vuelos
	 * internacionales y carga los datos serializados.
	 */
	public VueloInternacionalDAO() {
		FileHandler.checkFolder();
		readSerialized();
	}

	/**
	 * Muestra todos los vuelos internacionales registrados.
	 * 
	 * @return Una cadena con los detalles de todos los vuelos o un mensaje
	 *         indicando que no hay vuelos registrados.
	 */
	@Override
	public String showAll() {
		String content = "";
		int pos = 1;
		if (listaVuelosInternacionales.isEmpty()) {
			return "No hay vuelos registrados";

		} else {
			for (VueloInternacional vueloInternacional : listaVuelosInternacionales) {
				content += "Vuelo " + pos;
				pos++;
				content += vueloInternacional + "\n" + "\n";
			}
			return content;
		}
	}


	/**
	 * Obtiene una lista de todos los vuelos internacionales en formato DTO.
	 * 
	 * @return ArrayList de VueloInternacionalDTO.
	 */

	/**
	 * Muestra los vuelos internacionales disponibles para un destino específico.
	 *
	 * @param destino El destino para el cual se desea mostrar los vuelos internacionales.
	 * @return Una cadena que contiene la lista de vuelos internacionales disponibles para el destino especificado,
	 *         o un mensaje indicando que no hay vuelos disponibles o que no se encontraron vuelos.
	 */
	public String showSelected(String destino) {
	    boolean siHubo = false;
	    String content = "";
	    int pos = 1;
	    if (listaVuelosInternacionales.isEmpty()) {
	        return "No hay vuelos internacionales disponibles";
	    } else {
	        content += "\nVuelos Internacionales Disponibles" + "\n";
	        for (VueloInternacional vI : listaVuelosInternacionales) {
	            if (vI.getDestino().equalsIgnoreCase(destino)) {
	                content += "\n--------------------------------------------------------";
	                content += "\nVuelo " + pos;
	                content += "\n--------------------------------------------------------";
	                content += vI + "\n" + "\n";
	                pos++;
	                siHubo = true;
	            }
	        }
	        if (!siHubo)
	            content += "No se encontraron vuelos disponibles";

	        return content;
	    }
	}

	@Override
	public ArrayList<VueloInternacionalDTO> getAll() {
		return DataMapper.listaVInternacionalesToListaVuelosInternacionalesDTO(listaVuelosInternacionales);
	}

	/**
	 * Agrega un nuevo vuelo internacional.
	 * 
	 * @param newData Objeto VueloInternacionalDTO que contiene la información del
	 *                vuelo.
	 * @return true si el vuelo se agrega correctamente; false si ya existe.
	 */
	@Override
	public boolean add(VueloInternacionalDTO newData) {
		if (find(DataMapper.vueloInternacionalDTOToVueloInternacional(newData)) == null) {
			listaVuelosInternacionales.add(DataMapper.vueloInternacionalDTOToVueloInternacional(newData));
			writeFile();
			writeSerialized();
			return true;
		}
		return false;
	}

	/**
	 * Elimina un vuelo internacional especificado.
	 * 
	 * @param toDelete Objeto VueloInternacionalDTO que representa el vuelo a
	 *                 eliminar.
	 * @return true si el vuelo se elimina correctamente; false si no se encuentra.
	 */
	@Override
	public boolean delete(VueloInternacionalDTO toDelete) {
		VueloInternacional found = find(DataMapper.vueloInternacionalDTOToVueloInternacional(toDelete));
		if (found != null) {
			listaVuelosInternacionales.remove(found);
			writeFile();
			writeSerialized();
			return true;
		}
		return false;
	}

	/**
	 * Busca un vuelo internacional por sus atributos.
	 * 
	 * @param toFind Objeto VueloInternacional que contiene los atributos del vuelo
	 *               a buscar.
	 * @return El vuelo encontrado o null si no se encuentra.
	 */
	@Override
	public VueloInternacional find(VueloInternacional toFind) {
		VueloInternacional found = null;
		if (!listaVuelosInternacionales.isEmpty()) {
			for (VueloInternacional vI : listaVuelosInternacionales) {
				if (vI.getCompanyInCharge().equalsIgnoreCase(toFind.getCompanyInCharge())
						&& vI.getArrivalTime().equalsIgnoreCase(toFind.getArrivalTime())
						&& vI.getDestino().equalsIgnoreCase(toFind.getDestino())) {
					found = vI;
					return found;
				}
			}
		}
		return null;
	}

	/**
	 * Actualiza un vuelo internacional existente.
	 * 
	 * @param previous Objeto VueloInternacionalDTO que representa el vuelo a
	 *                 actualizar.
	 * @param newData  Objeto VueloInternacionalDTO con la nueva información.
	 * @return true si el vuelo se actualiza correctamente; false si no se
	 *         encuentra.
	 */
	@Override
	public boolean update(VueloInternacionalDTO previous, VueloInternacionalDTO newData) {
		VueloInternacional found = find(DataMapper.vueloInternacionalDTOToVueloInternacional(previous));
		if (found != null) {
			listaVuelosInternacionales.remove(found);
			listaVuelosInternacionales.add(DataMapper.vueloInternacionalDTOToVueloInternacional(newData));
			writeFile();
			writeSerialized();
			return true;
		}

		return false;
	}

	/**
	 * Lee los datos de vuelos internacionales desde un archivo CSV.
	 */
	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaVuelosInternacionales = new ArrayList<>();
		} else {
			listaVuelosInternacionales = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				VueloInternacional vI = new VueloInternacional();
				vI.setDestino(cols[0]);
				vI.setCompanyInCharge(cols[1]);
				vI.setNumPassengers(Integer.parseInt(cols[2]));
				vI.setCaptain(cols[3]);
				vI.setSecondInCommand(cols[4]);
				vI.setArrivalTime(cols[5]);
				vI.setDepartureTime(cols[6]);
				vI.setGas(Double.parseDouble(cols[7]));
				vI.setRequiereVisa(Boolean.parseBoolean(cols[8]));
				listaVuelosInternacionales.add(vI); // Agregar el vuelo a la lista
			}
		}

	}

	/**
	 * Escribe los datos de vuelos internacionales en un archivo CSV.
	 */
	@Override
	public void writeFile() {
		String content = "";
		for (VueloInternacional vueloInternacional : listaVuelosInternacionales) {
			content += vueloInternacional.getDestino() + ";";
			content += vueloInternacional.getCompanyInCharge() + ";";
			content += vueloInternacional.getNumPassengers() + ";";
			content += vueloInternacional.getCaptain() + ";";
			content += vueloInternacional.getSecondInCommand() + ";";
			content += vueloInternacional.getArrivalTime() + ";";
			content += vueloInternacional.getDepartureTime() + ";";
			content += vueloInternacional.getGas() + ";";
			content += vueloInternacional.isRequiereVisa();
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	/**
	 * Lee los datos serializados desde un archivo.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaVuelosInternacionales = new ArrayList<>();
		} else {
			listaVuelosInternacionales = (ArrayList<VueloInternacional>) content;
		}

	}

	/**
	 * Escribe la lista de vuelos internacionales en un archivo de datos
	 * serializados.
	 */
	@Override
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaVuelosInternacionales);
	}

	/**
	 * Valida si un nuevo vuelo internacional puede ser agregado sin conflictos de
	 * horarios o pilotos.
	 * 
	 * @param captain        Nombre del capitán del nuevo vuelo.
	 * @param seconOnCommand Nombre del segundo al mando del nuevo vuelo.
	 * @param horaSalida     Hora de salida del nuevo vuelo.
	 * @param horaLlegada    Hora de llegada del nuevo vuelo.
	 * @return true si el vuelo puede ser agregado; false si hay conflictos.
	 */
	public boolean validarRandom(String captain, String seconOnCommand, String horaSalida, String horaLlegada) {

		if (listaVuelosInternacionales.isEmpty()) {
			return true;
		} else {

			boolean valido = true;

			// hora salida parametro
			String[] hora1 = horaSalida.split(":");
			int horaSalidaParametro = Integer.parseInt(hora1[0]);

			// hora llegada parametro
			String[] hora2 = horaLlegada.split(":");
			int horaLlegadaParametro = Integer.parseInt(hora2[0]);

			for (VueloInternacional vI : listaVuelosInternacionales) {

				// hora salida del vuelo original
				String[] hora3 = vI.getDepartureTime().split(":");
				int horaSalidaOriginal = Integer.parseInt(hora3[0]);

				// hora llegada del vuelo original
				String[] hora4 = vI.getArrivalTime().split(":");
				int horaLlegadaOriginal = Integer.parseInt(hora4[0]);

				boolean hayInterseccion = (horaSalidaParametro < horaLlegadaOriginal)
						&& (horaLlegadaParametro > horaSalidaOriginal);

				boolean pilotoRepetido = vI.getCaptain().equalsIgnoreCase(captain)
						|| vI.getSecondInCommand().equalsIgnoreCase(seconOnCommand);

				if (hayInterseccion && pilotoRepetido) {
					valido = false;
				}

			}

			return valido;
		}
	}

}
