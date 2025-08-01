package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Transacciones;
import org.generation.ch55Spring.repository.TransaccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionesServiceImpl implements TransaccionesService {

    @Autowired
    private TransaccionesRepository transaccionesRepository;

    @Override
    public Transacciones save(Transacciones transaccion) {
        return transaccionesRepository.save(transaccion);
    }

    @Override
    public List<Transacciones> findAll() {
        return transaccionesRepository.findAll();
    }

    @Override
    public Transacciones findById(Long id) {
        Optional<Transacciones> result = transaccionesRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transaccionesRepository.deleteById(id);
    }

    @Override
    public Transacciones update(Long id, Transacciones transaccion) {
        if (transaccionesRepository.existsById(id)) {
            transaccion.setId(id);
            return transaccionesRepository.save(transaccion);
        }
        return null;
    }
}
