package co.edu.unbosque.view;

public class ViewFacade {

	private Consola con;

	public ViewFacade() {
		con = new Consola();
	}

	public Consola getCon() {
		return con;
	}

	public void setCon(Consola con) {
		this.con = con;
	}

}
