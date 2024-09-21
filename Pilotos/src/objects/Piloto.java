package objects;

import java.io.Serializable;

public class Piloto implements Serializable {

	private String pilotoName;

	public Piloto() {
		// TODO Auto-generated constructor stub
	}

	public Piloto(String pilotoName) {
		super();
		this.pilotoName = pilotoName;
	}

	public String getPilotoName() {
		return pilotoName;
	}

	public void setPilotoName(String pilotoName) {
		this.pilotoName = pilotoName;
	}

	@Override
	public String toString() {
		return "\nPiloto: " + pilotoName;
	}

}
