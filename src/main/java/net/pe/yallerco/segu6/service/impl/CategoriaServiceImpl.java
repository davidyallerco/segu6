package net.pe.yallerco.segu6.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.pe.yallerco.segu6.dto.GuardarCategoria;
import net.pe.yallerco.segu6.exception.ObjectNotFoundException;
import net.pe.yallerco.segu6.persistence.dao.CategoriaRepository;
import net.pe.yallerco.segu6.persistence.entity.Categoria;
import net.pe.yallerco.segu6.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Page<Categoria> buscarTodos(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Categoria> buscarPorId(Long productoId) {
		return categoriaRepository.findById(productoId);
	}

	@Override
	public Categoria crear(GuardarCategoria guardarCategoria) {
		Categoria categoria = new Categoria();
		categoria.setNombre(guardarCategoria.getNombre());
		categoria.setEstado(Categoria.CategoriaEstado.ENABLED);
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria actualizarPorId(Long categoriaId, GuardarCategoria guardarCategoria) {
		Categoria categoriaDeDB = categoriaRepository.findById(categoriaId)
				.orElseThrow(()-> new ObjectNotFoundException("Categoria not found with id " + categoriaId));
		
		categoriaDeDB.setNombre(guardarCategoria.getNombre());
		
		return categoriaRepository.save(categoriaDeDB);
	}

	@Override
	public Categoria deshabilitarPorId(Long categoriaId) {
		Categoria categoriaDeDB = categoriaRepository.findById(categoriaId)
				.orElseThrow(()-> new ObjectNotFoundException("Categoria not found with id " + categoriaId));
		
		categoriaDeDB.setEstado(Categoria.CategoriaEstado.DISABLED);
		
		return categoriaRepository.save(categoriaDeDB);
	}

}
