package javaraytracer;

/*
 * Light.java
 *
 * Created on 25 September 2006, 10:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public abstract class Light {
    
    private String id;
    protected Vector3D location;
    protected RGBColour colour;
    protected double range;
    protected RGBColour diffuseIntensity;
    protected RGBColour specularIntensity;
    protected RGBColour ambientIntensity;
    
    /** Creates a new instance of Light */
    public Light(String id) {
        this.id = id;
    }

    public Vector3D getLocation() {
        return location;
    }

    public void setLocation(Vector3D location) {
        this.location = location;
    }

    public RGBColour getColour() {
        return colour;
    }

    public void setColour(RGBColour colour) {
        this.colour = colour;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
    
    public abstract double getAttenuation(Vector3D intersectPoint);

    public RGBColour getDiffuseIntensity() {
        return diffuseIntensity;
    }

    public void setDiffuseIntensity(RGBColour diffuseIntensity) {
        this.diffuseIntensity = diffuseIntensity;
    }

    public RGBColour getSpecularIntensity() {
        return specularIntensity;
    }

    public void setSpecularIntensity(RGBColour specularIntensity) {
        this.specularIntensity = specularIntensity;
    }

    public RGBColour getAmbientIntensity() {
        return ambientIntensity;
    }

    public void setAmbientIntensity(RGBColour ambientIntensity) {
        this.ambientIntensity = ambientIntensity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
