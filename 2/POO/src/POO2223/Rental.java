import java.time.LocalDate;

public class Rental {

    private StorageUnit storageUnit;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(StorageUnit storageUnit, LocalDate startDate, LocalDate endDate) {
        this.storageUnit = storageUnit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public StorageUnit getStorageUnit() {
        return storageUnit;
    }

    public LocalDate getstartDate() {
        return startDate;
    }

    public LocalDate getendDate() {
        return startDate;
    }

    public void setStorageUnit(StorageUnit storageUnit) {
        this.storageUnit = storageUnit;
    }

    public void setstartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setendDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    @Override
    public String toString() {
        return String.format("%s, %s, [%s : %s] - [%s : %s], %s", storageUnit.getClass(), storageUnit.getLocation(),
                storageUnit.getType(), storageUnit.getdimensions(), startDate, endDate, storageUnit.getClass());
    }

}
