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
    private int kind;
    private int number;
    private int toy;
    /**
     * Act - do whatever the card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        // Add your action code here.
    }
    public card(int kind1, int number1){
        kind = kind1;
        number = number1;
        // intializes a deck of cards
    }
    public void drawACard(){
        if (isTouching(table.class)){
            getWorld().removeObject(this);
        }
        // randomly draws cards and places on the table. If there is already a card before 
        //placing it, removes the card that is already on the table and adds it to 
        //cardInPile array before placing another one.
    }
}
