package javaraytracer;

/*
 * Ray.java
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
public class Ray {
    
    private Vector3D startVector;
    private Vector3D directionVector;
    
    /** Creates a new instance of Ray */
    public Ray() {
    }

    public Vector3D getStartVector() {
        return startVector;
    }

    public void setStartVector(Vector3D startVector) {
        this.startVector = startVector;
    }

    public Vector3D getDirectionVector() {
        return directionVector;
    }

    public void setDirectionVector(Vector3D directionVector) {
        this.directionVector = directionVector;
    }
    
}
