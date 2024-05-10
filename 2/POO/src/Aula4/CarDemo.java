package Aula4;

import java.util.Scanner;

public class CarDemo {
    static Scanner sc = new Scanner(System.in);

    // Renault Megane Sport Tourer 2015 35356
    static int registerCars(Car[] cars) {
        System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
        String stuff = sc.nextLine();
        int numCars = 0;
        while (!stuff.isEmpty()) {
            String[] carStuff = stuff.split(", ");
            try {
                cars[numCars] = new Car(carStuff[0], carStuff[1], Integer.parseInt(carStuff[2]),
                        Integer.parseInt(carStuff[3]));
                numCars++;
                System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
                stuff = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Dados mal formatados. Tente novamente.");
                System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
                stuff = sc.nextLine();
            }
        }
        return numCars;
    }

    static void registerTrips(Car[] cars, int numCars) {
        System.out.print("Registe uma viagem no formato \"carro:distância\": ");
        String stuff = sc.nextLine();
        for (int i = 0; stuff != ""; i++) {
            String[] carStuff = stuff.split(":");
            try {
                int car = Integer.parseInt(carStuff[0]);
                int distance = Integer.parseInt(carStuff[1]);
                cars[car].drive(distance);
                System.out.print("Registe uma viagem no formato \"carro:distância\": ");
                stuff = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Dados mal formatados. Tente novamente.");
                System.out.print("Registe uma viagem no formato \"carro:distância\": ");
                stuff = sc.nextLine();
                break;
            }
        }
    }

    static void listCars(Car[] cars) {
        System.out.println("\nCarros registados: ");
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                System.out.println(cars[i]);
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Car[] cars = new Car[10];
        int numCars = registerCars(cars);
        if (numCars > 0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }
        sc.close();
    }
}
