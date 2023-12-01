package net.pe.yallerco.segu6.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.pe.yallerco.segu6.dto.GuardarProducto;
import net.pe.yallerco.segu6.persistence.entity.Producto;
import net.pe.yallerco.segu6.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping
	public ResponseEntity<Page<Producto>> buscarTodos(Pageable pageable){
		
		Page<Producto> productosPage = productoService.buscarTodos(pageable);
		if(productosPage.hasContent()) {
			return ResponseEntity.ok(productosPage);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{productoId}")
	public ResponseEntity<Producto> buscarPorId(@PathVariable Long productoId){
		
		
		Optional<Producto> producto = productoService.buscarPorId(productoId);
		
		if(producto.isPresent()){
			return ResponseEntity.ok(producto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Producto> crear(@RequestBody @Valid GuardarProducto guardarProducto){
		
		Producto producto = productoService.crear(guardarProducto);
		return ResponseEntity.status(HttpStatus.CREATED).body(producto);
	
	}
	
	@PutMapping("/{productoId}")
	public ResponseEntity<Producto> actualizarPorId(@PathVariable Long productoId, @RequestBody @Valid GuardarProducto guardarProducto){
		
		Producto producto = productoService.actualizarPorId(productoId,guardarProducto);
		return ResponseEntity.ok(producto);
	
	}
	
	@PutMapping("/{productoId}/disabled")//averiguar controller, store, collection, document
	public ResponseEntity<Producto> desabilitarPorId(@PathVariable Long productoId){
		
		Producto producto = productoService.deshabilitarPorId(productoId);
		return ResponseEntity.ok(producto);
	
	}
}
