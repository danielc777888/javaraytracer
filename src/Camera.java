package javaraytracer;

import java.util.List;

public class Camera implements Transformable{
    
    private Vector3D startVector;
    private Vector3D directionVector;
    private Matrix matrix;
    
    /** Creates a new instance of Camera */
    public Camera() {
    }
    
    public Vector3D getStartVector() {
        return startVector;
    }
    
    public void setStartVector(Vector3D startVector) {
        this.startVector = startVector;
    }
    
    public Vector3D getDirectionVector() {
        return directionVector;
    }
    
    public void setDirectionVector(Vector3D directionVector) {
        this.directionVector = directionVector;
    }
    
    public void transform(){
        directionVector = Matrix.multiply(matrix,directionVector);
    }
    
    public Matrix getMatrix() {
        return matrix;
    }
    
    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Start Vector : " + getStartVector() + "\n");
        sb.append("Direction Vector : " + getDirectionVector() + "\n");
        sb.append("Matrix : " + getMatrix());
        return sb.toString();
    }
    
}
