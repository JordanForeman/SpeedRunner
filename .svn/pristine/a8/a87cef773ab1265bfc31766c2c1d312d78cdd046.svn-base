/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package slickgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Jordan Foreman
 * @author Michael Cornell
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static LevelReader lr;
    public static final int width = 640;
    public static final int height = 320;
    public static ScoreList scoreList;
    
    public static void main(String[] args) throws SlickException
    {
        // TODO code application logic here
        try
        {
            scoreList = new ScoreList();
            lr = new LevelReader("src/resources/levels.xml");
            AppGameContainer app = new AppGameContainer(new GUI());
            app.setDisplayMode(width, height, false);
            app.setShowFPS(false);
            app.setTargetFrameRate(30);
            app.start();
        }
        
        catch(SlickException e)
        {
            e.printStackTrace();
        }
    }
}
