package com.example.ApiPokemon.Model;

import com.example.ApiPokemon.Controller.PokemonController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PostPokemonModel {

    public static void main(String[] args) {
        String nomeArquivo = "ListPokemon.json";

        // Cria alguns objetos Post para armazenar no arquivo
        PokemonController.Post post1 = new PokemonController.Post("1", "teste1", "grama", "teste3");
        PokemonController.Post post2 = new PokemonController.Post("2", "teste2", "eletrico", "teste4");

        // Armazena os objetos no arquivo
        List<PokemonController.Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);

        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (PokemonController.Post post : posts) {
                bufferedWriter.write(post.getId() + "\n");
                bufferedWriter.write(post.getNome() + "\n");
                bufferedWriter.write(post.getTipos() + "\n");
                bufferedWriter.write(post.getHabilidades() + "\n");
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
            System.out.println("Arquivo gravado com sucesso.");
        } catch (IOException ex) {
            System.out.println("Erro ao gravar arquivo " + nomeArquivo + ": " + ex.getMessage());
        }

        // Lê os objetos do arquivo
        List<PokemonController.Post> postsLidos = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String id = linha;
                String nome = bufferedReader.readLine();
                String tipos = bufferedReader.readLine();
                String habilidades = bufferedReader.readLine();
                bufferedReader.readLine(); // lê a linha vazia que separa os objetos

                PokemonController.Post post = new PokemonController.Post(id, nome, tipos, habilidades);
                postsLidos.add(post);
            }

            bufferedReader.close();
            System.out.println("Arquivo lido com sucesso.");
        } catch (IOException ex) {
            System.out.println("Erro ao ler arquivo " + nomeArquivo + ": " + ex.getMessage());
        }

        // Imprime os objetos lidos do arquivo
        for (PokemonController.Post post : postsLidos) {
            System.out.println(post.toString());
        }
    }
}
