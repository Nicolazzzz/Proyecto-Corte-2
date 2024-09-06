package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.VueloInternacionalDAO;
import co.edu.unbosque.model.persistence.VueloNacionalDAO;

public class ModelFacade {

	private VueloInternacionalDAO vInternacionalDAO;
	private VueloNacionalDAO vNacionalDAO;

	public ModelFacade() {

		vInternacionalDAO = new VueloInternacionalDAO();
		vNacionalDAO = new VueloNacionalDAO();
	}

	public VueloInternacionalDAO getvInternacionalDAO() {
		return vInternacionalDAO;
	}

	public void setvInternacionalDAO(VueloInternacionalDAO vInternacionalDAO) {
		this.vInternacionalDAO = vInternacionalDAO;
	}

	public VueloNacionalDAO getvNacionalDAO() {
		return vNacionalDAO;
	}

	public void setvNacionalDAO(VueloNacionalDAO vNacionalDAO) {
		this.vNacionalDAO = vNacionalDAO;
	}

}
