public class Shrub extends Plant {
    private boolean flowers;
    private String color;

    public Shrub(String name, String species, int age, boolean isSponsored, double height, String SponserName,
            boolean flowers, String color) {
        super(name, species, age, isSponsored, height, SponserName);
        this.flowers = flowers;
        this.color = color;
    }

    public boolean isFlowers() {
        return flowers;
    }

    public String getColor() {
        return color;
    }

    public void setFlowers(boolean flowers) {
        this.flowers = flowers;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shrub [Flowers: " + flowers + "; Color: " + color + " ; " + super.toString();
    }

}