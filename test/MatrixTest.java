import junit.framework.*;
/*
 * MatrixTest.java
 * JUnit based test
 *
 * Created on 08 October 2006, 15:12
 */

/**
 *
 * @author daniel cabral
 */
public class MatrixTest extends TestCase {
    
    public MatrixTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(MatrixTest.class);
        
        return suite;
    }

    /**
     * Test of multiply method, of class Matrix.
     */
    public void testMultiplyWithVector() {
        System.out.println("testMultiplyWithVector");
        Matrix m = new Matrix(new double[][]
        {
            {0,-1,0,2},
            {1,0,0,0},
            {0,0,1,0},
            {0,0,0,1}
        });
        Vector3D vector = new Vector3D();
        vector.setX(2);
        vector.setY(2);
        vector.setZ(-1);
        vector.setW(1);
       
       Vector3D result = Matrix.multiply(m,vector);
       assertEquals(0.0d,result.getX());
       assertEquals(2.0d,result.getY());
       assertEquals(-1.0d,result.getZ());
       assertEquals(1.0d,result.getW());
        
    }
    
     public void testMultiplyWithMatrix() {
        System.out.println("testMultiplyWithMatrix");
        Matrix rMatrix = Matrix.createRotationMatrix(45.0d, Matrix.X_AXIS);
        Matrix tMatrix = Matrix.createTranslationMatrix(30.0d, 40.0d,0.0d);
        Matrix result = Matrix.multiply(tMatrix,rMatrix);
        double[][] matrix = result.getMatrix();
        
        assertEquals(matrix[0][0],1.0d);
        assertEquals(matrix[0][1],0.0d);
        assertEquals(matrix[0][2],0.0d);
        assertEquals(matrix[0][3],30.0d);
        assertEquals(matrix[1][0],0.0d);
        assertEquals(matrix[1][1],0.7071d, 0.0001d);
        assertEquals(matrix[1][2],-0.7071d,0.0001d);
        assertEquals(matrix[1][3] ,40.0d);
        assertEquals(matrix[2][0],0.0d);
        assertEquals(matrix[2][1] ,0.7071d,0.0001d);
        assertEquals(matrix[2][2] ,0.7071d,0.0001d);
        assertEquals(matrix[2][3] , 0.0d);
        assertEquals(matrix[3][0] , 0.0d);
        assertEquals(matrix[3][1] , 0.0d);
        assertEquals(matrix[3][2] , 0.0d);
        assertEquals(matrix[3][3] , 1.0d);
             
    }

    /**
     * Test of createTranslationMatrix method, of class Matrix.
     */
    public void testCreateTranslationMatrix() {
        System.out.println("testCreateTranslationMatrix");
        Matrix result = Matrix.createTranslationMatrix(6, 3,5);
        double[][] matrix = result.getMatrix();
        // TODO add your test code below by replacing the default call to fail.
        assertTrue(matrix[0][0] == 1.0d);
        assertTrue(matrix[0][1] == 0.0d);
        assertTrue(matrix[0][2] == 0.0d);
        assertTrue(matrix[0][3] == 6.0d);
        assertTrue(matrix[1][0] == 0.0d);
        assertTrue(matrix[1][1] == 1.0d);
        assertTrue(matrix[1][2] == 0.0d);
        assertTrue(matrix[1][3] == 3.0d);
        assertTrue(matrix[2][0] == 0.0d);
        assertTrue(matrix[2][1] == 0.0d);
        assertTrue(matrix[2][2] == 1.0d);
        assertTrue(matrix[2][3] == 5.0d);
        assertTrue(matrix[3][0] == 0.0d);
        assertTrue(matrix[3][1] == 0.0d);
        assertTrue(matrix[3][2] == 0.0d);
        assertTrue(matrix[3][3] == 1.0d);
    }

    /**
     * Test of createScalingMatrix method, of class Matrix.
     */
    public void testCreateScalingMatrix() {
        System.out.println("testCreateScalingMatrix");
        Matrix result = Matrix.createScalingMatrix(6, 3,5);
        double[][] matrix = result.getMatrix();
        // TODO add your test code below by replacing the default call to fail.
        assertTrue(matrix[0][0] == 6.0d);
        assertTrue(matrix[0][1] == 0.0d);
        assertTrue(matrix[0][2] == 0.0d);
        assertTrue(matrix[0][3] == 0.0d);
        assertTrue(matrix[1][0] == 0.0d);
        assertTrue(matrix[1][1] == 3.0d);
        assertTrue(matrix[1][2] == 0.0d);
        assertTrue(matrix[1][3] == 0.0d);
        assertTrue(matrix[2][0] == 0.0d);
        assertTrue(matrix[2][1] == 0.0d);
        assertTrue(matrix[2][2] == 5.0d);
        assertTrue(matrix[2][3] == 0.0d);
        assertTrue(matrix[3][0] == 0.0d);
        assertTrue(matrix[3][1] == 0.0d);
        assertTrue(matrix[3][2] == 0.0d);
        assertTrue(matrix[3][3] == 1.0d);
       
    }

    /**
     * Test of createRotationMatrix method, of class Matrix.
     */
    public void testCreateRotationMatrix() {
        System.out.println("testCreateRotationMatrix");
        
       Matrix rMatrix = Matrix.createRotationMatrix(45.0d, Matrix.X_AXIS);
       double[][] matrix = rMatrix.getMatrix();
        // TODO add your test code below by replacing the default call to fail.
        assertEquals(matrix[0][0],1.0d);
        assertEquals(matrix[0][1],0.0d);
        assertEquals(matrix[0][2],0.0d);
        assertEquals(matrix[0][3],0.0d);
        assertEquals(matrix[1][0],0.0d);
        assertEquals(matrix[1][1],0.7071d, 0.0001d);
        assertEquals(matrix[1][2],-0.7071d,0.0001d);
        assertEquals(matrix[1][3] ,0.0d);
        assertEquals(matrix[2][0],0.0d);
        assertEquals(matrix[2][1] ,0.7071d,0.0001d);
        assertEquals(matrix[2][2] ,0.7071d,0.0001d);
        assertEquals(matrix[2][3] , 0.0d);
        assertEquals(matrix[3][0] , 0.0d);
        assertEquals(matrix[3][1] , 0.0d);
        assertEquals(matrix[3][2] , 0.0d);
        assertEquals(matrix[3][3] , 1.0d);
        
     }
 
}
