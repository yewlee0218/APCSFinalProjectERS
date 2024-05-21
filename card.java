import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class card extends Actor
{
    private int suit;
    private int rank;
    private GreenfootImage cardFront;
    /**
     * Act - do whatever the card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
        //cardFront = new GreenfootImage("card" + rank + suit + ".png");
    }
    public void drawACard(){
        //setImage(cardFront);
    }
}
