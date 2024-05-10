package Aula9.Exer3;

public class CommercialPlane extends Plane {
    private int numOfCrewMembers;

    public CommercialPlane(String id, String manufacturer, String model, int year, int maxNumOfPassengers, int maxSpeed,
            int numOfCrewMembers) {
        super(id, manufacturer, model, year, maxNumOfPassengers, maxSpeed);
        this.numOfCrewMembers = numOfCrewMembers;
    }

    public int getNumOfCrewMembers() {
        return numOfCrewMembers;
    }

    public void setNumOfCrewMembers(int numOfCrewMembers) {
        this.numOfCrewMembers = numOfCrewMembers;
    }

    @Override
    public String getPlaneType() {
        return "Comercial";
    }

    @Override
    public String toString() {
        return "CommercialPlane{" +
                "id='" + getId() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", maxNumOfPassengers=" + getMaxPassengers() +
                ", maxSpeed=" + getMaxSpeed() +
                ", numOfCrewMembers=" + numOfCrewMembers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CommercialPlane))
            return false;
        if (!super.equals(o))
            return false;

        CommercialPlane that = (CommercialPlane) o;

        return numOfCrewMembers == that.numOfCrewMembers;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numOfCrewMembers;
        return result;
    }

}
