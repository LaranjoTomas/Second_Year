package Aula4;

import java.util.Scanner;

public class SimpleCarDemo {
    static Scanner sc = new Scanner(System.in);

    static void listCars(Car[] cars) {
        System.out.println("Carros registados:");
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new Car("Renault", " Megane Sport Tourer ", 2015, 35356);
        cars[1] = new Car("Toyota", "Camry", 2010, 32456);
        cars[2] = new Car("Mercedes", "Vito", 2008, 273891);

        listCars(cars);

        // Adicionar 10 viagens geradas aleatoriamente
        for (int i = 0; i < 10; i++) {
            int j = (int) Math.round(Math.random() * 2); // escolhe um dos 3 carros
            int distance = (int) Math.round(Math.random() * 1000); // viagem até 1000 kms
            System.out.printf("Carro %d viajou %d quilómetros.\n", j, distance);

            // adicionar viagem ao carro j
            cars[j].drive(distance);
        }
        System.out.println("");
        listCars(cars);

        sc.close();
    }
}
