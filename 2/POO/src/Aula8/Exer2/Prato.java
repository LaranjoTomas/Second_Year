package Aula8.Exer2;

import java.util.ArrayList;
import java.util.List;

public class Prato {

    private final String nome;
    private final List<Alimento> listaAlimentos;
    private final int contagemIngredientes;

    public Prato(String nome) {
        this.nome = nome;
        listaAlimentos = new ArrayList<>();
        contagemIngredientes = 0;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Prato  '" + nome + "', composto por " + contagemIngredientes + " Ingredientes";
    }

    public boolean adicionarIngrediente(Alimento alim) {
        listaAlimentos.add(alim);
        return true;
    }

    public String alimentosInfo() {
        String msg = "";

        for (Alimento alimento : listaAlimentos) {
            msg = msg.concat(alimento.toString());
        }
        return msg;
    }

    public double totalPeso() {
        double p = 0;
        for (Alimento alimento : listaAlimentos) {
            p = p + alimento.getPeso();
        }
        return p;
    }

    public double totalCalorias() {
        Double parcial;
        double calorias = 0.0;

        for (Alimento alim : listaAlimentos) {
            parcial = alim.getCalorias();
            calorias = calorias + parcial;
        }
        return calorias;
    }

    public double totalProteinas() {
        double parcial;
        double proteinas = 0;
        for (Alimento alim : listaAlimentos) {
            parcial = alim.getCalorias();
            proteinas = proteinas + parcial;
        }
        return proteinas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prato other = (Prato) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
}
