package Aula9.Exer3;

public class MilitaryPlane extends Plane {
    private int numMissiles;

    public MilitaryPlane(String id, String manufacturer, String model, int year, int maxPassengers, int maxSpeed,
            int numMissiles) {
        super(id, manufacturer, model, year, maxPassengers, maxSpeed);
        this.numMissiles = numMissiles;
    }

    public int getNumMissiles() {
        return numMissiles;
    }

    public void setNumMissiles(int numMissiles) {
        this.numMissiles = numMissiles;
    }

    @Override
    public String getPlaneType() {
        return "Military";
    }

    @Override
    public String toString() {
        return "MilitaryPlane{" +
                "id='" + getId() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", maxPassengers=" + getMaxPassengers() +
                ", maxSpeed=" + getMaxSpeed() +
                ", numMissiles=" + numMissiles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MilitaryPlane))
            return false;
        if (!super.equals(o))
            return false;

        MilitaryPlane that = (MilitaryPlane) o;

        return numMissiles == that.numMissiles;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numMissiles;
        return result;
    }

}