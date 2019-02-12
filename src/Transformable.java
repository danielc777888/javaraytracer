package javaraytracer;

/*
 * Transformable.java
 *
 * Created on 15 October 2006, 14:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public interface Transformable {
    Matrix getMatrix();
    void setMatrix(Matrix matrix);
    void transform();
}
