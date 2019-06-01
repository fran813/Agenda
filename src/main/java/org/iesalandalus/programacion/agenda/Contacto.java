package org.iesalandalus.programacion.agenda;

import java.util.Objects;
import java.util.regex.*;

public class Contacto {

	private static final String ER_TELEFONO = "^[6 9][0-9]{8}$";
	private static final String ER_CORREO = "^\\w+.+[@][a-z]+[.][a-z]{1,5}$";

	private String nombre;
	private String telefono;
	private String correo;

	public Contacto(String nombre, String telefono, String correo) {

		this.setNombre(nombre);
		this.setTelefono(telefono);
		this.setCorreo(correo);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {

		if (nombre == null || nombre.isEmpty() == true) {

			throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
		}

		this.nombre = nombre;

	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {

		if (telefono == null || telefono.isEmpty() == true) {
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
		}

		Pattern patron = Pattern.compile(ER_TELEFONO);
		Matcher introducirTelefono = patron.matcher(telefono);

		if (introducirTelefono.matches() == true) {
			this.telefono = telefono;
		} else {
			throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
		}
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {

		if (correo == null || correo.isEmpty() == true) {
			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
		}

		Pattern pat = Pattern.compile(ER_CORREO);
		Matcher introducirCorreo = pat.matcher(correo);

		if (introducirCorreo.matches() == true) {
			this.correo = correo;
		} else {
			throw new IllegalArgumentException("El correo no tiene un formato válido.");
		}
	}

	@Override
	public String toString() {
		return getIniciales() + " [" + telefono + ", " + correo + "]";
	}

	private String getIniciales() {
		
		String iniciales = "";
		String [] arrayIniciales = nombre.split(" ");		
		for (int i = 0; i < arrayIniciales.length; i++) {
			if (!arrayIniciales[i].equals("")) {
				iniciales = iniciales + arrayIniciales[i].toUpperCase().charAt(0);
			}
		}
		return iniciales;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Contacto other = (Contacto) obj;
		if (Objects.equals(this.nombre.toUpperCase(), other.nombre.toUpperCase())) {
			return true;
		}
		if (!Objects.equals(this.telefono, other.telefono)) {
			return false;
		}
		if (!Objects.equals(this.correo, other.correo)) {
			return false;
		}
		return true;
	}

}
