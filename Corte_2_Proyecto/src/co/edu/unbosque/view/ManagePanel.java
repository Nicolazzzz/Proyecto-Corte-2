package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ManagePanel is a JPanel that manages the graphical interface for managing
 * different flight options, including international, national, and file
 * generation buttons, as well as a return button. It also displays background
 * images based on the flight theme.
 * 
 * @author YourName
 * @version 1.0
 */
public class ManagePanel extends JPanel {

	/**
	 * Serialization ID for this class.
	 */
	private static final long serialVersionUID = 1L;

	private JButton internacionalBtn, nacionalBtn, generarBtn, volverBtn;
	private JLabel imgWhite, imgDark;

	/**
	 * Constructs a ManagePanel and initializes all its components such as buttons
	 * and background images. The layout is set to null, and the panel is made
	 * visible.
	 */
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
		internacionalBtn.setOpaque(false);
		internacionalBtn.setBounds(480, 433, 321, 71);
		internacionalBtn.setActionCommand("INTERNACIONAL");
		internacionalBtn.setToolTipText("ADMINISTRAR VUELOS INTERNACIONALES");

		nacionalBtn = new JButton("NACIONAL BTN");
		nacionalBtn.setOpaque(false);
		nacionalBtn.setBounds(480, 324, 321, 71);
		nacionalBtn.setActionCommand("NACIONAL");
		nacionalBtn.setToolTipText("ADMINISTRAR VUELOS NACIONALES");

		generarBtn = new JButton("GENERAR FILE");
		generarBtn.setOpaque(false);
		generarBtn.setBounds(480, 542, 321, 71);
		generarBtn.setActionCommand("GENERARFILE");
		generarBtn.setToolTipText("GENERAR ARCHIVO DE VUELOS");

		volverBtn = new JButton("VOLVER BUTTON");
		volverBtn.setOpaque(false);
		volverBtn.setBounds(848, 533, 94, 94);
		volverBtn.setToolTipText("PUTO EL QUE LO LEA");
		volverBtn.setActionCommand("VOLVERADMIN");
		volverBtn.setToolTipText("VOLVER AL MENÚ PRINCIPAL");

		add(imgWhite);
		add(imgDark);
		add(internacionalBtn);
		add(nacionalBtn);
		add(generarBtn);
		add(volverBtn);
	}

	/**
	 * Gets the international button.
	 * 
	 * @return the internacionalBtn
	 */
	public JButton getInternacionalBtn() {
		return internacionalBtn;
	}

	/**
	 * Sets the international button.
	 * 
	 * @param internacionalBtn the internacionalBtn to set
	 */
	public void setInternacionalBtn(JButton internacionalBtn) {
		this.internacionalBtn = internacionalBtn;
	}

	/**
	 * Gets the national button.
	 * 
	 * @return the nacionalBtn
	 */
	public JButton getNacionalBtn() {
		return nacionalBtn;
	}

	/**
	 * Sets the national button.
	 * 
	 * @param nacionalBtn the nacionalBtn to set
	 */
	public void setNacionalBtn(JButton nacionalBtn) {
		this.nacionalBtn = nacionalBtn;
	}

	/**
	 * Gets the file generation button.
	 * 
	 * @return the generarBtn
	 */
	public JButton getGenerarBtn() {
		return generarBtn;
	}

	/**
	 * Sets the file generation button.
	 * 
	 * @param generarBtn the generarBtn to set
	 */
	public void setGenerarBtn(JButton generarBtn) {
		this.generarBtn = generarBtn;
	}

	/**
	 * Gets the return button.
	 * 
	 * @return the volverBtn
	 */
	public JButton getVolverBtn() {
		return volverBtn;
	}

	/**
	 * Sets the return button.
	 * 
	 * @param volverBtn the volverBtn to set
	 */
	public void setVolverBtn(JButton volverBtn) {
		this.volverBtn = volverBtn;
	}

	/**
	 * Gets the white-themed image label.
	 * 
	 * @return the imgWhite
	 */
	public JLabel getImgWhite() {
		return imgWhite;
	}

	/**
	 * Sets the white-themed image label.
	 * 
	 * @param imgWhite the imgWhite to set
	 */
	public void setImgWhite(JLabel imgWhite) {
		this.imgWhite = imgWhite;
	}

	/**
	 * Gets the dark-themed image label.
	 * 
	 * @return the imgDark
	 */
	public JLabel getImgDark() {
		return imgDark;
	}

	/**
	 * Sets the dark-themed image label.
	 * 
	 * @param imgDark the imgDark to set
	 */
	public void setImgDark(JLabel imgDark) {
		this.imgDark = imgDark;
	}

}
