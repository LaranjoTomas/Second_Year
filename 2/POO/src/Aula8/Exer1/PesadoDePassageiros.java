package Aula8.Exer1;

public class PesadoDePassageiros extends Viatura {

    private int NQuadro;
    private double Peso;
    private int NMaxPassageiros;

    public PesadoDePassageiros(String matricula, String marca, String modelo, double potência, int NQuadro, double Peso,
            int NMaxPassageiros) {
        super(matricula, marca, modelo, potência);
        this.NQuadro = NQuadro;
        this.Peso = Peso;
        this.NMaxPassageiros = NMaxPassageiros;
    }

    public int getNQuadro() {
        return NQuadro;
    }

    public void setNQuadro(int NQuadro) {
        this.NQuadro = NQuadro;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public int getNMaxPassageiros() {
        return NMaxPassageiros;
    }

    public void setNMaxPassageiros(int NMaxPassageiros) {
        this.NMaxPassageiros = NMaxPassageiros;
    }

    @Override
    public String toString() {
        return super.toString() + " NQuadro: " + NQuadro + " Peso: " + Peso + " NMaxPassageiros: " + NMaxPassageiros;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PesadoDePassageiros other = (PesadoDePassageiros) obj;
        if (NMaxPassageiros != other.NMaxPassageiros)
            return false;
        if (NQuadro != other.NQuadro)
            return false;
        if (Double.doubleToLongBits(Peso) != Double.doubleToLongBits(other.Peso))
            return false;
        return true;
    }

}
