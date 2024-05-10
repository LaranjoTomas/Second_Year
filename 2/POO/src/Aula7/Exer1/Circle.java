package Aula7.Exer1;

public class Circle extends Forma {
    private double raio;
    private String cor;

    public Circle(double raio, String cor) {
        if (Validates(raio) || ValidatesColor(cor)) {
            this.raio = raio;
            this.cor = cor;
        }
    }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        if (Validates(raio)) {
            this.raio = raio;
        }
    }

    public String getCor() {
        return this.cor;
    }

    public void setColor(String cor) {
        if (ValidatesColor(cor)) {
            this.cor = cor;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if (this.getCor() != ((Circle) obj).getCor())
            return false;

        Circle other = (Circle) obj;
        return this.raio == other.raio;
    }

    public double getArea() {

        int roundedNum = (int) (Math.PI * Math.pow(raio, 2) * 100.0);
        return roundedNum / 100.0;
    }

    public double getPerimeter() {
        int roundedNum = (int) (2 * Math.PI * raio * 100.0);
        return roundedNum / 100.0;
    }

    @Override
    public String toString() {
        return "Circle with radius " + this.raio + " has area " + this.getArea() + " and perimeter "
                + this.getPerimeter() + " and color " + this.getCor() + ".\n";
    }

    public boolean Validates(double raio) {
        if (raio < 0)
            throw new IllegalArgumentException("Raio não pode ser negativo.\n");
        return true;
    }
}
