package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

	private JLabel imgCompania, imgInputIOscuro, imgInputIClaro, imgInputNClaro, imgInputNOscuro, imgAvianca, imgLatam,
			imgWingo, imgSatena, imgClic, imgCopaA, imgAmericanA, imgIberia, imgAirF, imgDeltaA;

	private JButton volverBtn, saveBtn, companiaBtn;

	private JTextField destinoField, pasajerosField, salidaField, llegadaField, visaField;

	public InputPanel() {

		setSize(1280, 720);
		setLayout(null);
		setVisible(true);
		
		//IMAGENES--------------------------------------
		//TODAS ESTÁN EN FALSE!!!!!!!
		//<<DISCLAMER>> imgCompania FALTA, no tengo idea de que hacerle
		imgInputIOscuro = new JLabel();
		ImageIcon inputO = new ImageIcon("src/media/InputInterOscuro.png");
		Image inputI = inputO.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgInputIOscuro.setIcon(new ImageIcon(inputI));
		imgInputIOscuro.setBounds(0, 0, 1270, 720);
		imgInputIOscuro.setVisible(false);
		
		imgInputIClaro = new JLabel();
		ImageIcon inputC = new ImageIcon("src/media/InputInterClaro.png");
		Image inputIC = inputC.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgInputIClaro.setIcon(new ImageIcon(inputIC));
		imgInputIClaro.setBounds(0, 0, 1270, 720);
		imgInputIClaro.setVisible(false);
		
		imgInputNOscuro = new JLabel();
		ImageIcon inputON = new ImageIcon("src/media/InputNacionalOscuro.png");
		Image inputIN = inputON.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgInputNOscuro.setIcon(new ImageIcon(inputIN));
		imgInputNOscuro.setBounds(0, 0, 1270, 720);
		imgInputNOscuro.setVisible(false);
		
		imgInputNClaro= new JLabel();
		ImageIcon inputOC = new ImageIcon("src/media/InputNacionalClaro.png");
		Image inputIN1 = inputOC.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgInputNClaro.setIcon(new ImageIcon(inputIN1));
		imgInputNClaro.setBounds(0, 0, 1270, 720);
		imgInputNClaro.setVisible(false);
		
		imgAvianca = new JLabel();
		ImageIcon inputA = new ImageIcon("src/logo/logoavianca.png");
		Image inputIA = inputA.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgAvianca.setIcon(new ImageIcon(inputIA));
		imgAvianca.setBounds(0, 0, 1270, 720);
		imgAvianca.setVisible(false);
		
		imgLatam = new JLabel();
		ImageIcon inputL = new ImageIcon("src/logo/latam.png");
		Image inputIL = inputL.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgLatam.setIcon(new ImageIcon(inputIL));
		imgLatam.setBounds(0, 0, 1270, 720);
		imgLatam.setVisible(false);
		
		imgWingo = new JLabel();
		ImageIcon inputW = new ImageIcon("src/logo/wingo.png");
		Image inputIW = inputW.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgWingo.setIcon(new ImageIcon(inputIW));
		imgWingo.setBounds(0, 0, 1270, 720);
		imgWingo.setVisible(false);
		
		imgSatena = new JLabel();
		ImageIcon inputS = new ImageIcon("src/logo/Satena.png");
		Image inputIS = inputS.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgSatena.setIcon(new ImageIcon(inputIS));
		imgSatena.setBounds(0, 0, 1270, 720);
		imgSatena.setVisible(false);
		
		imgClic = new JLabel();
		ImageIcon inputCc = new ImageIcon("src/logo/clic.png");
		Image inputICc = inputCc.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgClic.setIcon(new ImageIcon(inputICc));
		imgClic.setBounds(0, 0, 1270, 720);
		imgClic.setVisible(false);
		
		imgCopaA = new JLabel();
		ImageIcon inputa = new ImageIcon("src/logo/copaAirlines.png");
		Image inputaa = inputa.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgCopaA.setIcon(new ImageIcon(inputaa));
		imgCopaA.setBounds(0, 0, 1270, 720);
		imgCopaA.setVisible(false);
		
		imgAmericanA = new JLabel();
		ImageIcon inputas = new ImageIcon("src/logo/americanAirlines.png");
		Image inputaas = inputas.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgAmericanA.setIcon(new ImageIcon(inputaas));
		imgAmericanA.setBounds(0, 0, 1270, 720);
		imgAmericanA.setVisible(false);

		imgIberia = new JLabel();
		ImageIcon inputxd = new ImageIcon("src/logo/iberiaAirlines.png");
		Image inputxxd = inputxd.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgIberia.setIcon(new ImageIcon(inputxxd));
		imgIberia.setBounds(0, 0, 1270, 720);
		imgIberia.setVisible(false);
		
		imgAirF = new JLabel();
		ImageIcon inputt = new ImageIcon("src/logo/airFrance.png");
		Image inputs = inputt.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgAirF.setIcon(new ImageIcon(inputs));
		imgAirF.setBounds(0, 0, 1270, 720);
		imgAirF.setVisible(false);

		imgDeltaA = new JLabel();
		ImageIcon inputtx = new ImageIcon("src/logo/deltaAirlines.png");
		Image inputsx = inputtx.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgDeltaA.setIcon(new ImageIcon(inputsx));
		imgDeltaA.setBounds(0, 0, 1270, 720);
		imgDeltaA.setVisible(false);
		
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
		
		//ETIQUETAS-------------------------------------
		destinoField = new JTextField();
		destinoField.setBounds(248, 255, 300, 60);
		destinoField.setOpaque(true);
		destinoField.setVisible(false);
		
		pasajerosField = new JTextField();
		pasajerosField.setBounds(248, 255, 300, 60);
		pasajerosField.setOpaque(true);
		pasajerosField.setVisible(false);
		
		salidaField = new JTextField();
		salidaField.setBounds(248, 255, 300, 60);
		salidaField.setOpaque(true);
		salidaField.setVisible(false);
		
		llegadaField = new JTextField();
		llegadaField.setBounds(248, 255, 300, 60);
		llegadaField.setOpaque(true);
		llegadaField.setVisible(false);
		
		visaField = new JTextField();
		visaField.setBounds(248, 255, 300, 60);
		visaField.setOpaque(true);
		visaField.setVisible(false);
		
		add(imgInputIOscuro);
		add(imgInputIClaro);
		add(imgInputNOscuro);
		add(imgInputNClaro);
		add(imgAvianca);
		add(imgLatam);
		add(imgWingo);
		add(imgSatena);
		add(imgClic);
		add(imgCopaA);
		add(imgAmericanA);
		add(imgIberia);
		add(imgAirF);
		add(imgDeltaA);
		add(volverBtn);
		add(saveBtn);
		add(companiaBtn);
		add(destinoField);
		add(pasajerosField);
		add(salidaField);
		add(llegadaField);
		add(visaField);
	}
}
