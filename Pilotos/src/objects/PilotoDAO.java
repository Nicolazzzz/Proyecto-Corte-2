package objects;

import java.util.ArrayList;

public class PilotoDAO implements CRUDOperation<PilotoDTO, Piloto> {

	private ArrayList<Piloto> listaPilotos;
	private final String FILE_NAME = "pilotos.csv";
	private final String SERIAL_NAME = "pilotos.bat";

	public PilotoDAO() {
		FileHandler.checkFolder();
		readSerialized();

	}

	@Override
	public String showAll() {
		String content = "";
		int pos = 1;
		if (listaPilotos.isEmpty()) {
			return "NO HAY NADA";
		} else {
			for (Piloto piloto : listaPilotos) {
				content += "Piloto " + pos;
				pos++;
				content += piloto + "\n";
			}
			return content;
		}
	}

	@Override
	public ArrayList<PilotoDTO> getAll() {
		return DataMapper.listPilotoToPilotoDTO(listaPilotos);
	}

	@Override
	public boolean add(PilotoDTO newData) {
		if (find(DataMapper.pilotoDTOToPiloto(newData)) == null) {
			listaPilotos.add(DataMapper.pilotoDTOToPiloto(newData));
			writeFile();
			writeSerialized();
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean delete(PilotoDTO toDelete) {

		Piloto found = find(DataMapper.pilotoDTOToPiloto(toDelete));
		if (found != null) {
			listaPilotos.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Piloto find(Piloto toFind) {
		Piloto found = null;
		if (!listaPilotos.isEmpty()) {
			for (Piloto piloto : listaPilotos) {
				if (piloto.getPilotoName().toLowerCase().equals(toFind.getPilotoName().toLowerCase())) {
					found = piloto;
					return found;
				}

			}
		}
		return null;
	}

	@Override
	public boolean update(PilotoDTO previous, PilotoDTO newData) {
		Piloto found = find(DataMapper.pilotoDTOToPiloto(previous));

		if (found != null) {
			listaPilotos.remove(found);
			listaPilotos.add(DataMapper.pilotoDTOToPiloto(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {

			return false;
		}
	}

	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaPilotos = new ArrayList<>();
		} else {
			listaPilotos = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = content.split(";");
				Piloto p = new Piloto();
				p.setPilotoName(cols[0]);
				listaPilotos.add(p);

			}

		}

	}

	@Override
	public void writeFile() {
		String content = "";
		for (Piloto p : listaPilotos) {
			content += p.getPilotoName();
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaPilotos = new ArrayList<>();
		} else {
			listaPilotos = (ArrayList<Piloto>) content;
		}

	}

	@Override
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaPilotos);

	}

}
