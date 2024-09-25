
package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Piloto;
import co.edu.unbosque.model.VueloInternacional;
import co.edu.unbosque.model.VueloInternacionalDTO;
import co.edu.unbosque.model.VueloNacional;
import co.edu.unbosque.model.VueloNacionalDTO;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.NotValidBooleanException;
import co.edu.unbosque.util.exception.NotValidInputException;
import co.edu.unbosque.util.exception.NotValidTimeFormatException;
import co.edu.unbosque.view.ViewFacade;

public class Controller {

	private ModelFacade mf;
	private ViewFacade vf;

	private String companiaA = "";
	private String destinoA = "";
	private String llegadaA = "";

	private boolean dark = false;
	private boolean white = true;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		mostrarMenuPrincipal();
	}

	public void run() {

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

			case 5:
				vf.getCon().burnLine();
				String vuelos = vf.getCon().readLine();
				vf.getCon().printLine(mf.getvInternacionalDAO().showSelected(vuelos));
				vf.getCon().printLine(mf.getvNacionalDAO().showSelected(vuelos));
				break;

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
			vf.getCon().burnLine();
			switch (op) {
			case 1:

				try {
					boolean validarRandom = true;
					vf.getCon().printLine("AGREGANDO");

					vf.getCon().printLine("DESTINO");
					String destino = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destino);

					vf.getCon().printLine("COMPANIA");
					String companyInCharge = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(companyInCharge);

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
					ExceptionChecker.notValidBooleanException(esHelice);

					vf.getCon().printLine("es turbina");
					boolean esTurbina = vf.getCon().readBoolean();
					ExceptionChecker.notValidBooleanException(esTurbina);

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

				} catch (StringIndexOutOfBoundsException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
				} catch (NotValidInputException e) {
					vf.getCon().printLine(
							"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
					break;

				} catch (NumberFormatException e) {
					vf.getCon().printLine("Ingrese correctamente los datos numericos, use numeros enteros");
					break;
				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();
				} catch (NotValidBooleanException e) {
					vf.getCon().printLine("En campos de respuesta para pregunta SI / NO, conteste con si o no");
					break;
				}
				break;

			case 2:
				vf.getCon().printLine(mf.getvNacionalDAO().showAll());
				break;

			case 3:

				try {
					vf.getCon().printLine("VALIDAR UPDATE");
					vf.getCon().printLine("compania");
					companiaA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(companiaA);

					vf.getCon().printLine("llegada");
					llegadaA = vf.getCon().readLine();
					ExceptionChecker.notValidTimeFormatException(llegadaA);

					vf.getCon().printLine("destino");
					destinoA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destinoA);

					if (mf.getvNacionalDAO().find(new VueloNacional(destinoA, companiaA, 0, null, null, llegadaA, null,
							0, false, false)) == null) {
						vf.getCon().printLine("No fue encontrado el vuelo, verifique los datos ingresados");
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();

				} catch (NotValidInputException e) {
					vf.getCon().printLine(
							"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
					break;
				}

				try {
					boolean validarRandom = true;
					vf.getCon().printLine("AGREGANDO");

					vf.getCon().printLine("DESTINO");
					String destino = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destino);

					vf.getCon().printLine("COMPANIA");
					String companyInCharge = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(companyInCharge);

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
					ExceptionChecker.notValidBooleanException(esHelice);

					vf.getCon().printLine("es turbina");
					boolean esTurbina = vf.getCon().readBoolean();
					ExceptionChecker.notValidBooleanException(esTurbina);

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

					if (mf.getvNacionalDAO().update(
							new VueloNacionalDTO(destinoA, companiaA, 0, null, null, llegadaA, null, 0),
							new VueloNacionalDTO(destino, companyInCharge, passenger, captain, secondOnCommand,
									arrivalTime, departureTime, gas, esTurbina, esHelice)) == true) {
						vf.getCon().printLine("CREADO EXITOSAMENTE");
					} else {
						vf.getCon().printLine("NO SE PUDO CREAR");
					}
				} catch (StringIndexOutOfBoundsException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");

				} catch (NotValidInputException e) {
					vf.getCon().printLine(
							"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
					break;

				} catch (NumberFormatException e) {
					vf.getCon().printLine("Ingrese correctamente los datos numericos, use numeros enteros");
					break;
				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();
				} catch (NotValidBooleanException e) {
					vf.getCon().printLine("En campos de respuesta para pregunta SI / NO, conteste con si o no");
					break;
				}
				break;

			case 4:
				try {
					vf.getCon().printLine("ELIMINANDO");
					vf.getCon().printLine("compania");
					String companiaA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(companiaA);

					vf.getCon().printLine("destino");
					String destinoA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destinoA);

					vf.getCon().printLine("llegada");
					String hLlegadaA = vf.getCon().readLine();
					ExceptionChecker.notValidTimeFormatException(hLlegadaA);

					if (mf.getvNacionalDAO().delete(new VueloNacionalDTO(destinoA, companiaA, 0, null, null, hLlegadaA,
							null, 0, false, false)) == false) {
						vf.getCon().printLine("No fue encontrado el vuelo, verifique los datos ingresados");
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();

				} catch (NotValidInputException e) {
					vf.getCon().printLine(
							"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
					break;
				}
				break;

			case 5:
				vf.getCon().printLine("VOLVIENDO.....");
				break nacionloop;

			default:
				break;
			}
		}

	}

	public void mostrarMenuInternacional() {
		interloop: while (true) {

			String menuInter = """

					MENU INTERNACIONAL
					1) Agregar
					2) Mostrar
					3) Actualizar
					4) Eliminar
					5) Salir

					""";
			vf.getCon().printLine(menuInter);
			int op = vf.getCon().readInt();
			vf.getCon().burnLine();
			switch (op) {
			case 1:

				try {
					boolean validarRandom = true;
					vf.getCon().printLine("AGREGANDO");

					vf.getCon().printLine("DESTINO");
					String destino = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destino);

					vf.getCon().printLine("COMPANIA");
					String companyInCharge = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(companyInCharge);

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

					vf.getCon().printLine("Requiere VISA");
					boolean requiresVisa = vf.getCon().readBoolean();
					ExceptionChecker.notValidBooleanException(requiresVisa);

					String captain = mf.getComplement().randomizer();
					String secondOnCommand = mf.getComplement().randomizer();

					validarRandom = verificarRandom(captain, secondOnCommand, departureTime, arrivalTime);

					while (validarRandom == false) {
						captain = mf.getComplement().randomizer();
						secondOnCommand = mf.getComplement().randomizer();
						validarRandom = verificarRandom(captain, secondOnCommand, departureTime, arrivalTime);
					}

					double gas = calcularGasTurbina(passenger, departureTime, arrivalTime);

					if (mf.getvInternacionalDAO().add(new VueloInternacionalDTO(destino, companyInCharge, passenger,
							captain, secondOnCommand, arrivalTime, departureTime, gas, requiresVisa)) == true) {
						vf.getCon().printLine("CREADO EXITOSAMENTE");
					} else {
						vf.getCon().printLine("NO SE PUDO CREAR");
					}
				} catch (StringIndexOutOfBoundsException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
				} catch (NotValidInputException e) {
					vf.getCon().printLine(
							"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
					break;

				} catch (NumberFormatException e) {
					vf.getCon().printLine("Ingrese correctamente los datos numericos, use numeros enteros");
					break;
				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();
				} catch (NotValidBooleanException e) {
					vf.getCon().printLine("En campos de respuesta para pregunta SI / NO, conteste con si o no");
					break;
				}
				break;
			case 2:
				vf.getCon().printLine(mf.getvInternacionalDAO().showAll());

				break;

			case 3:

				try {
					vf.getCon().printLine("VALIDAR UPDATE");
					vf.getCon().printLine("compania");
					companiaA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(companiaA);

					vf.getCon().printLine("llegada");
					llegadaA = vf.getCon().readLine();
					ExceptionChecker.notValidTimeFormatException(llegadaA);

					vf.getCon().printLine("destino");
					destinoA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destinoA);

					if (mf.getvInternacionalDAO().find(new VueloInternacional(destinoA, companiaA, 0, null, null,
							llegadaA, null, 0, false)) == null) {
						vf.getCon().printLine("No fue encontrado el vuelo, verifique los datos ingresados");
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();

				} catch (NotValidInputException e) {
					vf.getCon().printLine(
							"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
					break;
				}

				try {
					boolean validarRandom = true;
					vf.getCon().printLine("AGREGANDO");

					vf.getCon().printLine("DESTINO");
					String destino = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destino);

					vf.getCon().printLine("COMPANIA");
					String companyInCharge = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(companyInCharge);

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
					vf.getCon().printLine("Requiere VISA");
					boolean requiresVisa = vf.getCon().readBoolean();
					ExceptionChecker.notValidBooleanException(requiresVisa);

					String captain = mf.getComplement().randomizer();
					String secondOnCommand = mf.getComplement().randomizer();

					validarRandom = verificarRandom(captain, secondOnCommand, departureTime, arrivalTime);

					while (validarRandom == false) {
						captain = mf.getComplement().randomizer();
						secondOnCommand = mf.getComplement().randomizer();
						validarRandom = verificarRandom(captain, secondOnCommand, departureTime, arrivalTime);
					}

					double gas = calcularGasTurbina(passenger, departureTime, arrivalTime);

					if (mf.getvInternacionalDAO().update(
							new VueloInternacionalDTO(destinoA, companiaA, 0, null, null, llegadaA, null, 0),
							new VueloInternacionalDTO(destino, companyInCharge, passenger, captain, secondOnCommand,
									arrivalTime, departureTime, gas, requiresVisa)) == true) {
						vf.getCon().printLine("CREADO EXITOSAMENTE");
					} else {
						vf.getCon().printLine("NO SE PUDO CREAR");
					}

				} catch (StringIndexOutOfBoundsException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
				} catch (NotValidInputException e) {
					vf.getCon().printLine(
							"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
					break;

				} catch (NumberFormatException e) {
					vf.getCon().printLine("Ingrese correctamente los datos numericos, use numeros enteros");
					break;
				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();
				} catch (NotValidBooleanException e) {
					vf.getCon().printLine("En campos de respuesta para pregunta SI / NO, conteste con si o no");
					break;
				}
				break;

			case 4:
				try {
					vf.getCon().printLine("ELIMINANDO");
					vf.getCon().printLine("compania");
					String companiaA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(companiaA);

					vf.getCon().printLine("destino");
					String destinoA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destinoA);

					vf.getCon().printLine("llegada");
					String hLlegadaA = vf.getCon().readLine();
					ExceptionChecker.notValidTimeFormatException(hLlegadaA);

					if (mf.getvInternacionalDAO().delete(new VueloInternacionalDTO(destinoA, companiaA, 0, null, null,
							hLlegadaA, null, 0, false)) == false) {
						vf.getCon().printLine("No fue encontrado el vuelo, verifique los datos ingresados");
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
				} catch (NotValidTimeFormatException e) {
					vf.getCon().printLine("Formato de hora no valido, recuerde hh:mm (24:00)");
					break;
//					e.printStackTrace();

				} catch (NotValidInputException e) {
					vf.getCon().printLine(
							"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
					break;
				}
				break;

			case 5:
				vf.getCon().printLine("VOLVIENDO.....");
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

		if (pasajeros <= 100) {
			duracionVuelo = horaResultante + (minutoResultante / 60);
			consumoAvion = 4000; // ATR 72
			gas = (duracionVuelo * consumoAvion) * RESERVA;
		}

		if (pasajeros < 300 && pasajeros > 100) {
			duracionVuelo = horaResultante + (minutoResultante / 60);
			consumoAvion = 6000; // airbus A320 o Boeing 737
			gas = (duracionVuelo * consumoAvion) * RESERVA;

		}

		if (pasajeros >= 300) {
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
