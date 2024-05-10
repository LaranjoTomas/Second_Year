import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface StorageServiceInterface {
    boolean registerClient(int taxId, String name, ClientType type);
    Client getClient(int taxId);
    void addStorageUnit(StorageUnit storageUnit);
    void addStorageUnits(Collection<StorageUnit> storageUnits);
    boolean checkAvailable(StorageUnit storageUnit, LocalDate startDate, LocalDate endDate);
    List<StorageUnit> findAvailableUnits(UnitType unitType, LocalDate fromDate, int duration, int[] minDimensions);
    boolean rentStorageUnit(Client client, StorageUnit unit, LocalDate startDate, int duration);
    double calculateTotalCost(StorageUnit unit, int duration);
    List<String> listRentals();
    List<String> listRentals(UnitType unitType);
}
