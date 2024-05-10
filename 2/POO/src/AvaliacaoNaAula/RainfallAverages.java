import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;

// ADD MISSING IMPORTS
class RainfallInfo {
    LocalDate date;
    String location;
    double rainfall;

    RainfallInfo(LocalDate date, String location, double rainfall) {
        this.date = date;
        this.location = location;
        this.rainfall = rainfall;
    }

    LocalDate getDate() {
        return date;
    }

    String getLocation() {
        return location;
    }

    double getRainfall() {
        return rainfall;
    }

    LocalDate setDate(LocalDate date) {
        this.date = date;
        return date;
    }

    String setLocation(String location) {
        this.location = location;
        return location;
    }

    double setRainfall(double rainfall) {
        this.rainfall = rainfall;
        return rainfall;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]: %.1f", location, date, rainfall);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RainfallInfo) {
            RainfallInfo other = (RainfallInfo) obj;
            return date.equals(other.date) && location.equals(other.location) && rainfall == other.rainfall;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return date.hashCode() + location.hashCode() + (int) rainfall;
    }
}

public class RainfallAverages {
    public static void main(String[] args) {
        String filePath = "rainfall_data.csv";
        List<String> lines = null;
        String header = null;
        try {
            // CODE HERE: Read lines from file and store in list
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            header = reader.readLine();
            String line;
            // the list "lines" is equal to null, now add the value of the file to the list
            lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            System.out.printf("File header: %s\n", header);
            System.out.printf("Number of lines, excluding header: %d\n\n\n", lines == null ? 0 : lines.size()); // avoid
            // null
            // reference

            List<RainfallInfo> rainfallData = new ArrayList<>();
            // CODE HERE: Create list of information from file, represented as RainfallInfo
            // objects

            reader.close();

            for (String line2 : lines) {
                String[] parts = line2.split(",");
                LocalDate date = LocalDate.parse(parts[0]);
                String location = parts[1];
                double rainfall = Double.parseDouble(parts[2]);
                RainfallInfo rainfallInfo = new RainfallInfo(date, location, rainfall);
                rainfallData.add(rainfallInfo);
            }

            // CODE HERE: Print rainfall values for Porto and dates in April
            for (RainfallInfo rainfallInfo : rainfallData) {
                if (rainfallInfo.getLocation().equals("Porto") && rainfallInfo.getDate().getMonth() == Month.APRIL) {
                    System.out.println(rainfallInfo);
                }
            }

            System.out.println("\n");

            // Calculate average rainfall per location
            int count = 0;
            Map<String, Double> rainfallPerLocation = new HashMap<String, Double>(); // COMPLETE

            for (RainfallInfo rainfallInfo : rainfallData) {
                if (rainfallPerLocation.containsKey(rainfallInfo.getLocation())) {
                    rainfallPerLocation.put(rainfallInfo.getLocation(),
                            rainfallPerLocation.get(rainfallInfo.getLocation()) + rainfallInfo.getRainfall());
                } else {
                    rainfallPerLocation.put(rainfallInfo.getLocation(), rainfallInfo.getRainfall());
                }
            }

            // CODE HERE: Print average rainfall per location
            for (Map.Entry<String, Double> entry : rainfallPerLocation.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                for (RainfallInfo rainfallInfo : rainfallData) {
                    if (rainfallInfo.getLocation().equals(key)) {
                        count++;
                    }
                }
                System.out.printf("Location: %s, Average Rainfall %.2f\n", key, value / count);
                count = 0;
            }

            System.out.println("\n");
        } catch (Exception e) { // Workaround to avoid codecheck error. Should be a more specific Exception
                                // class.
            e.printStackTrace();
        }
    }
}