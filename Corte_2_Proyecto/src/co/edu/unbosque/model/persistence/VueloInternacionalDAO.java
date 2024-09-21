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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(VueloInternacionalDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VueloInternacional find(VueloInternacional toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(VueloInternacionalDTO previous, VueloInternacionalDTO newData) {
		// TODO Auto-generated method stub
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
				vI.setCompanyInCharge(cols[0]);
				vI.setNumPassengers(Integer.parseInt(cols[1]));
				vI.setCaptain(cols[2]);
				vI.setSecondInCommand(cols[3]);
				vI.setArrivalTime(cols[4]);
				vI.setDepartureTime(cols[5]);
				vI.setGas(Double.parseDouble(cols[6]));
				vI.setRequiereVisa(Boolean.parseBoolean(cols[7]));
			}
		}

	}

	@Override
	public void writeFile() {
		String content = "";
		for (VueloInternacional vueloInternacional : listaVuelosInternacionales) {
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

}
