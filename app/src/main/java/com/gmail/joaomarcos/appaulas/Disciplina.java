package com.gmail.joaomarcos.appaulas;

public class Disciplina {

    public int id;
    public String nome, aula;

    public Disciplina() {

    }

    public Disciplina(String nome, String aula) {
        this.nome = nome;
        this.aula = aula;
    }

    public Disciplina(int id, String nome, String aula) {
        this.id = id;
        this.nome = nome;
        this.aula = aula;
    }

    @Override
    public String toString() {
        return nome + "  |  " + aula;
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

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}
