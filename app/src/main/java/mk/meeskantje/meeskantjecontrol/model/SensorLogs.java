package mk.meeskantje.meeskantjecontrol.model;

public class SensorLogs {
    private int id, sensor_id, coordinate_id;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(int sensor_id) {
        this.sensor_id = sensor_id;
    }

    public int getCoordinate_id() {
        return coordinate_id;
    }

    public void setCoordinate_id(int coordinate_id) {
        this.coordinate_id = coordinate_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
