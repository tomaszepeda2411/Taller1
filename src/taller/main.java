// Tomás Zepeda - 21.789.061-6 - ICCI

package taller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		int opcion = 0;
		int s = 0;
		int alum = 0;
		int a = 0;
		int r = 0;
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
		try {
		switch(opcion) {
		case 1:
			System.out.println("Archivos Cargados");
			 s =leerSolicitudes(solicitudes,s);
			 alum =leerAlumnos(alumnos,alum);
			break;
			
		case 2:
			System.out.println("Gestionando Solicitudes...");
			
			for(int i=0;i<s;i++) {
				String solicitante = solicitudes[i];
				boolean encontrado = false;
				boolean duplicado = false;
				String paralelo = "";
				String rut = "";
			
				for (int k = 0;k < a;k++) {
					String[] partesA = admitidos[k].split("-");
					String nombre = partesA[0];
					if (nombre.equalsIgnoreCase(solicitante)) {
						duplicado = true;
						break;
						
					}
				}
				if (!duplicado) {
					for (int k =0;k<r;k++) {
						if(r >= rechazados.length) {
							System.out.println("La lista de rechazados esta llena");
							break;
						}
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
			String nombre = "";
			int aux = 0;
			do {
				
			System.out.println("¿Como deseas agregar a la persona?");
			System.out.println("1) Por nombre completo");
			System.out.println("2) Por RUT");
			
			aux = evitaCaidas(scan);
			
			switch(aux) {
			
			case 1:
				System.out.println("Ingrese nombre completo(Nombre Apellido):");
				nombre = scan.nextLine();
				boolean NombreDuplicado = false;
				for(int k=0;k< a;k++) {
					String[] partes = admitidos[k].split("-");
					String nombreD = partes[0];
					if(nombreD.equalsIgnoreCase(nombre)) {
						NombreDuplicado=true;
						break;
					}
				}
				if(!NombreDuplicado) {
					for(int k =0;k<r;k++) {
						if(rechazados[k].equalsIgnoreCase(nombre)) {
							NombreDuplicado=true;
							break;
						}
					}
				}
				if(NombreDuplicado) {
					System.out.println("El alumno ya esta en el grupo");
					break;
				}
				boolean encontrado = false;
				String alumno = "";
				String rut = "";
				String paralelo = "";
				
				for(int i=0;i<alumnos.length;i++) {
					
					String linea = alumnos[i];
					if (linea == null) {
						continue;
					}
					String[] partes = linea.split(";");
					String nombreA = partes[0];
					
					
					if(nombreA.equalsIgnoreCase(nombre)) {
						encontrado = true;
						rut = partes[1];
						paralelo = partes[2];
						break;
					}
					
				}
				if(encontrado) {
					System.out.println("Nombre encontado en el paralelo "+ paralelo);
					admitidos[a] = nombre + "-" + rut;
					admitidosPrint[a] = admitidos[a] + " |  Paralelo " + paralelo;
					a++;
				}else {
					System.out.println("Nombre no figura en los paralelos");
					if(r >= rechazados.length) {
						System.out.println("La lista de rechazados esta llena");
						break;
					}
					rechazados[r] = nombre;
					r++;
				}
				
				break;
				
			case 2:
				System.out.println("Ingrese Rut: ");
				 rut = scan.nextLine();
				
				 boolean RutDuplicado = false;
				 for (int k = 0; k<a;k++) {
					 String[] partes = admitidos[k].split("-");
					 String rutA = partes[1];
					 if(rutA.equalsIgnoreCase(rut)) {
						 RutDuplicado = true;
						 break;
					 }
				 }
				 if(RutDuplicado) {
					 System.out.println("El rut ya se encuentra en los admitidos");
					 break;
				 }
				 boolean Rencontrado = false;
				 String nombreR = "";
				 String paraleloR="";
				 
				for(int i = 0;i<alum;i++) {
					String linea = alumnos[i];
					if(linea==null) {
						continue;
					}
					
					String[] partes = linea.split(";");
					String rutA = partes[1];
					
			
					
					if(rutA.equalsIgnoreCase(rut)) {
					Rencontrado = true;
					nombreR = partes[0];
					paraleloR = partes[2];
					break;
				
					}
					
				}
				if(Rencontrado) {
					System.out.println("RUT encontrado en el paralelo:" + paraleloR);
					admitidos[a] = nombreR + "-" + rut;
					admitidosPrint[a] = admitidos[a] + " | Paralelo " + paraleloR;
					a++;
				}else {
					System.out.println("RUT no encontrado");
					System.out.println("Al no tener el nombre, se ingresara el rut a la lista de rechazados");
					if(r >= rechazados.length) {
						System.out.println("La lista de rechazados esta llena");
						break;
					}
				    rechazados[r] = rut;
				    r++;
				}
				
				break;
			default:
				System.out.println("Ingrese una opcion Valida!!!");
			}
			}while (aux != 1 && aux !=2);
			

			break;
		case 4:
			int op;
			do{
				System.out.println("==== ADMINISTRACION DEL CURSO ====");
				System.out.println("1- Cambiar paralelo de un alumno");
				System.out.println("2- Eliminar alumno del curso");
				System.out.println("3- Inscribir un alumno nuevo");
				System.out.println("4- Volver");
				System.out.println("Ingrese una opcion:");
				op = evitaCaidas(scan);
				switch(op) {
				case 1:
					System.out.print("Ingrese rut del alumno: ");
					String rut = scan.nextLine().trim();
					boolean rutActual = false;
					
					for (int i = 0; i<alumnos.length;i++) {
						String linea = alumnos[i];
						if(linea==null) {
							continue;
						}
						String[] partes = linea.split(";");
						
						if(partes.length>=3) {
						String nombreParalelo = partes[0].trim();
						String rutParalelo = partes[1].trim();
						String paralelo = partes[2].trim();
						
						if(rut.equalsIgnoreCase(rutParalelo)) {
							rutActual = true;
							System.out.println("Alumno: "+ nombreParalelo + "(Actualmente en "+ paralelo + ")");
							System.out.println("Nuevo paralelo (C1/C2): ");
							String paralel = scan.nextLine().trim().toUpperCase();
							
							while(!paralel.equalsIgnoreCase("C1") && !paralel.equalsIgnoreCase("C2")) {
								System.out.println("Opcion Invalida, Intentelo De nuevo: ");
								paralel = scan.nextLine().trim().toUpperCase();
						}
						alumnos[i] = nombreParalelo + ";" + rutParalelo +";" + paralel;
						
						for(int k =0; k<a;k++) {
							if(admitidos[k] !=null && admitidos[k].contains(rutParalelo)) {
								admitidosPrint[k] = admitidos[k] + " | Paralelo "+ paralel;
							}
						}
						guardarAlumnos(alumnos,alum);
						System.out.println("Paralelo nuevo guardado.");
						break;
						}
					}
				}
					if(!rutActual) {
						System.out.println("El RUT no es encontro entre los alumnos");
					}
					break;
				case 2:
					System.out.println("Ingrese el nombre del alumno a Eliminar(Nombre Apellido): ");
					String alumnoEliminar = scan.nextLine().trim();
					boolean Eliminar = false;
					boolean EliminarGrupo = false;
					int pos = -1;
					int pos2=-1;
					
					for(int i = 0;i<alum;i++) {
						
						if(alumnos[i] != null){
							String[] partes = alumnos[i].split(";");
							String nombreCompleto = partes[0];
							if(nombreCompleto.equalsIgnoreCase(alumnoEliminar)) {
							Eliminar = true;
							pos = i;
							
							break;
							}
							
						}
					}
					for( int j=0;j<a;j++) {
						String[] partes = admitidos[j].split("-");
						String nombreE = partes[0];
						if(nombreE.equalsIgnoreCase(alumnoEliminar)) {
							EliminarGrupo = true;
							pos2=j;
							break;
						}
						
						
					}
					if(Eliminar) {
						for(int i=pos;i<alum-1;i++) {
							alumnos[i] = alumnos[i+1];
						}
						alumnos[alum-1] = null;
						alum--;
						guardarAlumnos(alumnos,alum);
						System.out.println("Alumno eliminado y guardado.");
					}else {
						System.out.println("El alumno no se ha encontrado");
					}
					if(EliminarGrupo) {
						for(int j=pos2;j<a-1;j++) {
							admitidos[j] = admitidos[j+1];
							admitidosPrint[j] = admitidosPrint[j+1];
						}
						admitidos[a-1] = null;
						admitidosPrint[a-1] = null;
						a--;
						System.out.println("Alumno eliminado del grupo");
					}else {
						System.out.println("No se ha encontrado al alumno en el grupo");
					}
					break;
				case 3:
					System.out.println("Ingresa el alumno que quieres inscribir al curso(Respete formato (Nombre;Apellido;RUT;Paralelo): ");
					String alumnoNuevo = scan.nextLine().trim();
					String[] partes = alumnoNuevo.split(";");
					if(partes.length <4) {
						System.out.println("Formato invalidado,deben ser 4 datos separados por ';'");
						break;
					}
					String nombreN = partes[0].trim();
					String apellidoN = partes[1].trim();
					String rutN = partes[2].trim();
					String paraleloN = partes[3].toUpperCase();
					
					if(!paraleloN.equals("C1") && !paraleloN.equals("C2")) {
						System.out.println("El paralelo solo puede ser C1 o C2");
						break;
					}
					
					boolean rutUnico = true;
					for(int i = 0;i<alum;i++) {
						if(alumnos[i] != null){
							String[] partes2 = alumnos[i].split(";");
							String rutViejo = partes2[1];
							if(rutN.equalsIgnoreCase(rutViejo)) {
								rutUnico = false;
								break;
							
							}
								
							}
						}
					
					if(!rutUnico) {
						System.out.println("Rut ya encontrado en la lista de alumnos");
					}else {
						if(alum>=alumnos.length) {
							System.out.println("Se ha llegado al limite de alumnos inscritos");
						}else {
							alumnos[alum] = nombreN + " " + apellidoN + ";" + rutN + ";" + paraleloN;
							alum++;
							guardarAlumnos(alumnos,alum);
							System.out.println("Alumno inscrito");
						}
					}
 					break;
				case 4:
					break;
				default:
					System.out.println("Ingrese una opcion valida");
				
			}
			}while(op!=4);
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
		} catch (Exception e) {
			System.out.println("Ocurrio un error inesperado" + e + "Volviendo al menu princiapl....");
		}
		}while(opcion!=7);
		
		
	}

	private static int leerAlumnos(String[] alumnos,int alum) {
	File txtAlumnos = new File("Alumnos.txt");
	
	try {
		Scanner scan = new Scanner(txtAlumnos);
		int n = 0;
		while(scan.hasNextLine()) {
			String linea = scan.nextLine().trim();
			if(linea.isEmpty()) {
				continue;
			}
			
			String[] partes = linea.split(";");
			if(partes.length <4) {
				continue;
			}
			if (n>= alumnos.length) {
				System.out.println("Has llegado al limite de alumnos por inscribir");
				break;
			}
			String nombreA = partes[0].trim();
			String apellidoA = partes[1].trim();
			String rut = partes[2].trim();
			String paralelo = partes[3].trim();
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
				String linea = scan.nextLine().trim();
				if(linea.isEmpty()) {
					continue;
				}
				String[] partes = linea.split("-");
				if(partes.length <2) {
					continue;
				}
				if(a>=solicitudes.length) {
					System.out.println("Has llegado al limite de solicitudes");
					break;
				}
				String nombreS = partes[0].trim();
				String apellidoS = partes[1].trim();
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
	
	public static void guardarAlumnos(String[] alumnos,int cantidad) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Alumnos.txt"))){
			for (int i = 0; i<cantidad;i++) {
				if(alumnos[i] !=null && !alumnos[i].trim().isEmpty()) {
					String[] partes = alumnos[i].split(";");
					String[] nom = partes[0].split(" ");
					
					String nombre= "";
					if(nom.length>0) {
						nombre = nom[0];
					}
					String apellido ="";
					for(int j =1;j<nom.length;j++) {
						if(j>1) {
							apellido = apellido + " ";
						}
						apellido = apellido + nom[j];
					}
					bw.write(nombre + ";" + apellido + ";" + partes[1] + ";" + partes[2] );
					bw.newLine();
				}
			}
			System.out.println("Cambios guardados correctamente");
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo");
			
		}
	}

}
