import java.util.Scanner;

class tiempo extends Exception {
	public tiempo() {

		super("Error en formato");

	}
}

public class main {

	public static void main(String[] args) {
		String entrada = "";
		Scanner sc = new Scanner(System.in);

		do {
			entrada = sc.nextLine();
			try {
				time(entrada);
			} catch (tiempo e) {
				// TODO Auto-generated catch block
				System.out.println("Formato de tiempo picho, recuerde que es militar 24:00");
			}
		} while (entrada != "h");

	}

	public static void time(String time) throws tiempo {

		boolean punticos = false;

		String contenido = time.charAt(2) + "";
		if (contenido.equals(":"))
			punticos = true;

		if (punticos != true) {
			throw new tiempo();
		}

		if (time.length() < 5 || time.length() > 5) {
			throw new tiempo();
		}

		if (punticos == true) {

			String[] horas = time.split(":");
			int hora = Integer.parseInt(horas[0]);
			int minutos = Integer.parseInt(horas[1]);

			if (hora < 0 || hora > 23 || minutos < 0 || minutos > 59)
				throw new tiempo();
			System.out.println(hora + "horas");
			System.out.println(minutos + "minutos");

		}

	}
	/*
	 * for (int i = 1; i < 2; i++) { String prueba = time.charAt(i) + ""; if
	 * (prueba.equals(":")) punticos = true; } if (punticos != true) {
	 * System.out.println("ESTA RE MAL"); }
	 * 
	 * String[] horas = time.split(":"); for (int i = 0; i < horas.length; i++) {
	 * System.out.println(horas[i]); } /* String minuto = ""; String hora1 =
	 * time.charAt(0) + ""; String hora2 = time.charAt(1) + ""; minuto +=
	 * time.charAt(3) + ""; minuto += time.charAt(4);
	 * 
	 * System.out.println(hora1); System.out.println(hora2);
	 * System.out.println(minuto);
	 */

}
