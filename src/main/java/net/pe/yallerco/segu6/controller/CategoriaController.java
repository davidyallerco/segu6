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
import net.pe.yallerco.segu6.dto.GuardarCategoria;
import net.pe.yallerco.segu6.dto.GuardarProducto;
import net.pe.yallerco.segu6.persistence.entity.Categoria;
import net.pe.yallerco.segu6.persistence.entity.Producto;
import net.pe.yallerco.segu6.service.CategoriaService;
import net.pe.yallerco.segu6.service.ProductoService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<Page<Categoria>> buscarTodos(Pageable pageable){
		
		Page<Categoria> categoriasPage = categoriaService.buscarTodos(pageable);
		if(categoriasPage.hasContent()) {
			return ResponseEntity.ok(categoriasPage);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/categoriaId")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long categoriaId){
		
		
		Optional<Categoria> categoria = categoriaService.buscarPorId(categoriaId);
		
		if(categoria.isPresent()){
			return ResponseEntity.ok(categoria.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> crear(@RequestBody @Valid GuardarCategoria guardarCategoria){
		
		Categoria categoria = categoriaService.crear(guardarCategoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	
	}
	
	@PutMapping("/{categoriaId}")
	public ResponseEntity<Categoria> actualizarPorId(@PathVariable Long categoriaId, @RequestBody @Valid GuardarCategoria guardarCategoria){
		
		Categoria categoria = categoriaService.actualizarPorId(categoriaId,guardarCategoria);
		return ResponseEntity.ok(categoria);
	
	}
	
	@PutMapping("/{categoriaId}/disabled")//averiguar controller, store, collection, document
	public ResponseEntity<Categoria> desabilitarPorId(@PathVariable Long categoriaId){
		
		Categoria categoria = categoriaService.deshabilitarPorId(categoriaId);
		return ResponseEntity.ok(categoria);
	
	}
}
