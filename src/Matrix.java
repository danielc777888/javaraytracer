package javaraytracer;

/*
 * Matrix.java
 *
 * Created on 08 October 2006, 14:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel
 */
public class Matrix {
    
    public final static int X_AXIS = 0;
    public final static int Y_AXIS = 1;
    public final static int Z_AXIS = 2;
    
    private double[][] matrix;
    
    /** Creates a new instance of Matrix */
    public Matrix(double arr[][]) {
        this.setMatrix(arr);
    }
    
    public static Vector3D multiply(Matrix m, Vector3D vector){
        Vector3D result = new Vector3D();
        double[][] matrix = m.getMatrix();
        double x = (matrix[0][0] * vector.getX()) + (matrix[0][1] * vector.getY()) + (matrix[0][2] * vector.getZ()) + (matrix[0][3] * vector.getW());
        double y = (matrix[1][0] * vector.getX()) + (matrix[1][1] * vector.getY()) + (matrix[1][2] * vector.getZ()) + (matrix[1][3] * vector.getW());
        double z = (matrix[2][0] * vector.getX()) + (matrix[2][1] * vector.getY()) + (matrix[2][2] * vector.getZ()) + (matrix[2][3] * vector.getW());
        double w = (matrix[3][0] * vector.getX()) + (matrix[3][1] * vector.getY()) + (matrix[3][2] * vector.getZ()) + (matrix[3][3] * vector.getW());
        result.setX(x);
        result.setY(y);
        result.setZ(z);
        result.setW(w);
        return result;
    }
    
    public static Matrix multiply(Matrix matrix1, Matrix matrix2){
        double[][] m1 = matrix1.getMatrix();
        double[][] m2 = matrix2.getMatrix();
        return new Matrix(new double[][]{
            {
                (m1[0][0] * m2[0][0]) + (m1[0][1] * m2[1][0]) + (m1[0][2] * m2[2][0]) + (m1[0][3] * m2[3][0]),
                        (m1[0][0] * m2[0][1]) + (m1[0][1] * m2[1][1]) + (m1[0][2] * m2[2][1]) + (m1[0][3] * m2[3][1]),
                        (m1[0][0] * m2[0][2]) + (m1[0][1] * m2[1][2]) + (m1[0][2] * m2[2][2]) + (m1[0][3] * m2[3][2]),
                        (m1[0][0] * m2[0][3]) + (m1[0][1] * m2[1][3]) + (m1[0][2] * m2[2][3]) + (m1[0][3] * m2[3][3])
            },
            {
                (m1[1][0] * m2[0][0]) + (m1[1][1] * m2[1][0]) + (m1[1][2] * m2[2][0]) + (m1[1][3] * m2[3][0]),
                        (m1[1][0] * m2[0][1]) + (m1[1][1] * m2[1][1]) + (m1[1][2] * m2[2][1]) + (m1[1][3] * m2[3][1]),
                        (m1[1][0] * m2[0][2]) + (m1[1][1] * m2[1][2]) + (m1[1][2] * m2[2][2]) + (m1[1][3] * m2[3][2]),
                        (m1[1][0] * m2[0][3]) + (m1[1][1] * m2[1][3]) + (m1[1][2] * m2[2][3]) + (m1[1][3] * m2[3][3])
            },
            {
                (m1[2][0] * m2[0][0]) + (m1[2][1] * m2[1][0]) + (m1[2][2] * m2[2][0]) + (m1[2][3] * m2[3][0]),
                        (m1[2][0] * m2[0][1]) + (m1[2][1] * m2[1][1]) + (m1[2][2] * m2[2][1]) + (m1[2][3] * m2[3][1]),
                        (m1[2][0] * m2[0][2]) + (m1[2][1] * m2[1][2]) + (m1[2][2] * m2[2][2]) + (m1[2][3] * m2[3][2]),
                        (m1[2][0] * m2[0][3]) + (m1[2][1] * m2[1][3]) + (m1[2][2] * m2[2][3]) + (m1[2][3] * m2[3][3])
            },
            {
                (m1[3][0] * m2[0][0]) + (m1[3][1] * m2[1][0]) + (m1[3][2] * m2[2][0]) + (m1[3][3] * m2[3][0]),
                        (m1[3][0] * m2[0][1]) + (m1[3][1] * m2[1][1]) + (m1[3][2] * m2[2][1]) + (m1[3][3] * m2[3][1]),
                        (m1[3][0] * m2[0][2]) + (m1[3][1] * m2[1][2]) + (m1[3][2] * m2[2][2]) + (m1[3][3] * m2[3][2]),
                        (m1[3][0] * m2[0][3]) + (m1[3][1] * m2[1][3]) + (m1[3][2] * m2[2][3]) + (m1[3][3] * m2[3][3])
            },
                    
        });
    }
    
    public static Matrix createTranslationMatrix(double dX, double dY, double dZ){
        return new Matrix(new double[][]
        {
            {1,0,0,dX},
            {0,1,0,dY},
            {0,0,1,dZ},
            {0,0,0,1}
        }
        );
    }
    
    public static Matrix createScalingMatrix(double sX, double sY, double sZ){
        return new Matrix(new double[][]
        {
            {sX,0,0,0},
            {0,sY,0,0},
            {0,0,sZ,0},
            {0,0,0,1}
        }
        );
    }
    
    public static Matrix createRotationMatrix(double angle, int axis){
        double radians = Math.toRadians(angle);
        switch(axis){
            case Matrix.X_AXIS:{
                return new Matrix(new double[][]
                {
                    {1,0,0,0},
                    {0,Math.cos(radians),-Math.sin(radians),0},
                    {0,Math.sin(radians),Math.cos(radians),0},
                    {0,0,0,1}
                }
                );
            }
            case Matrix.Y_AXIS:{
                return new Matrix(new double[][]
                {
                    {Math.cos(radians),0,Math.sin(radians),0},
                    {0,1,0,0},
                    {-Math.sin(radians),0,Math.cos(radians),0},
                    {0,0,0,1}
                }
                );
            }
            case Matrix.Z_AXIS:{
                return new Matrix(new double[][]
                {
                    {Math.cos(radians),-Math.sin(radians),0,0},
                    {Math.sin(radians),Math.cos(radians),0,0},
                    {0,0,1,0},
                    {0,0,0,1}
                }
                );
            }
        }
        return null;
    }
    
    public static Matrix createRotationMatrix(Vector3D vector,double angle,int axis){
        Matrix tm1 = createTranslationMatrix(vector.getX(),vector.getY(),vector.getZ());
        Matrix rm =  createRotationMatrix(angle,axis);
        Matrix tm2 = createTranslationMatrix(-vector.getX(),-vector.getY(),-vector.getZ());
        return multiply(multiply(tm1,rm),tm2);
    }
    
    public static Matrix createScalingMatrix(Vector3D vector,double scaleX,double scaleY,double scaleZ){
        Matrix tm1 = createTranslationMatrix(vector.getX(),vector.getY(),vector.getZ());
        Matrix sm =  createScalingMatrix(scaleX, scaleY,scaleZ);
        Matrix tm2 = createTranslationMatrix(-vector.getX(),-vector.getY(),-vector.getZ());
        return multiply(multiply(tm1,sm),tm2);
    }
    
    public double[][] getMatrix() {
        return matrix;
    }
    
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
    
   public String toString(){
       StringBuffer sb = new StringBuffer();
       sb.append("\n");
       for(int y = 0; y < 4;y++){
           
           for(int x = 0; x < 4; x++){
               sb.append(matrix[y][x]);
               sb.append(" , ");
           }
           sb.append("\n");
       }
       return sb.toString();
   }
}
