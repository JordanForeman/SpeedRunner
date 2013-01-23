/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;


import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Mike Cornell
 * @author Jordan Foreman
 */
public class Obstacle
{
    
    int initialX;
    int initialY;
    
    String ImageResource;
    Image ObstacleImage = null;
    int width;
    int height;
    boolean deadly;
    int posX;
    int posY;
    
    public Obstacle(String resource) throws SlickException
    {
        ImageResource = resource;
    }
    
    public int getPosx()
    {
        return posX;
    }
    
    public int getPosy()
    {
        return posY;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public boolean getDeadly()
    {
        return deadly;
    }
    
    public void offset(int o)
    {
        posX = initialX + o;
    }
    
    public void draw(Graphics g) throws SlickException
    {
        g.drawImage(new Image(ImageResource), posX, posY);
    }
}
