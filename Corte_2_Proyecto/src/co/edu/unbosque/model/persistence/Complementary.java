package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;

public class Complementary {

	private ArrayList<Complementary> listaPilotos;
	private final String SERIAL_NAME = "pilotos.bat";

	public Complementary() {
		FileHandler.checkFolder();
		readSerialized();
	}

	public String showPilots() {
		String content = "";
		int pos = 1;
		if (listaPilotos.isEmpty()) {
			return "NO HAY PILOTOS";
		} else {
			for (Complementary pilots : listaPilotos) {
				content += "Piloto " + pos;
				pos++;
				content += pilots + "\n";
			}
			return content.toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaPilotos = new ArrayList<>();
		} else {
			listaPilotos = (ArrayList<Complementary>) content;
		}
	}

	public String randomizer() {

		if (listaPilotos.isEmpty()) {
			return "NO PILOTOS";
		}
		Random random = new Random();

		int index = random.nextInt(listaPilotos.size());

		return listaPilotos.get(index);

	}

}
