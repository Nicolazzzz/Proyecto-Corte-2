
package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Piloto;
import co.edu.unbosque.view.ViewFacade;

public class Controller {

	private ModelFacade mf;
	private ViewFacade vf;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		run();
	}

	public void run() {

		mainloop: while (true) {
			int op = vf.getCon().readInt();
			vf.getCon().burnLine();
			switch (op) {
			case 1:
				System.out.println("agregando");
				String name = vf.getCon().readLine();
				mf.getComplement().add(new Piloto(name));
				break;
			case 2:
				System.out.println("Eliminando");
				String nameD = vf.getCon().readLine();
				mf.getComplement().delete(new Piloto(nameD));
				break;

			case 3:
				System.out.println("Mueche");
				System.out.println(mf.getComplement().showPilots());
				break;

			case 4:
				System.out.println("BYE BYE BITCHS");
				break mainloop;
			case 5:
				System.out.println(mf.getComplement().randomizer());
				break;
			default:
				break;
			}

		}

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

		System.out.println(mf.getComplement().showPilots());

	}

	public double calcularGasHelice(int pasajeros, String horaSalida, String horaLlegada) {

		int horaResultante = 0;
		int minutoResultante = 0;
		int duracionVuelo = 0;
		int consumoAvion = 0; // litro / hora
		double RESERVA = 1.2; // siempre hay reservas del 20%
		double gas = 0;

		String[] tiempoSalida = horaSalida.split(":");
		int horaS = Integer.parseInt(tiempoSalida[0]);
		int minutoS = Integer.parseInt(tiempoSalida[1]);

		String[] tiempoLlegada = horaLlegada.split(":");
		int horaL = Integer.parseInt(tiempoLlegada[0]);
		int minutoL = Integer.parseInt(tiempoLlegada[1]);

		horaResultante = horaL - horaS;
		minutoResultante = minutoL - minutoS;

		if (pasajeros < 100) {
			duracionVuelo = horaResultante + (minutoResultante / 60);
			consumoAvion = 2500; // ejemplo por el BOMBARDIER Q300 o el EMBRAER EMB-120
			gas = (duracionVuelo * consumoAvion) * RESERVA;
		}

		if (pasajeros < 300 && pasajeros > 100) {
			duracionVuelo = horaResultante + (minutoResultante / 60);
			consumoAvion = 5000;
			gas = (duracionVuelo * consumoAvion) * RESERVA;

		}

		return gas;
	}

	public double calcularGasTurbina(int pasajeros, String horaSalida, String horaLlegada) {

		int horaResultante = 0;
		int minutoResultante = 0;
		int duracionVuelo = 0;
		int consumoAvion = 0; // litro / hora
		double RESERVA = 1.2; // siempre hay reservas del 20%
		double gas = 0;

		String[] tiempoSalida = horaSalida.split(":");
		int horaS = Integer.parseInt(tiempoSalida[0]);
		int minutoS = Integer.parseInt(tiempoSalida[1]);

		String[] tiempoLlegada = horaLlegada.split(":");
		int horaL = Integer.parseInt(tiempoLlegada[0]);
		int minutoL = Integer.parseInt(tiempoLlegada[1]);

		horaResultante = horaL - horaS;
		minutoResultante = minutoL - minutoS;

		if (pasajeros < 100) {
			duracionVuelo = horaResultante + (minutoResultante / 60);
			consumoAvion = 4000; // ATR 72
			gas = (duracionVuelo * consumoAvion) * RESERVA;
		}

		if (pasajeros < 300 && pasajeros > 100) {
			duracionVuelo = horaResultante + (minutoResultante / 60);
			consumoAvion = 6000; // airbus A320 o Boeing 737
			gas = (duracionVuelo * consumoAvion) * RESERVA;

		}

		if (pasajeros > 300) {
			duracionVuelo = horaResultante + (minutoResultante / 60);
			consumoAvion = 12000;
			gas = (duracionVuelo * consumoAvion) * RESERVA;

		}

		return gas;
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

}
