<h1>Taller 01 - "El grupo de POO"
  
## Descripcion del proyecto
Programa en Java (Sin POO, ni colecciones) para gestionar la inscripción de alumnos a un grupo de ayudantia de POO, procesando solicitudes automáticamente y permitiendo administración manual del curso.

El Codigo funciona con 2 archivos de textos
- **Alumnos.txt**: que posee los alumnos incritos correctamente en un paralelo
- **Solicitudes.txt**: que posee las solicitudes enviadas para ingresar al grupo de ayudantia

  
El programa ofrece un menu principal con 7 opciones.

- **1) Cargar archivos (Alumnos y solicitudes):**
Lee Alumnos.txt y Solicitudes.txt y los carga en memoria. Debe ejecutarse primero, antes de usar cualquier otra opción.


- **2) Procesar solicitudes (Filtrado Automatico):**
Revisa automáticamente cada solicitud: si la persona figura en algún paralelo, queda admitida; si no, queda rechazada. Detecta y omite solicitudes duplicadas.


- **3) Inscripcion manual al grupo:**
Permite admitir a una persona buscándola por nombre completo o por RUT, sin pasar por el filtrado automático.

- **4) Administracion del curso:**
  
Submenú con:

     1) Cambiar paralelo de un alumno (por RUT) — el cambio se guarda de inmediato en Alumnos.txt.

     2) Eliminar alumno del curso (por nombre) — lo saca tanto de la lista de alumnos como del grupo de admitidos, si correspondía.

     3) Inscribir un alumno nuevo — formato Nombre;Apellido;RUT;Paralelo.

- **5) Generar reportes:**
  Submenú que escribe archivos en la carpeta Reportes/, sin sobrescribir versiones anteriores:

      ReporteC1-VX.txt / ReporteC2-VX.txt — miembros admitidos por paralelo.
  
      Rechazados-VX.txt — solicitudes rechazadas.

Cada vez que se pide un reporte, se crea una versión nueva (X se incrementa automáticamente) y se añade a la carpeta Reportes.

- **6) Analisis estadistico:**
  Muestra el total de solicitudes recibidas, el porcentaje de rechazados, la tasa de admisión y la cantidad de personas que intentaron ingresar más de una vez.

- **7) Salir:**
  Termina el programa
  
## Integrantes
- **Nombre**: Tomás Zepeda | **RUT**: 21.789.061-6 | **Usuario de github**: tomaszepeda2411

## Estructura del proyecto
    |── Reportes             #Carpeta vacia que almacena los reportes sin sobreescribir los anteriores
    ├── src/
    │   └── Main.java        # Clase principal con menús y lógica
    ├── Alumnos.txt          # Archivo de alumnos (nombre;apellido;RUT;Paralelo)
    ├── Solicitudes.txt      # Archivo de solicitudes (Nombre-Apellido)
    └── README.md            # Documentación del proyecto

## Como Ejecutarlo
Desde la carpeta raíz del proyecto (donde están los .txt) O bien, ejecútalo directamente desde Eclipse u otro IDE, asegurándote de que el directorio de trabajo apunte a la carpeta que contiene los archivos .txt.
