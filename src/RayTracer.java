package javaraytracer;

import com.sun.imageio.plugins.common.ImageUtil;
import com.sun.imageio.plugins.png.PNGImageWriter;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.spi.IIORegistry;
import javax.imageio.spi.ImageWriterSpi;
import javax.imageio.stream.FileImageOutputStream;
import org.w3c.dom.css.RGBColor;
/*
 * RayTracer.java
 *
 * Created on 24 September 2006, 10:00
 *
 * Referennces:
 * 1. Samuel R. Bus : 3D Graphics
 * 2. Devmaster.Net : http://www.devmaster.net/articles/raytracing_series/part6.php Textures,Cameras and Speed
 * 3. http://www.ultimategameprogramming.com : RayTracing tutorial
 */

/**
 *
 * @author Daniel Cabral
 */
public class RayTracer extends Frame{
    
    EventHandler ev = new EventHandler();
    private RayTracingCanvas canvas;
    private int width;
    private int height;
    private int superSampling;
    private int maxDepth;
    private final static int DEFAULT_MAX_DEPTH = 100;
    private final static int DEFAULT_SUPER_SAMPLING = 1;
    
    
    /** Creates a new instance of RayTracer */
    public RayTracer(int width, int height) {
        super("Java RayTracer");
        this.width = width;
        this.height = height;
        canvas = new RayTracingCanvas();
        add("Center",canvas);
        setSize(width,height);
        addWindowListener(ev);
        superSampling = DEFAULT_SUPER_SAMPLING;
        maxDepth = DEFAULT_MAX_DEPTH;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int width = 640;
        int height = 480;
        
        RayTracer rayTracer = new RayTracer(width,height);
        rayTracer.setSuperSampling(9);
        
        //create Scene
        Scene scene = new Scene("test");
        
        //create Camera
        Camera camera = new Camera();
        camera.setStartVector(new Vector3D(0.0d,0.0d,0.0d));
        camera.setDirectionVector(new Vector3D(0.0d,0.0d,1000.0d));
        
        //setup camera transform
        Vector3D cDirectionV = new Vector3D(camera.getDirectionVector().getX(), camera.getDirectionVector().getY(),camera.getDirectionVector().getZ());
        cDirectionV.normalize();
        camera.setMatrix(Matrix.createRotationMatrix(cDirectionV,180.0d, Matrix.Z_AXIS));
        
        //create Light
        Light light = new PointLight("l1");
        light.setLocation(new Vector3D(0.0d,-100.0d,100.0d));
        light.setColour(new RGBColour(1.0d,1.0d,1.0d));
        light.setDiffuseIntensity(new RGBColour(0.7d,0.7d,0.7d));
        light.setSpecularIntensity(new RGBColour(0.7d,0.7d,0.7d));
        light.setRange(0.0d);
        
        Light light2 = new PointLight("l2");
        light2.setLocation(new Vector3D(0.0d,-200.0d,700.0d));
        light2.setColour(new RGBColour(1.0d,1.0d,1.0d));
        light2.setDiffuseIntensity(new RGBColour(0.7d,0.7d,0.7d));
        light2.setSpecularIntensity(new RGBColour(0.7d,0.7d,0.7d));
        
        
        Light light3 = new PointLight("l3");
        light3.setLocation(new Vector3D(-200.0d,0.0d,20.0d));
        light3.setColour(new RGBColour(0.5d,0.5d,0.5d));
        light3.setDiffuseIntensity(new RGBColour(0.7d,0.7d,0.7d));
        light3.setSpecularIntensity(new RGBColour(0.7d,0.7d,0.7d));
        
        //create material
        Material material = new Material();
        material.setDiffuse(new RGBColour(0.7d,0.7d,0.7d));
        material.setSpecular(new RGBColour(0.7d,0.7d,0.7d));
        material.setSpecularFactor(100.0d);
        
        //create Spheres
        Sphere sphere = new Sphere("Red sphere");
        sphere.setRadius(50.0d);
        sphere.setColour(new RGBColour(1.0d,0.0d,0.0d));
        sphere.setLocation(new Vector3D(20.0d,-100.0d,900.0d));
        sphere.setReflect(0.0d);
        sphere.setRefract(0.0d);
        sphere.setMaterial(material);
        
        Sphere sphere2 = new Sphere("Blue sphere");
        sphere2.setRadius(100.0d);
        sphere2.setColour(new RGBColour(1.0d,1.0d,1.0d));
        sphere2.setLocation(new Vector3D(0.0d,100.0d,600.0d));
        sphere2.setReflect(0.7d);
        sphere2.setRefract(0.0d);
        sphere2.setMaterial(material);
        
        Sphere sphere3 = new Sphere("Green sphere");
        sphere3.setRadius(50.0d);
        sphere3.setColour(new RGBColour(1.0d,1.0d,1.0d));
        sphere3.setLocation(new Vector3D(150.0d,100.0d,150.0d));
        sphere3.setReflect(0.0d);
        sphere3.setRefract(0.0d);
        sphere3.setMaterial(material);
        
        //create triangles
        Triangle t1 = new Triangle("Red Triangle1 back");
        t1.setColour(new RGBColour(1.0d,0.0d,0.0d));
        t1.setV1(new Vector3D(-200.0d, -200.0d, 1000.0d));
        t1.setV2(new Vector3D(-200.0d, 200.0d, 1000.0d));
        t1.setV3(new Vector3D(200.0d, -200.0d, 1000.0d));
        t1.setMaterial(material);
        t1.setTexture(createCheckPattern(Color.BLUE,Color.GREEN));
        
        Mesh m = new Mesh("m1");
        //create triangles
        Triangle mt1 = new Triangle("mt1");
        mt1.setV1(new Vector3D(200.0d, -200.0d, 1400.0d));
        mt1.setV2(new Vector3D(-350.0d, -250.0d, 0.0d));
        mt1.setV3(new Vector3D(-200.0d, -200.0d, 1400.0d));
        
        Triangle mt2 = new Triangle("mt2");
        mt2.setV1(new Vector3D(200.0d, -200.0d, 1400.0d));
        mt2.setV2(new Vector3D(350.0d, -250.0d, 0.0d));
        mt2.setV3(new Vector3D(-350.0d, -250.0d, 0.0d));
        
        Triangle[] triangles = new Triangle[]{
            mt1,mt2
        };
        
        m.setTriangles(triangles);
        m.setColour(new RGBColour(0.0d,0.0d,1.0d));
        m.setMaterial(material);
        m.setTexture(createCheckPattern(Color.BLUE,Color.YELLOW));
        
        Triangle t2 = new Triangle("Red Triangle2 back");
        t2.setColour(new RGBColour(1.0d,0.0d,0.0d));
        t2.setV1(new Vector3D(200.0d, 200.0d, 1000.0d));
        t2.setV2(new Vector3D(200.0d, -200.0d, 1000.0d));
        t2.setV3(new Vector3D(-200.0d, 200.0d, 1000.0d));
        t2.setMaterial(material);
        t2.setTexture(createCheckPattern(Color.BLUE,Color.GREEN));
        //rotate and scale triangle
        t2.setMatrix(Matrix.multiply(Matrix.createScalingMatrix(t2.getV3(),1.0d,1.0d,1.0d),Matrix.createRotationMatrix(t2.getV3(),45.0d,Matrix.X_AXIS)));
        t2.transform();
        
        
        Triangle t3 = new Triangle("Blue Triangle1 ceiling");
        t3.setColour(new RGBColour(0.0d,0.0d,1.0d));
        t3.setV1(new Vector3D(200.0d, -200.0d, 1400.0d));
        t3.setV2(new Vector3D(-350.0d, -250.0d, 0.0d));
        t3.setV3(new Vector3D(-200.0d, -200.0d, 1400.0d));
        t3.setMaterial(material);
        
        
        Triangle t4 = new Triangle("Blue Triangle2 ceiling");
        t4.setColour(new RGBColour(0.0d,0.0d,1.0d));
        t4.setV1(new Vector3D(200.0d, -200.0d, 1400.0d));
        t4.setV2(new Vector3D(350.0d, -250.0d, 0.0d));
        t4.setV3(new Vector3D(-350.0d, -250.0d, 0.0d));
        t4.setMaterial(material);
        
        Triangle t5 = new Triangle("White Triangle1 floor");
        t5.setColour(new RGBColour(0.0d,1.0d,1.0d));
        t5.setV1(new Vector3D(-200.0d, 200.0d, 1400.0d));
        t5.setV2(new Vector3D(-350.0d, 250.0d, 0.0d));
        t5.setV3(new Vector3D(200.0d, 200.0d, 1400.0d));
        t5.setMaterial(material);
        
        
        Triangle t6 = new Triangle("White Triangle2 floor");
        t6.setColour(new RGBColour(0.0d,1.0d,1.0d));
        t6.setV1(new Vector3D(200.0d, 200.0d, 1400.0d));
        t6.setV2(new Vector3D(-350.0d, 250.0d, 0.0d));
        t6.setV3(new Vector3D(350.0d, 250.0d, 0.0d));
        t6.setMaterial(material);
        
        Triangle t7 = new Triangle("White Triangle1 left");
        t7.setColour(new RGBColour(1.0d,0.0d,1.0d));
        t7.setV1(new Vector3D(-200.0d, -200.0d, 1400.0d));
        t7.setV2(new Vector3D(-350.0d, -250.0d, 0.0d));
        t7.setV3(new Vector3D(-350.0d, 250.0d, 0.0d));
        t7.setMaterial(material);
        
        
        Triangle t8 = new Triangle("White Triangle2 left");
        t8.setColour(new RGBColour(1.0d,0.0d,1.0d));
        t8.setV1(new Vector3D(-200.0d, -200.0d, 1400.0d));
        t8.setV2(new Vector3D(-350.0d, 250.0d, 0.0d));
        t8.setV3(new Vector3D(-200.0d, 200.0d, 1400.0d));
        t8.setMaterial(material);
        
        Triangle t9 = new Triangle("White Triangle1 right");
        t9.setColour(new RGBColour(0.0d,1.0d,1.0d));
        t9.setV1(new Vector3D(200.0d, -200.0d, 1400.0d));
        t9.setV2(new Vector3D(200.0d, 200.0d, 1400.0d));
        t9.setV3(new Vector3D(350.0d, -250.0d, 0.0d));
        t9.setReflect(0.0d);
        t9.setMaterial(material);
        
        Triangle t10 = new Triangle("White Triangle2 right");
        t10.setColour(new RGBColour(0.0d,1.0d,1.0d));
        t10.setV1(new Vector3D(200.0d, 200.0d, 1400.0d));
        t10.setV2(new Vector3D(350.0d, 250.0d, 0.0d));
        t10.setV3(new Vector3D(350.0d, -250.0d, 0.0d));
        t10.setReflect(0.0d);
        t10.setMaterial(material);
        
        //create planes
        Plane plane = new Plane("plane1");
        plane.setLocation(new Vector3D(0.0d,300.0d,0.0d));
        plane.setNormal(new Vector3D(0.0d, -1.0d,0.0d));
        plane.setColour(new RGBColour(1.0d,1.0d,1.0d));
        plane.setReflect(0.0d);
        plane.setMaterial(material);
        
        Plane plane2 = new Plane("plane2");
        plane2.setLocation(new Vector3D(0.0d,0.0d,900.0d));
        plane2.setNormal(new Vector3D(0.0d, 0.0d,-1.0d));
        plane2.setColour(new RGBColour(1.0d,1.0d,1.0d));
        plane2.setReflect(1.0d);
        plane2.setMaterial(material);
        plane2.setTexture(createStripePattern(Color.BLACK,Color.YELLOW));
        
        Plane plane3 = new Plane("plane3");
        plane3.setLocation(new Vector3D(0.0d,-380.0d,0.0d));
        plane3.setNormal(new Vector3D(0.0d, 1.0d,0.0d));
        plane3.setColour(new RGBColour(1.0d,1.0d,1.0d));
        plane3.setReflect(0.0d);
        plane3.setMaterial(material);
        
        Plane plane4 = new Plane("plane4");
        plane4.setLocation(new Vector3D(-300.0d,0.0d,0.0d));
        plane4.setNormal(new Vector3D(1.0d, 0.0d,0.0d));
        plane4.setColour(new RGBColour(1.0d,1.0d,1.0d));
        plane4.setReflect(0.0d);
        plane4.setMaterial(material);
        
        Plane plane5 = new Plane("plane5");
        plane5.setLocation(new Vector3D(300.0d,0.0d,0.0d));
        plane5.setNormal(new Vector3D(-1.0d, 0.0d,0.0d));
        plane5.setColour(new RGBColour(1.0d,1.0d,1.0d));
        plane5.setReflect(0.0d);
        plane5.setMaterial(material);
        
        //add objects to scene
        scene.setCamera(camera);
        scene.add(light);
        //scene.add(light2);
        //scene.add(light3);
        //scene.add(sphere);
        //scene.add(sphere2);
        //scene.add(sphere3);
        //scene.add(t1);
        scene.add(m);
        /*scene.add(t2);
        scene.add(t3);
        scene.add(t4);
        scene.add(t5);
        scene.add(t6);
        scene.add(t7);
        scene.add(t8);
        scene.add(t9);
        scene.add(t10);*/
        
        //scene.add(plane);
        //scene.add(plane2);
        //scene.add(plane3);
        //scene.add(plane4);
        //scene.add(plane5);
        System.out.println(scene);
        
        //render Scene
        BufferedImage image = rayTracer.render(scene);
        
        //display Image
        rayTracer.display(image);
        
        //save Image
        rayTracer.save(image,"test");
    }
    
