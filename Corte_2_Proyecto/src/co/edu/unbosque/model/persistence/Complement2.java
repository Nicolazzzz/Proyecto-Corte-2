package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;

import co.edu.unbosque.model.Piloto;

public class Complement2 {

	private ArrayList<Piloto> listaPilotos;
	private final String FILE_NAME = "pilotos.csv";
	private final String SERIAL_NAME = "pilotos.bat";

	public Complement2() {
		FileHandler.checkFolder();
		readSerialized();
		readFile();
	}

	public String showAll() {
		String content = "";
		int pos = 1;

		if (listaPilotos.isEmpty())
			return "NO HAY PILOTOS";
		else {

			for (Piloto piloto : listaPilotos) {
				content += "Piloto " + pos;
				pos++;
				content += piloto + "\n";

			}
			return content;
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

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaPilotos = new ArrayList<>();
		} else {
			listaPilotos = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				Piloto p = new Piloto();
				p.setName(row);
				listaPilotos.add(p);
			}
		}

	}

	public void randomizer() {

		Random random = new Random();

		int index = random.nextInt(listaPilotos.size());
		System.out.println(listaPilotos.get(index - 1));
	}

}
