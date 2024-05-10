package Aula3;

//Exercicio 3.4 do guião 3, mas com as notas random.

import java.util.Scanner;

public class Exer8 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many students in the class: ");
        int students = sc.nextInt();
        double grades[][] = new double[students][3];
        double NF;
        double min = 0.0;
        double max = 20.0;
        for (int i = 0; i < students; i++) {

            double NP = ((Math.random() * (max - min) + min) * 10.0) / 10.0;
            double NT = ((Math.random() * (max - min) + min) * 10.0) / 10.0;

            if (NT < 0.0 || NT > 20.0 || NP < 0.0 || NP > 20.0) {
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
        System.out.println("\nNotaT   NotaP   NotaF");
        for (int i = 0; i < students; i++) {
            System.out.printf("%6.1f %6.1f %6.0f\n", grades[i][0], grades[i][1], grades[i][2]);
        }

        sc.close();
    }
}
