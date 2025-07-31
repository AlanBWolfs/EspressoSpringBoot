package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Favoritos;
import org.generation.ch55Spring.model.FavoritosId;
import org.generation.ch55Spring.repository.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritosServiceImpl implements FavoritosService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    @Override
    public Favoritos save(Favoritos favorito) {
        return favoritosRepository.save(favorito);
    }

    @Override
    public List<Favoritos> findAll() {
        return favoritosRepository.findAll();
    }

    @Override
    public Favoritos findById(Long id) {
        Optional<Favoritos> favorito = favoritosRepository.findById(new FavoritosId());
        return favorito.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public Favoritos update(Long id, Favoritos favorito) {
        return null;
    }
}