package Aula9.Exer3;

public class Plane {
    private String id;
    private String manufacturer;
    private String model;
    private int year;
    private int maxPassengers;
    private int maxSpeed;

    public Plane(String id, String manufacturer, String model, int year, int maxPassengers, int maxSpeed) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id='" + id + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", maxPassengers=" + maxPassengers +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public String toCSV() {
        return id + "," + manufacturer + "," + model + "," + year + "," + maxPassengers + "," + maxSpeed;
    }

    public static Plane fromCSV(String csv) {
        String[] fields = csv.split(",");
        return new Plane(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Plane))
            return false;

        Plane plane = (Plane) o;

        if (year != plane.year)
            return false;
        if (maxPassengers != plane.maxPassengers)
            return false;
        if (maxSpeed != plane.maxSpeed)
            return false;
        if (!id.equals(plane.id))
            return false;
        if (!manufacturer.equals(plane.manufacturer))
            return false;
        return model.equals(plane.model);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year;
        result = 31 * result + maxPassengers;
        result = 31 * result + maxSpeed;
        return result;
    }

    public String getPlaneType() {
        return "Plane";
    }

}
