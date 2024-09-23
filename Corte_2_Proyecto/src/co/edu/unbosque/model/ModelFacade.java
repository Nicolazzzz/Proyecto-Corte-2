package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Complement2;
import co.edu.unbosque.model.persistence.VueloInternacionalDAO;
import co.edu.unbosque.model.persistence.VueloNacionalDAO;

public class ModelFacade {

	private VueloInternacionalDAO vInternacionalDAO;
	private VueloNacionalDAO vNacionalDAO;
	private Complement2 complement;

	public ModelFacade() {

		vInternacionalDAO = new VueloInternacionalDAO();
		vNacionalDAO = new VueloNacionalDAO();
		complement = new Complement2();
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

	public Complement2 getComplement() {
		return complement;
	}

	public void setComplement(Complement2 complement) {
		this.complement = complement;
	}

}
