
public class UnitType {

    enum Type {
        GARAGE, WAREHOUSE;
    }

    public static UnitType GARAGE;

    private Type type;
    private int[] dimensions;

    public UnitType(Type type, int[] dimensions) {
        this.type = type;
        this.dimensions = dimensions;
    }

    public Type gettype() {
        return type;
    }

    public int[] getdimensions() {
        return dimensions;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setdimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }

}
