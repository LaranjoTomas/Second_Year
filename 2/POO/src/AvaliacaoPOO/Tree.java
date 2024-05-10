public class Tree extends Plant {
    private String Folha;

    public Tree(String name, String species, int age, boolean isSponsored, double height, String SponserName,
            String folha) {
        super(name, species, age, isSponsored, height, SponserName);
        Folha = folha;
    }

    public String getFolha() {
        return Folha;
    }

    public void setFolha(String folha) {
        Folha = folha;
    }

    @Override
    public String toString() {
        return "Tree [Folha: " + Folha + " ; " + super.toString();
    }
}
