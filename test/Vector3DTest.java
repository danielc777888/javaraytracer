import junit.framework.*;
/*
 * Vector3DTest.java
 * JUnit based test
 *
 * Created on 24 September 2006, 14:19
 */

/**
 *
 * @author Gething
 */
public class Vector3DTest extends TestCase {
    
    public Vector3DTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(Vector3DTest.class);
        
        return suite;
    }
    
    /**
     * Test of add method, of class Vector3D.
     */
    public void testAdd() {
        System.out.println("testAdd");
        
        Vector3D v1 = new Vector3D(12.0d, 13.0d, 15.0d);
        Vector3D v2 = new Vector3D(14.0d, 10.0d, -1.0d);
        
        Vector3D result = Vector3D.add(v1,v2);
        assertEquals("Test X : ",26.0d,result.getX());
        assertEquals("Test Y : ",23.0d,result.getY());
        assertEquals("Test Z : ",14.0d,result.getZ());
         
        
    }

    /**
     * Test of subtract method, of class Vector3D.
     */
    public void testSubtract() {
        System.out.println("testSubtract");
        
        Vector3D v1 = new Vector3D(12.0d, 13.0d, 15.0d);
        Vector3D v2 = new Vector3D(14.0d, 10.0d, 1.0d);
        
        Vector3D result = Vector3D.subtract(v1,v2);
        assertEquals("Test X : ",-2.0d,result.getX());
        assertEquals("Test Y : ",3.0d,result.getY());
        assertEquals("Test Z : ",14.0d,result.getZ());
    }

    /**
     * Test of multiply method, of class Vector3D.
     */
    public void testMultiply() {
        System.out.println("testMultiply");
        
        Vector3D v1 = new Vector3D(12.0d, 13.0d, 15.0d);
        Vector3D v2 = new Vector3D(14.0d, 10.0d, -1.0d);
        
        Vector3D result = Vector3D.multiply(v1,v2);
        assertEquals("Test X : ",168.0d,result.getX());
        assertEquals("Test Y : ",130.0d,result.getY());
        assertEquals("Test Z : ",-15.0d,result.getZ());
       
    }


    /**
     * Test of divide method, of class Vector3D.
     */
    public void testDivide() {
        System.out.println("testDivide");
        
         Vector3D v1 = new Vector3D(12.0d, 13.0d, 15.0d);
        Vector3D v2 = new Vector3D(14.0d, 10.0d, -1.0d);
        
        Vector3D result = Vector3D.divide(v1,v2);
        assertEquals("Test X : ",0.8571428d,result.getX(),0.000001d);
        assertEquals("Test Y : ",1.3d,result.getY());
        assertEquals("Test Z : ",-15.0d,result.getZ());
     
    }

    /**
     * Test of getLength method, of class Vector3D.
     */
    public void testGetLength() {
        System.out.println("testGetLength");
        
        Vector3D v1 = new Vector3D(2.0d, 3.0d, 5.0d);
        double result = Vector3D.length(v1);
       assertEquals("Vector length : ",6.164414d,result, 0.00001d);
    }

    /**
     * Test of normalize method, of class Vector3D.
     */
    public void testNormalize() {
        System.out.println("testNormalize");
         Vector3D v1 = new Vector3D(2.0d, 3.0d, 5.0d);
         v1.normalize();
         assertEquals(" X normalized : ", 0.3244428d, v1.getX(), 0.0000001d);
         assertEquals(" Y normalized : ", 0.4866642d, v1.getY(), 0.0000001d);
         assertEquals(" X normalized : ", 0.8111071d, v1.getZ(), 0.0000001d);
      
    }

    /**
     * Test of dotProduct method, of class Vector3D.
     */
    public void testDotProduct() {
        System.out.println("testDotProduct");
        
        Vector3D v1 = new Vector3D(12.0d, 13.0d, 15.0d);
        Vector3D v2 = new Vector3D(14.0d, 10.0d, -1.0d);
        
        double result = Vector3D.dotProduct(v1,v2);
        
        assertEquals(" Dot product :",283.0d,result);
   
    }

    /**
     * Test of crossProduct method, of class Vector3D.
     */
    public void testCrossProduct() {
        System.out.println("testCrossProduct");
        
        Vector3D v1 = new Vector3D(12.0d, 13.0d, 15.0d);
        Vector3D v2 = new Vector3D(14.0d, 10.0d, -1.0d);
        
        Vector3D result = Vector3D.crossProduct(v1,v2);
        
        assertEquals("Cross product X :",-163.0d,result.getX());
        assertEquals("Cross product Y :",222.0d,result.getY());
        assertEquals("Cross product Z :",-62.0d,result.getZ());
        
      
    }
    
}
