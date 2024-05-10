package Aula8.Exer1;

public class Viatura implements KmPercorridosInterface {
    private String matricula;
    private String marca;
    private String modelo;
    private double potencia;

    private int ultimoTrajeto = 0;
    private int distanciaTotal = 0;

    public Viatura(String matricula, String marca, String modelo, double potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotência(double potencia) {
        this.potencia = potencia;
    }

    public void trajeto(int quilometros) {
        System.out.println("O veículo " + this.getMatricula() + " percorreu " + quilometros + " quilômetros.");
        this.ultimoTrajeto = quilometros;
        this.distanciaTotal += quilometros;
    }

    public int ultimoTrajeto() {
        return this.ultimoTrajeto;
    }

    public int distanciaTotal() {
        return this.distanciaTotal;
    }

    @Override
    public String toString() {
        return "Matrícula: " + this.getMatricula() + " Marca: " + this.getMarca() + " Modelo: " + this.getModelo()
                + " Potência: " + this.getPotencia();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final Viatura other = (Viatura) obj;
        return this.getMatricula().equals(other.getMatricula()) &&
                this.getMarca().equals(other.getMarca()) &&
                this.getModelo().equals(other.getModelo()) &&
                this.getPotencia() == other.getPotencia();
    }

}
