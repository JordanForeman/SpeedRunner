/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
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
public class MainMenu extends BasicGameState 
{
    
    //BasicGameState StateID
    int stateId = -1;
    
    //Images 
    Image StartButton = null;
    Image ExitButton = null;
    Image Title = null;
    
    public MainMenu(int sid)
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
        Title = new Image( "resources/title.png" );
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
    {
        
        g.setBackground(Color.white);
        
        float scale = (float)0.5;
        
        //g.drawImage(land, 0, 0);
        //land.draw(0, 0, 2);
        
        Title.draw(75, 100, scale);
        //g.drawImage(StartButton, 213, 160);
        StartButton.draw(190, 200, scale);
        //g.drawImage(ExitButton, 213, 240);
        ExitButton.draw(210, 245, scale);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException 
    {
        Input input = gc.getInput();
        
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        
        boolean insideStartGame = false;
        boolean insideExitGame = false;
        
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
