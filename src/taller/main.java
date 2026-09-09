// Tomás Zepeda - 21.789.061-6 - ICCI

package taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		leerSolicitudes();
		leerAlumnos();
		
	}

	private static void leerAlumnos() {
	File txtAlumnos = new File("Alumnos.txt");
	try {
		Scanner scan = new Scanner(txtAlumnos);
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombreA = partes[0];
			String apellidoA = partes[1];
			String rut = partes[2];
			String paralelo = partes[3];
		}scan.close();
	} catch (FileNotFoundException e) {
		System.out.println("Archivo no encontrado");
		e.printStackTrace();
	}
	}

	private static void leerSolicitudes() {
		File txtSolicitudes = new File("Solicitudes.txt");
		try {
			Scanner scan = new Scanner(txtSolicitudes);
			while(scan.hasNextLine()) {
				String linea = scan.nextLine();
				String[] partes = linea.split("-");
				String nombreS = partes[0];
				String apellidoS = partes[1];
			}scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo");
			e.printStackTrace();
		}
		
	}

}
