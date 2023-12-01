package net.pe.yallerco.segu6.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class GuardarProducto implements Serializable{

	@NotBlank
	private String nombre;
	
	@DecimalMin(value = "0.01", message = "el precio debe ser mayor a cero")
	private BigDecimal precio;
	
	@Min(value = 1)
	private Long categoriaId;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	
	
	
	
	
}
