/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Jordan Foreman
 */
public class Level 
{
    Score score;
    ObstacleList obstacles;
    String backgroundUrl;
    String audioUrl;
    String audioName;
    String levelName;
    int levelId;
    int offset;
    
    public void draw(Graphics g) throws SlickException
    {
        if(offset % Main.width != 0){
            g.drawImage(new Image(backgroundUrl), offset * 1, 0);
            g.drawImage(new Image(backgroundUrl), offset, 0);
        } 
        else 
        {
            g.drawImage(new Image(backgroundUrl), 0, 0);
        }
        for(Obstacle o : obstacles.AllObstacles()){
            o.offset(offset);
            g.drawImage(new Image(o.ImageResource), o.posX, o.posY);
            /*System.out.println(o.ImageResource + " : " + o.posX + " : " + o.posY);
            System.out.println();*/
        }
    }
}
