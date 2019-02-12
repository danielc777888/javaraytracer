package javaraytracer;

/*
 * PerformanceTimer.java
 *
 * Created on 25 September 2006, 10:00
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Daniel Cabral
 */
public class PerformanceTimer {
    
    private long startTime;
    private long stopTime;
    private long startMemory;
    private long stopMemory;
    private long memoryUsage;
    private long duration;
    private String description;
    
    /** Creates a new instance of PerformanceTimer */
    public PerformanceTimer(String description) {
        this.description = description;
    }
    
    public void start(){
        startTime = System.currentTimeMillis();
        startMemory = Runtime.getRuntime().totalMemory();
    }   
    
    public void stop(){
        stopTime = System.currentTimeMillis();
        stopMemory = Runtime.getRuntime().totalMemory();
        duration = stopTime - startTime;
        memoryUsage = stopMemory - startMemory;
        System.out.println(description + " : " + duration + "ms " + memoryUsage + " bytes");
    }
    
    
}
