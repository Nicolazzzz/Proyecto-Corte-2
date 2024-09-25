package co.edu.unbosque.view;

import java.awt.Image;
import java.sql.BatchUpdateException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserPanel extends JPanel {

	private JLabel imgDark, imgWhite;
	private JTextField destinoField;
	private JButton volverBtn, buscarBtn;

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

		buscarBtn = new JButton("BUSCAR");
		buscarBtn.setOpaque(false);
		buscarBtn.setBounds(480, 485, 320, 68);
		buscarBtn.setActionCommand("BUSCAR");

		add(imgDark);
		add(imgWhite);
		add(destinoField);
		add(volverBtn);
		add(buscarBtn);
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
	 * @return the destinoField
	 */
	public JTextField getDestinoField() {
		return destinoField;
	}

	/**
	 * @param destinoField the destinoField to set
	 */
	public void setDestinoField(JTextField destinoField) {
		this.destinoField = destinoField;
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
	 * @return the buscarBtn
	 */
	public JButton getBuscarBtn() {
		return buscarBtn;
	}

	/**
	 * @param buscarBtn the buscarBtn to set
	 */
	public void setBuscarBtn(JButton buscarBtn) {
		this.buscarBtn = buscarBtn;
	}

}
