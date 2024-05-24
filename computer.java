import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class computer extends Actor
{
    private int computerCardNum = 26;
    private ArrayList<card> playerPile = new ArrayList<>();
    private int timer = 100;
    /**
     * Act - do whatever the computer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld w = (MyWorld)getWorld();
        displayScore();
    }
    private void displayScore(){
        MyWorld w = (MyWorld)getWorld();
        w.showText("cards", 200, 50);
        w.showText(Integer.toString(computerCardNum), 200, 100);
    }
}
