package Aula8.Exer2;

import java.util.ArrayList;
import java.util.List;

public class Ementa {

    public static final int NR_PRATOS_NA_EMENTA = 4;

    private String nome;
    private String local;
    private final List<Prato> pratos;

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        this.pratos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("Ementa [nome=" + nome + ", local=" + local + "]\n");
        for (Prato prato : pratos) {
            builder.append("\t");
            builder.append(prato.getNome());
            builder.append("\t");
        }
        builder.append("]");
        return builder.toString();

    }

    public void addPrato(Prato prato) {
        pratos.add(prato);
    }

    public Prato listarPrato(int ordem) {
        return pratos.get(ordem);
    }

    public void listarPratos() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ementa other = (Ementa) obj;
        if (local == null) {
            if (other.local != null)
                return false;
        } else if (!local.equals(other.local))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (pratos == null) {
            if (other.pratos != null)
                return false;
        } else if (!pratos.equals(other.pratos))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((local == null) ? 0 : local.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((pratos == null) ? 0 : pratos.hashCode());
        return result;
    }
}
