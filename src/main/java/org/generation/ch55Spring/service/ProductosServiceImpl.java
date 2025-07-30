package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Productos;
import org.generation.ch55Spring.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepository productosRepository;

    @Autowired
    public ProductosServiceImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> getAllProducts() {
        return productosRepository.findAll();
    }

    @Override
    public Productos getProductById(Long id) {
        return productosRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El producto con el id " + id + " no existe")
        );
    }

    @Override
    public Productos deleteProductById(Long id) {
        Productos tmp = null;
        if (!productosRepository.existsById(id)) return tmp;
        tmp = productosRepository.findById(id).get();
        productosRepository.deleteById(id);
        return tmp;
    }

    @Override
    public Productos addProduct(Productos product) {
        return productosRepository.save(product);
    }

    @Override
    public Productos updateProductById(Long id, Productos productUpdated) {
        Optional<Productos> optionalProduct = productosRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("El producto con el id " + id + " no existe");
        }

        Productos originalProduct = optionalProduct.get();

        if (productUpdated.getTipo() != null) originalProduct.setTipo(productUpdated.getTipo());
        if (productUpdated.getCategoria() != null) originalProduct.setCategoria(productUpdated.getCategoria());
        if (productUpdated.getSubcategoria() != null) originalProduct.setSubcategoria(productUpdated.getSubcategoria());
        if (productUpdated.getProductoNombre() != null) originalProduct.setProductoNombre(productUpdated.getProductoNombre());
        if (productUpdated.getDescripcion() != null) originalProduct.setDescripcion(productUpdated.getDescripcion());
        if (productUpdated.getPrecio() != null) originalProduct.setPrecio(productUpdated.getPrecio());
        if (productUpdated.getImagen() != null) originalProduct.setImagen(productUpdated.getImagen());
        if (productUpdated.getEnMenu() != null) originalProduct.setEnMenu(productUpdated.getEnMenu());

        return productosRepository.save(originalProduct);
    }
}
