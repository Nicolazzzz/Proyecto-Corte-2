package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WelcomePanel welcomePanel;
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

		ImageIcon logoApp = new ImageIcon("src/media/Logo.jpg");
		setIconImage(logoApp.getImage());

		managePanel = new ManagePanel();
		welcomePanel = new WelcomePanel();

	}

	public void mostrarPanelManage() {
		setContentPane(managePanel);
	}

	public void mostrarPanelWelcome() {
		setContentPane(welcomePanel);
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
