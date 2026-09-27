package com.example.demo.repository;

import com.example.demo.entidade.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CarroRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Carro salvar(Carro carro) {
        if (carro.getId() == null) {
            entityManager.persist(carro); // INSERT
            return carro;
        } else {
            return entityManager.merge(carro); // UPDATE
        }
    }

    public List<Carro> listarTodos() {
        return entityManager.createQuery("SELECT c FROM Carro c", Carro.class)
                .getResultList();
    }

    // NOVO: Buscar por ID para edição
    public Carro buscarPorId(Long id) {
        return entityManager.find(Carro.class, id);
    }

    // NOVO: Deletar carro
    @Transactional
    public void deletar(Long id) {
        Carro carro = entityManager.find(Carro.class, id);
        if (carro != null) {
            entityManager.remove(carro);
        }
    }
}