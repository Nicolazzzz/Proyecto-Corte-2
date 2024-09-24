
package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Piloto;
import co.edu.unbosque.model.VueloNacionalDTO;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.NotValidTimeFormatException;
import co.edu.unbosque.view.ViewFacade;

public class Controller {

	private ModelFacade mf;
	private ViewFacade vf;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		mostrarMenuPrincipal();
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
			vf.getCon().burnLine();
			switch (op) {
			case 1:

				try {
					boolean validarRandom = true;
					vf.getCon().printLine("AGREGANDO");

					vf.getCon().printLine("DESTINO");
					String destino = vf.getCon().readLine();

					vf.getCon().printLine("COMPANIA");
					String companyInCharge = vf.getCon().readLine();
					vf.getCon().printLine("Pasajeros");
					int passenger = vf.getCon().readInt();
					vf.getCon().burnLine();

					vf.getCon().printLine("hora salida");
					String departureTime = vf.getCon().readLine();
					ExceptionChecker.notValidTimeFormatException(departureTime);

					vf.getCon().printLine("hora llegada");
					String arrivalTime = vf.getCon().readLine();
					ExceptionChecker.notValidTimeFormatException(arrivalTime);

					if (!verificarTiempo(departureTime, arrivalTime)) {
						vf.getCon().printLine("Hora invalida");
						break;
					}

					vf.getCon().printLine("es helice");
					boolean esHelice = vf.getCon().readBoolean();

					vf.getCon().printLine("es turbina");
					boolean esTurbina = vf.getCon().readBoolean();

					String captain = mf.getComplement().randomizer();
					String secondOnCommand = mf.getComplement().randomizer();

					validarRandom = verificarRandom(captain, secondOnCommand, departureTime, arrivalTime);

					while (validarRandom == false) {
						captain = mf.getComplement().randomizer();
						secondOnCommand = mf.getComplement().randomizer();
						validarRandom = verificarRandom(captain, secondOnCommand, departureTime, arrivalTime);
					}

					double gas = 0;
					if (esHelice)
						gas = calcularGasHelice(passenger, departureTime, arrivalTime);
					if (esTurbina)
						gas = calcularGasTurbina(passenger, departureTime, arrivalTime);

					if (mf.getvNacionalDAO().add(new VueloNacionalDTO(destino, companyInCharge, passenger, captain,
							secondOnCommand, arrivalTime, departureTime, gas, esTurbina, esHelice)) == true) {
						vf.getCon().printLine("CREADO EXITOSAMENTE");
					} else {
						vf.getCon().printLine("NO SE PUDO CREAR");
					}
					break;

				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();
				}
			case 2:
				vf.getCon().printLine(mf.getvNacionalDAO().showAll());

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

	public boolean verificarRandom(String captain, String seconOnCommand, String horaSalida, String horaLlegada) {
		boolean valido = true;

		if (mf.getvInternacionalDAO().validarRandom(captain, seconOnCommand, horaSalida, horaLlegada) == false
				|| mf.getvNacionalDAO().validarRandom(captain, seconOnCommand, horaSalida, horaLlegada) == false)
			valido = false;

		return valido;

	}

	public boolean verificarTiempo(String timeSalida, String timeLlegada) {

		String[] salida = timeSalida.split(":");
		int hora = Integer.parseInt(salida[0]);
		int minutos = Integer.parseInt(salida[1]);

		String[] llegada = timeLlegada.split(":");
		int hora2 = Integer.parseInt(llegada[0]);
		int minutos2 = Integer.parseInt(llegada[1]);

		if (hora > hora2 && minutos > minutos2 || hora > hora2) {
			return false;
		} else {
			return true;
		}
	}

}
