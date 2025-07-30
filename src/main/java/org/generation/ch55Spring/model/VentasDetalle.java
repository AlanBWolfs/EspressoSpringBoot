package org.generation.ch55Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas_detalle", schema = "espressocafe")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentasDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @Column(name = "id_transaccion", nullable = false)
    private Integer idTransaccion;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "descuento", nullable = false, precision = 10, scale = 2)
    private BigDecimal descuento = BigDecimal.ZERO;

    @Column(name = "total_a_pagar", precision = 10, scale = 2)
    private BigDecimal totalAPagar;

    @Column(name = "ISR", precision = 10, scale = 2)
    private BigDecimal isr;

    @Column(name = "comision_pagina", precision = 10, scale = 2)
    private BigDecimal comisionPagina;

    @Column(name = "utilidad", precision = 10, scale = 2)
    private BigDecimal utilidad;

    @Column(name = "metodo_pago", nullable = false, length = 30)
    private String metodoPago;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "estado_recoleccion", nullable = false, length = 45)
    private String estadoRecoleccion;

    @Column(name = "pago_realizado", nullable = false)
    private Boolean pagoRealizado = false;

    //! Eliminar los @JsonIgnore una vez se implementen las otras tablas
    //Relaciones opcionales si tienes las entidades correspondientes
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_transaccion", insertable = false, updatable = false)
    private Transacciones transaccion;

    @ManyToOne(fetch = FetchType.LAZY)
<<<<<<< HEAD:src/main/java/org/generation/ch55Spring/model/ventas_detalle.java
   @JoinColumn(name = "id_producto", insertable = false, updatable = false)
   private Productos producto;
=======
    @JsonIgnore
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
   private Productos producto;
>>>>>>> origin/betzabet:src/main/java/org/generation/ch55Spring/model/VentasDetalle.java

   @ManyToOne(fetch = FetchType.LAZY)
   @JsonIgnore
   @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
   private Users usuario;
}
