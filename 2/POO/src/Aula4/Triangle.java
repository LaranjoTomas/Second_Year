package Aula4;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        if (ValidatesSides(side1) && ValidatesSides(side2) && ValidatesSides(side3)
                && ValidatesTriangle(side1, side2, side3)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    public void setSide1(double side1) {
        if (ValidatesSides(side1)) {
            this.side1 = side1;
        }
    }

    public void setSide2(double side2) {
        if (ValidatesSides(side2)) {
            this.side2 = side2;
        }
    }

    public void setSide3(double side3) {
        if (ValidatesSides(side3)) {
            this.side3 = side3;
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

        Triangle other = (Triangle) obj;
        return this.side1 == other.side1 && this.side2 == other.side2 && this.side3 == other.side3;
    }

    public double getArea() {
        double p = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle with sides " + this.side1 + ", " + this.side2 + ", " + this.side3 + " has area "
                + this.getArea() + " and perimeter " + this.getPerimeter();
    }

    public boolean ValidatesSides(double side) {
        if (side <= 0)
            throw new IllegalArgumentException("Lados não podem ser negativos");
        return true;
    }

    public boolean ValidatesTriangle(double side1, double side2, double side3) {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
            throw new IllegalArgumentException("Não é um triângulo");
        return true;
    }

}
