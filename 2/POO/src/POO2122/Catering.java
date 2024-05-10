// create enum for catering 
public class Catering extends Activity {
    enum Option {
        DRINKS_AND_SNACKS, ART_MUSEUM, WINE_TASTING, FULL_MENU, LIGHT_BITES, ARCHITECTURAL_TOUR, RIVER_TOUR;
    }

    private Option option;
    private int price;

    public Catering(Catering.Option option, int price) {
        super(Type.CATERING, price);
        this.price = price;
        this.option = option;
    }

    public Option getOption() {
        return option;
    }

    public int getPrice() {
        return price;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return option + " for " + price + "participants";
    }
}
