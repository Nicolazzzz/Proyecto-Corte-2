
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Piloto;
import co.edu.unbosque.model.VueloInternacional;
import co.edu.unbosque.model.VueloInternacionalDTO;
import co.edu.unbosque.model.VueloNacional;
import co.edu.unbosque.model.VueloNacionalDTO;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.NegativeIntNumberException;
import co.edu.unbosque.util.exception.NotValidBooleanException;
import co.edu.unbosque.util.exception.NotValidInputException;
import co.edu.unbosque.util.exception.NotValidTimeFormatException;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;

	private String companiaA = "";
	private String destinoA = "";
	private String llegadaA = "";
	private String company = "";
	private String companyA = "";

	private boolean dark = true;
	private boolean white = false;

	private boolean nacional = false;
	private boolean internacional = false;

	private boolean horaInvalida = false;
	private boolean agregar = false;
	private boolean actualizar = false;
	private boolean eliminar = false;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();

		asignarLectores();
		vf.getVp().mostrarPanelWelcome();
		mostrarMenuPrincipal();

	}

	public void asignarLectores() {
		// WELCOME
		vf.getVp().getWelcomePanel().getAdminBtn().addActionListener(this);
		vf.getVp().getWelcomePanel().getAdminBtn().setActionCommand("ADMIN");

		vf.getVp().getWelcomePanel().getUserBtn().addActionListener(this);
		vf.getVp().getWelcomePanel().getUserBtn().setActionCommand("USER");

		vf.getVp().getWelcomePanel().getBackgroungBtn().addActionListener(this);
		vf.getVp().getWelcomePanel().getBackgroungBtn().setActionCommand("FONDO");

		// USER
		vf.getVp().getUserPanel().getBuscarBtn().addActionListener(this);
		vf.getVp().getUserPanel().getBuscarBtn().setActionCommand("BUSCAR");

		vf.getVp().getUserPanel().getVolverBtn().addActionListener(this);
		vf.getVp().getUserPanel().getVolverBtn().setActionCommand("VOLVERUSER");

		// MANAGE
		vf.getVp().getManagePanel().getInternacionalBtn().addActionListener(this);
		vf.getVp().getManagePanel().getInternacionalBtn().setActionCommand("INTERNACIONAL");

		vf.getVp().getManagePanel().getNacionalBtn().addActionListener(this);
		vf.getVp().getManagePanel().getNacionalBtn().setActionCommand("NACIONAL");

		vf.getVp().getManagePanel().getGenerarBtn().addActionListener(this);
		vf.getVp().getManagePanel().getGenerarBtn().setActionCommand("GENERARFILE");

		vf.getVp().getManagePanel().getVolverBtn().addActionListener(this);
		vf.getVp().getManagePanel().getVolverBtn().setActionCommand("VOLVERADMIN");

		// CRUD
		vf.getVp().getCrudPanel().getAddBtn().addActionListener(this);
		vf.getVp().getCrudPanel().getAddBtn().setActionCommand("AGREGAR");

		vf.getVp().getCrudPanel().getDeleteBtn().addActionListener(this);
		vf.getVp().getCrudPanel().getDeleteBtn().setActionCommand("ELIMINAR");

		vf.getVp().getCrudPanel().getShowBtn().addActionListener(this);
		vf.getVp().getCrudPanel().getShowBtn().setActionCommand("MOSTRAR");

		vf.getVp().getCrudPanel().getUpdateBtn().addActionListener(this);
		vf.getVp().getCrudPanel().getUpdateBtn().setActionCommand("ACTUALIZAR");

		vf.getVp().getCrudPanel().getVolverBtn().addActionListener(this);
		vf.getVp().getCrudPanel().getVolverBtn().setActionCommand("VOLVERCRUD");

		// INPUT
		vf.getVp().getInputPanel().getVolverBtn().addActionListener(this);
		vf.getVp().getInputPanel().getVolverBtn().setActionCommand("VOLVERINPUT");

		vf.getVp().getInputPanel().getSaveBtn().addActionListener(this);
		vf.getVp().getInputPanel().getSaveBtn().setActionCommand("GUARDARINPUT");

		vf.getVp().getInputPanel().getCompaniaBtn().addActionListener(this);
		vf.getVp().getInputPanel().getCompaniaBtn().setActionCommand("COMPANIAINPUT");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		// BIENVENIDA
		case "FONDO":

			if (white == true && dark == false) {
				white = false;
				dark = true;
				setearFondo();
				break;
			}

			if (dark == true && white == false) {
				white = true;
				dark = false;
				setearFondo();
				break;
			}

			break;

		case "ADMIN":
			setearFondo();
			vf.getVp().mostrarPanelManage();
			break;

		case "USER":
			setearFondo();
			vf.getVp().mostrarPanelUser();
			break;

		// USUARIO
		case "BUSCAR":

			String vuelos = vf.getVp().getUserPanel().getDestinoField().getText();
			vf.getCon().mostrarMensajeEmergenteConScrollWhite(
					mf.getvInternacionalDAO().showSelected(vuelos) + "\n" + mf.getvNacionalDAO().showSelected(vuelos));
			break;

		case "VOLVERUSER":
			vf.getVp().mostrarPanelWelcome();
			break;

		// ADMIN
		case "INTERNACIONAL":
			internacional = true;
			nacional = false;
			setearPorTipo();
			vf.getVp().mostrarPanelCrud();

			break;

		case "NACIONAL":
			internacional = false;
			nacional = true;
			setearPorTipo();
			vf.getVp().mostrarPanelCrud();
			break;

		case "GENERARFILE":
			break;

		case "VOLVERADMIN":
			vf.getVp().mostrarPanelWelcome();
			break;

		// CRUD

		case "MOSTRAR":
			if (white == true) {
				if (nacional == true)
					vf.getCon().mostrarMensajeEmergenteConScrollDark(mf.getvNacionalDAO().showAll());
				if (internacional == true)
					vf.getCon().mostrarMensajeEmergenteConScrollDark(mf.getvInternacionalDAO().showAll());
				break;
			}

			if (dark == true) {
				if (nacional == true)
					vf.getCon().mostrarMensajeEmergenteConScrollWhite(mf.getvNacionalDAO().showAll());
				if (internacional == true)
					vf.getCon().mostrarMensajeEmergenteConScrollWhite(mf.getvInternacionalDAO().showAll());
				break;
			}
			break;

		case "AGREGAR":
			eliminar = false;
			agregar = true;
			actualizar = false;
			setearFieldsCRUD();
			setearIMGCRUD();
			vf.getVp().mostrarPanelInput();
			break;

		case "ELIMINAR":
			eliminar = true;
			agregar = false;
			actualizar = false;
			setearFieldsCRUD();
			setearIMGCRUD();
			vf.getVp().mostrarPanelInput();
			break;

		case "ACTUALIZAR":

			eliminar = false;
			agregar = false;
			actualizar = true;
			setearFieldsCRUD();
			setearIMGCRUD();
			vf.getVp().mostrarPanelInput();
			break;

		case "VOLVERCRUD":
			vf.getVp().mostrarPanelManage();
			break;

		// INPUT

		case "COMPANIAINPUT":
			break;

		case "VOLVERINPUT":
			vf.getVp().mostrarPanelCrud();
			break;

		case "GUARDARINPUT":
			if (agregar == true) {
				agregar();
			}
			if (eliminar == true) {
				eliminar();
			}
			if (actualizar == true)
				actualizar();
			break;

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

					vf.getCon().printLine("destino");
					destinoA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destinoA);

					vf.getCon().printLine("llegada");
					llegadaA = vf.getCon().readLine();
					ExceptionChecker.notValidTimeFormatException(llegadaA);

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

					vf.getCon().printLine("destino");
					destinoA = vf.getCon().readLine();
					ExceptionChecker.notValidInputException(destinoA);

					vf.getCon().printLine("llegada");
					llegadaA = vf.getCon().readLine();
					ExceptionChecker.notValidTimeFormatException(llegadaA);

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

	public void setearIMGCRUD() {
		vf.getVp().getInputPanel().getImgInputIClaro().setVisible(false);
		vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(false);
		vf.getVp().getInputPanel().getImgInputNClaro().setVisible(false);
		vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(false);
		vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(false);
		vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(false);
		vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(false);
		vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(false);
		vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(false);
		vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(false);
		vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(false);
		vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(false);

		if (agregar == true && nacional == true && dark == true) {
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(true);
		}

		if (agregar == true && nacional == true && white == true) {
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(true);
			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(false);
		}

		if (agregar == true && internacional == true && dark == true) {
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(false);
		}

		if (agregar == true && internacional == true && white == true) {
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(true);
			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(false);
		}

		if (eliminar == true && nacional == true && dark == true) {
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(true);
		}

		if (eliminar == true && nacional == true && white == true) {
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(true);
			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(false);
		}

		if (eliminar == true && internacional == true && dark == true) {
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(false);
		}

		if (eliminar == true && internacional == true && white == true) {
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(true);
			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(false);
		}

		if (actualizar == true && nacional == true && dark == true) {
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(true);
		}

		if (actualizar == true && nacional == true && white == true) {
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(true);
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(false);
		}

		if (actualizar == true && internacional == true && dark == true) {
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(false);
		}

		if (actualizar == true && internacional == true && white == true) {
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(true);
			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(false);
		}

	}

	public void setearFondo() {

		if (dark == true && white == false) {
			// WELCOME
			vf.getVp().getWelcomePanel().getImgDark().setVisible(true);
			vf.getVp().getWelcomePanel().getImgWhite().setVisible(false);

			// ADMIN
			vf.getVp().getManagePanel().getImgDark().setVisible(true);
			vf.getVp().getManagePanel().getImgWhite().setVisible(false);

			// USER
			vf.getVp().getUserPanel().getImgDark().setVisible(true);
			vf.getVp().getUserPanel().getImgWhite().setVisible(false);

			// CRUD
			vf.getVp().getCrudPanel().getImgInterCrudOscuro().setVisible(true);
			vf.getVp().getCrudPanel().getImgInterCrudClaro().setVisible(false);

			vf.getVp().getCrudPanel().getImgNacionalCrudOscuro().setVisible(true);
			vf.getVp().getCrudPanel().getImgNacionalCrudClaro().setVisible(false);

			// INPUT

			// ======AGREGAR=======
			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(false);

			// ======DELETE========
			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(false);

			// ======VERIFICAR========
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(false);

		}

		if (dark == false && white == true) {
			// WELCOME
			vf.getVp().getWelcomePanel().getImgDark().setVisible(false);
			vf.getVp().getWelcomePanel().getImgWhite().setVisible(true);

			// ADMIN
			vf.getVp().getManagePanel().getImgDark().setVisible(false);
			vf.getVp().getManagePanel().getImgWhite().setVisible(true);

			// USER
			vf.getVp().getUserPanel().getImgDark().setVisible(false);
			vf.getVp().getUserPanel().getImgWhite().setVisible(true);

			// CRUD
			vf.getVp().getCrudPanel().getImgInterCrudOscuro().setVisible(false);
			vf.getVp().getCrudPanel().getImgInterCrudClaro().setVisible(true);

			vf.getVp().getCrudPanel().getImgNacionalCrudOscuro().setVisible(false);
			vf.getVp().getCrudPanel().getImgNacionalCrudClaro().setVisible(true);

			// INPUT
			// ======AGREGAR=======
			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(true);

			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(true);

			// ======DELETE========
			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(true);

			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(true);

			// ======VERIFICAR========
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(true);

			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(true);
		}

	}

	public void setearPorTipo() {

		if (nacional == true && internacional == false && dark == true && white == false) {
			// CRUD
			vf.getVp().getCrudPanel().getImgNacionalCrudOscuro().setVisible(true);
			vf.getVp().getCrudPanel().getImgNacionalCrudClaro().setVisible(false);

			vf.getVp().getCrudPanel().getImgInterCrudOscuro().setVisible(false);
			vf.getVp().getCrudPanel().getImgInterCrudClaro().setVisible(false);

			// INPUT

			// ------AGREGAR--------
			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(false);

			// =====ELIMINAR========
			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(false);

			// ======VERIFICAR========
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(false);

		}

		if (nacional == true && internacional == false && dark == false && white == true) {
			// CRUD
			vf.getVp().getCrudPanel().getImgNacionalCrudOscuro().setVisible(false);
			vf.getVp().getCrudPanel().getImgNacionalCrudClaro().setVisible(true);

			vf.getVp().getCrudPanel().getImgInterCrudOscuro().setVisible(false);
			vf.getVp().getCrudPanel().getImgInterCrudClaro().setVisible(false);

			// INPUT

			// ------AGREGAR--------
			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(true);

			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(false);

			// =====ELIMINAR========
			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(true);

			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(false);

			// ======VERIFICAR========
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(true);

			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(false);
		}

		if (nacional == false && internacional == true && dark == true && white == false) {
			// CRUD
			vf.getVp().getCrudPanel().getImgNacionalCrudOscuro().setVisible(false);
			vf.getVp().getCrudPanel().getImgNacionalCrudClaro().setVisible(false);

			vf.getVp().getCrudPanel().getImgInterCrudOscuro().setVisible(true);
			vf.getVp().getCrudPanel().getImgInterCrudClaro().setVisible(false);

			// INPUT

			// ------AGREGAR--------
			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(false);

			// =====ELIMINAR========
			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(false);

			// ======VERIFICAR========
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(true);
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(false);
		}

		if (nacional == false && internacional == true && dark == false && white == true) {
			// CRUD
			vf.getVp().getCrudPanel().getImgNacionalCrudOscuro().setVisible(false);
			vf.getVp().getCrudPanel().getImgNacionalCrudClaro().setVisible(false);

			vf.getVp().getCrudPanel().getImgInterCrudOscuro().setVisible(false);
			vf.getVp().getCrudPanel().getImgInterCrudClaro().setVisible(true);
			// INPUT

			// ------AGREGAR--------
			vf.getVp().getInputPanel().getImgInputNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgInputIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgInputIClaro().setVisible(true);

			// =====ELIMINAR========aaa
			vf.getVp().getInputPanel().getImgDeleteNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgDeleteIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgDeleteIClaro().setVisible(true);

			// ======VERIFICAR========
			vf.getVp().getInputPanel().getImgVerificarNOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarNClaro().setVisible(false);

			vf.getVp().getInputPanel().getImgVerificarIOscuro().setVisible(false);
			vf.getVp().getInputPanel().getImgVerificarIClaro().setVisible(true);
		}

	}

	public void setearFieldsCRUD() {

		if (agregar == true) {
			if (nacional == true) {
				if (agregar == true && eliminar == false && actualizar == false) {
					vf.getVp().getInputPanel().getDestinoField().setVisible(true);
					vf.getVp().getInputPanel().getPasajerosField().setVisible(true);
					vf.getVp().getInputPanel().getSalidaField().setVisible(true);
					vf.getVp().getInputPanel().getLlegadaField().setVisible(true);
					vf.getVp().getInputPanel().getPropio1Field().setVisible(true);
					vf.getVp().getInputPanel().getPropio2Field().setVisible(true);
					vf.getVp().getInputPanel().getCompaniaBtn().setVisible(true);
				}
			}

			if (internacional == true) {
				if (agregar == true && eliminar == false && actualizar == false) {
					vf.getVp().getInputPanel().getDestinoField().setVisible(true);
					vf.getVp().getInputPanel().getPasajerosField().setVisible(true);
					vf.getVp().getInputPanel().getSalidaField().setVisible(true);
					vf.getVp().getInputPanel().getLlegadaField().setVisible(true);
					vf.getVp().getInputPanel().getPropio1Field().setVisible(true);
					vf.getVp().getInputPanel().getPropio2Field().setVisible(false);
					vf.getVp().getInputPanel().getCompaniaBtn().setVisible(true);
				}
			}
		}
		if (eliminar == true || actualizar == true) {

			if (nacional == true) {
				if (agregar == false && eliminar == true && actualizar == false) {
					vf.getVp().getInputPanel().getDestinoField().setVisible(true);
					vf.getVp().getInputPanel().getCompaniaBtn().setVisible(true);
					vf.getVp().getInputPanel().getLlegadaField().setVisible(true);
					vf.getVp().getInputPanel().getPasajerosField().setVisible(false);
					vf.getVp().getInputPanel().getSalidaField().setVisible(false);
					vf.getVp().getInputPanel().getPropio1Field().setVisible(false);
					vf.getVp().getInputPanel().getPropio2Field().setVisible(false);

				}
			}

			if (internacional == true) {
				if (agregar == false && eliminar == true && actualizar == false) {
					vf.getVp().getInputPanel().getDestinoField().setVisible(true);
					vf.getVp().getInputPanel().getCompaniaBtn().setVisible(true);
					vf.getVp().getInputPanel().getLlegadaField().setVisible(true);
					vf.getVp().getInputPanel().getPasajerosField().setVisible(false);
					vf.getVp().getInputPanel().getSalidaField().setVisible(false);
					vf.getVp().getInputPanel().getPropio1Field().setVisible(false);
					vf.getVp().getInputPanel().getPropio2Field().setVisible(false);

				}
			}

		}
	}

	public void agregar() {

		if (nacional == true && internacional == false) {

			try {
				boolean validarRandom = true;

				String destino = vf.getVp().getInputPanel().getDestinoField().getText();
				ExceptionChecker.notValidInputException(destino);

				String companyInCharge = company;
				ExceptionChecker.notValidInputException(companyInCharge);

				int passenger = Integer.parseInt(vf.getVp().getInputPanel().getPasajerosField().getText());
				ExceptionChecker.negativeIntNumberException(passenger);

				String departureTime = vf.getVp().getInputPanel().getSalidaField().getText();
				ExceptionChecker.notValidTimeFormatException(departureTime);

				String arrivalTime = vf.getVp().getInputPanel().getLlegadaField().getText();
				ExceptionChecker.notValidTimeFormatException(arrivalTime);

				if (!verificarTiempo(departureTime, arrivalTime)) {
					horaInvalida = true;
				} else {
					horaInvalida = false;
				}

				String helice = vf.getVp().getInputPanel().getPropio1Field().getText();
				boolean esHelice = vf.getCon().leerBoolean(helice);
				ExceptionChecker.notValidBooleanException(esHelice);

				String turbina = vf.getVp().getInputPanel().getPropio2Field().getText();
				boolean esTurbina = vf.getCon().leerBoolean(turbina);
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
					vf.getCon().mostrarMensajeEmergente("CREADO EXITOSAMENTE");
				} else {
					vf.getCon().mostrarAlerta("NO SE PUDO CREAR");
				}

			} catch (NegativeIntNumberException e) {
				vf.getCon().mostrarError("No puede ingresar numeros negativos");
			} catch (StringIndexOutOfBoundsException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidInputException e) {
				vf.getCon().mostrarError(
						"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
			} catch (NumberFormatException e) {
				vf.getCon().mostrarError("Ingrese correctamente los datos numericos, use numeros enteros");
			} catch (NotValidTimeFormatException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidBooleanException e) {
				vf.getCon().mostrarError("En campos de respuesta para pregunta SI / NO, conteste con si o no");
			}
		}

		if (nacional == false && internacional == true) {

			try {
				boolean validarRandom = true;

				String destino = vf.getVp().getInputPanel().getDestinoField().getText();
				ExceptionChecker.notValidInputException(destino);

				String companyInCharge = company;
				ExceptionChecker.notValidInputException(companyInCharge);

				int passenger = Integer.parseInt(vf.getVp().getInputPanel().getPasajerosField().getText());
				ExceptionChecker.negativeIntNumberException(passenger);

				String departureTime = vf.getVp().getInputPanel().getSalidaField().getText();
				ExceptionChecker.notValidTimeFormatException(departureTime);

				String arrivalTime = vf.getVp().getInputPanel().getLlegadaField().getText();
				ExceptionChecker.notValidTimeFormatException(arrivalTime);

				if (!verificarTiempo(departureTime, arrivalTime)) {
					horaInvalida = true;
				} else {
					horaInvalida = false;
				}

				String visa = vf.getVp().getInputPanel().getPropio1Field().getText();
				boolean requiresVisa = vf.getCon().leerBoolean(visa);
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
					vf.getCon().mostrarMensajeEmergente("CREADO EXITOSAMENTE");
				} else {
					vf.getCon().mostrarAlerta("NO SE PUDO CREAR, VERIFIQUE QUE NO SEA IDENTICO A OTRO VUELO");
				}

			} catch (NegativeIntNumberException e) {
				vf.getCon().mostrarError("No puede ingresar numeros negativos");
			} catch (StringIndexOutOfBoundsException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidInputException e) {
				vf.getCon().mostrarError(
						"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
			} catch (NumberFormatException e) {
				vf.getCon().mostrarError("Ingrese correctamente los datos numericos, use numeros enteros");
			} catch (NotValidTimeFormatException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidBooleanException e) {
				vf.getCon().mostrarError("En campos de respuesta para pregunta SI / NO, conteste con si o no");
			}
		}
	}

	public void eliminar() {

		if (nacional == true && internacional == false) {
			try {
				String companiaA = company;
				ExceptionChecker.notValidInputException(companiaA);

				String destinoA = vf.getVp().getInputPanel().getDestinoField().getText();
				ExceptionChecker.notValidInputException(destinoA);

				String hLlegadaA = vf.getVp().getInputPanel().getLlegadaField().getText();
				ExceptionChecker.notValidTimeFormatException(hLlegadaA);

				if (mf.getvNacionalDAO().delete(new VueloNacionalDTO(destinoA, companiaA, 0, null, null, hLlegadaA,
						null, 0, false, false)) == false) {
					vf.getCon().mostrarAlerta("No fue encontrado el vuelo, verifique los datos ingresados");
				} else {
					vf.getCon().mostrarMensajeEmergente("Vuelo Eliminado Exitosamente");

				}
			} catch (StringIndexOutOfBoundsException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidTimeFormatException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");

			} catch (NotValidInputException e) {
				vf.getCon().mostrarError(
						"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
			}
		}

		if (nacional == false && internacional == true) {
			try {
				vf.getCon().printLine("ELIMINANDO");
				vf.getCon().printLine("compania");
				String companiaA = company;
				ExceptionChecker.notValidInputException(companiaA);

				vf.getCon().printLine("destino");
				String destinoA = vf.getVp().getInputPanel().getDestinoField().getText();
				ExceptionChecker.notValidInputException(destinoA);

				vf.getCon().printLine("llegada");
				String hLlegadaA = vf.getVp().getInputPanel().getLlegadaField().getText();
				ExceptionChecker.notValidTimeFormatException(hLlegadaA);

				if (mf.getvInternacionalDAO().delete(new VueloInternacionalDTO(destinoA, companiaA, 0, null, null,
						hLlegadaA, null, 0, false)) == false) {
					vf.getCon().mostrarAlerta("No fue encontrado el vuelo, verifique los datos ingresados");
				} else {
					vf.getCon().mostrarMensajeEmergente("Vuelo Eliminado Exitosamente");

				}
			} catch (StringIndexOutOfBoundsException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidTimeFormatException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");

			} catch (NotValidInputException e) {
				vf.getCon().mostrarError(
						"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
			}

		}
	}

	public void actualizar() {

		if (nacional == true && internacional == false) {

			try {
				boolean validarRandom = true;

				String destino = vf.getVp().getInputPanel().getDestinoField().getText();
				ExceptionChecker.notValidInputException(destino);

				String companyInCharge = company;
				ExceptionChecker.notValidInputException(companyInCharge);

				int passenger = Integer.parseInt(vf.getVp().getInputPanel().getPasajerosField().getText());
				ExceptionChecker.negativeIntNumberException(passenger);

				String departureTime = vf.getVp().getInputPanel().getSalidaField().getText();
				ExceptionChecker.notValidTimeFormatException(departureTime);

				String arrivalTime = vf.getVp().getInputPanel().getLlegadaField().getText();
				ExceptionChecker.notValidTimeFormatException(arrivalTime);

				if (!verificarTiempo(departureTime, arrivalTime)) {
					horaInvalida = true;
				} else {
					horaInvalida = false;
				}

				String helice = vf.getVp().getInputPanel().getPropio1Field().getText();
				boolean esHelice = vf.getCon().leerBoolean(helice);
				ExceptionChecker.notValidBooleanException(esHelice);

				String turbina = vf.getVp().getInputPanel().getPropio2Field().getText();
				boolean esTurbina = vf.getCon().leerBoolean(turbina);
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
						new VueloNacionalDTO(destino, companyInCharge, passenger, captain, secondOnCommand, arrivalTime,
								departureTime, gas, esTurbina, esHelice)) == true) {
					vf.getCon().mostrarMensajeEmergente("CREADO EXITOSAMENTE");
				} else {
					vf.getCon().mostrarAlerta("NO SE PUDO CREAR");
				}

			} catch (NegativeIntNumberException e) {
				vf.getCon().mostrarError("No puede ingresar numeros negativos");
			} catch (StringIndexOutOfBoundsException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidInputException e) {
				vf.getCon().mostrarError(
						"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
			} catch (NumberFormatException e) {
				vf.getCon().mostrarError("Ingrese correctamente los datos numericos, use numeros enteros");
			} catch (NotValidTimeFormatException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidBooleanException e) {
				vf.getCon().mostrarError("En campos de respuesta para pregunta SI / NO, conteste con si o no");
			}
		}

		if (nacional == false && internacional == true) {
			try {
				boolean validarRandom = true;

				String destino = vf.getVp().getInputPanel().getDestinoField().getText();
				ExceptionChecker.notValidInputException(destino);

				String companyInCharge = company;
				ExceptionChecker.notValidInputException(companyInCharge);

				int passenger = Integer.parseInt(vf.getVp().getInputPanel().getPasajerosField().getText());
				ExceptionChecker.negativeIntNumberException(passenger);

				String departureTime = vf.getVp().getInputPanel().getSalidaField().getText();
				ExceptionChecker.notValidTimeFormatException(departureTime);

				String arrivalTime = vf.getVp().getInputPanel().getLlegadaField().getText();
				ExceptionChecker.notValidTimeFormatException(arrivalTime);

				if (!verificarTiempo(departureTime, arrivalTime)) {
					horaInvalida = true;
				} else {
					horaInvalida = false;
				}

				String visa = vf.getVp().getInputPanel().getPropio1Field().getText();
				boolean requiresVisa = vf.getCon().leerBoolean(visa);
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
					vf.getCon().mostrarMensajeEmergente("CREADO EXITOSAMENTE");
				} else {
					vf.getCon().mostrarAlerta("NO SE PUDO CREAR");
				}
			} catch (NegativeIntNumberException e) {
				vf.getCon().mostrarError("No puede ingresar numeros negativos");
			} catch (StringIndexOutOfBoundsException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidInputException e) {
				vf.getCon().mostrarError(
						"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
			} catch (NumberFormatException e) {
				vf.getCon().mostrarError("Ingrese correctamente los datos numericos, use numeros enteros");
			} catch (NotValidTimeFormatException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidBooleanException e) {
				vf.getCon().mostrarError("En campos de respuesta para pregunta SI / NO, conteste con si o no");
			}
		}

	}

	public void VerificarActualizar() {

		if (nacional == true && internacional == false) {
			try {
				companiaA = company;
				ExceptionChecker.notValidInputException(companiaA);

				destinoA = vf.getVp().getInputPanel().getDestinoField().getText();
				ExceptionChecker.notValidInputException(destinoA);

				llegadaA = vf.getVp().getInputPanel().getLlegadaField().getText();
				ExceptionChecker.notValidTimeFormatException(llegadaA);

				if (mf.getvNacionalDAO().find(new VueloNacional(destinoA, companiaA, 0, null, null, llegadaA, null, 0,
						false, false)) == null) {
					vf.getCon().mostrarAlerta("No fue encontrado el vuelo, verifique los datos ingresados");
				} else {
					vf.getCon().mostrarMensajeEmergente("Vuelo encontrado, ingrese los datos a actualizar");
				}
			} catch (StringIndexOutOfBoundsException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidTimeFormatException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidInputException e) {
				vf.getCon().mostrarError(
						"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
			}
		}

		if (nacional == false && internacional == true) {
			try {
				companiaA = company;
				ExceptionChecker.notValidInputException(companiaA);

				destinoA = vf.getVp().getInputPanel().getDestinoField().getText();
				ExceptionChecker.notValidInputException(destinoA);

				llegadaA = vf.getVp().getInputPanel().getLlegadaField().getText();
				ExceptionChecker.notValidTimeFormatException(llegadaA);

				if (mf.getvInternacionalDAO().find(
						new VueloInternacional(destinoA, companiaA, 0, null, null, llegadaA, null, 0, false)) == null) {
					vf.getCon().mostrarAlerta("No fue encontrado el vuelo, verifique los datos ingresados");
				} else {
					vf.getCon().mostrarMensajeEmergente("Vuelo encontrado, ingrese los datos a actualizar");
				}
			} catch (StringIndexOutOfBoundsException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");
			} catch (NotValidTimeFormatException e) {
				vf.getCon().mostrarError("Formato de hora no valido, recuerde hh:mm (24:00)");

			} catch (NotValidInputException e) {
				vf.getCon().mostrarError(
						"No puede ingresar caracteres especiales o numeros en campos de nombres o palabras");
			}
		}
	}

}