    /**
     * Create check image pattern for texturing
     */
    public static BufferedImage createCheckPattern(Color colour1, Color colour2){
        //create textureMap
        BufferedImage check = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        Graphics checkGraphics = check.getGraphics();
        
        for (int i=0;i < 20;i++){
            for (int j=0; j < 20;j++){
                if ((j + i) % 2 == 0) {
                    checkGraphics.setColor(colour1);
                }else{
                    checkGraphics.setColor(colour2);
                    
                }
                checkGraphics.fillRect(i * 5,j * 5, 5, 5);
            }
        }
        return check;
    }
    
    /*
     * Create striped image pattern for texturing
     */
    public static BufferedImage createStripePattern(Color colour1, Color colour2){
        //create textureMap
        BufferedImage stripe = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        Graphics stripeGraphics = stripe.getGraphics();
        
        for (int i=0;i < 20;i++){
            if (i % 2 == 0) {
                stripeGraphics.setColor(colour1);
            }else{
                stripeGraphics.setColor(colour2);
                
            }
            stripeGraphics.fillRect(i * 5,0, 20, 100);
            
        }
        return stripe;
    }
    
    /**
     * Create subrays for superSampling
     */
    private Ray[] spawnSubRays(Ray primaryRay,int superSampling){
        Ray[] rays = new Ray[superSampling];
        double root = Math.sqrt(superSampling);
        //double increment = root / 10.0d;
        double increment = 1.0d / root;
        for (int x=0; x < root;x++){
            for (int y=0; y < root;y++){
                Ray ray = new Ray();
                double vx = (double)x * increment;
                double vy = (double)y * increment;
                ray.setStartVector(Vector3D.add(primaryRay.getStartVector(),new Vector3D(vx,vy,0.0d)));
                ray.setDirectionVector(Vector3D.add(primaryRay.getStartVector(),new Vector3D(vx,vy,primaryRay.getDirectionVector().getZ())));
                ray.getDirectionVector().normalize();
                rays[(int)((x*root) + y)] = ray;
            }
        }
        return rays;
    }
    
