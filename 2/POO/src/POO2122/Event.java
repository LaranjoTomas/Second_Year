
// event representa um evento, associado a uma data e a uma lista de atividades.
//pode conter várias atividades do tipo Sport ou Culture, desde que correspondam a modalidade opções distintas, mas apneas pode conter uma atividade de tipo Catering, independentemente da opção do menu.
import java.time.LocalDate;
import java.util.ArrayList;

public class Event implements IEvent {
    private Client client;
    private LocalDate date;
    private ArrayList<Activity> activities;

    public Event(Client client, LocalDate date) {
        this.client = client;
        this.date = date;
        this.activities = new ArrayList<>();
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public Event addActivity(Activity activity) {
        if ((activity.getClass() == Catering.class) && hasCateringActivity()) {
            return this;
        }
        activities.add(activity);
        return this;
    }

    public boolean hasCateringActivity() {
        for (Activity a : activities) {
            if (a.getClass() == Catering.class) {
                return true;
            }
        }
        return false;
    }

    public boolean removeActivity(Activity activity) {
        if (activities.contains(activity)) {
            activities.remove(activity);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event: ").append(client.getName()).append(" (").append(client.getAddress()).append(") ")
                .append(date.toString()).append("\n");
        for (Activity a : activities) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    public double totalPrice() {
        double total = 0;
        for (Activity a : activities) {
            total += a.price();
        }
        return total;
    }

}
