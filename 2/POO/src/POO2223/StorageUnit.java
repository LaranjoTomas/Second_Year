import java.util.Iterator;

public class StorageUnit implements Iterable<StorageUnit> {

    private String location;
    private int[] dimensions;
    private int pricePerDay;

    public StorageUnit(String location, int[] dimensions, int pricePerDay) {
        this.location = location;
        this.dimensions = dimensions;
        this.pricePerDay = pricePerDay;
    }

    public String getLocation() {
        return location;
    }

    public int[] getdimensions() {
        return dimensions;
    }

    public int getpricePerDay() {
        return pricePerDay;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setdimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }

    public void setLocation(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("Location: %s, Dimensions: %d, Price per day: %d", location, dimensions,
                pricePerDay);
    }

    public Object getType() {
        for (Object object : dimensions) {
            if (object instanceof Client.ClientType) {
                return object;
            }
        }
        return null;
    }

    @Override
    public Iterator<StorageUnit> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
