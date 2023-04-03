package com.example.ApiPokemon.Controller;

import java.util.Arrays;

public class PokemonController {
    private final int id;
    private final String nome;
    private final String regiao;
    private final String tipo;
    private final String habilidades;
    private final String sexo;
    private final String shiny;

    public PokemonController(int id, String nome, String tipo, String[] habilidades, String sexo, String shiny, String regiao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.habilidades = Arrays.toString(habilidades);
        this.sexo = sexo;
        this.shiny = shiny;
        this.regiao = regiao;
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

}
