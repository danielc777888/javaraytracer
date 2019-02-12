package javaraytracer;

/*
 * Triangle.java
 *
 * Created on 07 October 2006, 10:50
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class Triangle extends SceneObject{
    
    private Vector3D v1;
    private Vector3D v2;
    private Vector3D v3;
    
    /** Creates a new instance of Triangle */
    public Triangle(String id) {
        super(id);
    }
    
    public Triangle(String id, Triangle triangle){
        super(id,triangle);
        v1 = new Vector3D(triangle.getV1());
        v2 = new Vector3D(triangle.getV2());
        v3 = new Vector3D(triangle.getV3());
    }
    
    public Intersect intersect(Ray ray){
        Vector3D vector_2_1 = Vector3D.subtract(v2,v1);
        Vector3D vector_3_1 = Vector3D.subtract(v3,v1);
        
        Vector3D crossProduct = Vector3D.crossProduct(ray.getDirectionVector(),vector_3_1);
        
        double determinant = Vector3D.dotProduct(vector_2_1, crossProduct);
        
        if(determinant < MINI_NUMBER){
            return null;
        }
        
        Vector3D rayVertix = Vector3D.subtract(ray.getStartVector(), v1);
        
        double value_1 = Vector3D.dotProduct(rayVertix,crossProduct);
        if(value_1 < 0.0d || value_1 > determinant) {
            return null;
        }
        
        crossProduct = Vector3D.crossProduct(rayVertix, vector_2_1);
        double value_2 = Vector3D.dotProduct(ray.getDirectionVector(), crossProduct);
        
        if(value_2 < MINI_NUMBER || (value_1 + value_2) > determinant) {
            return null;
        }
        
        Intersect intersect = new Intersect();
        double inverseDeterminant = 1.0d / determinant;
        double distance = inverseDeterminant * (Vector3D.dotProduct(vector_3_1,crossProduct));
        if (distance < MINI_NUMBER)
            return null;
        intersect.setDistance(distance);
        Vector3D intersectionPoint = new Vector3D();
        intersectionPoint.setX(ray.getStartVector().getX() + (distance * ray.getDirectionVector().getX()));
        intersectionPoint.setY(ray.getStartVector().getY() + (distance * ray.getDirectionVector().getY()));
        intersectionPoint.setZ(ray.getStartVector().getZ() + (distance * ray.getDirectionVector().getZ()));
        intersect.setLocation(intersectionPoint);
              
        return intersect;
    }
    
    public Vector3D getNormal(Intersect intersectPoint){
        Vector3D normal = Vector3D.crossProduct(Vector3D.subtract(v2,v1), Vector3D.subtract(v3, v1));
        normal.normalize();
        return normal;
    }
    
    public Vector3D getV1() {
        return v1;
    }
    
    public void setV1(Vector3D v1) {
        this.v1 = v1;
    }
    
    public Vector3D getV2() {
        return v2;
    }
    
    public void setV2(Vector3D v2) {
        this.v2 = v2;
    }
    
    public Vector3D getV3() {
        return v3;
    }
    
    public void setV3(Vector3D v3) {
        this.v3 = v3;
    }
    
    public RGBColour getColour(Intersect intersect){
        if (getTexture() != null){
            Vector3D vectorPosition = intersect.getLocation();
            Vector3D uV = Vector3D.subtract(v1,v3);
            Vector3D vV = Vector3D.subtract(v1,v2);
            uV.normalize();
            vV.normalize();
            
            Vector3D vv1 = Vector3D.subtract(vectorPosition,v1);
            vv1.normalize();
            Vector3D vv2 = Vector3D.subtract(vectorPosition,v3);
            vv2.normalize();
            
            double u = Math.abs(Vector3D.dotProduct(uV, vv1));
            double v = Math.abs(Vector3D.dotProduct(vV, vv2));
            
            return getTextureColour(getTexture(),u,v);
        }else{
            return colour;
        }
    }
    
    public void transform(){
        if (getMatrix() != null){
            v1 = Matrix.multiply(getMatrix(),v1);
            v2 = Matrix.multiply(getMatrix(),v2);
            v3 = Matrix.multiply(getMatrix(),v3);
        }
    }
}
