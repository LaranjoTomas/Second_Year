package Aula8.Exer1;

public class AutomóvelLigeiro extends Viatura {

    private int NQuadro;
    private int Capacidade;

    public AutomóvelLigeiro(String matricula, String marca, String modelo, double potência, int NQuadro,
            int Capacidade) {
        super(matricula, marca, modelo, potência);
        this.NQuadro = NQuadro;
        this.Capacidade = Capacidade;
    }

    public int getNQuadro() {
        return NQuadro;
    }

    public void setNQuadro(int NQuadro) {
        this.NQuadro = NQuadro;
    }

    public int getCapacidade() {
        return Capacidade;
    }

    public void setCapacidade(int Capacidade) {
        this.Capacidade = Capacidade;
    }

    @Override
    public String toString() {
        return super.toString() + " NQuadro: " + NQuadro + " Capacidade: " + Capacidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AutomóvelLigeiro other = (AutomóvelLigeiro) obj;
        if (Capacidade != other.Capacidade)
            return false;
        if (NQuadro != other.NQuadro)
            return false;
        return true;
    }
}
