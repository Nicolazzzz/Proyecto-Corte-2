
package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	/**
	 * VentanaPrincipal is the main window for the application, extending JFrame. It
	 * manages various panels for the application such as the welcome, user, manage,
	 * and CRUD panels, allowing users to navigate between them.
	 * 
	 * @author Sebastian
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	private WelcomePanel welcomePanel;
	private UserPanel userPanel;
	private ManagePanel managePanel;
	private CrudPanel crudPanel;
	private InputPanel inputPanel;

	/**
	 * Constructs the main window, setting its size, title, layout, and icon. It
	 * also initializes various panels such as the manage, welcome, user, CRUD, and
	 * input panels.
	 */
	public VentanaPrincipal() {

		setLocation(40, 40);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setTitle("EL DORADO");

		ImageIcon logoApp = new ImageIcon("src/logo/Logo.png");
		setIconImage(logoApp.getImage());

		managePanel = new ManagePanel();
		welcomePanel = new WelcomePanel();
		userPanel = new UserPanel();
		crudPanel = new CrudPanel();
		inputPanel = new InputPanel();
	}

	/**
	 * Displays the manage panel in the main window.
	 */
	public void mostrarPanelManage() {
		setContentPane(managePanel);
	}

	/**
	 * Displays the welcome panel in the main window.
	 */
	public void mostrarPanelWelcome() {
		setContentPane(welcomePanel);
	}

	/**
	 * Displays the user panel in the main window.
	 */
	public void mostrarPanelUser() {
		setContentPane(userPanel);
	}

	/**
	 * Displays the CRUD panel in the main window.
	 */
	public void mostrarPanelCrud() {
		setContentPane(crudPanel);
	}

	/**
	 * Displays the input panel in the main window.
	 */
	public void mostrarPanelInput() {
		setContentPane(inputPanel);
	}

	/**
	 * Gets the input panel.
	 * 
	 * @return the inputPanel
	 */
	public InputPanel getInputPanel() {
		return inputPanel;
	}

	/**
	 * Sets the input panel.
	 * 
	 * @param inputPanel the inputPanel to set
	 */
	public void setInputPanel(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	/**
	 * Gets the CRUD panel.
	 * 
	 * @return the crudPanel
	 */
	public CrudPanel getCrudPanel() {
		return crudPanel;
	}

	/**
	 * Sets the CRUD panel.
	 * 
	 * @param crudPanel the crudPanel to set
	 */
	public void setCrudPanel(CrudPanel crudPanel) {
		this.crudPanel = crudPanel;
	}

	/**
	 * Gets the manage panel.
	 * 
	 * @return the managePanel
	 */
	public ManagePanel getManagePanel() {
		return managePanel;
	}

	/**
	 * Sets the manage panel.
	 * 
	 * @param managePanel the managePanel to set
	 */
	public void setManagePanel(ManagePanel managePanel) {
		this.managePanel = managePanel;
	}

	/**
	 * Gets the welcome panel.
	 * 
	 * @return the welcomePanel
	 */
	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	/**
	 * Sets the welcome panel.
	 * 
	 * @param welcomePanel the welcomePanel to set
	 */
	public void setWelcomePanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}

	/**
	 * Gets the serialization version UID.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the user panel.
	 * 
	 * @return the userPanel
	 */
	public UserPanel getUserPanel() {
		return userPanel;
	}

	/**
	 * Sets the user panel.
	 * 
	 * @param userPanel the userPanel to set
	 */
	public void setUserPanel(UserPanel userPanel) {
		this.userPanel = userPanel;
	}
}
