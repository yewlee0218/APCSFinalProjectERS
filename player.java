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
    private int playerCardNum = 26;
    private ArrayList<card> playerPile = new ArrayList<>();
    public int timer = 100;
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        MyWorld w = (MyWorld)getWorld();
        displayScore();
        checkIfWin();
        checkIfLose();
        if (w.playersturn){
            if (Greenfoot.mousePressed(slap.class)){
                w.placeCardDownPlayer();
                w.playersturn = false;
            }
        }
    }
    private void displayScore(){
        MyWorld w = (MyWorld)getWorld();
        w.showText("cards", 200, 300);
        w.showText("Press me to put down a card", 400, 300);
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
