import java.awt.image.BufferedImage;
import junit.framework.*;
/*
 * SphereTest.java
 * JUnit based test
 *
 * Created on 24 September 2006, 15:29
 */

/**
 *
 * @author Daniel Cabral
 */
public class SphereTest extends TestCase {
    
    public SphereTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(SphereTest.class);
        
        return suite;
    }

    /**
     * Test of intersect method, of class Sphere.
     */
    public void testIntersect() {
        System.out.println("testIntersect");
        
        Sphere sphere = new Sphere("s1");
        sphere.setRadius(50.0d);
        sphere.setLocation(new Vector3D(0.0d,0.0d,300.0d));
        
        Ray ray = new Ray();
        ray.setStartVector(new Vector3D(0.8d,0.0d,0.0d));
        Vector3D directionVector = new Vector3D(0.8d,0.0d, 5.0d);
        directionVector.normalize();
        ray.setDirectionVector(directionVector);
        
        Intersect intersect =  sphere.intersect(ray);
        //intersect.getLocation().normalize();
        Vector3D v1 = Vector3D.subtract(intersect.getLocation(),sphere.getLocation());
      
        
         assertTrue("Intersect found:", intersect != null);
         //assertEquals("Intersect distance:", 5.0d, intersect.getDistance());
          System.out.println("Intersect  : " + intersect.getLocation().toString());
          System.out.println("SUbvector  : " + v1.toString());
        
    }
    
    public void testTextureMap(){
        BufferedImage check = RayTracer.createCheck();
        Sphere sphere2 = new Sphere("Blue sphere");
        sphere2.setRadius(50.0d);
        sphere2.setColour(new RGBColour(1.0d,1.0d,1.0d));
        sphere2.setLocation(new Vector3D(0.0d,0.0d,300.0d));
        sphere2.setReflect(0.0d);
        sphere2.setRefract(0.0d);
        sphere2.setTextureMap(check);
        Texel texel = sphere2.getTexel(new Vector3D(45.0d, 0.0d, -20.0));
        
    }
       
}
