package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CrudPanel extends JPanel {
	
	private JButton addBtn, deleteBtn, showBtn, updateBtn;
	private JLabel imgCrudClaro, imgCrudOscuro;

	public CrudPanel() {
		
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);
		
		addBtn = new JButton("Agregar");
		addBtn.setOpaque(false);
		addBtn.setBounds(50, 50, 100, 100);
		addBtn.setActionCommand("AGREGARCRUD");
		
		deleteBtn = new JButton("Eliminar");
		deleteBtn.setOpaque(false);
		deleteBtn.setBounds(50, 50, 200, 200);
		deleteBtn.setActionCommand("ELIMINARCRUD");
		
		showBtn = new JButton("Mostrar");
		showBtn.setOpaque(false);
		showBtn.setBounds(50, 50, 300, 300);
		showBtn.setActionCommand("MOSTRARCRUD");
		
		updateBtn = new JButton("Actualizar");
		updateBtn.setOpaque(false);
		updateBtn.setBounds(50, 50, 400, 400);
		updateBtn.setActionCommand("ACTUALIZARCRUD");
		
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
		
	}
	
}
