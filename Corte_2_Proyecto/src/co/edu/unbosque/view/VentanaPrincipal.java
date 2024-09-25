package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
//
	public VentanaPrincipal() {

		setLocation(40, 40);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setTitle("EL DORADO");

		ImageIcon logoApp = new ImageIcon("src/media/Logo.jpg");
		setIconImage(logoApp.getImage());

	}

}
