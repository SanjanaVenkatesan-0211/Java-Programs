import java.io.*;
import java.util.*;

class SensorData implements Serializable {

    private static final long serialVersionUID = 1L;

    double temperature;
    double humidity;
    double pressure;

    SensorData(double t, double h, double p) {
        temperature = t;
        humidity = h;
        pressure = p;
    }

    public String toString() {
        return "Temp=" + temperature +
                ", Humidity=" + humidity +
                ", Pressure=" + pressure;
    }
}

public class SensorMonitor {

    public static void main(String[] args) throws Exception {

        SensorData packet = new SensorData(35.5, 70.0, 1013.2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(packet);
        oos.close();

        byte[] networkData = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(networkData);

        ObjectInputStream ois = new ObjectInputStream(bais);

        SensorData received = (SensorData) ois.readObject();

        List<SensorData> filteredList = new ArrayList<>();

        double threshold = 30.0;

        if (received.temperature > threshold) {
            filteredList.add(received);
        }

        System.out.println("Filtered Sensor Data:");

        for (SensorData s : filteredList) {
            System.out.println(s);
        }

        ois.close();
    }
}