package com.catolica;

public class Pessoa {
    private int rg;
    private String name;
    private int idade;

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "rg=" + rg +
                ", name='" + name + '\'' +
                ", idade=" + idade +
                '}';
    }
}
