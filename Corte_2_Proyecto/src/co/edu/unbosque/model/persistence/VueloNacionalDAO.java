package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Vuelo;
import co.edu.unbosque.model.VueloNacional;
import co.edu.unbosque.model.VueloNacionalDTO;

public class VueloNacionalDAO implements CRUDOperation<VueloNacionalDTO, VueloNacional> {

	private ArrayList<VueloNacional> listaVuelosNacionales;
	private final String FILE_NAME = "vuelosNacionales.csv";
	private final String SERIAL_NAME = "vuelosNacionales.bat";

	public VueloNacionalDAO() {
		FileHandler.checkFolder();
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

	@Override
	public ArrayList<VueloNacionalDTO> getAll() {
		return DataMapper.listaVuelosNacionalesToListaVuelosNacionalesDTO(listaVuelosNacionales);
	}

	@Override
	public boolean add(VueloNacionalDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(VueloNacionalDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VueloNacional find(VueloNacional toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(VueloNacionalDTO previous, VueloNacionalDTO newData) {
		// TODO Auto-generated method stub
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
				vN.setCompanyInCharge(cols[0]);
				vN.setNumPassengers(Integer.parseInt(cols[1]));
				vN.setCaptain(cols[2]);
				vN.setSecondInCommand(cols[3]);
				vN.setArrivalTime(cols[4]);
				vN.setDepartureTime(cols[5]);
				vN.setGas(Double.parseDouble(cols[6]));
				vN.setEsHelice(Boolean.parseBoolean(cols[7]));
				vN.setEsTurbina(Boolean.parseBoolean(cols[8]));

			}
		}
	}

	@Override
	public void writeFile() {
		String content = "";
		for (VueloNacional vueloNacional : listaVuelosNacionales) {
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

}
