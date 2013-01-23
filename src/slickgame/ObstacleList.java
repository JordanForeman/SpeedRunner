/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Mike Cornell
 */
public class ObstacleList
{
    
    private ArrayList<Obstacle> OList = null;
    
    public ObstacleList()
    {
        if(OList==null)
        {
            OList = new ArrayList<Obstacle>();
        }
    }
    
    public ArrayList<Obstacle> AllObstacles()
    {
        return OList;
    }
            
    public void AddObstacle(Obstacle obstacle)
    {
        OList.add(obstacle);
    }
    
    public void RemoveObstacle(Obstacle obstacle)
    {
        OList.remove(obstacle);
    }            
}
