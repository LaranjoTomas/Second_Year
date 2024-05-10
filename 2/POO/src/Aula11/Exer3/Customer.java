package Aula11.Exer3;

import java.util.ArrayList;

public class Customer {
    private int customerId;
    private ArrayList<Double> meterReadings;

    public Customer(int customerId, ArrayList<Double> list) {
        this.customerId = customerId;
        this.meterReadings = list;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ArrayList<Double> getMeterReadings() {
        return (ArrayList<Double>) meterReadings;
    }

    public void setMeterReadings(ArrayList<Double> meterReadings) {
        this.meterReadings = meterReadings;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", meterReadings=" + meterReadings + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            return this.customerId == customer.customerId;
        }
        return false;
    }

}