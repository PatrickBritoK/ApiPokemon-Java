package com.example.ApiPokemon.Controller;

public class PokemonController {
    private int id;
    private String nome;
    private String tipo;
    private String habilidade;

    public PokemonController(int id, String nome, String tipo, String habilidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.habilidade = habilidade;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
}

