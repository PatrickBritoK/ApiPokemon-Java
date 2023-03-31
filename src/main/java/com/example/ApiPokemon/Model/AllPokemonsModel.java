package com.example.ApiPokemon.Model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class AllPokemonsModel {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0");
        CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(request);
        String responseBody = EntityUtils.toString(response.getEntity());

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(responseBody, JsonObject.class);
        JsonArray results = json.getAsJsonArray("results");

        for (JsonElement element : results) {
            JsonObject pokemon = element.getAsJsonObject();
            String name = pokemon.get("name").getAsString();
            String url = pokemon.get("url").getAsString();
            int id = Integer.parseInt(url.substring(url.substring(0, url.lastIndexOf("/")).lastIndexOf("/") + 1, url.lastIndexOf("/")));

            System.out.println("id: " + id);
            System.out.println("Nome: " + name);

            //Não tem como puxar outras informações pq o json so tem o nome.
        }
    }
}
