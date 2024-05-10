public class LockerStorage extends StorageUnit{

    private String address;
    private int[] dimensions;
    private int price;

    public LockerStorage(String address, int[] dimensions, int price) {
        super(address, dimensions, price);
        this.address = address;
        this.dimensions = dimensions;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public int[] getdimensions() {
        return dimensions;
    }

    public int getprice() {
        return price;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setdimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }

    public void setprice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Address: %s, Dimensions: %s m3, Price: %d €", address, dimensions, price);
    }

}
