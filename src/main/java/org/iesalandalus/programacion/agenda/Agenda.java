package org.iesalandalus.programacion.agenda;

public class Agenda {

	private static final int MAX_CONTACTOS = 100;
	
		private int numContactos;
		
		public Agenda() {
			
			this.numContactos = numContactos;
		}
		
		public Contacto[]getContactos() {
			
			Contacto arrayContactos [] = new Contacto[getNumContactos()];
			Contacto [] contactos = new Contacto[getNumContactos()];
			
			System.arraycopy(arrayContactos, 0, contactos, 0, getNumContactos());
			return contactos;
			
		}
		public int getNumContactos() {
			return numContactos;
		}
}	
