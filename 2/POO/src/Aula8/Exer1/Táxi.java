package Aula8.Exer1;

public class Táxi extends AutomóvelLigeiro {

    private int NdaLicença;

    public Táxi(String matricula, String marca, String modelo, double potência, int NQuadro, int Capacidade,
            int NdaLicença) {
        super(matricula, marca, modelo, potência, NQuadro, Capacidade);
        this.NdaLicença = NdaLicença;
    }

    public int getNdaLicença() {
        return NdaLicença;
    }

    public void setNdaLicença(int NdaLicença) {
        this.NdaLicença = NdaLicença;
    }

    @Override
    public String toString() {
        return super.toString() + " NdaLicença: " + NdaLicença;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Táxi other = (Táxi) obj;
        if (NdaLicença != other.NdaLicença)
            return false;
        return true;
    }
}
