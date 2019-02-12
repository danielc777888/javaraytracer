package javaraytracer;

/*
 * Plane.java
 *
 * Created on 25 September 2006, 12:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class Plane extends SceneObject{
    
    private double d;
    
    /** Creates a new instance of Plane */
    public Plane(String id) {
        super(id);
    }
    
    
    public Intersect intersect(Ray ray){
        normal.normalize();
        d = -Vector3D.dotProduct(location,normal);
        double rayDistance = Vector3D.dotProduct(normal,ray.getDirectionVector());
        if (Math.abs(rayDistance) < 0.00001d){
            return null;
        }
        
        double dOrigin = -(Vector3D.dotProduct(normal,ray.getStartVector()) + d);
        
        double intersectDistance = dOrigin / rayDistance;
        
        if (intersectDistance < MINI_NUMBER){
            return null;
        }
        
        Intersect intersect = new Intersect();
        intersect.setDistance(intersectDistance);
        Vector3D location = new Vector3D();
        location.setX(ray.getStartVector().getX() + (intersectDistance * ray.getDirectionVector().getX()));
        location.setY(ray.getStartVector().getY() + (intersectDistance * ray.getDirectionVector().getY()));
        location.setZ(ray.getStartVector().getZ() + (intersectDistance * ray.getDirectionVector().getZ()));
        intersect.setLocation(location);
        
        return intersect;
        
    }
    
    public RGBColour getColour(Intersect intersect){
        if (getTexture() != null){
            Vector3D vectorPosition = intersect.getLocation();
            Vector3D uAxis = new Vector3D(normal.getY(), normal.getZ(),-normal.getX());
            Vector3D vAxis = Vector3D.crossProduct(uAxis,normal);
            vectorPosition.normalize();
            double u = Math.abs(Vector3D.dotProduct(vectorPosition,uAxis));
            double v = Math.abs(Vector3D.dotProduct(vectorPosition,vAxis));
            return getTextureColour(getTexture(),u, v);
        }else{
            return colour;
        }
        
    }
    public void transform(){
        if (getMatrix() != null){
            setLocation(Matrix.multiply(getMatrix(),getLocation()));
        }
    }
    
}
