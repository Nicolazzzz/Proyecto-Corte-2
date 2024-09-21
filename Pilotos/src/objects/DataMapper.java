package objects;

import java.util.ArrayList;

public class DataMapper {

	public static Piloto pilotoDTOToPiloto(PilotoDTO dto) {
		Piloto entity = new Piloto(dto.getPilotoName());
		return entity;

	}

	public static PilotoDTO pilotoToPilotoDTO(Piloto e) {
		PilotoDTO dto = new PilotoDTO(e.getPilotoName());
		return dto;
	}

	public static ArrayList<Piloto> listPilotoDTOToPiloto(ArrayList<PilotoDTO> dto) {
		ArrayList<Piloto> e = new ArrayList<>();
		for (PilotoDTO piloto : dto) {
			e.add(new Piloto(piloto.getPilotoName()));

		}
		return e;

	}

	public static ArrayList<PilotoDTO> listPilotoToPilotoDTO(ArrayList<Piloto> e) {
		ArrayList<PilotoDTO> dto = new ArrayList<>();
		for (Piloto piloto : e) {
			dto.add(new PilotoDTO(piloto.getPilotoName()));

		}
		return dto;

	}
}
