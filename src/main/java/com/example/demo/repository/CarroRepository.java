package com.example.demo.repository;

import com.example.demo.entidade.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // Diz ao Spring que esta classe faz parte da camada de persistência
public class CarroRepository {

    // Injeta a ferramenta oficial do JPA para gerenciar entidades e interagir com o banco
    @PersistenceContext
    private EntityManager entityManager;

    // Operação de Salvar (INSERT ou UPDATE)
    @Transactional // Obrigatório em operações que alteram o banco de dados
    public Carro salvar(Carro carro) {
        if (carro.getId() == null) {
            entityManager.persist(carro); // Equivalente ao INSERT
            return carro;
        } else {
            return entityManager.merge(carro); // Equivalente ao UPDATE
        }
    }

    // Operação de Listar Todos (SELECT * FROM carros)
    public List<Carro> listarTodos() {
        return entityManager.createQuery("SELECT c FROM Carro c", Carro.class)
                .getResultList();
    }
}