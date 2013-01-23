/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;

/**
 *
 * @author Jordan Foreman
 * @author Mike Cornell
 */
public class Player {
    
    Image playerImage = null;
    String stand = "resources/MegaMan_breathe.gif";
    String run = "resources/MegaMan_run.gif";
    
    int PosX = 0;
    int PosY = 0;
    
    int offset = 0;
    
    enum DirX{LEFT, RIGHT, NONE}
    DirX dirX;
    
    enum DirY{UP, DOWN, NONE}
    DirY dirY;
    
    enum MoveState{STANDING, WALKING, JUMPING, FALLING}
    MoveState state;
    
    int MoveSpeedX = 2;
    int MoveSpeedY = 3;
    int JumpHeight = 30;
    
    float scale = 1.0f;
    
    boolean dead = false;
    boolean flatMovement = true;
    boolean verticalMovement =false;
    
    Input lastInput;
    
    int StartJumpY;
    int StartJumpX;
    
    public Player(int x, int y) throws SlickException
    {
        playerImage = new Image(stand);
        PosX = x;
        PosY = y;
        state = MoveState.STANDING;
    }
    
    public Player(int x, int y, float sc) throws SlickException
    {
        playerImage = new Image(stand);
        PosX = x;
        PosY = y;
        scale = sc;
        state = MoveState.STANDING;
    }
    
    public void update(Input input, Graphics g, Level l) throws SlickException
    {
        
        
        //CHECKING INPUT
        if(input.isKeyDown(input.KEY_LEFT) && !isCollision("LEFT", l.obstacles, 0)) 
        { //Move Left
            if(offset < Main.width/8)
            {
                PosX -= MoveSpeedX;
                offset++;
            }
            if(!isCollision("DOWN",l.obstacles,0) && flatMovement)
            {
                state = MoveState.FALLING;
                UpdateJump(l);
            }
            else
            {
                dirX = (dirX != DirX.LEFT) ? DirX.LEFT : dirX;
                state = (state == MoveState.STANDING) ? MoveState.WALKING : state;
                l.offset += MoveSpeedX; 
            }
            
        } 
        else if(input.isKeyDown(input.KEY_RIGHT) && !isCollision("RIGHT", l.obstacles,0)) 
        { //Move Right
            if(offset > Main.width/-8)
            {
                PosX += MoveSpeedX;
                offset--;
            }
            
            if(!isCollision("DOWN",l.obstacles,0) && flatMovement)
            {
                state = MoveState.FALLING;
                UpdateJump(l);
            }
            else
            {
                dirX = (dirX != DirX.RIGHT) ? DirX.RIGHT : dirX;
                state = (state == MoveState.STANDING) ? MoveState.WALKING : state;
                l.offset -= MoveSpeedX;
            }
            
        }
        else 
        { //No relevant key is pressed
            dirX = (dirX != DirX.NONE) ? DirX.NONE : dirX;
            state = (state == MoveState.STANDING || state == MoveState.JUMPING || state == MoveState.FALLING) ? state : MoveState.STANDING;
        }
        
        if(input.isKeyDown(input.KEY_SPACE) && !isCollision("UP", l.obstacles,0))
        { //Jump
            if(state != MoveState.JUMPING && state != MoveState.FALLING)
            {
                StartJump();
            }
        } 
        
        if(state == MoveState.STANDING)
        {
            playerImage = new Image(stand);
        }
        
        if(state == MoveState.WALKING)
        {
            playerImage = new Image(run);
        }
        
        if(state == MoveState.JUMPING || state == MoveState.FALLING)
        {
            UpdateJump(l);
            //playerImage = new Image(jump);
        }
        
        lastInput = input;
        this.draw(g);
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(playerImage, PosX, PosY);
    }
    
    protected void StartJump()
    {
        state = MoveState.JUMPING;
        StartJumpX = this.PosX;
        StartJumpY = this.PosY;
    }
    
