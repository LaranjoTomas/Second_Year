package Aula7.Exer1;

// introduza a classe abstrata Forma com os serviços perímetro e área na sua interface pública.

public abstract class Forma {
    public abstract double getArea();

    public abstract double getPerimeter();

    public boolean ValidatesTriangle(double side1, double side2, double side3, String cor) {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1 || side1 <= 0 || side2 <= 0
                || side3 <= 0 || !ValidatesColor(cor))
            throw new IllegalArgumentException("Não é um triângulo");
        return true;
    }

    public static boolean ValidatesRectangle(double side1, double side2, String cor) {
        if (side1 <= 0 || side2 <= 0 || !ValidatesColor(cor))
            throw new IllegalArgumentException("Não é um retângulo");
        return true;
    }

    public static boolean ValidadesCircle(double radius, String cor) {
        if (radius <= 0 || !ValidatesColor(cor))
            throw new IllegalArgumentException("Não é um círculo");
        return true;
    }

    public static boolean ValidatesColor(String cor) {
        return cor.equals("red") || cor.equals("blue") || cor.equals("green") || cor.equals("yellow")
                || cor.equals("black")
                || cor.equals("white") || cor.equals("pink") || cor.equals("orange") || cor.equals("gray")
                || cor.equals("cyan") || cor.equals("magenta") || cor.equals("darkGray") || cor.equals("lightGray");
    }

}
