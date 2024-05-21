import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    public boolean playersturn = true;
    private int playerCardNum = 26;
    private ArrayList<card> playerPile = new ArrayList<>();
    public int timer = 100;
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        displayScore();
        checkIfWin();
        checkIfLose();
        if (playersturn){
            MyWorld w = (MyWorld)getWorld();
            card drawnCard = w.playerCard.remove(0);
            w.cardInPile.add(drawnCard);
            w.cardNumInPile++;
            w.addObject(drawnCard, 300, 200);
            }
            // fix this later.
    }
    public void placeCardDown(){
        
    }
    private void displayScore(){
        MyWorld w = (MyWorld)getWorld();
        w.showText("cards", 200, 300);
        w.showText(Integer.toString(playerCardNum), 200, 350);
    }
    private void checkIfWin(){
        MyWorld w = (MyWorld)getWorld();
        if (playerCardNum == 52){
            w.showText("You won!", 300, 200);
            Greenfoot.stop();
        }
    }
    private void checkIfLose(){
        MyWorld w = (MyWorld)getWorld();
        if (playerCardNum == 0){
            w.showText("You lost!", 300, 200);
            Greenfoot.stop();
        }
    }
    
}
