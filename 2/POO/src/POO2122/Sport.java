
public class Sport extends Activity {

    private Modality modality;
    private int price;

    public Sport(Sport.Modality kayak, int i) {
        super(Type.SPORT, i);
        this.modality = kayak;
        this.price = i;
    }

    enum Modality {
        KAYAK, HIKING;
    }

    public Modality getModality() {
        return modality;
    }

    public int getPrice() {
        return price;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Sport: " + modality + " (" + price + ")";
    }

}
