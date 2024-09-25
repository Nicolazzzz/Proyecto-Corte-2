package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel imgDark, imgWhite;
	private JButton adminBtn, userBtn, backgroungBtn;

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
		adminBtn.setOpaque(true);
		adminBtn.setBounds(10, 10, 200, 50);
		adminBtn.setActionCommand("ADMIN");

		userBtn = new JButton("USER BTN");
		userBtn.setOpaque(true);
		userBtn.setBounds(10, 60, 200, 50);
		userBtn.setActionCommand("USER");

		backgroungBtn = new JButton("BACKGROUND");
		backgroungBtn.setOpaque(true);
		backgroungBtn.setBounds(10, 110, 200, 50);
		backgroungBtn.setActionCommand("FONDO");

		add(imgDark);
		add(imgWhite);
		add(adminBtn);
		add(userBtn);
		add(backgroungBtn);
	}

	/**
	 * @return the imgDark
	 */
	public JLabel getImgDark() {
		return imgDark;
	}

	/**
	 * @param imgDark the imgDark to set
	 */
	public void setImgDark(JLabel imgDark) {
		this.imgDark = imgDark;
	}

	/**
	 * @return the imgWhite
	 */
	public JLabel getImgWhite() {
		return imgWhite;
	}

	/**
	 * @param imgWhite the imgWhite to set
	 */
	public void setImgWhite(JLabel imgWhite) {
		this.imgWhite = imgWhite;
	}

	/**
	 * @return the adminBtn
	 */
	public JButton getAdminBtn() {
		return adminBtn;
	}

	/**
	 * @param adminBtn the adminBtn to set
	 */
	public void setAdminBtn(JButton adminBtn) {
		this.adminBtn = adminBtn;
	}

	/**
	 * @return the userBtn
	 */
	public JButton getUserBtn() {
		return userBtn;
	}

	/**
	 * @param userBtn the userBtn to set
	 */
	public void setUserBtn(JButton userBtn) {
		this.userBtn = userBtn;
	}

	/**
	 * @return the backgroungBtn
	 */
	public JButton getBackgroungBtn() {
		return backgroungBtn;
	}

	/**
	 * @param backgroungBtn the backgroungBtn to set
	 */
	public void setBackgroungBtn(JButton backgroungBtn) {
		this.backgroungBtn = backgroungBtn;
	}

}
