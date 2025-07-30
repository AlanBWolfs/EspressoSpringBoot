package org.generation.ch55Spring.dto;

import java.time.LocalDateTime;

public class TransaccionDTO {
    private Long idTransaccion;
    private LocalDateTime fecha;

    public TransaccionDTO() {}

    public TransaccionDTO(Long idTransaccion, LocalDateTime fecha) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
