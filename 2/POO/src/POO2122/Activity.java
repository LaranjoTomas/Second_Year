public class Activity {

    public enum Type {
        SPORT, CULTURE, CATERING
    }

    private Type type;
    private int capacity;

    public Activity(Type type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return "Activity: " + type + " (" + capacity + ")";
    }

    public double price() {
        switch (type) {
            case SPORT:
                return 30;
            case CULTURE:
                return 22;
            case CATERING:
                return 25;
            default:
                return 0;
        }
    }
}
