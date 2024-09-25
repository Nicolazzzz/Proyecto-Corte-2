package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

	private JLabel imgCompania, imgInputIOscuro, imgInputIClaro, imgInputNClaro, imgInputNOscuro, imgAvianca, imgLatan,
			imgWingo, imgSatena, imgClic, imgCopaA, imgAmericanA, imgIberia, imgAirF, imgDeltaA;

	private JButton volverBtn, saveBtn, companiaBtn;

	private JTextField destinoField, pasajerosField, salidaField, llegadaField, visaField;

	public InputPanel() {

		setSize(1280, 720);
		setLayout(null);
		setVisible(true);
		
		//BOTONES--------------------------------------
		volverBtn = new JButton("Volver");
		volverBtn.setOpaque(false);
		volverBtn.setBounds(30, 30, 300, 400);
		volverBtn.setActionCommand("VOLVERINPUT");
		volverBtn.setToolTipText("VOLVER AL MENÚ");
		
		saveBtn = new JButton("Guardar");
		saveBtn.setOpaque(false);
		saveBtn.setBounds(30, 30, 300, 300);
		saveBtn.setActionCommand("GUARDARINPUT");
		saveBtn.setToolTipText("GUARDAR SELECCIÓN");
		
		companiaBtn = new JButton("Compañia");
		companiaBtn.setOpaque(false);
		companiaBtn.setBounds(30, 30, 300, 200);
		companiaBtn.setActionCommand("COMPAÑIAINPUT");
		companiaBtn.setToolTipText("SELECCIONAR COMPAÑIA ENCARGADA DEL VUELO");
	
		//IMAGENES--------------------------------------
	
	}
}
