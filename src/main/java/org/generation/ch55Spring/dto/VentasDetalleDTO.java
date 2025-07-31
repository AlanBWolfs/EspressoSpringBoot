package org.generation.ch55Spring.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VentasDetalleDTO {
    private Long idDetalle;
    private Long idTransaccion;
    private Long idUsuario;
    private Long idProducto;
    private BigDecimal precioUnitario;
    private Long cantidad;
    private BigDecimal descuento;
    private String metodoPago;
    private LocalDateTime fecha;
    private String estadoRecoleccion;
    private Boolean pagoRealizado;

    // Getters y setters
    public Long getIdDetalle() { return idDetalle; }
    public void setIdDetalle(Long idDetalle) { this.idDetalle = idDetalle; }

    public Long getIdTransaccion() { return idTransaccion; }
    public void setIdTransaccion(Long idTransaccion) { this.idTransaccion = idTransaccion; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdProducto() { return idProducto; }
    public void setIdProducto(Long idProducto) { this.idProducto = idProducto; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }

    public Long getCantidad() { return cantidad; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }

    public BigDecimal getDescuento() { return descuento; }
    public void setDescuento(BigDecimal descuento) { this.descuento = descuento; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getEstadoRecoleccion() { return estadoRecoleccion; }
    public void setEstadoRecoleccion(String estadoRecoleccion) { this.estadoRecoleccion = estadoRecoleccion; }

    public Boolean getPagoRealizado() { return pagoRealizado; }
    public void setPagoRealizado(Boolean pagoRealizado) { this.pagoRealizado = pagoRealizado; }
}
