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
            Gson gsonLido = new GsonBuilder()
                    .setLenient()
                    .create();
            PokemonController[] pokemonsArray = gsonLido.fromJson(sb.toString(), PokemonController[].class);
            pokemons = new ArrayList<>(Arrays.asList(pokemonsArray));

            // Determina o último ID salvo no arquivo
            if (!pokemons.isEmpty()) {
                lastId = pokemons.get(pokemons.size() - 1).getId();
            }

            System.out.println("###Adicione um Pokemon###");
        } catch (IOException ex) {
            System.out.println("Erro ao ler arquivo " + nomeArquivo + ": " + ex.getMessage());
        }

        int id = lastId + 1;
        //Nome do pokemon
        while (true) {
            System.out.println("Digite o nome do Pokémon:");
            String nome = scanner.nextLine();
            if (nome == null || nome.trim().isEmpty()) {
                System.out.println("Nome inválido. Por favor, digite novamente.");
                continue; // Volta para o início do loop
            }
            System.out.println("nome: " + nome);

            System.out.println("Qual a região?");
            String regiao = scanner.nextLine();


            //Sexo do pokemon
            System.out.println("Digite M=Macho/F=Femea/D=Desconhecido \n Se a resposta for em branco vai ser automaticamente dada como Desconhecido.");
            String sexo = scanner.nextLine();
            if (sexo.equals("M") || sexo.equals("m")) {
                sexo = "Macho";
            } else if (sexo.equals("F") || sexo.equals("f")) {
                sexo = "Femea";
            } else if (sexo.equals("D") || sexo.equals("d")) {
                sexo = "Desconhecido";
            } else if (sexo.isEmpty()) {
                sexo = "Desconhecido";
            }
            System.out.println("sexo: " + sexo);

            //Tipo de pokemon
            String[] tipos = {"Normal", "Lutador", "Voador", "Venenoso", "Terra", "Pedra", "Inseto", "Fantasma", "Aço", "Fogo", "Água", "Planta", "Elétrico", "Psíquico", "Gelo", "Dragão", "Noturno", "Fada", "Desconhecido"};

            System.out.println("Escolha o tipo do Pokémon:");
            for (int i = 0; i < tipos.length; i++) {
                System.out.println((i + 1) + ". " + tipos[i]);
            }

            int escolhaTipo = scanner.nextInt();
            scanner.nextLine();

            String tipo;

            if (escolhaTipo < 1 || escolhaTipo > tipos.length) {
                System.out.println("Escolha inválida.");
                tipo = "desconhecido";
            } else {
                tipo = tipos[escolhaTipo - 1];
            }
            System.out.println("tipo: " + tipo);
            //Habilidades do pokemon
            System.out.println("O Pokémon possui uma ou duas habilidades? (1/2)");
            int numHabilidades = scanner.nextInt();
            scanner.nextLine();

            String[] habilidades = new String[numHabilidades];

            for (int i = 0; i < numHabilidades; i++) {
                System.out.println("Digite a habilidade #" + (i + 1) + " do Pokémon:");
                habilidades[i] = scanner.nextLine();
            }
            //Se o pokemon for shiny
            System.out.println("O Pokémon entra na categoria shiny?(s/n)");
            String shiny = scanner.nextLine();
            if (shiny.equals("s") || shiny.equals("S")) {
                shiny = "True";
            } else if (shiny.equals("n") || shiny.equals("N")) {
                shiny = "false";
            }

            // Cria um objeto Pokémon com as informações do usuário
            PokemonController pokemon = new PokemonController(id, nome, tipo, habilidades, sexo, shiny, regiao);

            id++;
            pokemons.add(pokemon);


            System.out.println("Deseja adicionar mais um Pokémon? (s/n)");
            String resposta = scanner.nextLine();

            if (resposta.equals("n")) {
                break;
            }}
        scanner.close();


        // Cria um objeto Gson para serializar a lista de Pokémon em formato JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pokemons);

        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            fileWriter.write(json);
            fileWriter.close();
            System.out.println("Pokemon registrado com sucesso.");
        } catch (IOException ex) {
            System.out.println("Erro ao gravar arquivo " + nomeArquivo + ": " + ex.getMessage());
        }}}

