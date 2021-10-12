package com.gmail.joaomarcos.appaulas;

public class Disciplina {

    public int id;
    public String nome, aula, turno;

    public Disciplina() {

    }

    public Disciplina(String nome, String aula, String turno) {
        this.nome = nome;
        this.aula = aula;
        this.turno = turno;
    }

    public Disciplina(int id, String nome, String aula, String turno) {
        this.id = id;
        this.nome = nome;
        this.aula = aula;
        this.turno = turno;
    }

    @Override
    public String toString() {
        return nome + "  |  " + aula + "  |  " + turno;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
