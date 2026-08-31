import java.io.*;
import java.util.*;

class SensorData implements Serializable {

    private static final long serialVersionUID = 1L;

    double temperature;
    double humidity;
    double pressure;

    SensorData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "Temperature = " + temperature +
                ", Humidity = " + humidity +
                ", Pressure = " + pressure;
    }
}

public class SensorMonitor2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter number of sensor packets: ");
            int n = sc.nextInt();

            System.out.print("Enter temperature threshold: ");
            double threshold = sc.nextDouble();

            List<SensorData> filteredList = new ArrayList<>();

            for (int i = 1; i <= n; i++) {

                System.out.println("\nEnter details for Sensor " + i);

                System.out.print("Temperature: ");
                double temp = sc.nextDouble();

                System.out.print("Humidity: ");
                double hum = sc.nextDouble();

                System.out.print("Pressure: ");
                double pres = sc.nextDouble();

                // Create sensor object
                SensorData packet = new SensorData(temp, hum, pres);

                // Serialize object to byte array
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                ObjectOutputStream oos = new ObjectOutputStream(baos);

                oos.writeObject(packet);
                oos.flush();

                byte[] networkData = baos.toByteArray();

                // Simulate receiving byte array from network
                ByteArrayInputStream bais = new ByteArrayInputStream(networkData);

                ObjectInputStream ois = new ObjectInputStream(bais);

                // Deserialize object
                SensorData received = (SensorData) ois.readObject();

                // Filter based on temperature
                if (received.temperature > threshold) {
                    filteredList.add(received);
                }

                ois.close();
                oos.close();
            }

            System.out.println("\n===== FILTERED SENSOR READINGS =====");

            if (filteredList.isEmpty()) {
                System.out.println("No sensor readings exceed the threshold.");
            } else {
                for (SensorData sensor : filteredList) {
                    System.out.println(sensor);
                }
            }

            System.out.println("\nTotal Filtered Packets: "
                    + filteredList.size());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}