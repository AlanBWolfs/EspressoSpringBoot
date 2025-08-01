package org.generation.ch55Spring.service;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.dto.CarritoDTO;
import org.generation.ch55Spring.model.Carrito;
import org.generation.ch55Spring.model.Producto;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.repository.CarritoRepository;
import org.generation.ch55Spring.repository.ProductoRepository;
import org.generation.ch55Spring.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;
    private final UsuarioRepository usuariosRepository;
    private final ProductoRepository productosRepository;

    @Override
    public List<CarritoDTO> getCartItems(Long usuarioId) {
        List<Carrito> carritos = carritoRepository.findByUsuarioIdUsuario(usuarioId);

        return carritos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarritoDTO addProductToCart(Long usuarioId, Long productoId, Integer cantidad) {
        Usuarios usuario = usuariosRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Producto producto = productosRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Carrito carrito = carritoRepository.findByUsuarioIdUsuarioAndProductoIdProducto(usuarioId, productoId)
                .orElse(new Carrito());

        carrito.setUsuario(usuario);
        carrito.setProducto(producto);
        carrito.setCantidad(
                carrito.getCantidad() == null ? cantidad : carrito.getCantidad() + cantidad);

        Carrito saved = carritoRepository.save(carrito);

        return convertToDTO(saved);
    }

    @Override
    public void removeProductFromCart(Long usuarioId, Long productoId) {
        carritoRepository.findByUsuarioIdUsuarioAndProductoIdProducto(usuarioId, productoId)
                .ifPresent(carritoRepository::delete);
    }

    @Override
    public void decreaseProductQuantity(Long usuarioId, Long productoId, Integer cantidad) {
        Carrito carrito = carritoRepository.findByUsuarioIdUsuarioAndProductoIdProducto(usuarioId, productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en el carrito"));

        int cantidadActual = carrito.getCantidad() != null ? carrito.getCantidad() : 0;
        int nuevaCantidad = cantidadActual - cantidad;

        if (nuevaCantidad > 0) {
            carrito.setCantidad(nuevaCantidad);
            carritoRepository.save(carrito);
        } else {
            // Si la nueva cantidad es 0 o menos, eliminar el producto del carrito
            carritoRepository.delete(carrito);
        }
    }

    @Override
    public void clearCart(Long usuarioId) {
        List<Carrito> items = carritoRepository.findByUsuarioIdUsuario(usuarioId);
        carritoRepository.deleteAll(items);
    }

    // Método privado para mapear entidad a DTO
    private CarritoDTO convertToDTO(Carrito carrito) {
        CarritoDTO dto = new CarritoDTO();
        dto.setIdCarrito(carrito.getIdCarrito());
        dto.setCantidad(carrito.getCantidad());
        dto.setUsuarioId(carrito.getUsuario().getIdUsuario());
        dto.setProductoId(carrito.getProducto().getIdProducto());
        dto.setNombreProducto(carrito.getProducto().getNombre());
        dto.setPrecioProducto(carrito.getProducto().getPrecio());
        return dto;
    }
}
