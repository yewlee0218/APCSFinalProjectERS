import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class slap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class slap extends Actor
{
    private int timer = 100;
    /**
     * Act - do whatever the slap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        MyWorld w = (MyWorld)getWorld();
        boolean turn = w.getPlayersTurn();
        if (turn == false){
            if (timer > 0){
                w.showText("Thinking...", 100, 100);
                timer--;
            }
            else{
                w.placeCardDownComputer();
                w.setPlayersTurn(true);
            }
        }
        else {
            if (Greenfoot.mousePressed(this)){
                w.placeCardDownPlayer();
                w.setPlayersTurn(false);
            }
        }      
    }
}
