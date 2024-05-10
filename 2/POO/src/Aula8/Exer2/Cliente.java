package Aula8.Exer2;

public class Cliente {

    private String nome;
    private String nif;

    public Cliente(String nome, String nif) {
        this.setNome(nome);
        this.setNif(nif);
    }

    @Override
    public String toString() {
        return "Cliente = " + getNome() + ", " + getNif();
    }

    public java.lang.String getNome() {
        return this.nome;
    }

    public void setNome(java.lang.String value) {
        this.nome = value;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (nif == null) {
            if (other.nif != null)
                return false;
        } else if (!nif.equals(other.nif))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nif == null) ? 0 : nif.hashCode());
        return result;
    }
}
