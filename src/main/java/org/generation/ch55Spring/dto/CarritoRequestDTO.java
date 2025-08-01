package org.generation.ch55Spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarritoRequestDTO {
    private Long productoId;
    private Integer cantidad;
}
