package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion", nullable = false, unique = true)
    private Long idTransaccion;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "fk_ventas_usuarios1"))
    private Usuarios usuario;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }

    public void setId(Long id) {
    }
}
