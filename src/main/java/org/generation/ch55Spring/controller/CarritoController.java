package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.dto.CarritoDTO;
import org.generation.ch55Spring.service.CarritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @GetMapping("/{usuarioId}/carrito")
    public List<CarritoDTO> getCartItems(@PathVariable Long usuarioId) {
        return carritoService.getCartItems(usuarioId);
    }

    @PostMapping("/{usuarioId}/carrito/add")
    public CarritoDTO addProductToCart(
            @PathVariable Long usuarioId,
            @RequestParam Long productoId,
            @RequestParam Integer cantidad) {
        return carritoService.addProductToCart(usuarioId, productoId, cantidad);
    }

    @DeleteMapping("/{usuarioId}/carrito/remove")
    public void removeProductFromCart(
            @PathVariable Long usuarioId,
            @RequestParam Long productoId) {
        carritoService.removeProductFromCart(usuarioId, productoId);
    }

    @DeleteMapping("/{usuarioId}/carrito/clear")
    public void clearCart(@PathVariable Long usuarioId) {
        carritoService.clearCart(usuarioId);
    }
}
