import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StorageService implements StorageServiceInterface {

    private String name;
    private String address;
    private List<StorageUnit> storageUnits;
    private List<Client> clients;
    private List<Rental> rentals;

    public StorageService(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getname() {
        return name;
    }

    public String getaddress() {
        return address;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Address: %s", name, address);
    }

    public boolean registerClient(int taxId, String name, ClientType type) {
        Client client = new Client(taxId, name, type);
        clients.add(client);
        return true;
    }

    public Client getClient(int taxId) {
        for (Client client : clients) {
            if (client.getTaxID() == taxId) {
                return client;
            }
        }
        return null;
    }

    public void addStorageUnits(Collection<StorageUnit> storageUnits) {
        this.storageUnits.addAll(storageUnits);
    }

    public boolean checkAvailable(StorageUnit storageUnit, LocalDate startDate, LocalDate endDate) {
        for (Rental rental : rentals) {
            if (rental.getStorageUnit() == storageUnit) {
                if (rental.getstartDate().isBefore(startDate) && rental.getendDate().isAfter(startDate)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> listRentals() {
        List<String> Rental = null;
        Rental = new ArrayList<String>();
        for (int i = 0; i < rentals.size(); i++) {
            Rental.add(rentals.get(i).toString());
        }
        return Rental;
    }

    public void addStorageUnit(StorageUnit storageUnit) {
        storageUnits.add(storageUnit);
    }

    // Client c1 rents a garage unit
    public boolean rentStorageUnit(Client client, StorageUnit unit, LocalDate startDate, int duration) {
        if (checkAvailable(unit, startDate, startDate.plusDays(duration))) {
            Rental rental = new Rental(unit, startDate, startDate.plusDays(duration));
            rentals.add(rental);
            return true;
        }
        return false;

    }

    public double calculateTotalCost(StorageUnit unit, int duration) {
        return unit.getpricePerDay() * duration;
    }

    public List<StorageUnit> findAvailableUnits(UnitType unitType, LocalDate fromDate, int duration,
            int[] minDimensions) {
        List<StorageUnit> availableUnits = new ArrayList<StorageUnit>();
        for (StorageUnit unit : storageUnits) {
            if (unit.getType() == unitType && unit.getdimensions()[0] >= minDimensions[0]
                    && unit.getdimensions()[1] >= minDimensions[1] && unit.getdimensions()[2] >= minDimensions[2]) {
                if (checkAvailable(unit, fromDate, fromDate.plusDays(duration))) {
                    availableUnits.add(unit);
                }
            }
        }
        return availableUnits;
    }

    public List<String> listRentals(UnitType unitType) {
        List<String> Rental = null;
        Rental = new ArrayList<String>();
        for (int i = 0; i < rentals.size(); i++) {
            Rental.add(rentals.get(i).toString());
        }
        return Rental;
    }

    // this function returns a list of all the rentals of a given time period and
    // size
    public Iterable<StorageUnit> getAvailableUnitsBySize(LocalDate of, int i) {
        for (Rental rental : rentals) {
            if (rental.getstartDate().isBefore(of) && rental.getendDate().isAfter(of)) {
                return rental.getStorageUnit();
            }
        }
        return storageUnits;
    }

}
