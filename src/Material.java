package javaraytracer;

/*
 * Material.java
 *
 * Created on 07 October 2006, 14:13
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class Material {
    
    private RGBColour ambient;
    private RGBColour emissive;
    private RGBColour diffuse;
    private RGBColour specular;
    private double specularFactor;
    
    /** Creates a new instance of Material */
    public Material() {
    }

    public RGBColour getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(RGBColour diffuse) {
        this.diffuse = diffuse;
    }

    public RGBColour getSpecular() {
        return specular;
    }

    public void setSpecular(RGBColour specular) {
        this.specular = specular;
    }

    public double getSpecularFactor() {
        return specularFactor;
    }

    public void setSpecularFactor(double specularFactor) {
        this.specularFactor = specularFactor;
    }

    public RGBColour getAmbient() {
        return ambient;
    }

    public void setAmbient(RGBColour ambient) {
        this.ambient = ambient;
    }

    public RGBColour getEmissive() {
        return emissive;
    }

    public void setEmissive(RGBColour emissive) {
        this.emissive = emissive;
    }
    
}
