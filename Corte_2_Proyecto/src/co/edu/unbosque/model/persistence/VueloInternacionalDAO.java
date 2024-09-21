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
	public VueloInternacional fin(VueloInternacional toFind) {
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
