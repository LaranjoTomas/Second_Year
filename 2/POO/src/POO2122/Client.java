
public class Client {
    public String name;
    public String address;

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return "Client: " + name + " (" + address + ")";
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
