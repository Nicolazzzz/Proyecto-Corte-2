package co.edu.unbosque.view;

/**
 * Clase que actúa como fachada para la clase Consola, encapsulando su creación
 * y proporcionando acceso a sus métodos.
 * 
 * @author Nicolas
 * @version 1.0
 * @since 2024-09-24
 */
public class ViewFacade {

	private Consola con; // Objeto de la clase Consola
	private VentanaPrincipal vp;

	/**
	 * Constructor de la clase ViewFacade. Inicializa el objeto Consola.
	 */
	public ViewFacade() {
		con = new Consola();
		vp = new VentanaPrincipal();

	}

	/**
	 * Obtiene el objeto Consola.
	 * 
	 * @return El objeto Consola asociado a esta fachada.
	 */
	public Consola getCon() {
		return con;
	}

	/**
	 * Establece un nuevo objeto Consola.
	 * 
	 * @param con El nuevo objeto Consola a establecer.
	 */
	public void setCon(Consola con) {
		this.con = con;
	}

	/**
	 * @return the vp
	 */
	public VentanaPrincipal getVp() {
		return vp;
	}

	/**
	 * @param vp the vp to set
	 */
	public void setVp(VentanaPrincipal vp) {
		this.vp = vp;
	}

}
