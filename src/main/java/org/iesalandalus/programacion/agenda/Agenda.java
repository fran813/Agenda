package org.iesalandalus.programacion.agenda;

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

	public void anadir(Contacto contacto) {
			
		}

	private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto) {

	private boolean indiceNoSuperaTamano (int ) {
			
		}
