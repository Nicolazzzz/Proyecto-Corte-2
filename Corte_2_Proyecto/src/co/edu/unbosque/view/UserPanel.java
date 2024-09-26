
package co.edu.unbosque.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * UserPanel is a JPanel designed for user interaction, allowing them to search
 * for destinations. It provides a search field and buttons for searching and
 * returning, along with background images that change depending on the theme.
 * 
 * @author Santiago
 * @version 1.0
 */
public class UserPanel extends JPanel {

	private JLabel imgDark, imgWhite;
	private JTextField destinoField;
	private JButton volverBtn, buscarBtn;

	/**
	 * Constructs the UserPanel and initializes its components such as text fields,
	 * buttons, and background images for light and dark themes. The layout is set
	 * to null and the panel is made visible.
	 */
	public UserPanel() {
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		imgDark = new JLabel();
		ImageIcon imagenPortada1 = new ImageIcon("src/media/UsuarioConsultarOscuro.png");
		Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgDark.setIcon(new ImageIcon(portadaRedimensionada));
		imgDark.setBounds(0, 0, 1280, 720);
		imgDark.setVisible(true);

		imgWhite = new JLabel();
		ImageIcon imagenPortada2 = new ImageIcon("src/media/UsuarioConsultarClaro.png");
		Image portadaRedimensionada2 = imagenPortada2.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgWhite.setIcon(new ImageIcon(portadaRedimensionada2));
		imgWhite.setBounds(0, 0, 1280, 720);
		imgWhite.setVisible(true);

		destinoField = new JTextField("CONSULTA", SwingConstants.CENTER);
		destinoField.setBounds(180, 320, 920, 80);
		destinoField.setOpaque(true);
		destinoField.setVisible(true);

		volverBtn = new JButton("VOLVER");
		volverBtn.setOpaque(false);
		volverBtn.setBounds(900, 453, 132, 132);
		volverBtn.setActionCommand("VOLVERUSER");
		volverBtn.setToolTipText("VOLVER AL MENÚ PRINCIPAL");

		buscarBtn = new JButton("BUSCAR");
		buscarBtn.setOpaque(false);
		buscarBtn.setBounds(480, 485, 320, 68);
		buscarBtn.setActionCommand("BUSCAR");
		buscarBtn.setToolTipText("BUSCAR VUELO");

		add(destinoField);
		add(imgDark);
		add(imgWhite);
		add(volverBtn);
		add(buscarBtn);
	}

	/**
	 * Gets the dark-themed background image label.
	 * 
	 * @return the imgDark
	 */
	public JLabel getImgDark() {
		return imgDark;
	}

	/**
	 * Sets the dark-themed background image label.
	 * 
	 * @param imgDark the imgDark to set
	 */
	public void setImgDark(JLabel imgDark) {
		this.imgDark = imgDark;
	}

	/**
	 * Gets the light-themed background image label.
	 * 
	 * @return the imgWhite
	 */
	public JLabel getImgWhite() {
		return imgWhite;
	}

	/**
	 * Sets the light-themed background image label.
	 * 
	 * @param imgWhite the imgWhite to set
	 */
	public void setImgWhite(JLabel imgWhite) {
		this.imgWhite = imgWhite;
	}

	/**
	 * Gets the text field where the user inputs the destination.
	 * 
	 * @return the destinoField
	 */
	public JTextField getDestinoField() {
		return destinoField;
	}

	/**
	 * Sets the text field for destination input.
	 * 
	 * @param destinoField the destinoField to set
	 */
	public void setDestinoField(JTextField destinoField) {
		this.destinoField = destinoField;
	}

	/**
	 * Gets the button used to return to the previous screen.
	 * 
	 * @return the volverBtn
	 */
	public JButton getVolverBtn() {
		return volverBtn;
	}

	/**
	 * Sets the return button to go back to the previous screen.
	 * 
	 * @param volverBtn the volverBtn to set
	 */
	public void setVolverBtn(JButton volverBtn) {
		this.volverBtn = volverBtn;
	}

	/**
	 * Gets the search button.
	 * 
	 * @return the buscarBtn
	 */
	public JButton getBuscarBtn() {
		return buscarBtn;
	}

	/**
	 * Sets the search button.
	 * 
	 * @param buscarBtn the buscarBtn to set
	 */
	public void setBuscarBtn(JButton buscarBtn) {
		this.buscarBtn = buscarBtn;
	}
}
