package mk.meeskantje.meeskantjecontrol.model;

public class Coordinate {
    private int id, drone_id;
    private float x, y, z;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrone_id() {
        return drone_id;
    }

    public void setDrone_id(int drone_id) {
        this.drone_id = drone_id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}