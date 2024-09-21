package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

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
	public VueloNacional fin(VueloNacional toFind) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void writeFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public void readSerialized() {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeSerialized() {
		// TODO Auto-generated method stub

	}

}
