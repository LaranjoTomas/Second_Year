package Aula6;

import java.util.Scanner;
import java.util.ArrayList;

public class Exer2 {
    public static void main(String[] Args) {

        int input;
        int id = 0;
        Scanner sc = new Scanner(System.in);

        ArrayList<Contactos> List = new ArrayList<Contactos>();
        do {
            System.out.println("");
            System.out.println("1 - Insert Contact");
            System.out.println("2 - Change Contact");
            System.out.println("3 - Delete Contact");
            System.out.println("4 - Search Contact");
            System.out.println("5 - List Contact");
            System.out.println("6 - Insert Contact, without email");
            System.out.println("7 - Insert Contact, without number");
            System.out.println("0 - Exit");
            System.out.print("Enter option: ");

            input = sc.nextInt();

            switch (input) {
                case 1:
                    boolean valid = false;
                    System.out.print("\nEnter name: ");
                    String name = sc.next();
                    Pessoa pessoa = new Pessoa(name, input, null);
                    System.out.print("\nEnter email: ");
                    String email = sc.next();
                    System.out.print("\nEnter telemovel: ");
                    String telemovel = sc.next();
                    id++;
                    Contactos contact = new Contactos(pessoa, id, telemovel, email);

                    if (contact.validaEmail() == false) {
                        System.out.println("Invalid email");
                        break;
                    } else if (contact.validaTelemovel() == false) {
                        System.out.println("Invalid telemovel");
                        break;
                    }

                    for (Contactos contact7 : List) {
                        if (contact7.getPessoa().getNome().equals(name) || contact7.getTelemovel().equals(telemovel)) {
                            System.out.println("Contact already exists. Do u want to add another one? (y/n)");
                            String answer = sc.next();
                            if (answer.equals("y")) {
                                id++;
                                List.add(contact);
                                valid = true;
                            } else {
                                valid = true;
                                break;
                            }
                        } else {
                            valid = false;
                        }
                    }

                    if (valid == false) {
                        List.add(contact);
                    } else {
                        break;
                    }
                    break;
                case 2:
                    System.out.print("\nEnter name or number: ");
                    String name10 = sc.next();
                    for (Contactos contact2 : List) {
                        if (contact2.getPessoa().getNome().equals(name10) || contact2.getTelemovel().equals(name10)) {
                            System.out.print("\nEnter new name: ");
                            String name2 = sc.next();
                            Pessoa pessoa2 = new Pessoa(name2, input, null);
                            System.out.print("\nEnter new email: ");
                            String email2 = sc.next();
                            System.out.print("\nEnter new telemovel: ");
                            String telemovel2 = sc.next();
                            contact2.setPessoa(pessoa2);
                            contact2.setTelemovel(telemovel2);
                            contact2.setEmail(email2);
                        } else {
                            System.out.print("\nEnter id of person: ");
                            int id2 = sc.nextInt();
                            for (Contactos contact3 : List) {
                                if (contact3.getID() == id2) {
                                    System.out.print("\nEnter new name: ");
                                    String name2 = sc.next();
                                    Pessoa pessoa2 = new Pessoa(name2, input, null);
                                    System.out.print("\nEnter new email: ");
                                    String email2 = sc.next();
                                    System.out.print("\nEnter new telemovel: ");
                                    String telemovel2 = sc.next();
                                    contact3.setPessoa(pessoa2);
                                    contact3.setTelemovel(telemovel2);
                                    contact3.setEmail(email2);
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.print("\nEnter name or number: ");
                    String name9 = sc.next();
                    for (Contactos contact3 : List) {
                        if (contact3.getPessoa().getNome().equals(name9) || contact3.getTelemovel().equals(name9)) {
                            List.remove(contact3);
                        } else {
                            System.out.print("\nEnter id of person: ");
                            int id3 = sc.nextInt();
                            for (Contactos contact4 : List) {
                                if (contact4.getID() == id3) {
                                    List.remove(contact4);
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.print("\nEnter name or number: ");
                    String name3 = sc.next();
                    for (Contactos contact4 : List) {
                        if (contact4.getPessoa().getNome().equals(name3) || contact4.getTelemovel().equals(name3)) {
                            System.out.println("Contact [ Name: " + contact4.getPessoa().getNome() + "; id:  "
                                    + contact4.getID() + "; Number:  " + contact4.getTelemovel() + "; Email: "
                                    + contact4.getEmail());
                        } else {
                            System.out.print("\nEnter id: ");
                            int idforsearch = sc.nextInt();
                            for (Contactos contact5 : List) {
                                if (contact5.getID() == idforsearch) {
                                    System.out.println("Contact [ Name: " + contact4.getPessoa().getNome() + "; id: "
                                            + contact4.getID() + "; Number: " + contact4.getTelemovel() + "; Email: "
                                            + contact4.getEmail());
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    for (Contactos contact4 : List) {
                        System.out.println(contact4.getPessoa().getNome() + " " + contact4.getID() + " "
                                + contact4.getTelemovel() + " " + contact4.getEmail());
                    }
                    break;
                case 6:
                    System.out.print("\nEnter name: ");
                    String name5 = sc.next();
                    Pessoa pessoa5 = new Pessoa(name5, input, null);
                    System.out.print("\nEnter telemovel: ");
                    String telemovel5 = sc.next();
                    id++;
                    Contactos contact5 = new Contactos(pessoa5, id, telemovel5);
                    List.add(contact5);
                    break;
                case 7:
                    System.out.print("\nEnter name: ");
                    String name6 = sc.next();
                    Pessoa pessoa6 = new Pessoa(name6, input, null);
                    System.out.print("\nEnter email: ");
                    String email6 = sc.next();
                    id++;
                    Contactos contact6 = new Contactos(pessoa6, email6, id);
                    List.add(contact6);
                    break;
                case 0:
                    break;
            }
        } while (input != 0);
        sc.close();
    }
}