package org.generation.ch55Spring.mapper;

import org.generation.ch55Spring.dto.VentasDetalleDTO;
import org.generation.ch55Spring.model.VentasDetalle;

public class VentasDetalleMapper {

    public static VentasDetalleDTO toDTO(VentasDetalle entity) {
        VentasDetalleDTO dto = new VentasDetalleDTO();
        dto.setIdDetalle(entity.getIdDetalle());
        dto.setIdTransaccion(entity.getIdTransaccion());
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setIdProducto(entity.getIdProducto());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setCantidad(entity.getCantidad());
        dto.setDescuento(entity.getDescuento());
        dto.setMetodoPago(entity.getMetodoPago());
        dto.setFecha(entity.getFecha());
        dto.setEstadoRecoleccion(entity.getEstadoRecoleccion());
        dto.setPagoRealizado(entity.getPagoRealizado());
        return dto;
    }

    public static VentasDetalle toEntity(VentasDetalleDTO dto) {
        VentasDetalle entity = new VentasDetalle();
        entity.setIdDetalle(dto.getIdDetalle());
        entity.setIdTransaccion(dto.getIdTransaccion());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setIdProducto(dto.getIdProducto());
        entity.setPrecioUnitario(dto.getPrecioUnitario());
        entity.setCantidad(dto.getCantidad());
        entity.setDescuento(dto.getDescuento());
        entity.setMetodoPago(dto.getMetodoPago());
        entity.setFecha(dto.getFecha());
        entity.setEstadoRecoleccion(dto.getEstadoRecoleccion());
        entity.setPagoRealizado(dto.getPagoRealizado());
        return entity;
    }
}