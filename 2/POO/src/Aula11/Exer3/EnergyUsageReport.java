package Aula11.Exer3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EnergyUsageReport {

    static ArrayList<Customer> customers = new ArrayList<Customer>();

    public EnergyUsageReport() {
    }

    // Create the method load which recives a file name,reads all the date and
    // transfers the values to a java collection
    public ArrayList<Customer> load(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        while (line != null) {
            String[] data = line.split("\\|");
            int id = Integer.parseInt(data[0]);
            ArrayList<Double> meterReadings = new ArrayList<>();
            for (int i = 1; i < data.length; i++) {
                meterReadings.add(Double.parseDouble(data[i]));
            }
            Customer customer = new Customer(id, meterReadings);
            customers.add(customer);
            line = br.readLine();
        }
        br.close();
        return customers;
    }

    // method addCustomer, which adds a customer to the class
    public void addCustomer(Customer idcliente) {
        customers.add(idcliente);
    }

    // method removeCustomer, which removes a customer from the class
    public void removeCustomer(int idcliente) {
        customers.removeIf(customer -> customer.getCustomerId() == idcliente);
    }

    // method getCustomer, which gives an object customer which contains the info
    // ofq
    // the customer with the id given
    public static Customer getCustomer(int idcliente) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == idcliente) {
                return customer;
            }
        }
        return null;
    }

    // method calculateTotalUsage, which calculates the total usage of energy of a
    // customer given

    public static double calculateTotalUsage(int idcliente) {
        double total = 0;
        for (Customer customer : customers) {
            if (customer.getCustomerId() == idcliente) {
                for (Double grade : customer.getMeterReadings()) {
                    total += grade;
                }
            }
        }
        return total;
    }

    // method generateReport, which generates a report where it is listed in each
    // line the ID of the customer and the energy consumed

    public static void generateReport(String string) throws IOException {
        List<String> data = new ArrayList<>();
        for (Customer customer : customers) {
            data.add(customer.toString() + "\n");
        }
        generateFile(data, string);
    }

    public static void generateFile(List<String> data, String path) throws IOException {
        PrintWriter out = new PrintWriter(new File(path));
        out.print(data);
        out.close();
    }
}
