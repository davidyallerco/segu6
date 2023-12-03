package net.pe.yallerco.segu6.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public class GuardarCategoria implements Serializable{

	@NotBlank
	private String nombre;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
	
	
	
}
