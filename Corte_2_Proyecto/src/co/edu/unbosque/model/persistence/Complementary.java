package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;

import co.edu.unbosque.model.Piloto;

public class Complementary {

	private ArrayList<Piloto> listaPilotos;
	private final String SERIAL_NAME = "pilotos.bat";
	private final String FILE_NAME = "pilotos.csv";

	public Complementary() {
		FileHandler.checkFolder();
		readSerialized();
	}

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

	public void writeFile() {
		String content = "";
		for (Piloto piloto : listaPilotos) {
			content += piloto.getName() + ";";
			content += "\n";

		}
		FileHandler.writeFile(FILE_NAME, content);
	}

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

	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaPilotos);
	}

	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaPilotos = new ArrayList<>();
		} else {
			listaPilotos = (ArrayList<Piloto>) content;
		}
	}

	public String randomizer() {

		if (listaPilotos.isEmpty()) {
			return "NO PILOTOS";
		}
		Random random = new Random();

		int index = random.nextInt(listaPilotos.size());

		return listaPilotos.get(index).toString();
	}

}
