package Aula4;

import java.util.Scanner;
import java.util.ArrayList;

public class Exer1 {
    public static void main(String[] Args) {
        int input;
        Scanner sc = new Scanner(System.in);

        ArrayList<Circle> Circles = new ArrayList<Circle>();
        ArrayList<Triangle> Triangles = new ArrayList<Triangle>();
        ArrayList<Rectangle> Rectangles = new ArrayList<Rectangle>();

        do {
            System.out.println("Geometric shapes operations:");
            System.out.println("1 - create new Circle");
            System.out.println("2 - create new Rectangle");
            System.out.println("3 - create new Triangle");
            System.out.println("4 - show current Circle");
            System.out.println("5 - show current Rectangle");
            System.out.println("6 - show current Triangle");
            System.out.println("7 - change Circle radius");
            System.out.println("8 - change Rectangle width and height");
            System.out.println("9 - change Triangle side1, side2 and side3");
            System.out.println("10 - show Circle area");
            System.out.println("11 - show Rectangle area");
            System.out.println("12 - show Triangle area");
            System.out.println("13 - show Circle perimeter");
            System.out.println("14 - show Rectangle perimeter");
            System.out.println("15 - show Triangle perimeter");
            System.out.println("16 - compare all circles");
            System.out.println("17 - compare all rectangles");
            System.out.println("18 - compare all triangles");
            System.out.println("0 - exit");

            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Type the radius of the circle: ");
                    double radius = sc.nextDouble();
                    Circles.add(new Circle(radius));
                    break;
                case 2:
                    System.out.println("Type the side1 of the triangle: ");
                    double side1 = sc.nextDouble();
                    System.out.println("Type the side2 of the triangle: ");
                    double side2 = sc.nextDouble();
                    System.out.println("Type the side3 of the triangle: ");
                    double side3 = sc.nextDouble();
                    Triangles.add(new Triangle(side1, side2, side3));
                    break;
                case 3:
                    System.out.println("Type the width of the rectangle: ");
                    double width = sc.nextDouble();
                    System.out.println("Type the height of the rectangle: ");
                    double height = sc.nextDouble();
                    Rectangles.add(new Rectangle(width, height));
                    break;
                case 4:
                    if (Circles.size() <= 0) {
                        System.out.println("There is no circle to show");
                        break;
                    }
                case 5:
                    if (Triangles.size() <= 0) {
                        System.out.println("There is no triangle to show");
                        break;
                    }
                case 6:
                    if (Rectangles.size() <= 0) {
                        System.out.println("There is no rectangle to show");
                        break;
                    }
                case 7:
                    if (Circles.size() <= 0) {
                        System.out.println("There is no circle to change");
                        break;
                    }
                    System.out.println("Type the new radius of the circle: ");
                    double newRadius = sc.nextDouble();
                    Circles.get(Circles.size() - 1).setRaio(newRadius);
                    break;
                case 8:
                    if (Triangles.size() <= 0) {
                        System.out.println("There is no triangle to change");
                        break;
                    }
                    System.out.println("Type the new side1 of the triangle: ");
                    double newSide1 = sc.nextDouble();
                    System.out.println("Type the new side2 of the triangle: ");
                    double newSide2 = sc.nextDouble();
                    System.out.println("Type the new side3 of the triangle: ");
                    double newSide3 = sc.nextDouble();
                    Triangles.get(Triangles.size() - 1).setSide1(newSide1);
                    Triangles.get(Triangles.size() - 1).setSide2(newSide2);
                    Triangles.get(Triangles.size() - 1).setSide3(newSide3);
                    break;
                case 9:
                    if (Rectangles.size() <= 0) {
                        System.out.println("There is no rectangle to change");
                        break;
                    }
                    System.out.println("Type the new width of the rectangle: ");
                    double newWidth = sc.nextDouble();
                    System.out.println("Type the new height of the rectangle: ");
                    double newHeight = sc.nextDouble();
                    Rectangles.get(Rectangles.size() - 1).setLargura(newWidth);
                    Rectangles.get(Rectangles.size() - 1).setComprimento(newHeight);
                    break;
                case 10:
                    if (Circles.size() <= 0) {
                        System.out.println("There is no circle to show");
                        break;
                    }
                    System.out.println("The area of the circle is: " + Circles.get(Circles.size() - 1).getArea());
                    break;
                case 11:
                    if (Triangles.size() <= 0) {
                        System.out.println("There is no triangle to show");
                        break;
                    }

                    System.out.println("Área do Retângulo   : " + Triangles.get(Triangles.size() - 1).getArea());
                    break;
                case 12:
                    if (Rectangles.size() <= 0) {
                        System.out.println("There is no rectangle to show");
                        break;
                    }
                    System.out.println(
                            "The area of the rectangle is: " + Rectangles.get(Rectangles.size() - 1).getArea());
                    break;
                case 13:
                    if (Circles.size() <= 0) {
                        System.out.println("There is no circle to show");
                        break;
                    }
                    System.out.println(
                            "The perimeter of the circle is: " + Circles.get(Circles.size() - 1).getPerimeter());
                    break;
                case 14:
                    if (Triangles.size() <= 0) {
                        System.out.println("There is no triangle to show");
                        break;
                    }
                    System.out.println(
                            "The perimeter of the triangle is: " + Triangles.get(Triangles.size() - 1).getPerimeter());
                    break;
                case 15:
                    if (Rectangles.size() <= 0) {
                        System.out.println("There is no rectangle to show");
                        break;
                    }
                    System.out.println("The perimeter of the rectangle is: "
                            + Rectangles.get(Rectangles.size() - 1).getPerimeter());
                    break;
                case 16:
                    if (Circles.size() <= 0) {
                        System.out.println("There is no circle to compare");
                        break;
                    }
                    for (int i = 0; i < Circles.size(); i++) {
                        for (int j = 0; j < Circles.size(); j++) {
                            if (i != j) {
                                if (Circles.get(i).equals(Circles.get(j))) {
                                    System.out.println("The circle " + i + " is equal to the circle " + j);
                                } else {
                                    System.out.println("The circle " + i + " is not equal to the circle " + j);
                                }
                            }
                        }
                    }
                    break;
                case 17:
                    if (Triangles.size() <= 0) {
                        System.out.println("There is no triangle to compare");
                        break;
                    }
                    for (int i = 0; i < Triangles.size(); i++) {
                        for (int j = 0; j < Triangles.size(); j++) {
                            if (i != j) {
                                if (Triangles.get(i).equals(Triangles.get(j))) {
                                    System.out.println("The triangle " + i + " is equal to the triangle " + j);
                                } else {
                                    System.out.println("The triangle " + i + " is not equal to the triangle " + j);
                                }
                            }
                        }
                    }
                    break;
                case 18:
                    if (Rectangles.size() <= 0) {
                        System.out.println("There is no rectangle to show");
                        break;
                    }

                    for (int i = 0; i < Rectangles.size() - 1; i++) {
                        for (int j = i + 1; j < Rectangles.size(); j++) {
                            if (Rectangles.get(i).equals(Rectangles.get(j))) {
                                System.out.println("The Rectangles " + Rectangles.get(i) + " are " + Rectangles.get(j)
                                        + " equals.");
                            } else {
                                System.out.println("The Rectangles " + Rectangles.get(i) + " are " + Rectangles.get(j)
                                        + " equals.");
                            }
                        }
                    }
                    break;
                case 0:
                    break;
            }
        } while (input != 0);
        System.out.println();
        sc.close();
    }
}
