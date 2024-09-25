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
	private JLabel imgCrudClaro, imgCrudOscuro;

	public CrudPanel() {

		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		imgCrudClaro = new JLabel();
		ImageIcon crudC = new ImageIcon("src/media/InterClaro.png");
		Image crudCU = crudC.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgCrudClaro.setIcon(new ImageIcon(crudCU));
		imgCrudClaro.setBounds(0, 0, 1280, 720);
		imgCrudClaro.setVisible(true);

		imgCrudOscuro = new JLabel();
		ImageIcon crudO = new ImageIcon("src/media/InterOscuro.png");
		Image crudOU = crudO.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgCrudClaro.setIcon(new ImageIcon(crudOU));
		imgCrudClaro.setBounds(0, 0, 1280, 720);
		imgCrudClaro.setVisible(true);

		addBtn = new JButton("Agregar");
		addBtn.setOpaque(true);
		addBtn.setBounds(350, 350, 260, 70);
		addBtn.setActionCommand("AGREGAR");

		deleteBtn = new JButton("Eliminar");
		deleteBtn.setOpaque(true);
		deleteBtn.setBounds(350, 471, 260, 70);
		deleteBtn.setActionCommand("ELIMINAR");

		showBtn = new JButton("Mostrar");
		showBtn.setOpaque(true);
		showBtn.setBounds(200, 50, 260, 70);
		showBtn.setActionCommand("MOSTRAR");

		updateBtn = new JButton("Actualizar");
		updateBtn.setOpaque(true);
		updateBtn.setBounds(50, 50, 260, 70);
		updateBtn.setActionCommand("ACTUALIZAR");

		volverBtn = new JButton("Volver");
		volverBtn.setOpaque(true);
		volverBtn.setBounds(50, 200, 100, 100);
		volverBtn.setActionCommand("VOLVERCRUD");

		add(imgCrudClaro);
		add(imgCrudOscuro);
		add(addBtn);
		add(deleteBtn);
		add(showBtn);
		add(updateBtn);
		add(volverBtn);

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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the imgCrudClaro
	 */
	public JLabel getImgCrudClaro() {
		return imgCrudClaro;
	}

	/**
	 * @param imgCrudClaro the imgCrudClaro to set
	 */
	public void setImgCrudClaro(JLabel imgCrudClaro) {
		this.imgCrudClaro = imgCrudClaro;
	}

	/**
	 * @return the imgCrudOscuro
	 */
	public JLabel getImgCrudOscuro() {
		return imgCrudOscuro;
	}

	/**
	 * @param imgCrudOscuro the imgCrudOscuro to set
	 */
	public void setImgCrudOscuro(JLabel imgCrudOscuro) {
		this.imgCrudOscuro = imgCrudOscuro;
	}

}
