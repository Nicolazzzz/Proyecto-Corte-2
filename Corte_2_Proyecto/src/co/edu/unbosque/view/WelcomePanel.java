
package co.edu.unbosque.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * WelcomePanel is a JPanel that represents the welcome screen of the
 * application. It provides options for the user to navigate to the admin or
 * user sections, and a button to change the background theme between light and
 * dark modes.
 * 
 * @author Santiago
 * @version 1.0
 */
public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel imgDark, imgWhite;
	private JButton adminBtn, userBtn, backgroungBtn;

	/**
	 * Constructs the WelcomePanel, setting up its layout, background images, and
	 * buttons for interacting with the application.
	 */
	public WelcomePanel() {

		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		imgDark = new JLabel();
		ImageIcon imagenPortada1 = new ImageIcon("src/media/BienvenidaOscuro.png");
		Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgDark.setIcon(new ImageIcon(portadaRedimensionada));
		imgDark.setBounds(0, 0, 1280, 720);
		imgDark.setVisible(true);

		imgWhite = new JLabel();
		ImageIcon imagenPortada2 = new ImageIcon("src/media/BienvenidaClaro.png");
		Image portadaRedimensionada2 = imagenPortada2.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgWhite.setIcon(new ImageIcon(portadaRedimensionada2));
		imgWhite.setBounds(0, 0, 1280, 720);
		imgWhite.setVisible(true);

		adminBtn = new JButton("ADMIN BTN");
		adminBtn.setOpaque(false);
		adminBtn.setBounds(480, 406, 320, 70);
		adminBtn.setActionCommand("ADMIN");
		adminBtn.setToolTipText("PROGRAMA PARA ADMINISTRADORES");

		userBtn = new JButton("USER BTN");
		userBtn.setOpaque(false);
		userBtn.setBounds(480, 530, 320, 70);
		userBtn.setActionCommand("USER");
		userBtn.setToolTipText("CONSULTA DE VUELOS PARA USUARIOS");

		backgroungBtn = new JButton("BACKGROUND");
		backgroungBtn.setOpaque(false);
		backgroungBtn.setBounds(1148, 29, 102, 102);
		backgroungBtn.setActionCommand("FONDO");
		backgroungBtn.setToolTipText("CAMBIAR TEMA");

		add(imgDark);
		add(imgWhite);
		add(adminBtn);
		add(userBtn);
		add(backgroungBtn);
	}

	/**
	 * Gets the dark-themed background image.
	 * 
	 * @return the imgDark
	 */
	public JLabel getImgDark() {
		return imgDark;
	}

	/**
	 * Sets the dark-themed background image.
	 * 
	 * @param imgDark the imgDark to set
	 */
	public void setImgDark(JLabel imgDark) {
		this.imgDark = imgDark;
	}

	/**
	 * Gets the light-themed background image.
	 * 
	 * @return the imgWhite
	 */
	public JLabel getImgWhite() {
		return imgWhite;
	}

	/**
	 * Sets the light-themed background image.
	 * 
	 * @param imgWhite the imgWhite to set
	 */
	public void setImgWhite(JLabel imgWhite) {
		this.imgWhite = imgWhite;
	}

	/**
	 * Gets the admin button.
	 * 
	 * @return the adminBtn
	 */
	public JButton getAdminBtn() {
		return adminBtn;
	}

	/**
	 * Sets the admin button.
	 * 
	 * @param adminBtn the adminBtn to set
	 */
	public void setAdminBtn(JButton adminBtn) {
		this.adminBtn = adminBtn;
	}

	/**
	 * Gets the user button.
	 * 
	 * @return the userBtn
	 */
	public JButton getUserBtn() {
		return userBtn;
	}

	/**
	 * Sets the user button.
	 * 
	 * @param userBtn the userBtn to set
	 */
	public void setUserBtn(JButton userBtn) {
		this.userBtn = userBtn;
	}

	/**
	 * Gets the button used to change the background theme.
	 * 
	 * @return the backgroungBtn
	 */
	public JButton getBackgroungBtn() {
		return backgroungBtn;
	}

	/**
	 * Sets the button to change the background theme.
	 * 
	 * @param backgroungBtn the backgroungBtn to set
	 */
	public void setBackgroungBtn(JButton backgroungBtn) {
		this.backgroungBtn = backgroungBtn;
	}
}
