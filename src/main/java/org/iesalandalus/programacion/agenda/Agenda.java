package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;



public class Agenda {

	private static final int MAX_CONTACTOS = 100;

	private int numContactos;

	private Contacto[] contactos;

	public Agenda() {

		numContactos = 0;
		contactos = new Contacto[MAX_CONTACTOS];
	}

	public Contacto[] getContactos() {

		Contacto[] copiaContactos = new Contacto[MAX_CONTACTOS];
		for (int i = 0; i < copiaContactos.length; i++) {
			copiaContactos[i] = contactos[i];
		}

		return copiaContactos;
	}

	public int getNumContactos() {

		return numContactos;
	}

	public void anadir(Contacto contacto) throws OperationNotSupportedException {
		
		if (contactos == null) {
			throw new IllegalArgumentException("No se puede insertar un contacto nulo.");
		}			
		int indice = buscarPrimerIndiceComprobandoExistencia(contacto);
        if (!indiceNoSuperaTamano(indice)) {
            contactos[indice] = contacto;
            numContactos++;
        } else
			throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
	}	

	private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto)throws OperationNotSupportedException {
		
		int indice = 0;
		boolean contactoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !contactoEncontrado) {
			if (contactos[indice].equals(contacto)) {
				contactoEncontrado = true;
			}else {
				indice++;
			}
		}
		return indice;		
	}

	private boolean indiceNoSuperaTamano (int indice ) {
		
		return indice < numContactos;
	}
	
	public Contacto buscar(String nombre) {
		
		int indice = buscarIndiceCliente(nombre);
		if(indice == MAX_CONTACTOS)
			return null;
		return contactos[indice];
	}

	private int buscarIndiceCliente(String nombre) {

		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] != null) {
				if (contactos[i].getNombre().equals(nombre))
					return i;
			}
		}
		return MAX_CONTACTOS;
	}
	
	public void borrar (String nombre) throws OperationNotSupportedException{
		
		if (nombre == null) {
			throw new OperationNotSupportedException("No se puede borrar un nombre nulo.");
		}
		int indice = buscarIndiceCliente(nombre);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}else {
			throw new OperationNotSupportedException("El contacto a borrar no existe.");
		}
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {

		for (int i = indice; i < numContactos - 1; i++) {
			contactos[i] = contactos[i + 1];
		}
		contactos[numContactos] = null;
		numContactos--;
	}
	
}
