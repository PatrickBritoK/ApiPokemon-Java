package com.example.ApiPokemon.Controller;

public class PokemonController {
    public static class Post {
        private int id;
        private String nome;
        private String tipos;
        private String habilidades;

        public Post(String id, String nome, String tipos, String habilidades) {
            this.id = Integer.parseInt(id);
            this.nome = nome;
            this.tipos = tipos;
            this.habilidades = habilidades;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTipos() {
            return tipos;
        }

        public void setTipos(String tipos) {
            this.tipos = tipos;
        }

        public String getHabilidades() {
            return habilidades;
        }

        public void setHabilidades(String habilidades) {
            this.habilidades = habilidades;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "id ='" + id + '\'' +
                    ", nome ='" + nome + '\'' +
                    ", tipos ='" + tipos + '\'' +
                    ", habilidades ='" + habilidades + '\'' +
                    '}';
        }

    }
}
