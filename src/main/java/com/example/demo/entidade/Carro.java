package com.example.demo.entidade;

import jakarta.persistence.*;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;

    // Construtor vazio obrigatório pelo JPA
    public Carro() {}

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters e Setters (Encapsulamento)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
}