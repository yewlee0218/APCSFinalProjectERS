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
    public int timer = 300;
    /**
     * Act - do whatever the computer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld w = (MyWorld)getWorld();
        displayScore();
        checkCases();
    }
    private void displayScore(){
        MyWorld w = (MyWorld)getWorld();
        w.showText("Cards", 200, 50);
        w.showText(Integer.toString(w.computerCard.size()), 200, 100);
    }
    private boolean ifSpecialMethod(){
        MyWorld w = (MyWorld)getWorld();
        if (w.marriage()){
            return true;
        }
        else if (w.divorce()){
            return true;
        }
        else if (w.sandwich()){
            return true;
        }
        else if (w.couple()){
            return true;
        }
        else if (w.redTen()){
            return true;
        }
        else if (w.topBottom()){
            return true;
        }
        else if (w.threeInARow()){
            return true;
        }
        //else if(w.specialCard()){
            //return true;
        //}
        return false;
    }
    private void checkCases(){
        MyWorld w = (MyWorld)getWorld();
        if (ifSpecialMethod()){
            timer--;
            if (w.ifPatternSlapped == false && timer < 0){
                w.slapWin(w.computerCard, "No Special Card");
                timer = 300;
            }
        }
    }
}
