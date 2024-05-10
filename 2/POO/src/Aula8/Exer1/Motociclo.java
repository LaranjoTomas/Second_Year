package Aula8.Exer1;

public class Motociclo extends Viatura {

    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, double potência, String tipo) {
        super(matricula, marca, modelo, potência);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo: " + tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Motociclo other = (Motociclo) obj;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        return true;
    }

}
