package Aula5;

public class Property {
    private static int nextId = 1000;

    private int id;
    private int rooms;
    private String location;
    private int price;
    private boolean available;
    private DateYMD auctionStart;
    private DateYMD auctionEnd;

    public Property(String location, int rooms, int price) {
        this.id = nextId++;
        this.location = location;
        this.rooms = rooms;
        this.price = price;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public int getRooms() {
        return rooms;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public DateYMD getAuctionStart() {
        return auctionStart;
    }

    public DateYMD getAuctionEnd() {
        return auctionEnd;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setAuction(DateYMD dateYMD, int auctionDurationDays) {
        this.auctionStart = dateYMD;
        this.auctionEnd = new DateYMD(dateYMD.getDay(), dateYMD.getMonth(), dateYMD.getYear());
        this.auctionEnd.incrementDay(auctionDurationDays);
    }

    public void sell() {
        if (!available) {
            return;
        } else {
            System.out.println("Immovel " + id + " sold.");
            System.out.println("Immovel " + id + " unavailable.");
            available = false;
        }
    }

    public String toString() {
        String status = available ? "Yes" : "No";
        String auctionDates = (auctionStart != null && auctionEnd != null)
                ? ("; Auction " + auctionStart.toString() + " : " + auctionEnd.toString())
                : "";
        return "Immovel: " + id + "; Rooms: " + rooms + "; Location: " + location + "; Price: " + price
                + "; Available: " + status + auctionDates;
    }
}
