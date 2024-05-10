public class Plant {
    private String name;
    private String species;
    private int age;
    private boolean isSponsored;
    private double height;
    private String SponserName;

    public Plant(String name, String species, int age, boolean isSponsored, double height, String SponserName) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.isSponsored = isSponsored;
        this.height = height;
        this.SponserName = SponserName;
    }

    public String getName() {
        return name;
    }

    public String getSponserName() {
        return SponserName;
    }

    public void setSponserName(String sponserName) {
        SponserName = sponserName;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public boolean isSponsored() {
        return isSponsored;
    }

    public double getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSponsored(boolean sponsored) {
        isSponsored = sponsored;
    }

    public void setSponsorName(String SponserName) {
        this.SponserName = SponserName;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return " Plant Name:" + name + "; species:" + species + "; age:" + age + "; isSponsored:" + isSponsored
                + "; SponserName: " + SponserName + "; height:" + height + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Plant) {
            Plant plant = (Plant) obj;
            return this.name.equals(plant.name) && this.species.equals(plant.species) && this.age == plant.age
                    && this.isSponsored == plant.isSponsored && this.height == plant.height;
        }
        return false;
    }
}
