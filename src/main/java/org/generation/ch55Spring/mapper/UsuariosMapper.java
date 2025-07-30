package org.generation.ch55Spring.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.generation.ch55Spring.dto.UsuarioRequest;
import org.generation.ch55Spring.dto.TransaccionDTO;

import org.generation.ch55Spring.model.Usuarios;

public class UsuariosMapper {

    public static UsuarioRequest mapUsuarioToDTO(Usuarios usuario) {
        List<TransaccionDTO> transaccionesDTO = usuario.getTransacciones().stream()
                .map(t -> new TransaccionDTO(t.getIdTransaccion(), t.getFecha()))
                .collect(Collectors.toList());

        return new UsuarioRequest(
                usuario.getIdUsuario(),
                usuario.getNombreUsuario(),
                usuario.getCorreoElectronico(),
                transaccionesDTO
        );
    }

}
