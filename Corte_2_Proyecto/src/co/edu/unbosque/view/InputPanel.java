package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel imgCompania, imgInputIOscuro, imgInputIClaro, imgInputNClaro, imgInputNOscuro, imgDeleteNClaro,
			imgDeleteNOscuro, imgDeleteIOscuro, imgDeleteIClaro, imgAvianca, imgLatam, imgWingo, imgSatena, imgClic,
			imgCopaA, imgAmericanA, imgIberia, imgAirF, imgDeltaA;

	private JButton volverBtn, saveBtn, companiaBtn;

	private JTextField destinoField, pasajerosField, salidaField, llegadaField, visaField;

	public InputPanel() {

		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		// IMAGENES--------------------------------------
		// TODAS ESTÁN EN FALSE!!!!!!!
		// <<DISCLAMER>> imgCompania FALTA, no tengo idea de que hacerle, está mas abajo

		// IMAGENES--------------------------------------
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

		imgInputNClaro = new JLabel();
		ImageIcon inputOC = new ImageIcon("src/media/InputNacionalClaro.png");
		Image inputIN1 = inputOC.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgInputNClaro.setIcon(new ImageIcon(inputIN1));
		imgInputNClaro.setBounds(0, 0, 1270, 720);
		imgInputNClaro.setVisible(false);

		imgDeleteNClaro = new JLabel();
		ImageIcon inputDNC = new ImageIcon("src/media/EliminarNacionalClaro.png");
		Image inputNC = inputDNC.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgDeleteNClaro.setIcon(new ImageIcon(inputNC));
		imgDeleteNClaro.setBounds(0, 0, 1270, 720);
		imgDeleteNClaro.setVisible(false);

		imgDeleteNOscuro = new JLabel();
		ImageIcon inputDNO = new ImageIcon("src/media/EliminarNacionalOscuro.png");
		Image inputNO = inputDNO.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgDeleteNOscuro.setIcon(new ImageIcon(inputNO));
		imgDeleteNOscuro.setBounds(0, 0, 1270, 720);
		imgDeleteNOscuro.setVisible(false);

		imgDeleteIClaro = new JLabel();
		ImageIcon inputDIC = new ImageIcon("src/media/EliminarInterClaro.png");
		Image inputIDC = inputDIC.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgDeleteIClaro.setIcon(new ImageIcon(inputIDC));
		imgDeleteIClaro.setBounds(0, 0, 1270, 720);
		imgDeleteIClaro.setVisible(false);

		imgDeleteIOscuro = new JLabel();
		ImageIcon inputDIO = new ImageIcon("src/media/EliminarInterOscuro.png");
		Image inputIDO = inputDIO.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgDeleteIClaro.setIcon(new ImageIcon(inputIDO));
		imgDeleteIClaro.setBounds(0, 0, 1270, 720);
		imgDeleteIClaro.setVisible(false);

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

		imgCompania = new JLabel();// <--- AQUI ESTÁ
		ImageIcon inputCom = new ImageIcon("src/logo/deltaAirlines.png");
		Image inputcom = inputCom.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgCompania.setIcon(new ImageIcon(inputcom));
		imgCompania.setBounds(0, 0, 1270, 720);
		imgCompania.setVisible(false);

		// BOTONES--------------------------------------

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
		companiaBtn.setActionCommand("COMPANIAINPUT");
		companiaBtn.setToolTipText("SELECCIONAR COMPAÑIA ENCARGADA DEL VUELO");

		// ETIQUETAS-------------------------------------
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
		add(imgDeleteNClaro);
		add(imgDeleteNOscuro);
		add(imgDeleteIClaro);
		add(imgDeleteIOscuro);
		add(imgCompania);
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
		add(imgInputIOscuro);
		add(imgInputIClaro);
	}

	/**
	 * @return the imgDeleteNClaro
	 */
	public JLabel getImgDeleteNClaro() {
		return imgDeleteNClaro;
	}

	/**
	 * @param imgDeleteNClaro the imgDeleteNClaro to set
	 */
	public void setImgDeleteNClaro(JLabel imgDeleteNClaro) {
		this.imgDeleteNClaro = imgDeleteNClaro;
	}

	/**
	 * @return the imgDeleteNOscuro
	 */
	public JLabel getImgDeleteNOscuro() {
		return imgDeleteNOscuro;
	}

	/**
	 * @param imgDeleteNOscuro the imgDeleteNOscuro to set
	 */
	public void setImgDeleteNOscuro(JLabel imgDeleteNOscuro) {
		this.imgDeleteNOscuro = imgDeleteNOscuro;
	}

	/**
	 * @return the imgDeleteIOscuro
	 */
	public JLabel getImgDeleteIOscuro() {
		return imgDeleteIOscuro;
	}

	/**
	 * @param imgDeleteIOscuro the imgDeleteIOscuro to set
	 */
	public void setImgDeleteIOscuro(JLabel imgDeleteIOscuro) {
		this.imgDeleteIOscuro = imgDeleteIOscuro;
	}

	/**
	 * @return the imgDeleteIClaro
	 */
	public JLabel getImgDeleteIClaro() {
		return imgDeleteIClaro;
	}

	/**
	 * @param imgDeleteIClaro the imgDeleteIClaro to set
	 */
	public void setImgDeleteIClaro(JLabel imgDeleteIClaro) {
		this.imgDeleteIClaro = imgDeleteIClaro;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the imgCompania
	 */
	public JLabel getImgCompania() {
		return imgCompania;
	}

	/**
	 * @param imgCompania the imgCompania to set
	 */
	public void setImgCompania(JLabel imgCompania) {
		this.imgCompania = imgCompania;
	}

	/**
	 * @return the imgInputIOscuro
	 */
	public JLabel getImgInputIOscuro() {
		return imgInputIOscuro;
	}

	/**
	 * @param imgInputIOscuro the imgInputIOscuro to set
	 */
	public void setImgInputIOscuro(JLabel imgInputIOscuro) {
		this.imgInputIOscuro = imgInputIOscuro;
	}

	/**
	 * @return the imgInputIClaro
	 */
	public JLabel getImgInputIClaro() {
		return imgInputIClaro;
	}

	/**
	 * @param imgInputIClaro the imgInputIClaro to set
	 */
	public void setImgInputIClaro(JLabel imgInputIClaro) {
		this.imgInputIClaro = imgInputIClaro;
	}

	/**
	 * @return the imgInputNClaro
	 */
	public JLabel getImgInputNClaro() {
		return imgInputNClaro;
	}

	/**
	 * @param imgInputNClaro the imgInputNClaro to set
	 */
	public void setImgInputNClaro(JLabel imgInputNClaro) {
		this.imgInputNClaro = imgInputNClaro;
	}

	/**
	 * @return the imgInputNOscuro
	 */
	public JLabel getImgInputNOscuro() {
		return imgInputNOscuro;
	}

	/**
	 * @param imgInputNOscuro the imgInputNOscuro to set
	 */
	public void setImgInputNOscuro(JLabel imgInputNOscuro) {
		this.imgInputNOscuro = imgInputNOscuro;
	}

	/**
	 * @return the imgAvianca
	 */
	public JLabel getImgAvianca() {
		return imgAvianca;
	}

	/**
	 * @param imgAvianca the imgAvianca to set
	 */
	public void setImgAvianca(JLabel imgAvianca) {
		this.imgAvianca = imgAvianca;
	}

	/**
	 * @return the imgLatam
	 */
	public JLabel getImgLatam() {
		return imgLatam;
	}

	/**
	 * @param imgLatam the imgLatam to set
	 */
	public void setImgLatam(JLabel imgLatam) {
		this.imgLatam = imgLatam;
	}

	/**
	 * @return the imgWingo
	 */
	public JLabel getImgWingo() {
		return imgWingo;
	}

	/**
	 * @param imgWingo the imgWingo to set
	 */
	public void setImgWingo(JLabel imgWingo) {
		this.imgWingo = imgWingo;
	}

	/**
	 * @return the imgSatena
	 */
	public JLabel getImgSatena() {
		return imgSatena;
	}

	/**
	 * @param imgSatena the imgSatena to set
	 */
	public void setImgSatena(JLabel imgSatena) {
		this.imgSatena = imgSatena;
	}

	/**
	 * @return the imgClic
	 */
	public JLabel getImgClic() {
		return imgClic;
	}

	/**
	 * @param imgClic the imgClic to set
	 */
	public void setImgClic(JLabel imgClic) {
		this.imgClic = imgClic;
	}

	/**
	 * @return the imgCopaA
	 */
	public JLabel getImgCopaA() {
		return imgCopaA;
	}

	/**
	 * @param imgCopaA the imgCopaA to set
	 */
	public void setImgCopaA(JLabel imgCopaA) {
		this.imgCopaA = imgCopaA;
	}

	/**
	 * @return the imgAmericanA
	 */
	public JLabel getImgAmericanA() {
		return imgAmericanA;
	}

	/**
	 * @param imgAmericanA the imgAmericanA to set
	 */
	public void setImgAmericanA(JLabel imgAmericanA) {
		this.imgAmericanA = imgAmericanA;
	}

	/**
	 * @return the imgIberia
	 */
	public JLabel getImgIberia() {
		return imgIberia;
	}

	/**
	 * @param imgIberia the imgIberia to set
	 */
	public void setImgIberia(JLabel imgIberia) {
		this.imgIberia = imgIberia;
	}

	/**
	 * @return the imgAirF
	 */
	public JLabel getImgAirF() {
		return imgAirF;
	}

	/**
	 * @param imgAirF the imgAirF to set
	 */
	public void setImgAirF(JLabel imgAirF) {
		this.imgAirF = imgAirF;
	}

	/**
	 * @return the imgDeltaA
	 */
	public JLabel getImgDeltaA() {
		return imgDeltaA;
	}

	/**
	 * @param imgDeltaA the imgDeltaA to set
	 */
	public void setImgDeltaA(JLabel imgDeltaA) {
		this.imgDeltaA = imgDeltaA;
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
	 * @return the saveBtn
	 */
	public JButton getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @param saveBtn the saveBtn to set
	 */
	public void setSaveBtn(JButton saveBtn) {
		this.saveBtn = saveBtn;
	}

	/**
	 * @return the companiaBtn
	 */
	public JButton getCompaniaBtn() {
		return companiaBtn;
	}

	/**
	 * @param companiaBtn the companiaBtn to set
	 */
	public void setCompaniaBtn(JButton companiaBtn) {
		this.companiaBtn = companiaBtn;
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
	 * @return the pasajerosField
	 */
	public JTextField getPasajerosField() {
		return pasajerosField;
	}

	/**
	 * @param pasajerosField the pasajerosField to set
	 */
	public void setPasajerosField(JTextField pasajerosField) {
		this.pasajerosField = pasajerosField;
	}

	/**
	 * @return the salidaField
	 */
	public JTextField getSalidaField() {
		return salidaField;
	}

	/**
	 * @param salidaField the salidaField to set
	 */
	public void setSalidaField(JTextField salidaField) {
		this.salidaField = salidaField;
	}

	/**
	 * @return the llegadaField
	 */
	public JTextField getLlegadaField() {
		return llegadaField;
	}

	/**
	 * @param llegadaField the llegadaField to set
	 */
	public void setLlegadaField(JTextField llegadaField) {
		this.llegadaField = llegadaField;
	}

	/**
	 * @return the visaField
	 */
	public JTextField getVisaField() {
		return visaField;
	}

	/**
	 * @param visaField the visaField to set
	 */
	public void setVisaField(JTextField visaField) {
		this.visaField = visaField;
	}

}
