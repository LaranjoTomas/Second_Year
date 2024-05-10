package Aula9.Exer1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import Aula5.DateYMD;
import Aula7.Exer2.Data;

public class ALDemo {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            c1.add(i);
        }

        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++) {
            System.out.println("Elemento: " + c1.get(i));
        }

        System.out.println("Contém 50? " + c1.contains(50));
        System.out.println("----------------------------------------------");
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println("Index of Calor: " + c2.indexOf("Calor"));
        System.out.println("Last index of Frio: " + c2.lastIndexOf("Calor"));
        System.out.println("Sublist: " + c2.subList(1, 3));
        c2.set(1, "Sol");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);
        System.out.println("----------------------------------------------");
        Set<Pessoa> c3 = new HashSet<>();
        Pessoa p1 = (new Pessoa("João", 000000000, new DateYMD(1, 1, 2000)));
        c3.add(p1);
        Pessoa p2 = (new Pessoa("Maria", 111111111, new DateYMD(2, 2, 2000)));
        c3.add(p2);
        Pessoa p3 = (new Pessoa("Pedro", 222222222, new DateYMD(3, 3, 2000)));
        c3.add(p3);
        Pessoa p4 = (new Pessoa("Ana", 333333333, new DateYMD(3, 3, 2000)));
        c3.add(p4);
        Pessoa p5 = (new Pessoa("Leandro", 444444444, new DateYMD(4, 4, 2000)));
        c3.add(p5);
        System.out.println(c3);

        System.out.println("----------------------------------------------");

        Set<Data> c4 = new TreeSet<>();

        Data d1 = new Aula7.Exer2.DateYMD(2, 1, 2000);
        c4.add(d1);
        Data d2 = new Aula7.Exer2.DateYMD(7, 2, 2000);
        c4.add(d2);
        Data d3 = new Aula7.Exer2.DateYMD(12, 3, 2000);
        c4.add(d3);
        Data d4 = new Aula7.Exer2.DateYMD(13, 4, 2000);
        c4.add(d4);
        Data d5 = new Aula7.Exer2.DateYMD(5, 5, 2000);
        c4.add(d5);

        System.out.println(c4);

    }
}
