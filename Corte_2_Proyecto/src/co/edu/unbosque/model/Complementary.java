package co.edu.unbosque.model;

public class Complementary {

	private String pilot;

	public Complementary() {
		// TODO Auto-generated constructor stub
	}

	public Complementary(String pilot) {
		super();
		this.pilot = pilot;
	}

	/**
	 * @return the pilot
	 */
	public String getPilot() {
		return pilot;
	}

	/**
	 * @param pilot the pilot to set
	 */
	public void setPilot(String pilot) {
		this.pilot = pilot;
	}

	@Override
	public String toString() {
		return "\nPiloto: " + pilot;
	}

}