    protected void UpdateJump(Level l)
    {
        if(this.state == MoveState.JUMPING)
        {
            flatMovement = false;
            verticalMovement = true;
            if(!isCollision("UP", l.obstacles,0) )
            {
                if(this.PosY >= (StartJumpY - JumpHeight))
                {
                    this.PosY -= this.MoveSpeedY;
                } 
                else 
                {
                    this.state = MoveState.FALLING;
                }
            } 
            else 
            {
                if(!dead)
                {
                    this.state = MoveState.FALLING;
                }
            }
        } 
        else if(this.state == MoveState.FALLING)
        {
            if(isCollision("DOWN", l.obstacles,0))
            {
                if(!dead)
                {
                    this.state = MoveState.STANDING;
                    flatMovement = true;
                    verticalMovement = false;
                }
            } 
            else 
            {
                this.PosY += this.MoveSpeedY;
            }
            if(this.PosY == Main.height){
                this.die();
            }
        }
    }
    
    protected boolean isCollision(String dir, ObstacleList oList, int i)
    {
        //TODO: FIX THIS METHOD
        
        double PlayerBottom = playerImage.getHeight() + this.PosY;
        double PlayerRight =  playerImage.getWidth() + this.PosX ;
        double PlayerTop = this.PosY;
        double PlayerLeft = this.PosX;
        
        
        
        while( i<oList.AllObstacles().size())
        {
            
            double ObjectTop = oList.AllObstacles().get(i).getPosy();
            double ObjectBottom = oList.AllObstacles().get(i).getPosy() + oList.AllObstacles().get(i).getHeight();
            double ObjectLeft = oList.AllObstacles().get(i).getPosx();
            double ObjectRight = oList.AllObstacles().get(i).getPosx() + oList.AllObstacles().get(i).getWidth();
            
            
            //possible collision to the right
            if(  PlayerRight >= ObjectLeft - 8 && PlayerRight <= ObjectLeft && dir.equals("RIGHT") )
            {                
                if(PlayerTop <= ObjectBottom && PlayerTop >= ObjectTop)
                {   
                    if(oList.AllObstacles().get(i).getDeadly())
                    {
                        this.die();
                    }
                    return true;
                }
                else
                {
                    i++;
                    isCollision(dir,oList,i);
                }
            }
            
            //possible collision to the left
            if(  PlayerLeft <= ObjectRight + 12 && PlayerLeft >= ObjectRight && dir.equals("LEFT")  )
            {     
                //check to make sure its an actual collision
                if(PlayerTop <= ObjectBottom && PlayerTop >= ObjectTop)
                {   
                    if(oList.AllObstacles().get(i).getDeadly())
                    {
                        this.die();
                    }
                    return true;   
                }
                else
                {
                    i++;
                    isCollision(dir,oList,i);
                }
                
            
            }
            
            //possible collision up
            if(  PlayerTop <= ObjectBottom + 12 && PlayerTop >= ObjectBottom && dir.equals("UP"))
            {
                if(PlayerRight >= ObjectLeft - 2 && PlayerLeft <= ObjectRight + 17)
                {
                    if(oList.AllObstacles().get(i).getDeadly())
                    {
                        this.die();
                    }
                    return true;
                }
                else
                {
                    i++;
                    isCollision(dir,oList,i);
                }
                
            
            }
            
            //possible collision down
            if(  PlayerBottom >= ObjectTop - 2 && PlayerBottom <= ObjectTop && dir.equals("DOWN"))
            {  
                
                if(PlayerRight >= ObjectLeft - 2 && PlayerLeft <= ObjectRight + 17)
                {
                    if(oList.AllObstacles().get(i).getDeadly())
                    {
                        this.die();
                    }
                    return true;
                }
                
                else if(PlayerBottom >= 274)
                {
                    return true;
                }
                else
                {
                    i++;
                    isCollision(dir,oList,i);
                }
            
            }
            
        i++;
        }
        //no possible collisions
        return false;
    }
    
    
    
    
    public boolean getDead()
    {
        return dead;
    }
    
    public void die()
    {
        dead = true;
    }
    
    public void live()
    {
        dead = false;
    }
    
}
