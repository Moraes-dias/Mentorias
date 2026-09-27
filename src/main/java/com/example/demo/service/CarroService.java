package com.example.demo.service;

import com.example.demo.DTO.CarroDTO;
import com.example.demo.entidade.Carro;
import com.example.demo.repository.CarroRepositoryComSpring;
import com.example.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarCarros() {
        return carroRepository.listarTodos();
    }

    public Carro cadastrarCarro(CarroDTO dto) {
        // Converte o DTO para a Entidade (POO)
        Carro novoCarro = new Carro(dto.marca(), dto.modelo());
        return carroRepository.salvar(novoCarro);
    }
}