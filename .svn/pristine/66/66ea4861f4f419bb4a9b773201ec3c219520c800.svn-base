/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package slickgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jordan Foreman
 * @author Michael Cornell
 */
public class ScoreList 
{
    private ArrayList<Score> AllScores;
    

    public ScoreList()
    {
        AllScores = new ArrayList<Score>();
    }
    

    public boolean AddScore(Score score)
    {
        return AllScores.add(score);
    }
    

    public boolean ClearList()
    {
        AllScores.clear();
        if(AllScores.isEmpty())
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    
    

    public ArrayList<Score> TopTen(int LevelID)
    {
        ArrayList<Score> temp = new ArrayList();
        ArrayList<Score> topTen = new ArrayList();
        
        for(int i=0; i<AllScores.size(); i++)
        {
            if (AllScores.get(i).getLevelId()== LevelID)
            {
                temp.add(this.AllScores.get(i));
            }
        }
        
        Collections.sort(temp);
        
        for(int i = 0; i < 10; i++)
        {
            topTen.add(temp.get(i));
        }
        return topTen;
    }
    

    

    public ArrayList<Score> AllScores()
    {
        return AllScores;
    }
    

    private void sortScores()
    {
        Collections.sort(this.AllScores);
    }

}
