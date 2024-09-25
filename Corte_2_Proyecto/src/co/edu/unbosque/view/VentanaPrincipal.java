package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WelcomePanel welcomePanel;
	private UserPanel userPanel;
	private ManagePanel managePanel;
	private CrudPanel crudPanel;

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
		userPanel = new UserPanel();
		crudPanel = new CrudPanel();

	}

	public void mostrarPanelManage() {
		setContentPane(managePanel);
	}

	public void mostrarPanelWelcome() {
		setContentPane(welcomePanel);
	}

	public void mostrarPanelUser() {
		setContentPane(userPanel);
	}

	public void mostrarPanelCrud() {
		setContentPane(crudPanel);
	}

	/**
	 * @return the crudPanel
	 */
	public CrudPanel getCrudPanel() {
		return crudPanel;
	}

	/**
	 * @param crudPanel the crudPanel to set
	 */
	public void setCrudPanel(CrudPanel crudPanel) {
		this.crudPanel = crudPanel;
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

	/**
	 * @return the welcomePanel
	 */
	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	/**
	 * @param welcomePanel the welcomePanel to set
	 */
	public void setWelcomePanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the userPanel
	 */
	public UserPanel getUserPanel() {
		return userPanel;
	}

	/**
	 * @param userPanel the userPanel to set
	 */
	public void setUserPanel(UserPanel userPanel) {
		this.userPanel = userPanel;
	}

}
