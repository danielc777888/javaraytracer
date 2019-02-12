package javaraytracer;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/*
 * Sphere.java
 *
 * Created on 24 September 2006, 11:51
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class Sphere extends SceneObject{
    
    private double radius;
    
    /** Creates a new instance of Sphere */
    public Sphere(String id) {
        super(id);
    }
    
    public Sphere(String id, Sphere sphere) {
        super(id,sphere);
        radius = sphere.getRadius();
    }
    
    public Intersect intersect(Ray ray){
        
        double alpha = Vector3D.dotProduct(Vector3D.subtract(location,ray.getStartVector()), ray.getDirectionVector());
        Vector3D q = Vector3D.add(ray.getStartVector(),Vector3D.multiply(ray.getDirectionVector(),alpha));
        
        double bSquare = Vector3D.length(Vector3D.subtract(q,location));
        
        if (bSquare > radius){
            return null;
        }
        
        double a = Math.sqrt((radius * radius) - (bSquare * bSquare));
        if (alpha >= (a + MINI_NUMBER)){
            Intersect result = new Intersect();
            Vector3D iPoint = Vector3D.subtract(q, Vector3D.multiply(ray.getDirectionVector(),a));
            //System.out.println("Hit OUTSIDE circle at point  : " + iPoint.toString());
            double length = Vector3D.length(iPoint);
            result.setDistance(length);
            result.setLocation(iPoint);
            //System.out.println("Length is  : " + length);
            return result;
        }
        
        if (alpha +  a > MINI_NUMBER){
            Intersect result = new Intersect();
            Vector3D iPoint = Vector3D.add(q, Vector3D.multiply(ray.getDirectionVector(),a));
            //System.out.println("Hit INSIDE circle at point  : " + iPoint.toString());
            double length = Vector3D.length(iPoint);
            result.setDistance(length);
            result.setLocation(iPoint);
            //System.out.println("Length is  : " + length);
            return result;
        }
        
        
        return null;
    }
    
    public Vector3D getNormal(Intersect intersect){
        Vector3D intersectPoint = intersect.getLocation();
        Vector3D normal = new Vector3D();
        double invertRadius = 1 / radius;
        normal.setX((intersectPoint.getX() - location.getX()) * invertRadius);
        normal.setY((intersectPoint.getY() - location.getY()) * invertRadius);
        normal.setZ((intersectPoint.getZ() - location.getZ()) * invertRadius);
        return normal;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public RGBColour getColour(Intersect intersect){
        
        if (getTexture() != null){
            Vector3D intersectPoint = intersect.getLocation();
            Vector3D vN = new Vector3D(0.0d,1.0d,0.0d);
            Vector3D vE = new Vector3D(1.0d,0.0d,0.0d);
            Vector3D vC = Vector3D.crossProduct(vN, vE);
            BufferedImage texture = getTexture();
            Vector3D subVector = Vector3D.multiply(Vector3D.subtract(intersectPoint, getLocation()),radius);
            subVector.normalize();
            double phi = Math.acos(-Vector3D.dotProduct(subVector, vN));
            double u = phi * (1.0d / Math.PI);
            double v = u;
            double theta = (Math.acos(Vector3D.dotProduct(vE, subVector) / Math.sin(phi))) * (0.5d / Math.PI);
            if (Vector3D.dotProduct(vC, subVector) >= MINI_NUMBER){
                u = (1.0d - theta);
            }else{
                u = theta;
            }
            return getTextureColour(getTexture(),u,v);
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
