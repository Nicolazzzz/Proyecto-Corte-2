package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagePanel extends JPanel {

	/**
	 * a
	 */
	private static final long serialVersionUID = 1L;
	private JButton internacionalBtn, nacionalBtn, generarBtn, volverBtn;
	private JLabel imgWhite, imgDark;

	public ManagePanel() {
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		imgWhite = new JLabel();
		ImageIcon imagenPortada1 = new ImageIcon("src/media/VuelosClaro.png");
		Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgWhite.setIcon(new ImageIcon(portadaRedimensionada));
		imgWhite.setBounds(0, 0, 1280, 720);
		imgWhite.setVisible(true);

		imgDark = new JLabel();
		ImageIcon imagenPortada2 = new ImageIcon("src/media/VuelosOscuro.png");
		Image portadaRedimensionada2 = imagenPortada2.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgDark.setIcon(new ImageIcon(portadaRedimensionada2));
		imgDark.setBounds(0, 0, 1280, 720);
		imgDark.setVisible(true);

		internacionalBtn = new JButton("INTERNACIONAL BTN");
		internacionalBtn.setOpaque(true);
		internacionalBtn.setBounds(10, 10, 200, 50);
		internacionalBtn.setActionCommand("INTERNACIONAL");

		nacionalBtn = new JButton("NACIONAL BTN");
		nacionalBtn.setOpaque(true);
		nacionalBtn.setBounds(10, 60, 200, 50);
		nacionalBtn.setActionCommand("NACIONAL");

		generarBtn = new JButton("GENERAR FILE");
		generarBtn.setOpaque(true);
		generarBtn.setBounds(10, 110, 200, 50);
		generarBtn.setActionCommand("GENERARFILE");

		volverBtn = new JButton("VOLVER BUTTON");
		volverBtn.setOpaque(true);
		volverBtn.setBounds(10, 160, 200, 50);
		volverBtn.setActionCommand("VOLVERADMIN");

		add(imgWhite);
		add(imgDark);
		add(internacionalBtn);
		add(nacionalBtn);
		add(generarBtn);
		add(volverBtn);

	}

	/**
	 * @return the internacionalBtn
	 */
	public JButton getInternacionalBtn() {
		return internacionalBtn;
	}

	/**
	 * @param internacionalBtn the internacionalBtn to set
	 */
	public void setInternacionalBtn(JButton internacionalBtn) {
		this.internacionalBtn = internacionalBtn;
	}

	/**
	 * @return the nacionalBtn
	 */
	public JButton getNacionalBtn() {
		return nacionalBtn;
	}

	/**
	 * @param nacionalBtn the nacionalBtn to set
	 */
	public void setNacionalBtn(JButton nacionalBtn) {
		this.nacionalBtn = nacionalBtn;
	}

	/**
	 * @return the generarBtn
	 */
	public JButton getGenerarBtn() {
		return generarBtn;
	}

	/**
	 * @param generarBtn the generarBtn to set
	 */
	public void setGenerarBtn(JButton generarBtn) {
		this.generarBtn = generarBtn;
	}

	/**
	 * @return the volverBtn
	 */
	public JButton getVolverBtn() {
		return volverBtn;
	}

	/**
	 * @param volverBtn the volverBtn to set
	 */
	public void setVolverBtn(JButton volverBtn) {
		this.volverBtn = volverBtn;
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

}
