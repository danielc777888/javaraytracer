package javaraytracer;

import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/*
 * SceneObject.java
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
public abstract class SceneObject implements Transformable  {
    
    public final static double MINI_NUMBER = 0.0000001d;
    protected RGBColour colour;
    protected Vector3D location;
    protected Vector3D normal;
    private String id;
    private double reflect;
    private double refract;
    private Material material;
    private BufferedImage texture;
    private Matrix matrix;
    
    
    /** Creates a new instance of SceneObject */
    public SceneObject(String id) {
        this.id = id;
    }
    
    public SceneObject(String id,SceneObject sceneObject){
        this.id = id;
        location = new Vector3D(sceneObject.getLocation());
        colour = sceneObject.getColour();
        refract = sceneObject.getRefract();
        reflect = sceneObject.getReflect();
        material = sceneObject.getMaterial();
        texture = sceneObject.getTexture();
        matrix = sceneObject.getMatrix();
        normal = sceneObject.getNormal();
        //System.out.println("Matrix:" + matrix);
    }
    
    public abstract Intersect intersect(Ray ray);
    
    public RGBColour getColour() {
        return colour;
    }
    
    public RGBColour getColour(Intersect vectorPosition) {
        return colour;
    }
    
    public void setColour(RGBColour colour) {
        this.colour = colour;
    }
    
    public Vector3D getLocation() {
        return location;
    }
    
    public void setLocation(Vector3D location) {
        this.location = location;
    }
    
    public Vector3D getNormal() {
        return normal;
    }
    
    public Vector3D getNormal(Intersect intersectPoint){
        return normal;
    }
    
    public void setNormal(Vector3D normal) {
        this.normal = normal;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public double getReflect() {
        return reflect;
    }
    
    public void setReflect(double reflect) {
        this.reflect = reflect;
    }
    
    public double getRefract() {
        return refract;
    }
    
    public void setRefract(double refract) {
        this.refract = refract;
    }
    
    public Material getMaterial() {
        return material;
    }
    
    
     public Material getMaterial(Intersect intersect){
          if (intersect.getSceneObject() != null){
             return intersect.getSceneObject().getMaterial();
         }         
         return material;
     }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    
    public BufferedImage getTexture() {
        return texture;
    }
    
    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }
    
    public Matrix getMatrix() {
        return matrix;
    }
    
    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
    
    public void transform(){
        
    }
    
    public static RGBColour getTextureColour(BufferedImage texture, double u, double v){
        if (texture != null){
            int x = (int)(u * 100.0d);
            int y = (int)(v * 100.0d);
            if(x > 99)
                x = 99;
            if (y > 99)
                y = 99;
            
            int pixel = texture.getRGB(x,y);
            RGBColour result = new RGBColour(((pixel >> 16) & 255)/ 255.0d,((pixel >> 8) & 255) / 255.0d,(pixel & 255) / 255.0d);
            return result;
        }else{
            return new RGBColour(0,0,0);
        }
    }
    
}
