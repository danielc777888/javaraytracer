package javaraytracer;

public class Intersect {
    
    private double distance;
    private Vector3D location;
    private SceneObject sceneObject;
    
    /** Creates a new instance of Intersect */
    public Intersect() {
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vector3D getLocation() {
        return location;
    }

    public void setLocation(Vector3D location) {
        this.location = location;
    }

    public SceneObject getSceneObject() {
        return sceneObject;
    }

    public void setSceneObject(SceneObject sceneObject) {
        this.sceneObject = sceneObject;
    }
    
}
