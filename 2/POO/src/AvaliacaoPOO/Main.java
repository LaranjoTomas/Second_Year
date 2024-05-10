import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isSponsored;
        ParkManager pManager = new ParkManager("Serralves");

        int choice = 0;
        do {
            System.out.println("Choose an option:");
            System.out.println("1 - Add plant");
            System.out.println("2 - Remove plant");
            System.out.println("3 - Search for species");
            System.out.println("4 - Sponsor a plant");
            System.out.println("5 - View all plants");
            System.out.println("6 - Summary of species");
            System.out.println("0 - Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("What is the name of the Plant? ");
                    String name = sc.next();
                    System.out.println(
                            "What is the species of the Plant? There can be Tree, PalmTree and Shrub. Or a different species. ");
                    String species = sc.next();
                    System.out.println("What is the age of the Plant? ");
                    int age = sc.nextInt();
                    System.out.println("What is the height of the Plant? ");
                    double height = sc.nextDouble();
                    System.out.println("What is the name of the Sponsor? If there is no sponsor, write none.");
                    String SponserName = sc.next();
                    if (SponserName.equals("none")) {
                        isSponsored = false;
                    } else {
                        isSponsored = true;
                    }
                    if (species.equals("Tree")) {
                        System.out.println("What is the type of leaf of the Tree? ");
                        String folha = sc.next();
                        Tree tree = new Tree(name, species, age, isSponsored, height, SponserName, folha);
                        pManager.addPlant(tree);
                        break;
                    } else if (species.equals("PalmTree")) {
                        System.out.println(
                                "What is the habitat of the PalmTree, noticed there is only semi-desert or tempered. ");
                        String habitat = sc.next();
                        PalmTree flower = new PalmTree(name, species, age, isSponsored, height, SponserName, habitat);
                        pManager.addPlant(flower);
                        break;
                    } else if (species.equals("Shrub")) {
                        System.out.println("Does the Shrub have flowers? (true/false) ");
                        boolean flower = sc.nextBoolean();
                        System.out.println("What is the color of the Shrub? ");
                        String color = sc.next();
                        Shrub shrub = new Shrub(name, species, age, isSponsored, height, SponserName, flower, color);
                        pManager.addPlant(shrub);
                        break;
                    } else {
                        Plant plant = new Plant(name, species, age, isSponsored, height, SponserName);
                        pManager.addPlant(plant);
                        break;
                    }
                case 2:
                    // remover planta
                    System.out.println("What is the name of the Plant you want to remove? ");
                    String nameToRemove = sc.next();
                    pManager.removePlant(nameToRemove);
                    break;
                case 3:
                    // procurar planta
                    System.out.println("What is the species of the Plant you want to search for? ");
                    String speciesToSearch = sc.next();
                    pManager.searchForSpecies(speciesToSearch);
                    break;
                case 4:
                    // patrocinar planta
                    System.out.println("What is the name of the plant you want to sponsor? ");
                    String nameToSponsor = sc.next();
                    pManager.searchForName(nameToSponsor);
                    System.out.println("What is the name of the sponsor? ");
                    String sponsorName = sc.next();
                    pManager.sponsorPlant(nameToSponsor, sponsorName);
                    break;

                case 5:
                    // imprimir a informação de todas as plantas
                    pManager.listAllPlants();
                    break;
                case 6:
                    // imprimir resumo com a informação relativa a todas
                    // especies
                    pManager.listSummarySpecies();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
                default:
                    // imprimir mensagem de erro
                    System.out.println("Invalid option!");
                    break;
            }
        } while (choice != 7);
        sc.close();
    }
}
