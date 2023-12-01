package net.pe.yallerco.segu6.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.pe.yallerco.segu6.dto.GuardarProducto;
import net.pe.yallerco.segu6.persistence.entity.Producto;

public interface ProductoService {
	
	Page<Producto> buscarTodos(Pageable pageable);
	
	Optional<Producto> buscarPorId(Long productoId);
	
	Producto crear(GuardarProducto guardarProducto);

	Producto actualizarPorId(Long productoId,  GuardarProducto guardarProducto);

	Producto deshabilitarPorId(Long productoId);

}
