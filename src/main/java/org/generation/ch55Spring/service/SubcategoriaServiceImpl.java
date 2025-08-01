package org.generation.ch55Spring.service;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Subcategoria;
import org.generation.ch55Spring.repository.SubcategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubcategoriaServiceImpl implements SubcategoriaService {

    private final SubcategoriaRepository subcategoriaRepository;

    @Override
    public List<Subcategoria> findAll() {
        return subcategoriaRepository.findAll();
    }

    @Override
    public Optional<Subcategoria> findById(Long id) {
        return subcategoriaRepository.findById(id);
    }

    @Override
    public Subcategoria save(Subcategoria subcategoria) {
        return subcategoriaRepository.save(subcategoria);
    }

    @Override
    public Subcategoria update(Long id, Subcategoria subcategoria) {
        return subcategoriaRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(subcategoria.getNombre());
                    existing.setCategoria(subcategoria.getCategoria());
                    return subcategoriaRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));
    }

    @Override
    public void delete(Long id) {
        subcategoriaRepository.deleteById(id);
    }
}
