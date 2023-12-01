package net.pe.yallerco.segu6.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.pe.yallerco.segu6.dto.GuardarProducto;
import net.pe.yallerco.segu6.exception.ObjectNotFoundException;
import net.pe.yallerco.segu6.persistence.dao.ProductoRespository;
import net.pe.yallerco.segu6.persistence.entity.Categoria;
import net.pe.yallerco.segu6.persistence.entity.Producto;
import net.pe.yallerco.segu6.persistence.entity.Producto.ProductoEstado;
import net.pe.yallerco.segu6.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRespository productoRespository;

	@Override
	public Page<Producto> buscarTodos(Pageable pageable) {
		return productoRespository.findAll(pageable);
	}

	@Override
	public Optional<Producto> buscarPorId(Long productoId) {
		return productoRespository.findById(productoId);
	}

	@Override
	public Producto crear(GuardarProducto guardarProducto) {
		
		Producto producto = new Producto();
		producto.setNombre(guardarProducto.getNombre());
		producto.setPrecio(guardarProducto.getPrecio());
		producto.setEstado(Producto.ProductoEstado.ENABLED);
		
		Categoria categoria = new Categoria();
		categoria.setId(guardarProducto.getCategoriaId());
		producto.setCategoria(categoria);
		
		return productoRespository.save(producto);
	}

	@Override
	public Producto actualizarPorId(Long productoId, GuardarProducto guardarProducto) {
		Producto productoDeDB = productoRespository.findById(productoId)
				.orElseThrow(()-> new ObjectNotFoundException("Producto no found with id " + productoId));
		
		productoDeDB.setNombre(guardarProducto.getNombre());
		productoDeDB.setPrecio(guardarProducto.getPrecio());
		
		Categoria categoria = new Categoria();
		categoria.setId(guardarProducto.getCategoriaId());
		productoDeDB.setCategoria(categoria);
		
		return productoRespository.save(productoDeDB);
	}

	@Override
	public Producto deshabilitarPorId(Long productoId) {
		Producto productoDeDB = productoRespository.findById(productoId)
				.orElseThrow(()-> new ObjectNotFoundException("Producto no found with id " + productoId));
		productoDeDB.setEstado(Producto.ProductoEstado.DISABLED);
		return productoRespository.save(productoDeDB);
	}

}