    /**
     * Get pixel colour average of superSampling subRays
     */
    private int getPixelAverage(RGBColour[] colours){
        double red = 0.0d;
        double green = 0.0d;
        double blue =0.0d;
        for(int i=0; i < colours.length;i++){
            RGBColour colour = colours[i];
            red += colour.getRed();
            green += colour.getGreen();
            blue += colour.getBlue();
        }
        
        red = red / (double)colours.length;
        green = green / (double)colours.length;
        blue = blue /(double)colours.length;
        RGBColour colour = new RGBColour(red,green,blue);
        return colour.getPixel();
    }
    
    
    /**
     * Render scene
     */
    public BufferedImage render(Scene scene){
        PerformanceTimer pt = new PerformanceTimer("Render Scene");
        pt.start();
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        
        Camera camera = scene.getCamera();
        double  halfWidth = (double)width / 2.0d;
        double  halfHeight = (double)height / 2.0d;
        for (int y=0; y < height; y++){
            for (int x=0; x < width; x++){
                //create primary ray to cast out
                Ray ray = new Ray();
                int pixel = 0;
                ray.setStartVector(new Vector3D(x - halfWidth, y - halfHeight, camera.getStartVector().getZ()));
                Vector3D rayDirectionVector = new Vector3D();
                rayDirectionVector.setX(camera.getDirectionVector().getX() + ((double)x - halfWidth));
                rayDirectionVector.setY(camera.getDirectionVector().getY() +  ((double)y - halfHeight));
                rayDirectionVector.setZ(camera.getDirectionVector().getZ());
                
                if (camera.getMatrix() != null){
                    //apply camera transform to ray
                    ray.setStartVector(Matrix.multiply(camera.getMatrix(),ray.getStartVector()));
                    rayDirectionVector = Matrix.multiply(camera.getMatrix(),rayDirectionVector);
                }
                
                ray.setDirectionVector(rayDirectionVector);
                
                if (superSampling > 1){
                    //initialize subrays for superSampling
                    Ray rays[] = spawnSubRays(ray,superSampling);
                    RGBColour colours[] = new RGBColour[superSampling];
                    for (int r=0; r < rays.length;r++){
                        Ray subRay = rays[r];
                        RGBColour colour = new RGBColour(0,0,0);
                        trace(subRay,scene,colour, maxDepth);
                        //System.out.println("Colour:" + colour.toString());
                        colour.convert();
                        colour.clamp();
                        colours[r] = colour;
                    }
                    pixel = getPixelAverage(colours);
                }else{
                    rayDirectionVector.normalize();
                    RGBColour colour = new RGBColour(0,0,0);
                    trace(ray,scene,colour,maxDepth);
                    colour.convert();
                    colour.clamp();
                    pixel = colour.getPixel();
                    
                }
                //set specific pixel colour
                image.setRGB(x,y,pixel);
            }
        }
        pt.stop();
        return image;
    }
    
