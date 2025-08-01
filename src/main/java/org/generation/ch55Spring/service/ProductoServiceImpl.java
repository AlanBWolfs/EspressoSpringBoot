package org.generation.ch55Spring.service;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Producto;
import org.generation.ch55Spring.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Long id, Producto producto) {
        return productoRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(producto.getNombre());
                    existing.setDescripcion(producto.getDescripcion());
                    existing.setPrecio(producto.getPrecio());
                    existing.setImagen(producto.getImagen());
                    existing.setSubsubcategoria(producto.getSubsubcategoria());
                    return productoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findBySubsubcategoriaId(Long subsubcategoriaId) {
        return productoRepository.findBySubsubcategoriaId(subsubcategoriaId);
    }
}
