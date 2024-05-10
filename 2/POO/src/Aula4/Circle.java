package Aula4;

public class Circle {
    private double raio;

    public Circle(double raio) {
        if (Validates(raio)) {
            this.raio = raio;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Circle other = (Circle) obj;
        return this.raio == other.raio;
    }

    public double getArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * raio;
    }

    @Override
    public String toString() {
        return "Circle with radius " + this.raio + " has area " + this.getArea() + " and perimeter "
                + this.getPerimeter() + ".\n";
    }

    public boolean Validates(double raio) {
        if (raio < 0)
            throw new IllegalArgumentException("Raio não pode ser negativo.\n");
        return true;
    }
}
