
public class Client {

    enum ClientType {
        ENTERPRISE, PERSONAL;
    }

    private int taxID;
    private String name;
    private ClientType type;

    public Client(int taxID, String name, ClientType type) {
        this.taxID = taxID;
        this.name = name;
        this.type = type;
    }

    public int getTaxID() {
        return taxID;
    }

    public String getname() {
        return name;
    }

    public ClientType gettype() {
        return type;
    }

    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void settype(ClientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Tax ID: %d, Name: %s, Type: %s", taxID, name, type);
    }
}
