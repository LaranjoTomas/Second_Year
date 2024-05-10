public class PalmTree extends Plant {
    private String habitat;

    public PalmTree(String name, String species, int age, boolean isSponsored, double height, String SponserName,
            String habitat) {
        super(name, species, age, isSponsored, height, SponserName);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "PalmTree [Habitat: " + habitat + " ; " + super.toString();
    }
}
