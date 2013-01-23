/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;



import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Input;

/**
 *
 * @author Jordan Foreman
 * @author Mike Cornell
 */
public class GamePlay extends BasicGameState 
{

    int stateId = -1;
    Player player = null;
    Level level;
    long endTime;
    long startTime;
    public static Timer timer;
    public static String message;
    
    public GamePlay(int sid)
    {
        level = Main.lr.getLevelById(0);
        level.score = new Score(level.levelId); 
        timer = new Timer();
        this.stateId = sid;
    }
    
    @Override
    public int getID() 
    {
        return this.stateId;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
    {
        player = new Player(0, 264, 2);
        timer.start();
        startTime = timer.getTimeInSeconds();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
    {
        level.draw(g);
        player.draw(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException 
    {     
        
        if(player.getDead())
        {
            timer.stop();
            player.live();
            
            level.offset = 0;
            player.PosX = 0;
            player.PosY = 264;
            player.offset = 0;
            
            endTime = timer.getTimeInSeconds();
            level.score.CalculateTotalTime(startTime, endTime);
            Main.scoreList.AddScore(level.score);
            
            message = "sorry you lost :(";
            
            sbg.enterState(GUI.END_GAME_STATE);
        }
        
        else if(player.PosX - level.offset >= 405)
        {
            timer.stop();
            
            level.offset = 0;
            player.PosX = 0;
            player.PosY = 264;
            player.offset = 0;
            
            endTime = timer.getTimeInSeconds();
            level.score.CalculateTotalTime(startTime, endTime);
            Main.scoreList.AddScore(level.score);
            
            message = "WINNER!!  :)";
            
            sbg.enterState(GUI.END_GAME_STATE);
        }
        
        
        level.draw(gc.getGraphics());
        player.update(gc.getInput(), gc.getGraphics(), level);

    }
    
}
