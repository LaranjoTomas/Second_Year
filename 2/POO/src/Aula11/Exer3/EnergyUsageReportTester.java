package Aula11.Exer3;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class EnergyUsageReportTester {
    public static void main(String[] args) throws IOException {

        // Create an instance of the EnergyUsageReport class
        EnergyUsageReport energyReport = new EnergyUsageReport();

        // Load the customer data from a text file using the load() method
        energyReport.load("../src/Aula11/Exer3/clients.txt");

        // Add one or more customers to the collection using the addCustomer() method
        Customer newCustomer = new Customer(999, new ArrayList<>(Arrays.asList(1500.0, 2000.0, 2500.0, 3000.0)));
        energyReport.addCustomer(newCustomer);

        // Remove one or more customers from the collection using the removeCustomer()
        // method
        energyReport.removeCustomer(1015);

        // Retrieve a customer from the collection using the getCustomer() method
        Customer retrievedCustomer = EnergyUsageReport.getCustomer(1025);
        System.out.println("Retrieved customer: " + retrievedCustomer);

        // Calculate the total energy usage for a specific customer using the
        // calculateTotalUsage() method
        double totalEnergyUsage = EnergyUsageReport.calculateTotalUsage(1003);
        System.out.println("Total energy usage for customer 1003: " + totalEnergyUsage);

        // Generate a report of all customers and their total energy usage using the
        // generateReport() method
        EnergyUsageReport.generateReport("energy_report.txt");
    }
}
