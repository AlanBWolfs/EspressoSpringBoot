package org.generation.ch55Spring.service;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Subsubcategoria;
import org.generation.ch55Spring.repository.SubsubcategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubsubcategoriaServiceImpl implements SubsubcategoriaService {

    private final SubsubcategoriaRepository subsubcategoriaRepository;

    @Override
    public List<Subsubcategoria> findAll() {
        return subsubcategoriaRepository.findAll();
    }

    @Override
    public Optional<Subsubcategoria> findById(Long id) {
        return subsubcategoriaRepository.findById(id);
    }

    @Override
    public Subsubcategoria save(Subsubcategoria subsubcategoria) {
        return subsubcategoriaRepository.save(subsubcategoria);
    }

    @Override
    public Subsubcategoria update(Long id, Subsubcategoria subsubcategoria) {
        return subsubcategoriaRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(subsubcategoria.getNombre());
                    existing.setSubcategoria(subsubcategoria.getSubcategoria());
                    return subsubcategoriaRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Sub-subcategoría no encontrada"));
    }

    @Override
    public void delete(Long id) {
        subsubcategoriaRepository.deleteById(id);
    }
}
