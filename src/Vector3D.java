package javaraytracer;

/*
 * Vector3D.java
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
public class Vector3D {
    
    private double x;
    private double y;
    private double z;
    private double w;
    
    /** Creates a new instance of Vector3D */
    public Vector3D() {
        w = 1.0d;
    }
    
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        w = 1.0d;
    }
    
     public Vector3D(Vector3D vector){
        if (vector != null){
            this.x = vector.getX();
            this.y = vector.getY();
            this.z = vector.getZ();
        }
        w = 1.0d;
    }
    
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getZ() {
        return z;
    }
    
    public void setZ(double z) {
        this.z = z;
    }
    
    public void add(Vector3D vector){
        x += vector.getX();
        y += vector.getY();
        z += vector.getZ();
    }
    
    public static Vector3D add(Vector3D vector1, Vector3D vector2){
        return new Vector3D(vector1.getX() + vector2.getX(),
                vector1.getY() + vector2.getY(),
                vector1.getZ() + vector2.getZ());
    }
    
     public static Vector3D add(Vector3D vector1, double scalar){
        return new Vector3D(vector1.getX() + scalar,
                vector1.getY() + scalar,
                vector1.getZ() + scalar);
    }
    
    public void subtract(Vector3D vector){
        x -= vector.getX();
        y -= vector.getY();
        z -= vector.getZ();
    }
    
    public static Vector3D subtract(Vector3D vector1, Vector3D vector2){
        return new Vector3D(vector1.getX() - vector2.getX(),
                vector1.getY() - vector2.getY(),
                vector1.getZ() - vector2.getZ());
    }
    
    public static Vector3D subtract(Vector3D vector1, double scalar){
        return new Vector3D(vector1.getX() - scalar,
                vector1.getY() - scalar,
                vector1.getZ() - scalar);
    }
    
    public void multiply(Vector3D vector){
        x *= vector.getX();
        y *= vector.getY();
        z *= vector.getZ();
    }
    
    public static Vector3D multiply(Vector3D vector1, Vector3D vector2){
        return new Vector3D(vector1.getX() * vector2.getX(),
                vector1.getY() * vector2.getY(),
                vector1.getZ() * vector2.getZ());
    }
    
    public static Vector3D multiply(Vector3D vector1, double scalar){
        return new Vector3D(vector1.getX() * scalar,
                vector1.getY() * scalar,
                vector1.getZ() * scalar);
    }
    
    public void divide(Vector3D vector){
        x = x / vector.getX();
        y = y / vector.getY();
        z = z / vector.getZ();
    }
    
    public static Vector3D divide(Vector3D vector1, Vector3D vector2){
        return new Vector3D(vector1.getX() / vector2.getX(),
                vector1.getY() / vector2.getY(),
                vector1.getZ() / vector2.getZ());
    }
    
    public static Vector3D divide(Vector3D vector1, double scalar){
        return new Vector3D(vector1.getX() / scalar,
                vector1.getY() / scalar,
                vector1.getZ() / scalar);
    }
    
    public static double length(Vector3D vector){
        return Math.sqrt((vector.getX()*vector.getX())
        + (vector.getY()*vector.getY())
        + (vector.getZ()*vector.getZ()));
    }
    
    public void normalize(){
        double length = length(this);
        if (length == 0.0d){
            length = 1.0d;
        }
        x = x / length;
        y = y / length;
        z = z / length;
    }
    
    public static double dotProduct(Vector3D vector1,Vector3D vector2){
        return (vector1.getX() * vector2.getX())
        + (vector1.getY() * vector2.getY())
        + (vector1.getZ() * vector2.getZ());
    }
    
    public static Vector3D crossProduct(Vector3D vector1,Vector3D vector2){
        Vector3D result = new Vector3D();
        result.setX((vector1.getY() * vector2.getZ()) - (vector1.getZ() * vector2.getY()));
        result.setY((vector1.getZ() * vector2.getX()) - (vector1.getX() * vector2.getZ()));
        result.setZ((vector1.getX() * vector2.getY()) - (vector1.getY() * vector2.getX()));
        return result;
    }
    
    public String toString(){
        return "X:" + getX() + " Y:" + getY() + " Z:" + getZ();
    }
    
    public double getW() {
        return w;
    }
    
    public void setW(double w) {
        this.w = w;
    }
    
}
