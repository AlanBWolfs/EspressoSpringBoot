package org.generation.ch55Spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {
    private Long idCarrito;
    private Integer cantidad;
    private Long usuarioId;
    private Long productoId;
    private String nombreProducto;
    private BigDecimal precioProducto;
}
