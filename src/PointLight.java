package javaraytracer;

/*
 * PointLight.java
 *
 * Created on 07 October 2006, 10:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class PointLight extends Light{
    
    /** Creates a new instance of PointLight */
    public PointLight(String id) {
        super(id);
    }
    
    public double getAttenuation(Vector3D intersectPoint){
        if (range == 0.0d){
            return 1.0d;
        }else{
            double distance = Vector3D.length(Vector3D.subtract(intersectPoint, location));
            double attenuation = 1.0d / ((distance * distance) / (range * range));
            return attenuation;
        }
    }
            
}
