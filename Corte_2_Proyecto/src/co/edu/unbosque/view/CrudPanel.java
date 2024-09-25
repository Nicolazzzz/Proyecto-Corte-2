package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CrudPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addBtn, deleteBtn, showBtn, updateBtn, volverBtn;
	private JLabel imgInterCrudClaro, imgInterCrudOscuro, imgNacionalCrudOscuro, imgNacionalCrudClaro;

	public CrudPanel() {

		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		imgInterCrudClaro = new JLabel();
		ImageIcon crudC = new ImageIcon("src/media/InterClaro.png");
		Image crudCU = crudC.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgInterCrudClaro.setIcon(new ImageIcon(crudCU));
		imgInterCrudClaro.setBounds(0, 0, 1280, 720);
		imgInterCrudClaro.setVisible(true);

		imgInterCrudOscuro = new JLabel();
		ImageIcon crudO = new ImageIcon("src/media/InterOscuro.png");
		Image crudOU = crudO.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgInterCrudOscuro.setIcon(new ImageIcon(crudOU));
		imgInterCrudOscuro.setBounds(0, 0, 1280, 720);
		imgInterCrudOscuro.setVisible(true);

		imgNacionalCrudClaro = new JLabel();
		ImageIcon crudNC = new ImageIcon("src/media/NacionalesClaro.png");
		Image crudNCU = crudNC.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgNacionalCrudClaro.setIcon(new ImageIcon(crudNCU));
		imgNacionalCrudClaro.setBounds(0, 0, 1280, 720);
		imgNacionalCrudClaro.setVisible(true);

		imgNacionalCrudOscuro = new JLabel();
		ImageIcon crudNO = new ImageIcon("src/media/NacionalesOscuro.png");
		Image crudNOU = crudNO.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgNacionalCrudOscuro.setIcon(new ImageIcon(crudNOU));
		imgNacionalCrudOscuro.setBounds(0, 0, 1280, 720);
		imgNacionalCrudOscuro.setVisible(true);

		addBtn = new JButton("Agregar");
		addBtn.setOpaque(false);
		addBtn.setBounds(342, 324, 278, 71);
		addBtn.setActionCommand("AGREGAR");

		deleteBtn = new JButton("Eliminar");
		deleteBtn.setOpaque(false);
		deleteBtn.setBounds(342, 471, 278, 71);
		deleteBtn.setActionCommand("ELIMINAR");

		showBtn = new JButton("Mostrar");
		showBtn.setOpaque(false);
		showBtn.setBounds(662, 324, 278, 71);
		showBtn.setActionCommand("MOSTRAR");

		updateBtn = new JButton("Actualizar");
		updateBtn.setOpaque(false);
		updateBtn.setBounds(662, 471, 278, 71);
		updateBtn.setActionCommand("ACTUALIZAR");

		volverBtn = new JButton("Volver");
		volverBtn.setOpaque(false);
		volverBtn.setBounds(595, 550, 94, 94);
		volverBtn.setActionCommand("VOLVERCRUD");

		add(imgInterCrudClaro);
		add(imgInterCrudOscuro);
		add(imgNacionalCrudClaro);
		add(imgNacionalCrudOscuro);
		add(addBtn);
		add(deleteBtn);
		add(showBtn);
		add(updateBtn);
		add(volverBtn);

	}

	/**
	 * @return the addBtn
	 */
	public JButton getAddBtn() {
		return addBtn;
	}

	/**
	 * @param addBtn the addBtn to set
	 */
	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	/**
	 * @return the deleteBtn
	 */
	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	/**
	 * @param deleteBtn the deleteBtn to set
	 */
	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	/**
	 * @return the showBtn
	 */
	public JButton getShowBtn() {
		return showBtn;
	}

	/**
	 * @param showBtn the showBtn to set
	 */
	public void setShowBtn(JButton showBtn) {
		this.showBtn = showBtn;
	}

	/**
	 * @return the updateBtn
	 */
	public JButton getUpdateBtn() {
		return updateBtn;
	}

	/**
	 * @param updateBtn the updateBtn to set
	 */
	public void setUpdateBtn(JButton updateBtn) {
		this.updateBtn = updateBtn;
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
	 * @return the imgInterCrudClaro
	 */
	public JLabel getImgInterCrudClaro() {
		return imgInterCrudClaro;
	}

	/**
	 * @param imgInterCrudClaro the imgInterCrudClaro to set
	 */
	public void setImgInterCrudClaro(JLabel imgInterCrudClaro) {
		this.imgInterCrudClaro = imgInterCrudClaro;
	}

	/**
	 * @return the imgInterCrudOscuro
	 */
	public JLabel getImgInterCrudOscuro() {
		return imgInterCrudOscuro;
	}

	/**
	 * @param imgInterCrudOscuro the imgInterCrudOscuro to set
	 */
	public void setImgInterCrudOscuro(JLabel imgInterCrudOscuro) {
		this.imgInterCrudOscuro = imgInterCrudOscuro;
	}

	/**
	 * @return the imgNacionalCrudOscuro
	 */
	public JLabel getImgNacionalCrudOscuro() {
		return imgNacionalCrudOscuro;
	}

	/**
	 * @param imgNacionalCrudOscuro the imgNacionalCrudOscuro to set
	 */
	public void setImgNacionalCrudOscuro(JLabel imgNacionalCrudOscuro) {
		this.imgNacionalCrudOscuro = imgNacionalCrudOscuro;
	}

	/**
	 * @return the imgNacionalCrudClaro
	 */
	public JLabel getImgNacionalCrudClaro() {
		return imgNacionalCrudClaro;
	}

	/**
	 * @param imgNacionalCrudClaro the imgNacionalCrudClaro to set
	 */
	public void setImgNacionalCrudClaro(JLabel imgNacionalCrudClaro) {
		this.imgNacionalCrudClaro = imgNacionalCrudClaro;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
