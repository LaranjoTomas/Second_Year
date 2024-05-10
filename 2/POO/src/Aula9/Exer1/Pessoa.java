package Aula9.Exer1;

import Aula5.DateYMD;

public class Pessoa {
    private String nome;
    private int cc;
    private DateYMD dataNasc;

    public Pessoa(String nome, int cc, DateYMD dataNasc) {
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public int getCc() {
        return cc;
    }

    public DateYMD getDataNasc() {
        return dataNasc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public void setDataNasc(DateYMD dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return nome + "; CC: " + cc + "; Data de Nascimento: " + dataNasc;
    }

    public int compareTo(Pessoa p) {
        return this.nome.compareTo(p.getNome());
    }
}
