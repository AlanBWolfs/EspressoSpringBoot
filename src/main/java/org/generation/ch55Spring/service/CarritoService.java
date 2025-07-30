package org.generation.ch55Spring.service;

import org.generation.ch55Spring.dto.CarritoDTO;

import java.util.List;

public interface CarritoService {

    List<CarritoDTO> getCartItems(Long usuarioId);

    CarritoDTO addProductToCart(Long usuarioId, Long productoId, Integer cantidad);

    void removeProductFromCart(Long usuarioId, Long productoId);

    void decreaseProductQuantity(Long usuarioId, Long productoId, Integer cantidad);

    void clearCart(Long usuarioId);

}
