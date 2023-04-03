package com.example.ApiPokemon.Model;

import com.example.ApiPokemon.Controller.PokemonController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class PostPokemonModel {

    public static void main(String[] args) {
        String nomeArquivo = "ListPokemon.json";

        List<PokemonController> pokemons = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int lastId = 0;

        // Lê os objetos do arquivo e determina o último ID salvo
        try {
            Scanner fileScanner = new Scanner(new File(nomeArquivo));
            StringBuilder sb = new StringBuilder();

            while (fileScanner.hasNextLine()) {
                sb.append(fileScanner.nextLine());
            }

            fileScanner.close();

            // Converte o JSON de volta para uma lista de objetos Pokemon
            // Converte o JSON de volta para uma lista de objetos Pokemon
            Gson gsonLido = new GsonBuilder()
                    .setLenient()
                    .create();
            PokemonController[] pokemonsArray = gsonLido.fromJson(sb.toString(), PokemonController[].class);
            pokemons = new ArrayList<>(Arrays.asList(pokemonsArray));

            // Determina o último ID salvo no arquivo
            if (!pokemons.isEmpty()) {
                lastId = pokemons.get(pokemons.size() - 1).getId();
            }

            System.out.println("Arquivo lido com sucesso.");
        } catch (IOException ex) {
            System.out.println("Erro ao ler arquivo " + nomeArquivo + ": " + ex.getMessage());
        }

        int id = lastId + 1;

        while (true) {
            System.out.println("Digite o nome do Pokémon:");
            String nome = scanner.nextLine();

            System.out.println("Digite o tipo do Pokémon:");
            String tipo = scanner.nextLine();

            System.out.println("Digite a habilidade do Pokémon:");
            String habilidade = scanner.nextLine();

            // Cria um objeto Pokémon com as informações do usuário
            PokemonController pokemon = new PokemonController(id, nome, tipo, habilidade);

            id++;
            pokemons.add(pokemon);


            System.out.println("Deseja adicionar mais um Pokémon? (s/n)");
            String resposta = scanner.nextLine();

            if (resposta.equals("n")) {
                break;
            }
        }
        scanner.close();

        // Cria um objeto Gson para serializar a lista de Pokémon em formato JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pokemons);

        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            fileWriter.write(json);
            fileWriter.close();
            System.out.println("Arquivo gravado com sucesso.");
        } catch (IOException ex) {
            System.out.println("Erro ao gravar arquivo " + nomeArquivo + ": " + ex.getMessage());
        }
        for (PokemonController pokemon : pokemons) {
            System.out.println(pokemon.toString());
        }
    }
}
