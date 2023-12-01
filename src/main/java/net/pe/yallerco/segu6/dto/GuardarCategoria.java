package net.pe.yallerco.segu6.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public class GuardarCategoria implements Serializable{

	@NotBlank
	private String nombre;
//	private BigDecimal precio;
//	private Long categoriaId;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public BigDecimal getPrecio() {
//		return precio;
//	}
//	public void setPrecio(BigDecimal precio) {
//		this.precio = precio;
//	}
//	public Long getCategoriaId() {
//		return categoriaId;
//	}
//	public void setCategoriaId(Long categoriaId) {
//		this.categoriaId = categoriaId;
//	}
	
	
	
	
	
	
}
