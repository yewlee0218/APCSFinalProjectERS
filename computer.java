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
    //private ArrayList<card> playerPile = new ArrayList<>();
    //public int timer = 100;
    /**
     * Act - do whatever the computer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld w = (MyWorld)getWorld();
        displayScore();
        int random = (int)(Math.random()*10000)+1;
        if (random < 5){
            checkCases();
        }
    }
    private void displayScore(){
        MyWorld w = (MyWorld)getWorld();
        w.showText("cards", 200, 50);
        w.showText(Integer.toString(w.computerCard.size()), 200, 100);
    }
    private void checkCases(){
        MyWorld w = (MyWorld)getWorld();
        if (w.marriage()){
            w.slapWin(w.computerCard);
            w.showText("marriage", 500, 150);
        } 
        else if (w.divorce()){
            w.slapWin(w.computerCard);
            w.showText("divorce", 500, 150);
        }
        else if (w.couple()){
            w.slapWin(w.computerCard);
            w.showText("couple", 500, 150);
        }
        else if (w.sandwich()){
            w.slapWin(w.computerCard);
            w.showText("sandwich", 500, 150);
        }
        //else if (w.redTen()){
            //w.slapWin(w.computerCard);
            //w.showText("red ten", 500, 150); 
        //}
        else{
            w.slapLose(w.computerCard);
        }
    }
}
