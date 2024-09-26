
package co.edu.unbosque.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CrudPanel is a JPanel that manages a CRUD (Create, Read, Update, Delete)
 * interface. It contains buttons to perform the CRUD operations and background
 * images related to international and national options, in both light and dark
 * themes.
 * 
 * @author Santiago
 * @version 1.0
 */
public class CrudPanel extends JPanel {

	/**
	 * Serialization ID for this class.
	 */
	private static final long serialVersionUID = 1L;

	private JButton addBtn, deleteBtn, showBtn, updateBtn, volverBtn;
	private JLabel imgInterCrudClaro, imgInterCrudOscuro, imgNacionalCrudOscuro, imgNacionalCrudClaro;

	/**
	 * Constructs a CrudPanel and initializes its buttons and background images for
	 * both international and national flight themes. The layout is set to null and
	 * the panel is made visible.
	 */
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
		addBtn.setToolTipText("AGREGAR VUELO");

		deleteBtn = new JButton("Eliminar");
		deleteBtn.setOpaque(false);
		deleteBtn.setBounds(342, 471, 278, 71);
		deleteBtn.setActionCommand("ELIMINAR");
		deleteBtn.setToolTipText("ELIMINAR VUELO");

		showBtn = new JButton("Mostrar");
		showBtn.setOpaque(false);
		showBtn.setBounds(662, 324, 278, 71);
		showBtn.setActionCommand("MOSTRAR");
		showBtn.setToolTipText("MOSTRAR VUELOS");

		updateBtn = new JButton("Actualizar");
		updateBtn.setOpaque(false);
		updateBtn.setBounds(662, 471, 278, 71);
		updateBtn.setActionCommand("ACTUALIZAR");
		updateBtn.setToolTipText("ACTUALIZAR VUELOS");

		volverBtn = new JButton("Volver");
		volverBtn.setOpaque(false);
		volverBtn.setBounds(595, 550, 94, 94);
		volverBtn.setActionCommand("VOLVERCRUD");
		volverBtn.setToolTipText("VOLVER AL MENÚ DE VUELOS");

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
	 * Gets the button to add a new entry.
	 * 
	 * @return the addBtn
	 */
	public JButton getAddBtn() {
		return addBtn;
	}

	/**
	 * Sets the button to add a new entry.
	 * 
	 * @param addBtn the addBtn to set
	 */
	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	/**
	 * Gets the button to delete an entry.
	 * 
	 * @return the deleteBtn
	 */
	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	/**
	 * Sets the button to delete an entry.
	 * 
	 * @param deleteBtn the deleteBtn to set
	 */
	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	/**
	 * Gets the button to show an entry.
	 * 
	 * @return the showBtn
	 */
	public JButton getShowBtn() {
		return showBtn;
	}

	/**
	 * Sets the button to show an entry.
	 * 
	 * @param showBtn the showBtn to set
	 */
	public void setShowBtn(JButton showBtn) {
		this.showBtn = showBtn;
	}

	/**
	 * Gets the button to update an entry.
	 * 
	 * @return the updateBtn
	 */
	public JButton getUpdateBtn() {
		return updateBtn;
	}

	/**
	 * Sets the button to update an entry.
	 * 
	 * @param updateBtn the updateBtn to set
	 */
	public void setUpdateBtn(JButton updateBtn) {
		this.updateBtn = updateBtn;
	}

	/**
	 * Gets the button to go back.
	 * 
	 * @return the volverBtn
	 */
	public JButton getVolverBtn() {
		return volverBtn;
	}

	/**
	 * Sets the button to go back.
	 * 
	 * @param volverBtn the volverBtn to set
	 */
	public void setVolverBtn(JButton volverBtn) {
		this.volverBtn = volverBtn;
	}

	/**
	 * Gets the label for the international flight CRUD panel in light mode.
	 * 
	 * @return the imgInterCrudClaro
	 */
	public JLabel getImgInterCrudClaro() {
		return imgInterCrudClaro;
	}

	/**
	 * Sets the label for the international flight CRUD panel in light mode.
	 * 
	 * @param imgInterCrudClaro the imgInterCrudClaro to set
	 */
	public void setImgInterCrudClaro(JLabel imgInterCrudClaro) {
		this.imgInterCrudClaro = imgInterCrudClaro;
	}

	/**
	 * Gets the label for the international flight CRUD panel in dark mode.
	 * 
	 * @return the imgInterCrudOscuro
	 */
	public JLabel getImgInterCrudOscuro() {
		return imgInterCrudOscuro;
	}

	/**
	 * Sets the label for the international flight CRUD panel in dark mode.
	 * 
	 * @param imgInterCrudOscuro the imgInterCrudOscuro to set
	 */
	public void setImgInterCrudOscuro(JLabel imgInterCrudOscuro) {
		this.imgInterCrudOscuro = imgInterCrudOscuro;
	}

	/**
	 * Gets the label for the national flight CRUD panel in dark mode.
	 * 
	 * @return the imgNacionalCrudOscuro
	 */
	public JLabel getImgNacionalCrudOscuro() {
		return imgNacionalCrudOscuro;
	}

	/**
	 * Sets the label for the national flight CRUD panel in dark mode.
	 * 
	 * @param imgNacionalCrudOscuro the imgNacionalCrudOscuro to set
	 */
	public void setImgNacionalCrudOscuro(JLabel imgNacionalCrudOscuro) {
		this.imgNacionalCrudOscuro = imgNacionalCrudOscuro;
	}

	/**
	 * Gets the label for the national flight CRUD panel in light mode.
	 * 
	 * @return the imgNacionalCrudClaro
	 */
	public JLabel getImgNacionalCrudClaro() {
		return imgNacionalCrudClaro;
	}

	/**
	 * Sets the label for the national flight CRUD panel in light mode.
	 * 
	 * @param imgNacionalCrudClaro the imgNacionalCrudClaro to set
	 */
	public void setImgNacionalCrudClaro(JLabel imgNacionalCrudClaro) {
		this.imgNacionalCrudClaro = imgNacionalCrudClaro;
	}

	/**
	 * Gets the serialization version UID.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
