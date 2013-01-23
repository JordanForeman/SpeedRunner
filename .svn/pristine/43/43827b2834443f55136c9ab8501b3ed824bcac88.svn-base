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
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Jordan Foreman
 * @author Mike Cornell
 */
public class GUI extends StateBasedGame
{   
    
    public static final int MAIN_MENU_STATE = 0;
    public static final int GAMEPLAY_STATE = 1;
    public static final int END_GAME_STATE = 3;
    
    public GUI()
    {
        super("SpeedRunner!");
        this.addState(new MainMenu(MAIN_MENU_STATE));
        this.addState(new GamePlay(GAMEPLAY_STATE));
        this.addState(new EndGame(END_GAME_STATE));
        this.enterState(MAIN_MENU_STATE);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException 
    {
        this.getState(MAIN_MENU_STATE).init(gc, this);
        this.getState(GAMEPLAY_STATE).init(gc, this);
        this.getState(END_GAME_STATE).init(gc, this);
    }
    
}
