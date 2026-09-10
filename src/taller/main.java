// Tomás Zepeda - 21.789.061-6 - ICCI

package taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		int opcion = 0;
		Scanner scan = new Scanner(System.in);
		do {
		System.out.println("==== Sistema de Control del Grupo POO ====");
		System.out.println("1) Cargar archivos  (Alumnos y solicitudes)");
		System.out.println("2) Procesar solicitudes (Filtrado automatico");
		System.out.println("3) Inscripcion manual al grupo");
		System.out.println("4) Administracion del curso");
		System.out.println("5) Generar reportes");
		System.out.println("6) Analisis estadistico");
		System.out.println("7) Salir");
		opcion = scan.nextInt();
		switch(opcion) {
		case 1:
			leerSolicitudes();
			leerAlumnos();
		case 2:
		
		case 3:
		case 4:
		case 5:
		case 6:
			
		case 7:
			break;
		default:
			System.out.println("Ingrese una opcion Valida!!!");
			
		}
		}while(opcion!=7);
		
		
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
			
		}System.out.println("Archivo Alumnos cargado correctamente!");
		scan.close();
	} catch (FileNotFoundException e) {
		System.out.println("Archivo Alumnos no encontrado");
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
			}System.out.println("Archivo Solicitudes cargado correctamente!");
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo");
		}
		
	}

}
