
package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller {

	private ViewFacade vf;
	private ModelFacade mf;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		run();
	}

	public void run() {
		vf.getCon().printLine(mf.getComplement().showAll());
//		mf.getComplement().randomizer();
	}

	public void mostrarMenuPrincipal() {

		mainloop: while (true) {

			String menuPpal = """


					MENU PRINCIPAL

					1) NACIONAL
					2) INTERNACIONAL
					3) GENERAR ARCHIVO VUELOS
					4) SALIR

					"""

			;

			vf.getCon().printLine(menuPpal);
			int op = vf.getCon().readInt();

			switch (op) {
			case 1:
				mostrarMenuNacional();

				break;

			case 2:
				mostrarMenuInternacional();
				break;

			case 3:
				break;

			case 4:
				break mainloop;

			default:
				break;
			}
		}

	}

	public void mostrarMenuNacional() {
		nacionloop: while (true) {

			String menuNacional = """

					MENU NACIONAL
					1) Agregar
					2) Mostrar
					3) Actualizar
					4) Eliminar
					5) Salir

					""";
			vf.getCon().printLine(menuNacional);
			int op = vf.getCon().readInt();
			switch (op) {
			case 1:

				String companyInCharge = vf.getCon().readLine();
				int passenger = vf.getCon().readInt();
				String captain = vf.getCon().readLine();
				String secondOnCommand = vf.getCon().readLine();
				String arrivalTime = vf.getCon().readLine();
				String departureTime = vf.getCon().readLine();
				double gas = vf.getCon().readDouble();
				boolean esHelice = vf.getCon().readBoolean();
				boolean esTurbina = vf.getCon().readBoolean();

				break;
			case 2:

				break;
			case 3:

				String companyInChargeA = vf.getCon().readLine();
				int passengerA = vf.getCon().readInt();
				String captainA = vf.getCon().readLine();
				String secondOnCommandA = vf.getCon().readLine();
				String arrivalTimeA = vf.getCon().readLine();
				String departureTimeA = vf.getCon().readLine();
				double gasA = vf.getCon().readDouble();
				boolean esHeliceA = vf.getCon().readBoolean();
				boolean esTurbinaA = vf.getCon().readBoolean();

				break;
			case 4:

				break;
			case 5:

				break nacionloop;

			default:
				break;
			}
		}

	}

	public void mostrarMenuInternacional() {
		interloop: while (true) {

			String menuInter = """

					MENU NACIONAL
					1) Agregar
					2) Mostrar
					3) Actualizar
					4) Eliminar
					5) Salir

					""";
			vf.getCon().printLine(menuInter);
			int op = vf.getCon().readInt();
			switch (op) {
			case 1:

				String companyInCharge = vf.getCon().readLine();
				int passenger = vf.getCon().readInt();
				String captain = vf.getCon().readLine();
				String secondOnCommand = vf.getCon().readLine();
				String arrivalTime = vf.getCon().readLine();
				String departureTime = vf.getCon().readLine();
				double gas = vf.getCon().readDouble();
				boolean requiresVisa = vf.getCon().readBoolean();

				break;
			case 2:

				break;
			case 3:

				String companyInChargeA = vf.getCon().readLine();
				int passengerA = vf.getCon().readInt();
				String captainA = vf.getCon().readLine();
				String secondOnCommandA = vf.getCon().readLine();
				String arrivalTimeA = vf.getCon().readLine();
				String departureTimeA = vf.getCon().readLine();
				double gasA = vf.getCon().readDouble();
				boolean requiresVisaA = vf.getCon().readBoolean();

				break;
			case 4:

				break;
			case 5:

				break interloop;

			default:
				break;

			}
		}
	}

	public void checkRandom(String nombre, String horaSalida, String horaLlegada) {
		
		

	}
}
