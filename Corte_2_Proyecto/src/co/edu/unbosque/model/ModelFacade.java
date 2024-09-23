package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Complementary;
import co.edu.unbosque.model.persistence.VueloInternacionalDAO;
import co.edu.unbosque.model.persistence.VueloNacionalDAO;

public class ModelFacade {

	private VueloInternacionalDAO vInternacionalDAO;
	private VueloNacionalDAO vNacionalDAO;
	private Complementary complement;

	public ModelFacade() {

		vInternacionalDAO = new VueloInternacionalDAO();
		vNacionalDAO = new VueloNacionalDAO();
		complement = new Complementary();
	}

	/**
	 * @return the vInternacionalDAO
	 */
	public VueloInternacionalDAO getvInternacionalDAO() {
		return vInternacionalDAO;
	}

	/**
	 * @param vInternacionalDAO the vInternacionalDAO to set
	 */
	public void setvInternacionalDAO(VueloInternacionalDAO vInternacionalDAO) {
		this.vInternacionalDAO = vInternacionalDAO;
	}

	/**
	 * @return the vNacionalDAO
	 */
	public VueloNacionalDAO getvNacionalDAO() {
		return vNacionalDAO;
	}

	/**
	 * @param vNacionalDAO the vNacionalDAO to set
	 */
	public void setvNacionalDAO(VueloNacionalDAO vNacionalDAO) {
		this.vNacionalDAO = vNacionalDAO;
	}

	/**
	 * @return the complement
	 */
	public Complementary getComplement() {
		return complement;
	}

	/**
	 * @param complement the complement to set
	 */
	public void setComplement(Complementary complement) {
		this.complement = complement;

	}
}
