package javaraytracer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/*
 * Scene.java
 *
 * Created on 24 September 2006, 11:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class Scene {
    
    private HashMap sceneObjects;
    private Camera camera;
    private HashMap lights;
    private String name;
    
    /** Creates a new instance of Scene */
    public Scene(String name) {
        this.name = name;
        sceneObjects = new HashMap();
        lights = new HashMap();
    }
    
    public void add(SceneObject sceneObject){
        sceneObjects.put(sceneObject.getId(), sceneObject);
    }
    
    public void add(Light light){
        lights.put(light.getId(),light);
    }
    
    public void removeSceneObject(String id){
        sceneObjects.remove(id);
    }
    
    public void removeLight(String id){
        lights.remove(id);
    }
    
    public Collection getSceneObjects(){
        return sceneObjects.values();
    }
    
    public Camera getCamera() {
        return camera;
    }
    
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    
    public Collection getLights() {
        return lights.values();
    }
    
    public Light getLight(String id) {
        return (Light)lights.get(id);
    }
    
    public SceneObject getSceneObject(String id){
        return (SceneObject)sceneObjects.get(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Scene : " + getName() + "\n");
        sb.append("Camera : " + getCamera() + "\n");
        sb.append("Lights\n");
        sb.append("------\n");
        for (Iterator iterator = lights.keySet().iterator();iterator.hasNext();){
            String sid = (String)iterator.next();
            sb.append(sid + " : " + lights.get(sid) + "\n");
        }
        sb.append("Scene Objects\n");
        sb.append("--------------\n");
        for (Iterator iterator = sceneObjects.keySet().iterator();iterator.hasNext();){
            String sid = (String)iterator.next();
            sb.append(sid + " : " + sceneObjects.get(sid) + "\n");
        }
        return sb.toString();
    }
    
}
