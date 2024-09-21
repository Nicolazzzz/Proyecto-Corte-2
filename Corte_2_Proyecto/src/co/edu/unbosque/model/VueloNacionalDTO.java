package co.edu.unbosque.model;

public class VueloNacionalDTO extends VueloDTO {

	private boolean esTurbina;
	private boolean esHelice;

	public VueloNacionalDTO() {
		// TODO Auto-generated constructor stub
	}

	public VueloNacionalDTO(boolean esTurbina, boolean esHelice) {
		super();
		this.esTurbina = esTurbina;
		this.esHelice = esHelice;
	}

	public VueloNacionalDTO(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, double gas, boolean esTurbina, boolean esHelice) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		this.esTurbina = esTurbina;
		this.esHelice = esHelice;
	}

	public VueloNacionalDTO(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, double gas) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsTurbina() {
		return esTurbina;
	}

	public void setEsTurbina(boolean esTurbina) {
		this.esTurbina = esTurbina;
	}

	public boolean isEsHelice() {
		return esHelice;
	}

	public void setEsHelice(boolean esHelice) {
		this.esHelice = esHelice;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTiene turbina: " + esTurbina + "\nTiene Helice: " + esHelice;
	}

}
