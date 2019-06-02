package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;


public class MainApp {

	private static final String ERROR = "Error, la acción no ha podido realizarse";
	private static final String EXITO = "Acción realizada con éxito";
    private static Agenda agenda;

	public static void main(String[] args) throws OperationNotSupportedException{
		
		agenda = new Agenda();
		mostrarMenu();
	}
	
	private static void mostrarMenu() throws OperationNotSupportedException {
	
	int opcion;
	System.out.println("Programa para gestionar una agenda de contactos");
	System.out.println("1 - Añadir Contacto");
	System.out.println("2 - Buscar Contacto");
	System.out.println("3 - Borrar Contacto");
	System.out.println("4 - Listar Agenda");
	System.out.println("0 - Salir");
	opcion = elegirOpcion();
	ejecutarOpcion(opcion);
	}
	
	private static int elegirOpcion() {

		int opcion;
		do {
			System.out.println("Elige una opcion.");
			opcion = Entrada.entero();
		} while (opcion > 4 || opcion < 0);
		if (opcion == 0) {
			System.out.println("Hasta prontoo!");
			System.exit(0);
		}
		return opcion;
	}
	
	private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {

		switch (opcion) {
		case 1:
			anadirContacto();
			mostrarMenu();
			break;
		case 2:
			buscarContacto();
			mostrarMenu();
			break;
		case 3:
			borrarContacto();
			mostrarMenu();
			break;
		case 4:
			listarAgenda();
			mostrarMenu();
			break;
		}
	}
	
	private static void anadirContacto() throws OperationNotSupportedException {

		String nombre, correo, telefono;
		System.out.println("Introduce nombre del contacto.");
		nombre = Entrada.cadena();
		System.out.println("Introduce su número de telefono.");
		telefono = Entrada.cadena();
		System.out.println("Introduce su correo electronido.");
		correo = Entrada.cadena();
		try {
			Contacto contactoNuevo = new Contacto(nombre, telefono, correo);
			agenda.anadir(contactoNuevo);
			System.out.println(EXITO);
			System.out.println(contactoNuevo + " Ha sido añadido");
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + ", los datos introducidos no son correctos.");
		}
	}
	
	private static void buscarContacto() {
		
		System.out.println("Introduce el nombre del contacto que quieres buscar.");
		String nombre = Entrada.cadena();
		if (agenda.buscar(nombre) == null) {
			System.out.println(ERROR + ", el contacto no existe.");
		}else {
			System.out.println(EXITO);
			System.out.println(agenda.buscar(nombre).toString());
		}
	}
	
	private static void borrarContacto(){
		
		String nombre;
		System.out.println("Introduce el nombre del contacto que quieres borrar.");
		nombre = Entrada.cadena();		
		try {
			agenda.borrar(nombre);
			System.out.println(EXITO + ", el contacto ha sido eliminado.");
		}catch(OperationNotSupportedException e){            
            System.out.println(ERROR + ", el contacto no se encuentra en la agenda.");
       }
	}
	
	private static void listarAgenda() {
		if (agenda.getNumContactos() == 0) {
			System.out.println(ERROR + ", la agenda está vacia.");
		} else {
			System.out.println(EXITO + ", la agenda contiene los siguientes contactos:");
			Contacto[] contactos = agenda.getContactos();
			for (int i = 0; i < contactos.length && contactos[i] != null; i++)
				System.out.println(contactos[i]);
		}
	}
}
