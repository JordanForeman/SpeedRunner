/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import javax.xml.parsers.*;
import java.io.IOException;
import org.xml.sax.SAXException;

/**
 *
 * @author Jordan Foreman
 */
public class LevelReader {
    
    Document dom;
    
    public LevelReader(String source){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            dom = db.parse(source);
            
        } catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch(SAXException se) {
            se.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public Level getLevelById(int id){
        NodeList levels = dom.getElementsByTagName("level");
        if(levels != null && levels.getLength() > 0){
            Element level = (Element)levels.item(id);
            
            //Get level details
            Level l = new Level();
            
            l.levelId = id;
            l.levelName = level.getAttribute("name");
            
            //AUDIO
            Element audio = (Element)level.getElementsByTagName("audio").item(0);
            l.audioUrl = "resources/" + audio.getAttribute("resource").toString();
            l.audioName = "resources/" + audio.getAttribute("title").toString();
            
            //BACKGROUND
            l.backgroundUrl = "resources/" + ((Element)level.getElementsByTagName("backdrop").item(0)).getAttribute("resource").toString();
            
            //OBSTACLE LIST
            NodeList obstacles = level.getElementsByTagName("obstacle");
            if(obstacles != null && obstacles.getLength() > 0){
                ObstacleList oList = new ObstacleList();
                for(int i = 0; i < obstacles.getLength(); i++){
                    Element ObEl = (Element)obstacles.item(i);
                    
                    try{
                        Obstacle obstacle = new Obstacle("resources/" + ObEl.getAttribute("resource"));
                        obstacle.width = Integer.parseInt(ObEl.getAttribute("width"));
                        obstacle.height = Integer.parseInt(ObEl.getAttribute("height"));
                        obstacle.initialX = obstacle.posX = Integer.parseInt(ObEl.getAttribute("PosX"));
                        obstacle.initialY = obstacle.posY = Integer.parseInt(ObEl.getAttribute("PosY"));
                        obstacle.deadly = (ObEl.getAttribute("deadly").equals("true")) ? true : false;
                        
                        oList.AddObstacle(obstacle);
                        
                    } catch(SlickException e) {
                        e.printStackTrace();
                    }
                }
                l.obstacles = oList;
            }
            return l;
        } else {
            return null;
        }
    }
}
