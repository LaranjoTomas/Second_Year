package Aula3;

//Exercicio 3.4 do guião 3

import java.util.Scanner;

public class Exer1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many students in the class: ");
        int students = sc.nextInt();
        double grades[][] = new double[students][3];
        double NF;

        for (int i = 1; i <= students; i++) {
            System.out.println("Type your Pratical Grade(NP) and then your Teorical/Pratical Grade(NT): ");
            double NP = (sc.nextDouble() * 10.0) / 10.0;
            double NT = (sc.nextDouble() * 10.0) / 10.0;

            if (NT < 0 || NT > 20 || NP < 0 || NP > 20) {
                System.out.println("Invalid Grade!");
                System.exit(0);
            }

            if (NT < 7.0 || NP < 7.0) {
                NF = 66;
            } else {
                NF = Math.round(0.4 * NT + 0.6 * NP);
            }
            NF = (int) NF;
            grades[i][0] = NT;
            grades[i][1] = NP;
            grades[i][2] = NF;

        }
        System.out.println("NotaT   NotaP   NotaF");
        for (int i = 1; i < students + 1; i++) {
            System.out.printf("%6.1f %6.1f %6.0f\n", grades[i][0], grades[i][1], grades[i][2]);
        }

        sc.close();
    }
}
