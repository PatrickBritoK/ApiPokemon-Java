package com.example.ApiPokemon.Controller;

public class PokemonController {
    private final int id;
    private final String nome;
    private final String tipo;
    private final String habilidade;
    private final String sexo;

    public PokemonController(int id, String nome, String tipo, String habilidade, String sexo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.habilidade = habilidade;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getHabilidade() {
        return habilidade;
    }
}
