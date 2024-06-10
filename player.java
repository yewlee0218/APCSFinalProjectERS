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
    //public int timer = 100;
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
        w.ifPatternSlapped = false; 
        if (Greenfoot.isKeyDown("space")){
            if (w.couple()){
                w.slapWin(w.playerCard, "couple");
            }
            else if (w.sandwich()){
                w.slapWin(w.playerCard, "sandwich");
                w.ifPatternSlapped = true; 
            }
            if (w.marriage()){
                w.slapWin(w.playerCard, "marriage");
                w.ifPatternSlapped = true; 
            } 
            else if (w.divorce()){
                w.slapWin(w.playerCard, "divorce");
                w.ifPatternSlapped = true; 
            }
            else if (w.redTen()){
                w.slapWin(w.playerCard, "redTen");
                w.ifPatternSlapped = true; 
            }
            else if (w.topBottom()){
                w.slapWin(w.playerCard, "topBottom");
                w.ifPatternSlapped = true; 
            }
            else if (w.threeInARow()){
                w.slapWin(w.playerCard, "Three in a Row");
                w.ifPatternSlapped = true; 
            }
            //else if(w.specialCard()){
              //  w.slapWin(w.playerCard, "Special Card");
                //w.ifPatternSlapped = true;
            //}
            else if (w.slapValid == true) {
                w.slapLose(w.getPlayerCard());
                w.ifPatternSlapped = false; 
                w.slapValid = false;
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
