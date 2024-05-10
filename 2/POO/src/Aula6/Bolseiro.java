package Aula6;

import Aula5.DateYMD;

public class Bolseiro extends Aluno {

    private float Bolsa;
    private String ProfName;

    public Bolseiro(String nome, int cc, DateYMD dataNasc, Professor Professor, float Bolsa) {
        super(nome, cc, dataNasc);
        this.ProfName = Professor.getNome();
        this.Bolsa = Bolsa;
    }

    public String getOrientador() {
        return ProfName;
    }

    public float getBolsa() {
        return Bolsa;
    }

    public void setBolsa(float Bolsa) {
        this.Bolsa = Bolsa;
    }

    public void setProfName(String ProfName) {
        this.ProfName = ProfName;
    }

    @Override
    public String toString() {
        return "Professor Orientador: " + ProfName + "; Valor da Bolsa: " + Bolsa + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final Bolseiro other = (Bolseiro) obj;
        return this.Bolsa == other.Bolsa && this.ProfName.equals(other.ProfName) && super.equals(obj);
    }
}
