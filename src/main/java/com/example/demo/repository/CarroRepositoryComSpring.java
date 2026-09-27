package com.example.demo.repository;

import com.example.demo.entidade.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepositoryComSpring extends JpaRepository<Carro, Long> {
}
