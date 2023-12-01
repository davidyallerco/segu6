package net.pe.yallerco.segu6.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.pe.yallerco.segu6.dto.GuardarCategoria;
import net.pe.yallerco.segu6.dto.GuardarProducto;
import net.pe.yallerco.segu6.persistence.entity.Categoria;
import net.pe.yallerco.segu6.persistence.entity.Producto;

public interface CategoriaService {
	
	Page<Categoria> buscarTodos(Pageable pageable);
	
	Optional<Categoria> buscarPorId(Long productoId);
	
	Categoria crear(GuardarCategoria guardarCategoria);

	Categoria actualizarPorId(Long categoriaId,  GuardarCategoria guardarCategoria);

	Categoria deshabilitarPorId(Long categoriaId);

}
