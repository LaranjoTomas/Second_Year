import java.util.ArrayList;

public class ParkManager {
    private ArrayList<Plant> plants;
    private String ParkName;

    public ParkManager(String ParkName) {
        this.ParkName = ParkName;
        plants = new ArrayList<Plant>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(String nameToRemove) {
        for (Plant plant : plants) {
            if (plant.getName().equals(nameToRemove)) {
                plants.remove(plant);
                break;
            }
        }
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void searchForName(String name) {
        for (Plant plant : plants) {
            if (plant.getName().equals(name)) {
                System.out.println(plant);
            }
        }
    }

    public void searchForSpecies(String name) {
        for (Plant plant : plants) {
            if (plant.getSpecies().equals(name)) {
                System.out.println(plant);
            }
        }
    }

    public boolean sponsorPlant(String plantName, String sponsorName) {
        for (Plant plant : plants) {
            if (plant.getName() == plantName) {
                plant.setSponsorName(sponsorName);
                plant.setSponsored(true);
                return true;
            }
        }
        return false;
    }

    public void listAllPlants() {
        for (Plant plant : plants) {
            System.out.println(plant);
        }
    }

    public void listSummarySpecies() {
        ArrayList<String> species = new ArrayList<String>();
        for (Plant plant : plants) {
            if (!species.contains(plant.getSpecies())) {
                species.add(plant.getSpecies());
            }
        }
        for (String specie : species) {
            System.out.println(specie);
        }
    }

    public String getParkName() {
        return ParkName;
    }

    public void setParkName(String parkName) {
        ParkName = parkName;
    }

    @Override
    public String toString() {
        return "ParkManager [ParkName:" + ParkName + "]";
    }
}
