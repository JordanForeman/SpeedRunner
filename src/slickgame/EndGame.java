/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;


/**
 *
 * @author Mike Cornell
 *         Jordan Foreman
 */
public class EndGame extends BasicGameState
{
    int stateId = -1;
    Font font;
    UnicodeFont unicodeFont = null;
    Image StartButton = null;
    Image ExitButton = null;
    public static Timer timer;
    
    
    
    
    public EndGame(int sid)
    {
        this.stateId = sid;
    }
    
    @Override
    public int getID() 
    {
        return this.stateId;
    }
    
    
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
    {
        StartButton = new Image( "resources/startButton.png" );
        ExitButton = new Image ( "resources/exitButton.png");
        font = new Font("Verdana", Font.BOLD, 20);
        unicodeFont = new UnicodeFont(font);
        unicodeFont.getEffects().add(new ColorEffect(java.awt.Color.black));
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
    {
        float scale = (float)0.5;
        StartButton.draw(190, 200, scale);
        ExitButton.draw(210, 245, scale);
        
        if(GamePlay.message.equals("WINNER!!  :)"))
        {
            unicodeFont.drawString(250, 50, GamePlay.message);     
            unicodeFont.drawString(160, 100, "your score was - " + Main.scoreList.AllScores().get(0).getTotalTime() + " seconds! ");     
        }
        else
        {
            unicodeFont.drawString(230, 50, GamePlay.message); 
        }
    }
    
    
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException 
    {
        unicodeFont.loadGlyphs();
        
        Input input = gc.getInput();
        
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        
        boolean insideExitGame = false;
        boolean insideStartGame = false;
        
        if(mouseX >= 190 && mouseX <= 190 + StartButton.getWidth()/2 && mouseY >= 200 && mouseY <= 200 + StartButton.getHeight()/2)
        {
            insideStartGame = true;
        }
        else if(mouseX >= 210 && mouseX <= 210 + ExitButton.getWidth()/2 && mouseY >= 245 && mouseY <= 245 + ExitButton.getHeight()/2)
        {
            insideExitGame = true;
        }
        if(insideStartGame)
        {
            if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
            {
                GamePlay.timer.start();
                sbg.enterState(GUI.GAMEPLAY_STATE);
            }
        }
        if(insideExitGame)
        {
            if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
            {
                gc.exit();
            }
        }
    }
}
