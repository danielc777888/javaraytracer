package javaraytracer;

/*
 * Intersect.java
 *
 * Created on 24 September 2006, 11:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
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
