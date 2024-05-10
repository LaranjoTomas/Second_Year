// deve registar clientes eventos associados a cada cliente com condições. não devem existir clientes repetidos(mesmo nome e localidade) e cada cliente pode ter mais de um evento associado

import java.time.LocalDate;
import java.util.ArrayList;

public class EventManager {
    private ArrayList<Client> clients;
    private ArrayList<Event> events;

    public EventManager(String name) {
        this.clients = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public Client addClient(String name, String address) {
        Client c = new Client(name, address);
        if (!clients.contains(c)) {
            clients.add(c);
            return c;
        }
        return null;
    }

    public Event addEvent(Client c1, LocalDate date) {
        Event e = new Event(c1, date);
        if (!events.contains(e)) {
            events.add(e);
            return e;
        }
        return null;
    }

    public String listClients() {
        StringBuilder sb = new StringBuilder();
        for (Client c : clients) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }

    public String listEvents() {
        StringBuilder sb = new StringBuilder();
        for (Event e : events) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }

    // create function named clientsWithEvents that returns a list of clients with
    // events

    public String[] nextEventsByDate() {
        String[] nextEvents = new String[events.size()];
        for (int i = 0; i < events.size(); i++) {
            nextEvents[i] = events.get(i).toString();
        }
        return nextEvents;
    }

    public String[] clientsWithEvents() {
        String[] clientsWithEvents = new String[clients.size()];
        for (int i = 0; i < clients.size(); i++) {
            clientsWithEvents[i] = clients.get(i).toString();
        }
        return clientsWithEvents;
    }

}