package org.iesalandalus.programacion.agenda;

import java.util.Objects;
import java.util.regex.*;

public class Contacto {
	
	private static final String ER_TELEFONO = "^[6 9][0-9]{8}$";
	private static final String ER_CORREO = "^\\w+.+[@]\\w+.[a-z]{2,5}$";
	
	private String nombre;
	private String telefono;
	private String correo;

public Contacto(String nombre, String telefono, String correo) {

}

public String getNombre() {
	return nombre;
}

private void setNombre(String nombre) {
	
	if ( nombre == null || nombre.isEmpty()) {		
	} else {
		throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
	}
	this.nombre = nombre;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	
	Pattern patron = Pattern.compile(ER_TELEFONO);
	Matcher introducirTelefono = patron.matcher(telefono);
	
	if (introducirTelefono.matches() == false) {
	}else {
		throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
	}
	if (telefono == null || telefono.isEmpty()) {
	} else {
		throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
	}
		this.telefono = telefono;
	}
	

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	
	Pattern pat = Pattern.compile(ER_CORREO);
	Matcher introducirCorreo = pat.matcher(correo);
	
	if (correo == null || correo.isEmpty()) {
	} else {
		throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
	}
	if (introducirCorreo.matches() == false) {
	}else {
		throw new IllegalArgumentException("El correo no tiene un formato válido.");
	}
	this.correo = correo;
}


}
