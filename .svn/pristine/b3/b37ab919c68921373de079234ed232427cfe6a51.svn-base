/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package slickgame;

/**
 *
 * @author Jordan Foreman
 * @author Michael Cornell
 */
public class Score implements Comparable 
{
    private long TotalTime;
    private int LevelId;

    public Score()
    {
        TotalTime = 0;
        LevelId = 0;

    }

    public Score(int level)
    {
        LevelId = level;
        TotalTime = 0;
    }

    public void CalculateTotalTime(long StartTime, long EndTime)
    {
        TotalTime = EndTime - StartTime;
    }

    //Getters 
    public double getTotalTime(){ return TotalTime; }
    public int getLevelId(){ return LevelId; }

    //Setters
    public void setLevelId(int val){ LevelId = val; }

    //Implement the Comparable Interface
    public int compareTo(Object o) 
    {
        Score sc = (Score)o;
        return (int)(TotalTime - sc.getTotalTime());
    }
    
}
