package com.example.ApiPokemon.Model;

import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class PokemonName {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número ou nome do Pokemon: ");
        String userInput = scanner.nextLine();

        String url = "https://pokeapi.co/api/v2/pokemon/" + userInput.toLowerCase();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(request);
        String responseBody = EntityUtils.toString(response.getEntity());

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(responseBody, JsonObject.class);

        String name = json.get("name").getAsString();
        int id = json.get("id").getAsInt();
        int height = json.get("height").getAsInt();
        double weight = json.get("weight").getAsDouble();

        System.out.println("id: " + id);
        System.out.println("Nome: " + name);
        System.out.println("Altura: 0," + height + " metros" );
        System.out.println("Peso: " + weight);

        scanner.close();
    }
}
