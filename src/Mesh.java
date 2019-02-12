package javaraytracer;

import java.awt.image.BufferedImage;

/*
 * Mesh.java
 *
 * Created on 21 October 2006, 16:21
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class Mesh extends SceneObject{
    
    private Triangle[] triangles;
    
    /** Creates a new instance of Mesh */
    public Mesh(String id) {
        super(id);
    }
    
    public Mesh(String id, Mesh mesh) {
        super(id,mesh);
        if (mesh.getTriangles() != null){
            triangles = new Triangle[mesh.getTriangles().length];
            for (int i=0;i < mesh.getTriangles().length;i++){
                triangles[i] = new Triangle(id + "_t" + i, mesh.getTriangles()[i]);
            }
        }
    }

    public Triangle[] getTriangles() {
        return triangles;
    }

    public void setTriangles(Triangle[] triangles) {
        this.triangles = triangles;
    }
    
    public Intersect intersect(Ray ray){
        Intersect result = null;
        for (int i=0;i < triangles.length;i++){
            Intersect intersect = triangles[i].intersect(ray);
            if (intersect != null){
                if (result == null || (intersect.getDistance() < result.getDistance())){
                    result = intersect;
                    result.setSceneObject(triangles[i]);
                }
            }      
        }
       return result;
    }

    public void setMaterial(Material material){
        for (int i=0;i < triangles.length;i++){
            triangles[i].setMaterial(material);
        }
    }
    
    public void setMatrix(Matrix matrix){
        super.setMatrix(matrix);
        for (int i=0;i < triangles.length;i++){
            triangles[i].setMatrix(matrix);
        }
    }
    
     public void setColour(RGBColour colour){
        for (int i=0;i < triangles.length;i++){
            triangles[i].setColour(colour);
        }
    }
     
     public void setReflect(double reflect){
          for (int i=0;i < triangles.length;i++){
            triangles[i].setReflect(reflect);
        }
     }
     
     public void setRefract(double refract){
          for (int i=0;i < triangles.length;i++){
            triangles[i].setRefract(refract);
        }
     }
     
     public void setTexture(BufferedImage texture){
          for (int i=0;i < triangles.length;i++){
            triangles[i].setTexture(texture);
        }
     }
     
     public void transform(){
          for (int i=0;i < triangles.length;i++){
            triangles[i].transform();
        }
     }
     
     public Vector3D getNormal(Intersect intersect){
         if (intersect.getSceneObject() != null){
             return intersect.getSceneObject().getNormal(intersect);
         }         
         return null;
     }
     
     public RGBColour getColour(Intersect intersect){
          if (intersect.getSceneObject() != null){
             return intersect.getSceneObject().getColour(intersect);
         }         
         return null;
     }
     
   
    
}
