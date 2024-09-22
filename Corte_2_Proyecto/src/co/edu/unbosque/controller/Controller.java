
package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller {

	private ModelFacade mf;
	private ViewFacade vf;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		run();
	}

	public void run() {

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
}
