/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;

/**
 *
 * @author jordanforeman
 */
public class Timer {
    private long startTime;
    private long endTime;
    private boolean running;
    
    /**
     * Starts the timer
     */
    public void start(){
        if(!running){
            startTime = System.currentTimeMillis();
            running = true;
        } else {
            System.out.println("Timer already started");
        }
    }
    
    /**
     * Stops the timer
     */
    public void stop(){
        if(running){
            endTime = System.currentTimeMillis();
            running = false;
        } else {
            System.out.println("Timer not started yet");
        }
    }
    
    /**
     * Resets the timer
     */
    public void reset(){
        startTime = 0;
        endTime = 0;
        running = false;
    }
    
    /**
     * Returns the total amount of time attached to the time at the moment this
     * method is called in milliseconds, taking into account whether or not the 
     * timer is running.
     * 
     * @return The timers total time, in Milliseconds
     */
    public long getTimeInMillis(){
        if(!running){
            return endTime - startTime;
        } else {
            return System.currentTimeMillis() - startTime;
        }
    }
    
    /**
     * Returns the total amount of time attached to the time at the moment this
     * method is called in milliseconds, taking into account whether or not the 
     * timer is running.
     * 
     * @return The timers total time, in Seconds
     */
    public long getTimeInSeconds(){
        return getTimeInMillis() / 1000;
    }
  
}
