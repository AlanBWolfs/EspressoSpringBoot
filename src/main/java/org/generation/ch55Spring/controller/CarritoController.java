package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.dto.CarritoDTO;
import org.generation.ch55Spring.dto.CarritoRequestDTO;
import org.generation.ch55Spring.service.CarritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @GetMapping("/{usuarioId}/carrito")
    public ResponseEntity<List<CarritoDTO>> getCartItems(@PathVariable Long usuarioId) {
        List<CarritoDTO> items = carritoService.getCartItems(usuarioId);
        return ResponseEntity.ok(items);
    }

    @PostMapping("/{usuarioId}/carrito/add")
    public ResponseEntity<CarritoDTO> addProductToCart(
            @PathVariable Long usuarioId,
            @RequestBody CarritoRequestDTO carritoRequest) {

        try {
            CarritoDTO carritoDTO = carritoService.addProductToCart(
                    usuarioId,
                    carritoRequest.getProductoId(),
                    carritoRequest.getCantidad());
            return ResponseEntity.status(HttpStatus.CREATED).body(carritoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{usuarioId}/carrito/remove")
    public ResponseEntity<Void> removeProductFromCart(
            @PathVariable Long usuarioId,
            @RequestParam Long productoId) {
        carritoService.removeProductFromCart(usuarioId, productoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{usuarioId}/carrito/decrease")
    public ResponseEntity<Void> decreaseProductQuantity(
            @PathVariable Long usuarioId,
            @RequestParam Long productoId,
            @RequestParam Integer cantidad) {
        carritoService.decreaseProductQuantity(usuarioId, productoId, cantidad);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{usuarioId}/carrito/clear")
    public ResponseEntity<Void> clearCart(@PathVariable Long usuarioId) {
        carritoService.clearCart(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
