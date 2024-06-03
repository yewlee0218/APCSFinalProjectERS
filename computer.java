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
        int chance = (int)(Math.random() * 200)+1;
        
        if (w.cardInPile.size() > 2){
            if (w.cardInPile.get(w.cardInPile.size()-1).getRank() == 11 || w.cardInPile.get(w.cardInPile.size()-1).getRank() == 12){
                if (chance < 25){
                    checkCases();
                }
            }
            if (w.cardInPile.get(w.cardInPile.size() - 1).getSuit() == w.cardInPile.get(w.cardInPile.size() - 2).getSuit()){
                if (chance < 25){
                    checkCases();
                }
            }
        } 
        
        
        //int chance = (int)(Math.random()*150)+1;
        //if (chance == 18){
            //checkCases();
        //}
    }
    private void displayScore(){
        MyWorld w = (MyWorld)getWorld();
        w.showText("cards", 200, 50);
        w.showText(Integer.toString(w.computerCard.size()), 200, 100);
    }
    private void checkCases(){
        MyWorld w = (MyWorld)getWorld();
        if (w.marriage()){
            w.slapWin();
            w.showText("marriage", 500, 150);
        } 
        else if (w.divorce()){
            w.slapWin();
            w.showText("divorce", 500, 150);
        }
        else if (w.couple()){
            w.slapWin();
            w.showText("couple", 500, 150);
        }
        else if (w.sandwich()){
            w.slapWin();
            w.showText("sandwich", 500, 150);
        }
        else{
            w.slapLose();
        }
    }
}
