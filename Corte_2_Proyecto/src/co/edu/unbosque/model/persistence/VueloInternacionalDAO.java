package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.VueloInternacional;
import co.edu.unbosque.model.VueloInternacionalDTO;

public class VueloInternacionalDAO implements CRUDOperation<VueloInternacionalDTO, VueloInternacional> {

	private ArrayList<VueloInternacional> listaVuelosInternacionales;
	private final String FILE_NAME = "vuelosInternacionales.csv";
	private final String SERIAL_NAME = "vuelosInternacionales.bat";

	public VueloInternacionalDAO() {
		FileHandler.checkFolder();
		readSerialized();
	}

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

	@Override
	public ArrayList<VueloInternacionalDTO> getAll() {
		return DataMapper.listaVInternacionalesToListaVuelosInternacionalesDTO(listaVuelosInternacionales);
	}

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

	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaVuelosInternacionales = new ArrayList<>();
		} else {
			listaVuelosInternacionales = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = content.split(";");
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
			}
		}

	}

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

	@Override
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaVuelosInternacionales);
	}

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
						|| vI.getSecondInCommand().equalsIgnoreCase(seconOnCommand)
						|| vI.getCaptain().equalsIgnoreCase(seconOnCommand)
						|| vI.getSecondInCommand().equalsIgnoreCase(captain);

				if (hayInterseccion && pilotoRepetido) {
					return false;
				}
			}

			return valido;
		}
	}
}
