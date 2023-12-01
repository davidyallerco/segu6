package net.pe.yallerco.segu6.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	private CategoriaEstado estado;
	
	
	public static enum CategoriaEstado{
		ENABLED, DISABLED;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public CategoriaEstado getEstado() {
		return estado;
	}


	public void setEstado(CategoriaEstado estado) {
		this.estado = estado;
	}

	
	
	

	
	
	
}
