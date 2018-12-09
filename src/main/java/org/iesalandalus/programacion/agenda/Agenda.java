package org.iesalandalus.programacion.agenda;

public class Agenda {

	private static final int MAX_CONTACTOS = 100;
	
		private int numContactos;
		
		public Agenda() {
			
			this.numContactos = numContactos;
		}
		
		public Contacto[]getContactos() {
			
			Contacto arrayContactos [] = new Contacto[getNumContactos()];
			Contacto [] copiaDeContactos = new Contacto[getNumContactos()];
			
			System.arraycopy(arrayContactos, 0, copiaDeContactos, 0, getNumContactos());
			return copiaDeContactos;
			
		}
		
		
		public int getNumContactos() {
			return numContactos;
		}
		
		
		public void anadir(Contacto contacto) {
			
		}
		
		private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto) {
			
		private boolean indiceNoSuperaTamano (int ) {
			
		}
	
