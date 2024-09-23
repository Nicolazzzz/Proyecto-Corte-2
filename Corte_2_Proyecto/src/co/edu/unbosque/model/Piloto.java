package co.edu.unbosque.model;

import java.io.Serializable;

public class Piloto implements Serializable {

	private String name;

	public Piloto() {
		// TODO Auto-generated constructor stub
	}

	public Piloto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nPiloto: " + name;
	}

}
