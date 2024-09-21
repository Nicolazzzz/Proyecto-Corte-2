package controller;

import java.util.Scanner;

import objects.PilotoDAO;
import objects.PilotoDTO;

public class Controller {

	private PilotoDAO dao;

	public Controller() {
		dao = new PilotoDAO();

		Scanner sc = new Scanner(System.in);

		mainloop: while (true) {

			System.out.println("opcion");
			int op = sc.nextInt();
			sc.nextLine();
			switch (op) {
			case 1:
				System.out.println("Nombre");
				String name = sc.nextLine();
				dao.add(new PilotoDTO(name));
				break;

			case 4:
				System.out.println("Borrando");
				String nameD = sc.nextLine();
				dao.delete(new PilotoDTO(nameD));
				break;
			case 2:
				System.out.println(dao.showAll());
				break;

			case 3:
				System.out.println("BYE BYE");
				break;

			default:
				System.out.println("IMBECIL");
				break mainloop;
			}
		}
	}

}
