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
