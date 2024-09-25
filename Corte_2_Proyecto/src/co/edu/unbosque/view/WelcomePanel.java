package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	private JLabel img;
	private JButton adminBtn, userBtn, backgroungBtn;

	public WelcomePanel() {
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

	}

	/**
	 * @return the img
	 */
	public JLabel getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(JLabel img) {
		this.img = img;
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
