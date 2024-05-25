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
        //checkCases();
    }
    private void displayScore(){
        MyWorld w = (MyWorld)getWorld();
        w.showText("cards", 200, 50);
        w.showText(Integer.toString(w.computerCard.size()), 200, 100);
    }
    private void checkCases(){
        MyWorld w = (MyWorld)getWorld();
        if (w.marriage()){
            w.slapLose();
            w.showText("marriage", 150, 150);
        } 
        else if (w.divorce()){
            w.slapLose();
            w.showText("divorce", 150, 150);
        }
        else if (w.couple()){
            w.slapLose();
            w.showText("couple", 150, 150);
        }
        else if (w.sandwich()){
            w.slapLose();
            w.showText("sandwich", 150, 150);
        }
    }
}
