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

        if (Greenfoot.isKeyDown("space")){
            Greenfoot.delay(10);
            if (w.marriage()){
                w.slapWin(w.playerCard);
            } 
            else if (w.divorce()){
                w.slapWin(w.playerCard);
            }
            else if (w.couple()){
                w.slapWin(w.playerCard);
            }
            else if (w.sandwich()){
                w.slapWin(w.playerCard);
            }
            else{
                while (w.timer > 0){
                    w.textshowing = "Slap Invalid";
                    w.showText(w.textshowing, 500, 150);
                    w.timer--;
                }
                w.slapLose(w.playerCard);
                w.textshowing = "";
                w.showText(w.textshowing, 500, 150);
                w.timer = 10; 
            }
        }
    }
    private void displayScore(){
        MyWorld w = (MyWorld)getWorld();
        w.showText("Cards", 200, 300);
        w.showText("Place Card", 400, 300);
        w.showText("Press space to slap", 100, 200);
        w.showText("Cards in Pile: " + Integer.toString(w.cardInPile.size()), 120, 150);
        w.showText(Integer.toString(w.playerCard.size()), 200, 350);
    }
    private void checkIfWin(){
        MyWorld w = (MyWorld)getWorld();
        if (w.playerCard.size() == 52){
            w.showText("You won!", 300, 200);
            Greenfoot.stop();
        }
    }
    private void checkIfLose(){
        MyWorld w = (MyWorld)getWorld();
        if (w.playerCard.size() == 0){
            w.showText("You lost!", 300, 200);
            Greenfoot.stop();
        }
    }
    
    
}
