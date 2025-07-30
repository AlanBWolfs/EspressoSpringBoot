package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion", nullable = false, unique = true)
    private Long idTransaccion;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    public class TransaccionDTO {
        private Long idTransaccion;
        private LocalDateTime fecha;

        //! Relaciones
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_usuario", nullable = false,
                foreignKey = @ForeignKey(name = "fk_ventas_usuarios1"))
        private Users usuario;

        //! Genera automáticamente el valor de fecha
        @PrePersist
        protected void onCreate() {
            this.fecha = LocalDateTime.now();
        }

    }
}