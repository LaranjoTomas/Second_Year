package Aula7.Exer1;

public class Triangle extends Forma {
    private double side1;
    private double side2;
    private double side3;
    private String cor;

    public Triangle(double side1, double side2, double side3, String cor) {
        if (ValidatesSides(side1) && ValidatesSides(side2) && ValidatesSides(side3) && ValidatesColor(cor)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.cor = cor;
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

    public String getCor() {
        return this.cor;
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
        if (this.getCor() != ((Triangle) obj).getCor())
            return false;

        Triangle other = (Triangle) obj;
        return this.side1 == other.side1 && this.side2 == other.side2 && this.side3 == other.side3;
    }

    public double getArea() {
        double p = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3) * 10.0) / 10.0;
    }

    public double getPerimeter() {
        int roundedNum = (int) ((this.side1 + this.side2 + this.side3) * 100);
        return roundedNum / 100.0;
    }

    @Override
    public String toString() {
        return "Triangle with sides " + this.side1 + ", " + this.side2 + " and " + this.side3 + " has area "
                + this.getArea() + " and perimeter " + this.getPerimeter() + " and color " + this.getCor() + ".\n";
    }

    public boolean ValidatesSides(double side) {
        if (side <= 0)
            throw new IllegalArgumentException("Lados não podem ser negativos");
        return true;
    }

}
