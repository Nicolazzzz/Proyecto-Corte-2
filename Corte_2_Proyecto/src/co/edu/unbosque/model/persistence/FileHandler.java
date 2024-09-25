package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase encargada de manejar operaciones de entrada y salida de archivos.
 * Permite leer y escribir tanto archivos de texto plano como objetos
 * serializados. Además, asegura que exista una carpeta para almacenar los
 * archivos.
 * 
 * @author Sebastian
 * @version 1.0
 * @since 2024-09-24
 */
public class FileHandler {

	private static Scanner sc;
	private static PrintWriter pw;
	private static File archivo;
	private static final String FOLDER_NAME = "data";

	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	private static FileInputStream fis;
	private static ObjectInputStream ois;

	/**
	 * Verifica si la carpeta de almacenamiento existe. Si no, la crea.
	 */
	public static void checkFolder() {
		archivo = new File(FOLDER_NAME);
		if (archivo.exists() && archivo.isDirectory()) {
			return;
		} else {
			archivo.mkdir();
		}
	}

	/**
	 * Escribe contenido en un archivo de texto plano.
	 *
	 * @param url     Nombre del archivo en el que se escribirá el contenido.
	 * @param content Contenido que se desea escribir en el archivo.
	 */
	public static void writeFile(String url, String content) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			pw = new PrintWriter(archivo);
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR EN LA ESCRITURA DEL ARCHIVO (TEXTO PLANO)");
		} catch (IOException e) {
			System.out.println("ERROR EN LA CREACIÓN DEL ARCHIVO (TEXTO PLANO)");
		}
	}

	/**
	 * Lee el contenido de un archivo de texto plano.
	 *
	 * @param url Nombre del archivo que se desea leer.
	 * @return Contenido del archivo como una cadena, o null si hay un error.
	 */
	public static String readFile(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			sc = new Scanner(archivo);
			StringBuilder content = new StringBuilder();
			while (sc.hasNext()) {
				content.append(sc.nextLine()).append("\n");
			}
			sc.close();
			return content.toString();

		} catch (IOException e) {
			System.out.println("ERROR EN LA LECTURA DEL ARCHIVO (TEXTO PLANO)");
		}

		return null;
	}

	/**
	 * Escribe un objeto en un archivo utilizando serialización.
	 *
	 * @param url     Nombre del archivo donde se escribirá el objeto.
	 * @param content Objeto que se desea serializar y guardar en el archivo.
	 */
	public static void writeSerialized(String url, Object content) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			fos.close();
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR EN CREAR ARCHIVO (Serialized)");
		}
	}

	/**
	 * Lee un objeto desde un archivo serializado.
	 *
	 * @param url Nombre del archivo desde el que se leerá el objeto.
	 * @return El objeto leído del archivo, o null si hay un error.
	 */
	public static Object readSerialized(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);

			Object content = ois.readObject();

			fis.close();
			ois.close();
			return content;

		} catch (IOException e) {
			System.out.println("ERROR EN LECTURA DE ARCHIVO (SERIALIZED)");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR AL LEER LOS DATOS DEL SERIALIZED(CLASS NOT FOUND)");
		}
		return null;
	}
}