    /**
     * Recursive trace method
     */
    public void trace(Ray ray,Scene scene,RGBColour colour,int maxDepth){
        SceneObject closestObject = null;
        Intersect closestIntersect = null;
        
        //loop through scene objects
        for (Iterator iterator = scene.getSceneObjects().iterator(); iterator.hasNext();){
            SceneObject sceneObject = (SceneObject)iterator.next();
            //intersection test
            Intersect intersect = sceneObject.intersect(ray);
            if (intersect != null){
                //check for closest object
                if (closestIntersect == null || intersect.getDistance() < closestIntersect.getDistance()){
                    closestIntersect = intersect;
                    closestObject = sceneObject;
                }
            }
        }
        
        //if intersection found
        if (closestObject != null){
            Material material = closestObject.getMaterial(closestIntersect);
            Collection lights = scene.getLights();
            Collection sceneObjects = scene.getSceneObjects();
            Vector3D intersectPoint = closestIntersect.getLocation();
            
            //get normal
            Vector3D normal = closestObject.getNormal(closestIntersect);
            normal.normalize();
            
            //initialize phong model component values
            double totalLightAmbientRed = 0;
            double totalLightAmbientGreen = 0;
            double totalLightAmbientBlue = 0;
            double totalLightDiffuseRed = 0;
            double totalLightDiffuseGreen = 0;
            double totalLightDiffuseBlue = 0;
            double totalLightSpecularRed = 0;
            double totalLightSpecularGreen = 0;
            double totalLightSpecularBlue = 0;
            
            //loop through lights
            for (Iterator iterator = lights.iterator();iterator.hasNext();){
                
                Light light = (Light)iterator.next();
                double lightColourRed = light.getColour().getRed();
                double lightColourBlue = light.getColour().getBlue();
                double lightColourGreen = light.getColour().getGreen();
                
                //get light intensity fall-off
                double attenuation = light.getAttenuation(intersectPoint);
                
                //apply light intensity fall-off
                lightColourRed *= attenuation;
                lightColourBlue *= attenuation;
                lightColourGreen *= attenuation;
                
                //calculate lightVector
                Vector3D lightVector = Vector3D.subtract(light.getLocation(),intersectPoint);
                double lightDistance = Vector3D.length(lightVector);
                lightVector.normalize();
                
                //calculate viewVector
                Vector3D viewVector = Vector3D.subtract(ray.getStartVector(),intersectPoint);
                viewVector.normalize();
                
                //test for shadows
                Ray shadowRay = new Ray();
                shadowRay.setStartVector(intersectPoint);
                shadowRay.setDirectionVector(lightVector);
                boolean shadow = false;
                
                for (Iterator iterator2 = sceneObjects.iterator();iterator2.hasNext();){
                    SceneObject object  = (SceneObject)iterator2.next();
                    Intersect shadowIntersect = object.intersect(shadowRay);
                    //if intersection between object and light, shadow exists
                    if (shadowIntersect != null && shadowIntersect.getDistance() < lightDistance){
                        shadow = true;
                        break;
                    }
                }
                
                if (!shadow){
                    //add the light's phong model components
                    //add light's ambient intensity
                    if (light.getAmbientIntensity() != null){
                        totalLightAmbientRed += lightColourRed * light.getAmbientIntensity().getRed();
                        totalLightAmbientGreen += lightColourGreen * light.getAmbientIntensity().getGreen();
                        totalLightAmbientBlue += lightColourBlue * light.getAmbientIntensity().getBlue();
                    }
                    
                    //calculate light Coefficient
                    double lightCoefficient = Vector3D.dotProduct(lightVector,normal);
                    
                    // If the light coefficient is less than 0 make it = to 0.
                    if(lightCoefficient < 0){
                        lightCoefficient = 0;
                    }
                    
                    //calculate lights diffuse intensity
                    if (light.getDiffuseIntensity() != null && lightCoefficient > 0.0d){
                        totalLightDiffuseRed += lightColourRed * light.getDiffuseIntensity().getRed() * lightCoefficient;
                        totalLightDiffuseGreen += lightColourGreen *  light.getDiffuseIntensity().getGreen() * lightCoefficient;
                        totalLightDiffuseBlue += lightColourBlue * light.getDiffuseIntensity().getBlue() * lightCoefficient;
                    }
                    
                    //calculate lights specular intensity
                    if (light.getSpecularIntensity() != null && lightCoefficient > 0.0d){
                        double specularReflection = 1.0d;
                        if (material != null){
                            Vector3D mirrorReflection = Vector3D.subtract(Vector3D.multiply(normal,Vector3D.dotProduct(lightVector,normal) * 2.0d),  lightVector);
                            specularReflection = Math.pow(Vector3D.dotProduct(viewVector, mirrorReflection), material.getSpecularFactor());
                        }
                        
                        totalLightSpecularRed +=   lightColourRed * light.getSpecularIntensity().getRed() * specularReflection;
                        totalLightSpecularGreen += lightColourGreen * light.getSpecularIntensity().getGreen() * specularReflection;
                        totalLightSpecularBlue +=  lightColourBlue * light.getSpecularIntensity().getBlue() * specularReflection;
                    }
                }
            }
            
            double red = 0.0d;
            double green = 0.0d;
            double blue = 0.0d;
            
            if (material != null){
                //add objects material ambient component
                if (material.getAmbient() != null){
                    red += material.getAmbient().getRed() * totalLightAmbientRed;
                    green += material.getAmbient().getGreen() * totalLightAmbientGreen;
                    blue += material.getAmbient().getBlue() * totalLightAmbientBlue;
                }
                
                //add material's emmissive constant
                if (material.getEmissive() != null){
                    red += material.getEmissive().getRed();
                    green += material.getEmissive().getGreen();
                    blue += material.getEmissive().getBlue();
                }
                
                //add material's diffuse component
                if (material.getDiffuse() != null){
                    red += material.getDiffuse().getRed() * totalLightDiffuseRed;
                    green += material.getDiffuse().getGreen() * totalLightDiffuseGreen;
                    blue += material.getDiffuse().getBlue() * totalLightDiffuseBlue;
                }
                
                //add material's specular component
                if (material.getSpecular() != null){
                    red += material.getSpecular().getRed() * totalLightSpecularRed;
                    green += material.getSpecular().getGreen() * totalLightSpecularGreen;
                    blue += material.getSpecular().getBlue() * totalLightSpecularBlue;
                }
            }
            
            //if maxDepth reached , then stop recursion
            if (maxDepth == 0){
                return;
            }
            //calculate reflection
            if (closestObject.getReflect() > 0.0d){
                Vector3D reflectionVector = Vector3D.subtract(ray.getDirectionVector(),
                        (Vector3D.multiply
                        (Vector3D.multiply
                        (normal,Vector3D.dotProduct
                        (ray.getDirectionVector(),normal)),2.0d)));
                Ray reflectionRay = new Ray();
                reflectionRay.setStartVector(closestIntersect.getLocation());
                reflectionRay.setDirectionVector(reflectionVector);
                RGBColour reflectionColour = new RGBColour(0.0d,0.0d,0.0d);
                maxDepth--;
                //cast reflectionRay
                trace(reflectionRay,scene,reflectionColour,maxDepth);
                
                //apply colour from reflectionRay
                red += (reflectionColour.getRed() * closestObject.getReflect());
                green += (reflectionColour.getGreen() * closestObject.getReflect());
                blue += (reflectionColour.getBlue() * closestObject.getReflect());
                
            }
            
            //calculate refraction
            if (closestObject.getRefract() > 0.0d){
                Vector3D transmissionVector = calculateTransmissionVector(ray.getDirectionVector(),normal,closestObject.getRefract());
                if (transmissionVector != null){
                    Ray refractionRay = new Ray();
                    refractionRay.setStartVector(closestIntersect.getLocation());
                    refractionRay.setDirectionVector(transmissionVector);
                    RGBColour refractionColour = new RGBColour(0.0d,0.0d,0.0d);
                    maxDepth--;
                    //cast refractionRay
                    trace(refractionRay,scene,refractionColour,maxDepth);
                    
                    //apply refractionRay colour
                    red += (refractionColour.getRed()  * closestObject.getRefract());
                    green += (refractionColour.getGreen() * closestObject.getRefract());
                    blue += (refractionColour.getBlue() * closestObject.getRefract());
                }
            }
            
            //apply calculated colour to objects colour
            RGBColour finalColour = closestObject.getColour(closestIntersect);
            if (finalColour == null){
                colour.setRed(red);
                colour.setGreen(green);
                colour.setBlue(blue);
            }else{
                colour.setRed(finalColour.getRed() * red);
                colour.setGreen(finalColour.getGreen() * green);
                colour.setBlue(finalColour.getBlue() * blue);
            }
        }
    }
    
