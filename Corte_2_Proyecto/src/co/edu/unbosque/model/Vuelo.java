package co.edu.unbosque.model;

public abstract class Vuelo {

	private String companyInCharge;
	private int numPassengers;
	private String captain;
	private String secondInCommand;
	private String arrivalTime;
	private String departureTime;

	public Vuelo() {
		// TODO Auto-generated constructor stub
	}

	public Vuelo(String companyInCharge, int numPassengers, String captain, String secondInCommand, String arrivalTime,
			String departureTime) {
		super();
		this.companyInCharge = companyInCharge;
		this.numPassengers = numPassengers;
		this.captain = captain;
		this.secondInCommand = secondInCommand;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "\nCompany In Charge= " + companyInCharge + "\nNum Passengers= " + numPassengers + "\nCaptain= "
				+ captain + "\nSecond In Command= " + secondInCommand + "\nArrival Time= " + arrivalTime
				+ "\nDeparture Time= " + departureTime;
	}

}
