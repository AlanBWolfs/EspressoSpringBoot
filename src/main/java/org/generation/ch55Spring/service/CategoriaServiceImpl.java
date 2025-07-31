package org.generation.ch55Spring.service;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Categoria;
import org.generation.ch55Spring.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        return categoriaRepository.findById(id).map(existing -> {
            existing.setNombre(categoria.getNombre()); // 👈 actualizamos solo el nombre (o lo que quieras)
            return categoriaRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Categoría no encontrada con id " + id));
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
