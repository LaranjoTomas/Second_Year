package Aula8.Exer1;

public class PesadoDeMercadorias extends Viatura {

    private int NQuadro;
    private double Peso;
    private int CargaMax;

    public PesadoDeMercadorias(String matricula, String marca, String modelo, double potência, int NQuadro, double Peso,
            int CargaMax) {
        super(matricula, marca, modelo, potência);
        this.NQuadro = NQuadro;
        this.Peso = Peso;
        this.CargaMax = CargaMax;
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

    public int getCargaMax() {
        return CargaMax;
    }

    public void setCargaMax(int CargaMax) {
        this.CargaMax = CargaMax;
    }

    @Override
    public String toString() {
        return super.toString() + " NQuadro: " + NQuadro + " Peso: " + Peso + " CargaMax: " + CargaMax;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PesadoDeMercadorias other = (PesadoDeMercadorias) obj;
        if (CargaMax != other.CargaMax)
            return false;
        if (NQuadro != other.NQuadro)
            return false;
        if (Double.doubleToLongBits(Peso) != Double.doubleToLongBits(other.Peso))
            return false;
        return true;
    }
}
