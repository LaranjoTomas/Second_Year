package Aula9.Exer3;

import java.util.List;
import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager planeManager = new PlaneManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nPlane Fleet Menu:");
            System.out.println("1. Add a plane to the fleet");
            System.out.println("2. Remove a plane from the fleet");
            System.out.println("3. Search for a plane");
            System.out.println("4. Print summary of all planes in the fleet");
            System.out.println("5. Print list of all commercial planes in the fleet");
            System.out.println("6. Print list of all military planes in the fleet");
            System.out.println("7. Print the fastest plane in the fleet");
            System.out.println("0. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the plane type (1 for commercial, 2 for military):");
                    int planeType = scanner.nextInt();
                    System.out.println("Enter the plane ID:");
                    String id = scanner.next();
                    System.out.println("Enter the plane manufacturer:");
                    String manufacturer = scanner.next();
                    System.out.println("Enter the plane model:");
                    String model = scanner.next();
                    System.out.println("Enter the plane year:");
                    int year = scanner.nextInt();
                    System.out.println("Enter the plane max number of passengers:");
                    int maxNumOfPassengers = scanner.nextInt();
                    System.out.println("Enter the plane max speed:");
                    int maxSpeed = scanner.nextInt();
                    if (planeType == 1) {
                        System.out.println("Enter the plane number of crew members:");
                        int numOfCrewMembers = scanner.nextInt();
                        CommercialPlane commercialPlane = new CommercialPlane(id, manufacturer, model, year,
                                maxNumOfPassengers, maxSpeed, numOfCrewMembers);
                        planeManager.addPlane(commercialPlane);
                    } else if (planeType == 2) {
                        System.out.println("Enter the plane number of missiles:");
                        int numOfMissiles = scanner.nextInt();
                        MilitaryPlane militaryPlane = new MilitaryPlane(id, manufacturer, model, year,
                                maxNumOfPassengers, maxSpeed, numOfMissiles);
                        planeManager.addPlane(militaryPlane);
                    } else {
                        System.out.println("Invalid plane type!");
                    }
                    break;
                case 2:
                    System.out.println("Enter the plane ID:");
                    id = scanner.next();
                    planeManager.removePlane(id);
                    break;
                case 3:
                    System.out.println("Enter the plane ID:");
                    id = scanner.next();
                    Plane plane = planeManager.searchPlane(id);
                    if (plane != null) {
                        System.out.println(plane);
                    } else {
                        System.out.println("Plane not found!");
                    }
                    break;
                case 4:
                    planeManager.printAllPlanes();
                    break;
                case 5:
                    List<Plane> commercialPlanes = planeManager.getCommercialPlanes();
                    for (Plane commercialPlane : commercialPlanes) {
                        System.out.println(commercialPlane);
                    }
                    break;
                case 6:
                    List<Plane> militaryPlanes = planeManager.getMilitaryPlanes();
                    for (Plane militaryPlane : militaryPlanes) {
                        System.out.println(militaryPlane);
                    }
                    break;
                case 7:
                    Plane fastestPlane = planeManager.getFastestPlane();
                    System.out.println(fastestPlane);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }
}
