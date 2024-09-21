package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDOperation<D, E> {

	public String showAll();

	public ArrayList<D> getAll();

	public boolean add(D newData);

	public boolean delete(D toDelete);

	public E find(E toFind);

	public boolean update(D previous, D newData);

	public void readFile();

	public void writeFile();

	public void readSerialized();

	public void writeSerialized();

}
