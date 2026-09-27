package com.example.demo.controller;

import com.example.demo.DTO.CarroDTO;
import com.example.demo.entidade.Carro;
import com.example.demo.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listar() {
        return carroService.listarCarros();
    }

    @PostMapping
    public Carro criar(@RequestBody CarroDTO dto) {
        return carroService.cadastrarCarro(dto);
    }

    // NOVO: Endpoint PUT para atualizar
    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @RequestBody CarroDTO dto) {
        return carroService.atualizarCarro(id, dto);
    }

    // NOVO: Endpoint DELETE para excluir
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        carroService.deletarCarro(id);
    }
}