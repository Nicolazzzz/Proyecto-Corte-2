package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Vuelo;
import co.edu.unbosque.model.VueloInternacional;
import co.edu.unbosque.model.VueloNacional;
import co.edu.unbosque.model.VueloNacionalDTO;

public class VueloNacionalDAO implements CRUDOperation<VueloNacionalDTO, VueloNacional> {

	private ArrayList<VueloNacional> listaVuelosNacionales;
	private final String FILE_NAME = "vuelosNacionales.csv";
	private final String SERIAL_NAME = "vuelosNacionales.bat";

	public VueloNacionalDAO() {
		FileHandler.checkFolder();
		readSerialized();
	}

	@Override
	public String showAll() {
		String content = "";
		int pos = 1;

		if (listaVuelosNacionales.isEmpty()) {
			return "No hay vuelos registrados";
		} else {
			for (VueloNacional vueloNacional : listaVuelosNacionales) {
				content += "Vuelo " + pos;
				pos++;
				content += vueloNacional + "\n" + "\n";
			}
			return content;
		}
	}

	public String showSelected(String destino) {
		boolean siHubo = false;
		String content = "";
		int pos = 1;
		if (listaVuelosNacionales.isEmpty()) {
			return "No hay vuelos nacionales disponibles";
		} else {
			content += "\nVuelos Nacionales Disponibles" + "\n";
			for (VueloNacional vN : listaVuelosNacionales) {
				if (vN.getDestino().equalsIgnoreCase(destino)) {
					content += "\n--------------------------------------------------------";
					content += "\nVuelo " + pos;
					content += "\n--------------------------------------------------------";
					content += vN + "\n" + "\n";
					pos++;
					siHubo = true;
				} else {
					if (!siHubo)
						content += "No se encontraron vuelos disponibles";
				}

			}

		}
		return content;
	}

	@Override
	public ArrayList<VueloNacionalDTO> getAll() {
		return DataMapper.listaVuelosNacionalesToListaVuelosNacionalesDTO(listaVuelosNacionales);
	}

	@Override
	public boolean add(VueloNacionalDTO newData) {
		if (find(DataMapper.vueloNacionalDTOToVueloNacional(newData)) == null) {
			listaVuelosNacionales.add(DataMapper.vueloNacionalDTOToVueloNacional(newData));
			writeFile();
			writeSerialized();
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(VueloNacionalDTO toDelete) {
		VueloNacional found = find(DataMapper.vueloNacionalDTOToVueloNacional(toDelete));
		if (found != null) {
			listaVuelosNacionales.remove(found);
			writeFile();
			writeSerialized();
			return true;
		}

		return false;
	}

	@Override
	public VueloNacional find(VueloNacional toFind) {
		VueloNacional found = null;
		if (!listaVuelosNacionales.isEmpty()) {
			for (VueloNacional vN : listaVuelosNacionales) {
				if (vN.getCompanyInCharge().equalsIgnoreCase(toFind.getCompanyInCharge())
						&& vN.getArrivalTime().equalsIgnoreCase(toFind.getArrivalTime())
						&& vN.getDestino().equalsIgnoreCase(toFind.getDestino())) {
					found = vN;
					return found;
				}
			}
		}

		return null;
	}

	@Override
	public boolean update(VueloNacionalDTO previous, VueloNacionalDTO newData) {
		VueloNacional found = find(DataMapper.vueloNacionalDTOToVueloNacional(previous));
		if (found != null) {
			listaVuelosNacionales.remove(found);
			listaVuelosNacionales.add(DataMapper.vueloNacionalDTOToVueloNacional(newData));
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
			listaVuelosNacionales = new ArrayList<>();
		} else {
			listaVuelosNacionales = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				VueloNacional vN = new VueloNacional();
				vN.setDestino(cols[0]);
				vN.setCompanyInCharge(cols[1]);
				vN.setNumPassengers(Integer.parseInt(cols[2]));
				vN.setCaptain(cols[3]);
				vN.setSecondInCommand(cols[4]);
				vN.setArrivalTime(cols[5]);
				vN.setDepartureTime(cols[6]);
				vN.setGas(Double.parseDouble(cols[7]));
				vN.setEsHelice(Boolean.parseBoolean(cols[8]));
				vN.setEsTurbina(Boolean.parseBoolean(cols[9]));
				listaVuelosNacionales.add(vN);

			}
		}
	}

	@Override
	public void writeFile() {
		String content = "";
		for (VueloNacional vueloNacional : listaVuelosNacionales) {
			content += vueloNacional.getDestino() + ";";
			content += vueloNacional.getCompanyInCharge() + ";";
			content += vueloNacional.getNumPassengers() + ";";
			content += vueloNacional.getCaptain() + ";";
			content += vueloNacional.getSecondInCommand() + ";";
			content += vueloNacional.getArrivalTime() + ";";
			content += vueloNacional.getDepartureTime() + ";";
			content += vueloNacional.getGas() + ";";
			content += vueloNacional.isEsTurbina() + ";";
			content += vueloNacional.isEsHelice();
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaVuelosNacionales = new ArrayList<>();
		} else {
			listaVuelosNacionales = (ArrayList<VueloNacional>) content;
		}
	}

	@Override
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaVuelosNacionales);
	}

	public boolean validarRandom(String captain, String seconOnCommand, String horaSalida, String horaLlegada) {
		if (listaVuelosNacionales.isEmpty()) {
			return true;
		} else {

			boolean valido = true;

			// hora salida parametro
			String[] hora1 = horaSalida.split(":");
			int horaSalidaParametro = Integer.parseInt(hora1[0]);

			// hora llegada parametro
			String[] hora2 = horaLlegada.split(":");
			int horaLlegadaParametro = Integer.parseInt(hora2[0]);

			for (VueloNacional vN : listaVuelosNacionales) {

				// hora salida del vuelo original
				String[] hora3 = vN.getDepartureTime().split(":");
				int horaSalidaOriginal = Integer.parseInt(hora3[0]);

				// hora llegada del vuelo original
				String[] hora4 = vN.getArrivalTime().split(":");
				int horaLlegadaOriginal = Integer.parseInt(hora4[0]);

				boolean hayInterseccion = (horaSalidaParametro < horaLlegadaOriginal)
						&& (horaLlegadaParametro > horaSalidaOriginal);

				boolean pilotoRepetido = vN.getCaptain().equalsIgnoreCase(captain)
						|| vN.getSecondInCommand().equalsIgnoreCase(seconOnCommand)
						|| vN.getCaptain().equalsIgnoreCase(seconOnCommand)
						|| vN.getSecondInCommand().equalsIgnoreCase(captain);

				if (hayInterseccion && pilotoRepetido) {
					return false;
				}
			}

			return valido;
		}
	}

}
