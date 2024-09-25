package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private ManagePanel managePanel;

//
	public VentanaPrincipal() {

		setLocation(40, 40);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setTitle("EL DORADO");

		ImageIcon logoApp = new ImageIcon("src/media/logo.jpg");
		setIconImage(logoApp.getImage());

		managePanel = new ManagePanel();

	}

	public void mostrarPanelManage() {
		setContentPane(managePanel);
	}

	/**
	 * @return the managePanel
	 */
	public ManagePanel getManagePanel() {
		return managePanel;
	}

	/**
	 * @param managePanel the managePanel to set
	 */
	public void setManagePanel(ManagePanel managePanel) {
		this.managePanel = managePanel;
	}

}
