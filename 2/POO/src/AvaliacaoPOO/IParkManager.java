public interface IParkManager {
    public void addPlant(Plant plant);
    public void removePlant(Plant plant);
    public void searchForSpecies(String name);
    public boolean sponsorPlant(int plantId);
    public void listAllPlants();
    public void listSummarySpecies();
}
