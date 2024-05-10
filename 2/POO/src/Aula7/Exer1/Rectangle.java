package Aula7.Exer1;

public class Rectangle extends Forma {
    private double comprimento;
    private double largura;
    private String cor;

    public Rectangle(double comprimento, double largura, String cor) {
        if (Validates(comprimento) && Validates(largura) && ValidatesColor(cor)) {
            this.comprimento = comprimento;
            this.largura = largura;
            this.cor = cor;
        }
    }

    public double getComprimento() {
        return this.comprimento;
    }

    public double getLargura() {
        return this.largura;
    }

    public String getCor() {
        return this.cor;
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
        if (this.getCor() != ((Rectangle) obj).getCor())
            return false;
        Rectangle other = (Rectangle) obj;
        return this.comprimento == other.comprimento && this.largura == other.largura;
    }

    public double getArea() {
        int roundedNum = (int) (this.comprimento * this.largura * 100.0);
        return roundedNum / 100.0;
    }

    public double getPerimeter() {
        int roundedNum = (int) (2 * (this.comprimento + this.largura) * 100.0);
        return roundedNum / 100.0;
    }

    @Override
    public String toString() {
        return "Rectangle with sides " + this.comprimento + " and " + this.largura + " has area "
                + this.getArea() + " and perimeter " + this.getPerimeter() + " and color " + this.getCor() + ".\n";
    }

    public boolean Validates(double side) {
        if (side <= 0)
            throw new IllegalArgumentException("Comprimento e largura não podem ser negativos");
        return true;
    }
}
