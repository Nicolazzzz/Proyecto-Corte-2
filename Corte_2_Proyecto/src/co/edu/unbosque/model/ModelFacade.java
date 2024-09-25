package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Complementary;
import co.edu.unbosque.model.persistence.VueloInternacionalDAO;
import co.edu.unbosque.model.persistence.VueloNacionalDAO;

/**
 * Clase que actúa como fachada para interactuar con los DAOs de vuelos
 * nacionales e internacionales, así como con las operaciones complementarias.
 * Proporciona métodos para gestionar la lógica de acceso a datos.
 * 
 * @author Mario
 * @version 1.0
 * @since 2024-09-24
 */
public class ModelFacade {

	private VueloInternacionalDAO vInternacionalDAO;
	private VueloNacionalDAO vNacionalDAO;
	private Complementary complement;

	/**
	 * Constructor que inicializa los DAOs de vuelos internacionales y nacionales,
	 * así como las operaciones complementarias.
	 */
	public ModelFacade() {
		vInternacionalDAO = new VueloInternacionalDAO();
		vNacionalDAO = new VueloNacionalDAO();
		complement = new Complementary();
	}

	/**
	 * Obtiene el DAO de vuelos internacionales.
	 * 
	 * @return El DAO de vuelos internacionales.
	 */
	public VueloInternacionalDAO getvInternacionalDAO() {
		return vInternacionalDAO;
	}

	/**
	 * Establece el DAO de vuelos internacionales.
	 * 
	 * @param vInternacionalDAO El DAO de vuelos internacionales a establecer.
	 */
	public void setvInternacionalDAO(VueloInternacionalDAO vInternacionalDAO) {
		this.vInternacionalDAO = vInternacionalDAO;
	}

	/**
	 * Obtiene el DAO de vuelos nacionales.
	 * 
	 * @return El DAO de vuelos nacionales.
	 */
	public VueloNacionalDAO getvNacionalDAO() {
		return vNacionalDAO;
	}

	/**
	 * Establece el DAO de vuelos nacionales.
	 * 
	 * @param vNacionalDAO El DAO de vuelos nacionales a establecer.
	 */
	public void setvNacionalDAO(VueloNacionalDAO vNacionalDAO) {
		this.vNacionalDAO = vNacionalDAO;
	}

	/**
	 * Obtiene el objeto Complementary, que gestiona operaciones adicionales.
	 * 
	 * @return El objeto Complementary.
	 */
	public Complementary getComplement() {
		return complement;
	}

	/**
	 * Establece el objeto Complementary.
	 * 
	 * @param complement El objeto Complementary a establecer.
	 */
	public void setComplement(Complementary complement) {
		this.complement = complement;
	}
}
