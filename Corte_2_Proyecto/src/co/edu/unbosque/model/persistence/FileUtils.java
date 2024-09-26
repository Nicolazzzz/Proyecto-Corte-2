package co.edu.unbosque.model.persistence;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtils {


    public FileUtils() {

        String srcNacionalName = "data\\vuelosNacionales.csv";
        String srcInterName = "data\\vuelosInternacionales.csv";
        String dstFileName = "data\\todo.txt";
        
        try {
            copyInternacional(srcInterName, dstFileName);
            copyNacional(srcNacionalName, dstFileName);
        } catch (IOException e) {
            System.err.println("Error al copiar archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // INTERNACIONAL
    private static void copyInternacional(String srcInterName, String dstFileName) throws IOException {
        File srcFile = new File(srcInterName);
        File dstFile = new File(dstFileName);
        if (!dstFile.exists()) {
            dstFile.createNewFile();
        }

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(srcFile, StandardCharsets.UTF_8));
            writer = new BufferedWriter(new FileWriter(dstFile, StandardCharsets.UTF_8));

            writer.write("VUELOS INTERNACIONALES:\n\n");
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(";");
                if (data.length >= 9) {
                    writer.write("Destino: " + data[0] + "\n");
                    writer.write("Compañía: " + data[1] + "\n");
                    writer.write("Número de Pasajeros: " + data[2] + "\n");
                    writer.write("Capitán a Cargo: " + data[3] + "\n");
                    writer.write("Segundo al Mando: " + data[4] + "\n");
                    writer.write("Hora de Llegada: " + data[5] + "\n");
                    writer.write("Hora de Salida: " + data[6] + "\n");
                    writer.write("Combustible: " + data[7] + "\n");
                    writer.write("Requiere Visa: " + data[8] + "\n");
                    writer.write("\n");
                }
            }
            System.out.println("Vuelos internacionales copiados y formateados correctamente");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // NACIONAL
    private static void copyNacional(String srcNacionalName, String dstFileName) throws IOException {
        File srcFile = new File(srcNacionalName);
        File dstFile = new File(dstFileName);
        
        if (!srcFile.exists()) {
            System.err.println("El archivo de vuelos nacionales no existe: " + srcNacionalName);
            return;
        }

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(srcFile, StandardCharsets.UTF_8));
            writer = new BufferedWriter(new FileWriter(dstFile, StandardCharsets.UTF_8, true));

            writer.write("\nVUELOS NACIONALES:\n\n");
            String line;
            boolean isFirstLine = true;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(";");
                if (data.length >= 10) {  
                    writer.write("Destino: " + data[0] + "\n");
                    writer.write("Compañía: " + data[1] + "\n");
                    writer.write("Número de Pasajeros: " + data[2] + "\n");
                    writer.write("Capitán a Cargo: " + data[3] + "\n");
                    writer.write("Segundo al Mando: " + data[4] + "\n");
                    writer.write("Hora de Llegada: " + data[5] + "\n");
                    writer.write("Hora de Salida: " + data[6] + "\n");
                    writer.write("Combustible: " + data[7] + "\n");
                    writer.write("Es Turbina: " + data[8] + "\n");
                    writer.write("Es Hélice: " + data[9] + "\n");
                    writer.write("\n"); 
                } else {
                    System.err.println("Línea " + lineCount + " no tiene suficientes campos: " + line);
                }
            }
            
            if (lineCount <= 1) {
                System.err.println("El archivo de vuelos nacionales está vacío o solo contiene la cabecera.");
            } else {
                System.out.println("Vuelos nacionales copiados y formateados correctamente. Total de líneas procesadas: " + (lineCount - 1));
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static Object readSerializedFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            System.out.println("Objeto leído con éxito: " + obj);
            return obj;
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo encontrar el archivo " + fileName);
            e.printStackTrace();
        } catch (InvalidClassException e) {
            System.err.println("Error: La clase del objeto serializado no coincide con la clase actual");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo encontrar la clase del objeto serializado");
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            System.err.println("Error: El archivo está corrupto o no es un archivo serializado válido");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de E/S al leer el archivo");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado al leer el archivo");
            e.printStackTrace();
        }
        return null;
    }
}