    /**
     * Calculate transmissionVector for refractionRay
     */
    public Vector3D calculateTransmissionVector(Vector3D directionVector,Vector3D normal,double refractionIndex){
        directionVector = Vector3D.multiply(directionVector,-1.0d);
        double w =  Vector3D.dotProduct(Vector3D.multiply(directionVector,-1.0d), Vector3D.multiply(normal,refractionIndex));
        double k = Math.sqrt(1.0d + ((w - refractionIndex)*(w + refractionIndex)));
        Vector3D tVector = Vector3D.add(Vector3D.multiply(normal,(w - k)),Vector3D.multiply(directionVector,refractionIndex));
        return tVector;
    }
    
    /**
     * Display rendered image
     */
    public void display(Image image){
        PerformanceTimer pt = new PerformanceTimer("Display Scene");
        pt.start();
        setVisible(false);
        canvas.setImage(image);
        repaint();
        setSize(width,height);
        setVisible(true);
        pt.stop();
    }
    
    
    /**
     * Save rendered image in png format
     */
    public void save(BufferedImage image, String fileName){
        PerformanceTimer pt = new PerformanceTimer("Save Image");
        pt.start();
        try{
            File file = new File(fileName + ".png");
            FileImageOutputStream fios = new FileImageOutputStream(file);
            
            Iterator iterator =  ImageIO.getImageWritersByFormatName("png");
            if (iterator.hasNext()){
                ImageWriter imageWriter = (ImageWriter)iterator.next();
                imageWriter.setOutput(fios);
                imageWriter.write(image);
            }
            
            fios.close();
            
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
        pt.stop();
        
    }
    
    /**
     * Canvas to paint the rendered image.
     */
    class RayTracingCanvas extends Canvas{
        private Image image;
        
        public void paint(Graphics graphics){
            graphics.setColor(Color.BLACK);
            graphics.clearRect(0,0,getWidth(),getHeight());
            if (image != null){
                graphics.drawImage(image,0,0,this);
            }
        }
        
        public void setImage(Image image){
            this.image = image;
        }
        
    }
    
    class EventHandler extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
    
    public int getSuperSampling() {
        return superSampling;
    }
    
    public void setSuperSampling(int superSampling) {
        this.superSampling = superSampling;
    }
    
    public int getMaxDepth() {
        return maxDepth;
    }
    
    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
    
    public String toString(){
        return "RayTracer " + getHeight() + " x " + getWidth() + " superSampling=" + getSuperSampling() + " maxDepth=" + getMaxDepth();
    }
}