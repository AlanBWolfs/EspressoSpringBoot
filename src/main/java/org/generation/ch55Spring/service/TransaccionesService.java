package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Transacciones;
import java.util.List;

public interface TransaccionesService {
    Transacciones save(Transacciones transaccion);
    List<Transacciones> findAll();
    Transacciones findById(Long id);
    void deleteById(Long id);
    Transacciones update(Long id, Transacciones transaccion);
}