
public class Culture extends Activity {

    enum Option {
        DRINKS_AND_SNACKS, ART_MUSEUM, WINE_TASTING, FULL_MENU, LIGHT_BITES, ARCHITECTURAL_TOUR, RIVER_TOUR;
    }

    private Option option;
    private int price;

    public Culture(Option option, int price) {
        super(Type.CULTURE, price);
        this.price = price;
        this.option = option;
    }

    public int getPrice() {
        return price;
    }

    public Option getOption() {
        return option;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Culture: " + option + " (" + price + ")";
    }
}
