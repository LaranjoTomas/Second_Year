package Aula4;

public class Rectangle {
    private double comprimento;
    private double largura;

    public Rectangle(double comprimento, double largura) {
        if (Validates(comprimento) && Validates(largura)) {
            this.comprimento = comprimento;
            this.largura = largura;
        }
    }

    public double getComprimento() {
        return this.comprimento;
    }

    public double getLargura() {
        return this.largura;
    }

    public void setComprimento(double comprimento) {
        if (Validates(this.comprimento)) {
            this.comprimento = comprimento;
        }
    }

    public void setLargura(double largura) {
        if (Validates(this.largura)) {
            this.largura = largura;
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

        Rectangle other = (Rectangle) obj;
        return this.comprimento == other.comprimento && this.largura == other.largura;
    }

    public double getArea() {
        return this.comprimento * this.largura;
    }

    public double getPerimeter() {
        return 2 * (this.comprimento + this.largura);
    }

    @Override
    public String toString() {
        return "Rectangle with sides " + this.comprimento + ", " + this.largura + " has area "
                + this.getArea() + " and perimeter " + this.getPerimeter();
    }

    public boolean Validates(double side) {
        if (side <= 0)
            throw new IllegalArgumentException("Comprimento e largura não podem ser negativos");
        return true;
    }
}
