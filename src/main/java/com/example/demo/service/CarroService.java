package com.example.demo.service;

import com.example.demo.DTO.CarroDTO;
import com.example.demo.entidade.Carro;
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
        Carro novoCarro = new Carro(dto.marca(), dto.modelo(), dto.ano(), dto.cor());
        return carroRepository.salvar(novoCarro);
    }

    public Carro atualizarCarro(Long id, CarroDTO dto) {
        Carro carro = carroRepository.buscarPorId(id);
        if (carro != null) {
            carro.setMarca(dto.marca());
            carro.setModelo(dto.modelo());
            carro.setAno(dto.ano());
            carro.setCor(dto.cor());
            return carroRepository.salvar(carro);
        }
        throw new RuntimeException("Carro não encontrado com o ID: " + id);
    }

    public void deletarCarro(Long id) {
        carroRepository.deletar(id);
    }
}