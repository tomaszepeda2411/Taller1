// Tomás Zepeda - 21.789.061-6 - ICCI

package taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		int opcion = 0;
		int s = 0;
		int alum = 0;
		String[] rechazados = new String[100];
		String[] admitidos = new String[100];
		String[] admitidosPrint = new String[100];
		String[] solicitudes = new String[100];
		String[] alumnos = new String[100];
		Scanner scan = new Scanner(System.in);
		
		do {
		System.out.println("==== Sistema de Control del Grupo POO ====");
		System.out.println("1) Cargar archivos  (Alumnos y solicitudes)");
		System.out.println("2) Procesar solicitudes (Filtrado automatico)");
		System.out.println("3) Inscripción manual al grupo");
		System.out.println("4) Administración del curso");
		System.out.println("5) Generar reportes");
		System.out.println("6) Análisis estadístico");
		System.out.println("7) Salir");
		
		opcion = evitaCaidas(scan);
		switch(opcion) {
		case 1:
			System.out.println("Archivos Cargados");
			 s =leerSolicitudes(solicitudes,s);
			 alum =leerAlumnos(alumnos,alum);
			break;
			
		case 2:
			System.out.println("Gestionando Solicitudes...");
			int a = 0;
			int r = 0;
			
			
			for(int i=0;i<s;i++) {
				String solicitante = solicitudes[i];
				boolean encontrado = false;
				boolean duplicado = false;
				String paralelo = "";
				String rut = "";
			
				for (int k = 0;k < a;k++) {
					String[] partesA = admitidos[k].split(";");
					String nombre = partesA[0];
					if (nombre.equalsIgnoreCase(solicitante)) {
						duplicado = true;
						break;
						
					}
				}
				if (!duplicado) {
					for (int k =0;k<r;k++) {
						if(rechazados[k].equalsIgnoreCase(solicitante)) {
						duplicado = true;
						break;
					}
				}
			}
				if(duplicado) {
					continue;
				}
				for(int j = 0; j<alum;j++) {
					String[] partes = alumnos[j].split(";");
					String inscrito = partes[0];
					
					if(solicitante.equalsIgnoreCase(inscrito)) {
						encontrado = true;
						rut = partes[1];
						paralelo = partes[2];
						break;
					}
				}
				
				if (encontrado) {
					admitidos[a] = solicitante + "-" + rut;
					admitidosPrint[a] = admitidos[a] + " | Paralelo " + paralelo;
			
					a++;
				}else {
					rechazados[r] = solicitante ;
					r++;
					
				}
			}
		
			System.out.println("==== ADMITIDOS: "+ a +  "====");
			for(int i=0;i<a;i++) {
				System.out.println(admitidosPrint[i]);
			}
			System.out.println("==== Rechazados: "+ r+ "====");
			for(int i=0;i<r;i++) {
				System.out.println(rechazados[i]+ " | No figura en ningun paralelo");
			}
				break;
		case 3:
			int aux = 0;
			do {
			System.out.println("¿Como deseas agregar a la persona?");
			System.out.println("1) Por nombre completo");
			System.out.println("2) Por RUT");
			aux = evitaCaidas(scan);
			switch(aux) {
			case 1:
				System.out.println("Ingrese nombre completo:");
				break;
			case 2:
				System.out.println("Ingrese Rut");
				break;
			default:
				System.out.println("Ingrese una opcion Valida!!!");
			}
			}while (aux != 1 && aux !=2);
				
			
			
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
			
		case 7:
			break;
		default:
			System.out.println("Ingrese una opcion Valida!!!");
			
		}
		}while(opcion!=7);
		
		
	}

	private static int leerAlumnos(String[] alumnos,int alum) {
	File txtAlumnos = new File("Alumnos.txt");
	
	try {
		Scanner scan = new Scanner(txtAlumnos);
		int n = 0;
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombreA = partes[0];
			String apellidoA = partes[1];
			String rut = partes[2];
			String paralelo = partes[3];
			alumnos[n] = nombreA + " "+ apellidoA + ";" + rut + ";" + paralelo;
			n++;
			
			
		}
		System.out.println("-"+ n + " Alumnos inscritos");
		scan.close();
		return n;
		
	} catch (FileNotFoundException e) {
		System.out.println("Archivo Alumnos no encontrado");
	}
	return 0;
	}

	private static int leerSolicitudes(String[] solicitudes,int a) {
		File txtSolicitudes = new File("Solicitudes.txt");
	
		try {
			a = 0;
			Scanner scan = new Scanner(txtSolicitudes);
			while(scan.hasNextLine()) {
				String linea = scan.nextLine();
				String[] partes = linea.split("-");
				String nombreS = partes[0];
				String apellidoS = partes[1];
				solicitudes[a] = nombreS +" "+ apellidoS ;
				a++;
			}
			System.out.println("-"+ a + " solicitudes recibidas");
			scan.close();
			return a;
			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo");
		}
		return 0;
		
		
	}
	
	private static int evitaCaidas(Scanner scan) {
		while(true) {
			try {
				String entrada = scan.nextLine();
				return Integer.parseInt(entrada);
		} catch(NumberFormatException e) {
			System.out.println("Ingrese un numero de las opciones por favor");
			
		}
		}
	}

}
